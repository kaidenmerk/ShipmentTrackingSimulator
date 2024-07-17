class TrackerViewHelper : Observer {
    // Shipment Object Observer
    var shipmentId: String = ""
        private set
    var shipmentStatus: String = "Status: N/A"
        private set
    var shipmentLocation: String = "Location: N/A"
        private set
    var expectedDelivery: String = "Expected Delivery: N/A"
        private set
    var shipmentNotes: String = "Notes: N/A"
        private set
    var shipmentUpdates: String = "Updates: N/A"
        private set

    override fun update(shipment: Shipment) {
        shipmentId = shipment.id
        shipmentStatus = "Status: ${shipment.getStatus()}"
        shipmentLocation = "Location: ${shipment.getCurrentLocation()}"
        expectedDelivery = "Expected Delivery: ${shipment.getExpectedDeliveryDateTimestamp() ?: "N/A"}"
        shipmentNotes = "Notes: ${shipment.getNotes().joinToString(", ")}"
        shipmentUpdates = "Updates: ${shipment.getUpdateHistory().joinToString(", ") { update ->
            "${update.newStatus} on ${update.timestamp}"
        }}"
    }

    fun reset() {
        shipmentId = ""
        shipmentStatus = "Status: N/A"
        shipmentLocation = "Location: N/A"
        expectedDelivery = "Expected Delivery: N/A"
        shipmentNotes = "Notes: N/A"
        shipmentUpdates = "Updates: N/A"
    }
}