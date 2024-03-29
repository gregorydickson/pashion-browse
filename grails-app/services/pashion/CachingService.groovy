package pashion
import pashion.SearchableItem
import org.json.*
import javax.annotation.PostConstruct
import grails.transaction.Transactional
import grails.converters.JSON

import static java.util.concurrent.TimeUnit.*
import static grails.async.Promises.*
import grails.async.Promise

import reactor.spring.context.annotation.*
import grails.plugin.json.view.test.*
import groovy.transform.Synchronized

import com.pubnub.api.*

@Transactional
@Consumer
class CachingService implements JsonViewTest {

    static lazyInit = false
    static scope = "singleton"
    
    def seasons
    def themes
    String connections = null


    Pubnub pubnub = null

    @PostConstruct
    void init() {
        pubnub = new Pubnub("pub-c-b5b66a91-2d36-4cc1-96f3-f33188a8cc73", "sub-c-dd158aea-b76b-11e6-b38f-02ee2ddab7fe")
    }

    @Selector('connectionsUpdate')
    def invalidateConnections(String data){
        log.info "UPDATING CONNECTIONS "
        String newValue = loadConnections()
        connections = newValue
        Callback callback=new Callback() {}
        def channel = data + '_cacheInvalidate'
        log.info "send invalidate from acceptcontact on:" + channel
        pubnub.publish(channel, "refresh the cache please" , callback)

    }

    
    def connections(){
        log.info "checking connections:"
        if(connections == null){
            def result = loadConnections()
            connections = result
            return result
        }
        log.info "************* Connections not null returning existing connections"
        connections

    }
    def themes(){
        if(!themes){
            def result = loadThemes()
            themes = result
            return result
        }
        themes
    }
    def seasons(){
        if(!seasons){
            def result = loadSeasons()
            seasons = result
            return result
        }
        seasons
    }

    def loadThemes(){
        
        def items = SearchableItem.list().collect{it.theme}
        def result = []
        items.each{
            if(it){
                if(it.contains(",")){
                    it.split(",").each{result << it.trim().toLowerCase().capitalize()}
                } else{
                    result << it.trim().toLowerCase().capitalize()
                }
            }
        }
        result = result.unique().sort()
        result.removeAll([""])
        return result as JSON
    }

    def loadSeasons(){
        List items = SearchableItem.list().collect{it.season}

        items.unique()
        log.info"seasons"+items
        return items as JSON

    }

    def loadConnections(){
        def list = User.list()
        log.info ""
        log.info "***************   Connections Rendering in Service ********************"
        JsonRenderResult renderResult = render(template: "/user/connections", model:[userList: list])
        log.info "Rendered Connections in service"
        String json = renderResult.jsonText
        json
    }

    


          
      
}
