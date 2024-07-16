class LocationUpdate(newStatus: String, timestamp: Long, shipmentID: String, private var additionalInfo: String,
                     previousStatus: String? = null
) : ShippingUpdate(newStatus, timestamp,
    shipmentID, previousStatus
) {
    override fun applyUpdate(shipment: Shipment) {
        shipment.setStatus(newStatus)
        shipment.setCurrentLocation(additionalInfo)

    }

}