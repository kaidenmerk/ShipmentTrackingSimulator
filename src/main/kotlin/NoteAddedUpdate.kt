class NoteAddedUpdate(
    newStatus: String,
    timestamp: Long,
    shipmentID: String,
    var additionalInfo: String,
) : ShippingUpdate(
    newStatus,
    timestamp,
    shipmentID
) {
    override fun applyUpdate(shipment: Shipment) {
        shipment.setStatus(newStatus)
        shipment.addNote(additionalInfo)
    }

}