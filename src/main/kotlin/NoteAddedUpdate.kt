class NoteAddedUpdate(newStatus: String, timestamp: Long, shipmentID: String, var additionalInfo: String,
                      previousStatus: String?
) : ShippingUpdate(newStatus, timestamp,
    shipmentID, previousStatus
) {
    override fun applyUpdate(shipment: Shipment) {
        shipment.setStatus(newStatus)
        shipment.addNote(additionalInfo)
    }

}