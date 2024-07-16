class UserInterface(
    private val simulator: TrackingSimulator,
    private val viewHelper: TrackerViewHelper
    ) {
    fun trackShipment(id: String) {
        val shipment = simulator.findShipment(id)
        if (shipment != null) {
            viewHelper.trackShipment(id)
        } else {
            displayError("Shipment with ID $id does not exist.")
        }
    }

    fun stopTracking(id: String) {
        viewHelper.stopTracking()
    }

    fun displayError(message: String) {
        println("Error: $message")
    }

    fun updateDisplay() {
        // Implement UI
    }
}