class DelayedUpdate(
    newStatus: String,
    timestamp: Long,
    shipmentID: String,
    var additionalInfo: String
) : ShippingUpdate(
    newStatus,
    timestamp,
    shipmentID
) {
    override fun applyUpdate(shipment: Shipment) {
        shipment.setStatus(newStatus)
        var additionalInfoLong = additionalInfo.toLong()
        shipment.setExpectedDeliveryDateTimestamp(additionalInfoLong)
    }

}