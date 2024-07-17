package shipmentTrackingSimTests
import shipmentTrackingSim.*

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
class ShipmentTest {

    private lateinit var shipment: Shipment

    @BeforeEach
    fun setUp() {
        shipment = Shipment(id = "123", status = "Pending")
    }

    @Test
    fun testAddNote() {
        val initialSize = shipment.getNotes().size
        shipment.addNote("Note 1")
        assertEquals(initialSize + 1, shipment.getNotes().size)
        assertEquals("Note 1", shipment.getNotes().last())
    }

    @Test
    fun testAddUpdate() {
        val initialSize = shipment.getUpdateHistory().size
        val update = DeliveredUpdate("Delivered", 2525254,"3434")
        shipment.addUpdate(update)
        assertEquals(initialSize + 1, shipment.getUpdateHistory().size)
        assertEquals(update, shipment.getUpdateHistory().last())
        assertEquals("Delivered", shipment.getStatus())
    }

    @Test
    fun testAddObserver() {
        val trackerViewHelper = TrackerViewHelper()
        shipment.addObserver(trackerViewHelper)
    }

    @Test
    fun testRemoveObserver() {
        val trackerViewHelper = TrackerViewHelper()
        shipment.addObserver(trackerViewHelper)
        shipment.removeObserver(trackerViewHelper)
    }


    @Test
    fun testGetStatus() {
        assertEquals("Pending", shipment.getStatus())
    }

    @Test
    fun testSetStatus() {
        shipment.setStatus("Shipped")
        assertEquals("Shipped", shipment.getStatus())
    }

    @Test
    fun testGetExpectedDeliveryDateTimestamp() {
        assertNull(shipment.getExpectedDeliveryDateTimestamp())
    }

    @Test
    fun testSetExpectedDeliveryDateTimestamp() {
        val timestamp = 1625097600L
        shipment.setExpectedDeliveryDateTimestamp(timestamp)
        assertEquals(timestamp, shipment.getExpectedDeliveryDateTimestamp())
    }

    @Test
    fun testGetCurrentLocation() {
        assertEquals("", shipment.getCurrentLocation())
    }

    @Test
    fun testSetCurrentLocation() {
        shipment.setCurrentLocation("New York")
        assertEquals("New York", shipment.getCurrentLocation())
    }

    @Test
    fun testGetNotes() {
        assertTrue(shipment.getNotes().isEmpty())
        shipment.addNote("Note 1")
        assertEquals(1, shipment.getNotes().size)
        assertEquals("Note 1", shipment.getNotes()[0])
    }

    @Test
    fun testGetUpdateHistory() {
        assertTrue(shipment.getUpdateHistory().isEmpty())
        val update = ShippedUpdate("Shipped", 12442, "205", "2425")
        shipment.addUpdate(update)
        assertEquals(1, shipment.getUpdateHistory().size)
        assertEquals(update, shipment.getUpdateHistory()[0])
    }
}
