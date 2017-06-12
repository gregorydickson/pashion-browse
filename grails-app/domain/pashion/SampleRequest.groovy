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
	String prAgency
	String requestingUserCompany
	Address addressDestination
	Address returnToAddress

	String courierOut
	Boolean courierOutNotification = false
	String courierReturn
	Boolean courierReturnNotification = false
	String paymentOut
	String paymentReturn
	User receivingUser 
	User requestingUser 
	User deliverTo
	String emailNotification
	
	String returnBy
	String requiredBy

	String overview

	String message
	
	
	// Pickup Date is the Date for the courier pickup
	Date pickupDate
	Date pickupDateReturn
	String pickupTime
	String pickupTimeReturn

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
		
		message maxSize: 4000
		
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
