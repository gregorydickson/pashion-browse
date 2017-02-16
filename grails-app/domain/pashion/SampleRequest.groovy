package pashion

import java.time.LocalDate
import java.time.ZoneId

class SampleRequest {

	
	String idString
	String season
	String image
	String look
	Date dateRequested

	Date bookingStartDate
	Date bookingEndDate
	String requestStatusBrand //Pending ->Approved->Shipped -> Delivered -> Due Back ->Overdue ->Closed
	String requestStatusPress
	Boolean overdue = false
	Long userCreatedId
	
	Brand brand

	PressHouse pressHouse
	Address addressDestination
	Address returnToAddress

	String courierOut
	String courierReturn
	String paymentOut
	String paymentReturn
	User receivingUser 
	User requestingUser 
	User deliverTo
	
	String returnBy
	String requiredBy

	String overview
	
	String pickupId
	Date pickupDate
	String pickupDestination

	String editorialName
	String editorialWho
	Date editorialWhen

	//auto fields
	Date dateCreated
	Date lastUpdated

	Collection searchableItems  //approved Items
	Collection searchableItemsProposed // proposed Items
	Collection searchableItemsDenied
	Collection<BookingStatus> searchableItemsStatus

	ShippingEvent shippingOut
	ShippingEvent shippingReturn

	static constraints = {
		
		season nullable:true
		image nullable: true
		look nullable:true
		searchableItems nullable:true
		searchableItemsProposed nullable: true
		idString nullable: true
		dateRequested nullable: true

		bookingStartDate nullable: true
	    bookingEndDate nullable: true
		requestStatusBrand nullable: true 
		requestStatusPress nullable: true
		userCreatedId nullable: true
		brand nullable:true
		returnToAddress nullable: true
		addressDestination nullable:true
		deliverTo nullable:true

		pressHouse nullable: true
		courierOut nullable: true
		courierReturn nullable: true
		receivingUser nullable:true
		requestingUser nullable: true 

		overview nullable:true

		pickupId nullable: true
		pickupDate nullable: true
	 	pickupDestination nullable: true

		editorialName nullable: true 
		editorialWho nullable: true 
		editorialWhen nullable: true 

		shippingOut nullable: true 
		shippingReturn nullable: true

		searchableItemsStatus nullable:true
		
	}


	static mapping = {
        cache true
        searchableItems lazy:false
        brand lazy:false
        deliverTo lazy: false
        searchableItemsProposed lazy: false
        searchableItems lazy:false
        searchableItemsDenied lazy:false
        shippingOut lazy:false
        shippingReturn lazy:false
        searchableItemsStatus lazy:false
        requestingUser lazy: false

        receivingUser lazy:false
	
        returnToAddress lazy:false
        addressDestination lazy:false
        pressHouse lazy: false

    }

	static belongsTo = SearchableItem 

	static hasMany = [ searchableItems:SearchableItem,
					   searchableItemsProposed:SearchableItem,
					   searchableItemsDenied:SearchableItem ]

  	

	
}
