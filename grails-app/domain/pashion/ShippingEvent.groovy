package pashion


class ShippingEvent {

	String status
	Date startDate
	Date endDate
	String courier
	String tracking
	String stuartQuoteId
	String stuartJobId
	String stuartStatus
	String stuartJSON
	String transportType
	BigDecimal finalAmount
	String currency
	BigDecimal latitude
	BigDecimal longitude
	String driverPhone
	String driverName
	String driverStatus
	

	//auto fields
	Date dateCreated
	Date lastUpdated

	static belongsTo = [sampleRequest:SampleRequest]
	static mapping = {
        cache true
    }

	static constraints = {
    }

    String toString(){
    	return id+" - " + status + " " + startDate
    }


}


