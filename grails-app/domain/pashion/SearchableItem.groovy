package pashion

import java.time.LocalDate
import java.time.ZoneId

/*
 * A Searchable Item is the main domain object for Pashion's image search
 * a searchable item can be a Look, Sample, or Runway photo. 
 * a Look (a type of SearchableItem) will probably have samples (another type
 * of Searchable Item) associated with it.
 */
class SearchableItem {

	Long id
	String clientID // The sample id that is used by the client
	String name //string for ID set by user For Look this is the Look ID which matches Vogue Runway
	String description
	Brand brand
	City city
	City sampleCity
	String sex

	String image
	
	SearchableItemType type //Look or Sample or Runway
	Boolean isBookable = false
	Boolean isPrivate = false
	String imageProvider
	
	// Start of searchable attributes
	String color
	String material
	String itemsInLook // type in Look data entry sheet
	String sampleType //if it is a sample, what is it
	String shape
	String accessories
	String occasion
	String style
	String motif
	String theme
	String culture
	String lookSeason //season in Look data etnry
	String decade
	String attributes  //all attributes space separated (tags)
					   // Used for full text searching
					   // e.g. red dress silk

	String path

	String size
	
	Season season

	Date fromDate

	Long userCreatedId
	Long lastModifiedUserId

	//auto fields
	Date dateCreated
	Date lastUpdated

	SearchableItem look //if this is a sample, then it has a Look
	User owner

	static constraints = {
		clientID nullable:true
		name nullable:true
		city nullable:true
		sampleCity nullable:true
		description nullable:true, maxSize: 1000
		brand nullable: true
		sex nullable:true
		type nullable: true
		image nullable:true

		imageProvider nullable:true

		color nullable: true
		material nullable: true
		itemsInLook nullable: true
		sampleType nullable:true
		shape nullable: true
	 	accessories nullable: true
	 	occasion nullable: true
	 	style nullable: true
	 	motif nullable: true
	 	theme nullable: true
	 	culture nullable: true
	 	lookSeason nullable: true
	 	decade nullable: true

	 	attributes nullable:true, maxSize: 1000

	 	path nullable:true

		size nullable: true
		theme nullable:true

		fromDate nullable:true
		
		look nullable: true 
		owner nullable:true
		
		userCreatedId nullable:true
		lastModifiedUserId nullable:true

		brandCollection nullable: true
		permissions nullable:true
		sampleRequests nullable:true
		samples nullable:true
	}

	String toString(){
		return name +" sample city:" +sampleCity?.name
	}


		
	

	
	
	static belongsTo = [brandCollection: BrandCollection]
	

	static hasMany = [ permissions:Permission, sampleRequests:SampleRequest, samples:SearchableItem]

	
	static mapping = {

		brand index: 'brand_idx'
		theme index: 'theme_idx'
		fromDate index: 'fromDate_idx'
		toDate index: 'toDate_idx'

		attributes index: 'attributes_idx'
		season index: 'season_idx'

		sampleRequests lazy: true
		samples lazy:true
		type lazy:false
		brandCollection lazy:false
		city lazy:false

		description type: 'text'

		cache true
		isBookable  defaultValue: false
	}

}
