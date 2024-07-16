class CreatedUpdate(newStatus: String, timestamp: Long, shipmentID: String, additionalInfo: String?,
                    previousStatus: String?
) : ShippingUpdate(newStatus, timestamp,
    shipmentID,
    additionalInfo, previousStatus
) {
    override fun applyUpdate(shipment: Shipment) {
        shipment.setStatus(newStatus)
    }

}