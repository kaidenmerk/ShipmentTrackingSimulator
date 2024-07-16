class TrackerViewHelper : Observer {
    private var shipmentId: String = ""
    private var shipmentNotes: MutableList<String> = mutableListOf()
    private var shipmentUpdateHistory: MutableList<String> = mutableListOf()
    private var expectedShipmentDeliveryDate: Long? = null
    private var shipmentStatus: String = ""

    override fun update(shipment: Shipment) {
        TODO("Not yet implemented")
    }

    fun trackShipment(id: String) {
        shipmentId = id
    }

    fun stopTracking() {
        shipmentId = ""
        shipmentNotes.clear()
        shipmentUpdateHistory.clear()
        expectedShipmentDeliveryDate = null
        shipmentStatus = ""
    }
}