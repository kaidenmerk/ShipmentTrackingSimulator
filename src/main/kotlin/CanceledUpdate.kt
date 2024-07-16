class CanceledUpdate(newStatus: String, timestamp: Long, shipmentID: String,
                     previousStatus: String? = null
) : ShippingUpdate(newStatus, timestamp,
    shipmentID, previousStatus
) {
    override fun applyUpdate(shipment: Shipment) {
        shipment.setStatus(newStatus)
    }

}