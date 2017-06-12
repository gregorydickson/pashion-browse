package pashion

import java.time.LocalDate
import java.time.ZoneId

/*
 * A Searchable Item is the main domain object for Pashion's image search
 * a searchable item can be a Look, Sample, or Runway photo. 
 * a Look (a type of SearchableItem) will probably have samples (another type
 * of Searchable Item) associated with it. Hence the look attribute where
 * a Searchable Item can be self-referencing. Several data associations are
 * de-normalized to have the data directly on this object.
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
	String imageProviderFileName
	
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

	static belongsTo = [brandCollection: BrandCollection]
	
	static hasMany = [ permissions:Permission, sampleRequests:SampleRequest, samples:SearchableItem]

	static mapping = {

		brand index: 'brand_idx'
		theme index: 'theme_idx'
		fromDate index: 'fromDate_idx'
		toDate index: 'toDate_idx'
		attributes index: 'attributes_idx'
		season index: 'season_idx'

		sampleRequests lazy: false
		samples lazy:false
		type lazy:false
		brandCollection lazy:false
		city lazy:false

		description type: 'text'

		cache true
		isBookable  defaultValue: false
	}

	static constraints = {
		description maxSize: 4000
	 	attributes  maxSize: 4000
	}

	String toString(){
		return name +" sample city:" +sampleCity?.name
	}


		
	


}
