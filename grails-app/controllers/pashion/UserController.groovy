package pashion

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional
import grails.converters.JSON


import javax.servlet.http.HttpServletResponse


@Transactional(readOnly = true)
class UserController {


    def cookieService
    def cachingService

    
    
    
    
   

    
    def logout(){
        session.user = null
        session.invalidate()
        redirect(controller:'user',action:'login')
    }


    

    def guest(){
        session.user = 'guest'
        log.info "logging in as guest"
        redirect (uri:'/dashboard/#guestpage' )
    }

    

    
}
