package shipmentTrackingSim

class LocationUpdate(
    newStatus: String,
    timestamp: Long,
    shipmentID: String,
    private var additionalInfo: String
) : ShippingUpdate(
    newStatus,
    timestamp,
    shipmentID,
) {
    override fun applyUpdate(shipment: Shipment) {
        shipment.setStatus(newStatus)
        shipment.setCurrentLocation(additionalInfo)

    }

}