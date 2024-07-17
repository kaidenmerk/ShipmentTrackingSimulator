package shipmentTrackingSim

import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import java.text.SimpleDateFormat
import java.util.*

class UserInterface(private val simulator: TrackingSimulator, private val viewHelper: TrackerViewHelper) {
    // State changes to shipments or newShipmentId trigger change
    var shipments by mutableStateOf<List<Shipment>>(emptyList())
    var newShipmentId by mutableStateOf("")

    fun addShipment(id: String) {
        val shipment = simulator.findShipment(id)
        if (shipment != null) {
            shipments = shipments + shipment

        } else {
            // Handle cases where shipment is not found
            println("Shipment with ID $id not found.")
        }
        newShipmentId = ""
    }

    fun removeShipment(shipment: Shipment) {
        shipments = shipments - shipment
    }

    @Composable
    @Preview
    fun App() {
        MaterialTheme {
            Column {
                TextField(
                    value = newShipmentId,
                    onValueChange = { newShipmentId = it },
                    label = { Text("Add Shipment ID") }
                )
                Button(onClick = {
                    addShipment(newShipmentId)
                }) {
                    Text("Add Shipment")
                }
                // For each shipment added, create a new ShipmentUI
                shipments.forEach { shipment ->
                    ShipmentUI(shipment)
                }
            }
        }
    }

    @Composable
    fun ShipmentUI(shipment: Shipment) {
        Column {
            Row {
                Button(onClick = {
                    // Stop tracking logic
                    shipment.removeObserver(viewHelper)
                    viewHelper.reset()
                    removeShipment(shipment)
                }) {
                    Text("Stop Tracking ${shipment.id}")
                }
            }
            updateDisplay(shipment)
        }
    }

    @Composable
    fun updateDisplay(shipment: Shipment) {
        val dateFormat = SimpleDateFormat("MM/dd/yyyy", Locale.US)
        Column {
            Text("Status: ${shipment.getStatus()}")
            Text("Location: ${shipment.getCurrentLocation()}")
            Text("Expected Delivery: ${dateFormat.format(shipment.getExpectedDeliveryDateTimestamp()?.let { Date(it) })}")
            Text("Notes: ${shipment.getNotes()}")
            Text("Updates: ${shipment.getUpdateHistory()}")
        }
    }
}

fun main() = application {
    val simulator = TrackingSimulator()
    val viewHelper = TrackerViewHelper()
    val userInterface = UserInterface(simulator, viewHelper)
    val updates = simulator.loadUpdatesFromFile("src/main/resources/test.txt")
    simulator.runSimulation(updates)
    Window(onCloseRequest = ::exitApplication) {
        userInterface.App()
    }
}