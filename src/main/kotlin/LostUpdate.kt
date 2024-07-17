package shipmentTrackingSim

class LostUpdate(
    newStatus: String,
    timestamp: Long,
    shipmentID: String
) : ShippingUpdate(
    newStatus,
    timestamp,
    shipmentID
) {
    override fun applyUpdate(shipment: Shipment) {
        shipment.setStatus(newStatus)
    }

}