class DeliveredUpdate(newStatus: String, timestamp: Long, shipmentID: String,
                      previousStatus: String?
) : ShippingUpdate(newStatus, timestamp,
    shipmentID,
    previousStatus
) {
    override fun applyUpdate(shipment: Shipment) {
        shipment.setStatus(newStatus)
    }

}