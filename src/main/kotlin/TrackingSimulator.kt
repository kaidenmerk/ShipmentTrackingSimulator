import java.io.File

class TrackingSimulator {
    private val shipments: MutableList<Shipment> = mutableListOf()

    fun findShipment(id: String): Shipment? {
        return shipments.find {it.id == id}
    }

    fun addShipment(shipment: Shipment) {
        shipments.add(shipment)
    }

    fun runSimulation(updates: List<ShippingUpdate>) {
        updates.forEach {
            processUpdate(it)
            Thread.sleep(1000)
        }
    }

    fun processUpdate(update: ShippingUpdate) {
        val shipment = findShipment(update.shipmentID)
        if (shipment != null) {
            shipment.addUpdate(update)
        }
        else if (update is CreatedUpdate) {
            val newShipment = Shipment(
                id = update.shipmentID,
                status = update.newStatus
            )
            addShipment(newShipment)
            newShipment.addUpdate(update)
        }
    }
    fun loadUpdatesFromFile(filename: String): List<ShippingUpdate> {
        val updates = mutableListOf<ShippingUpdate>()
        File(filename).forEachLine { line ->
            val parts = line.split(",")
            val update = when (parts[0]) {
                "created" -> CreatedUpdate("created", parts[2].toLong(), parts[1])
                "shipped" -> ShippedUpdate("shipped",  parts[2].toLong(), parts[1], parts[3])
                "location" -> LocationUpdate("location",  parts[2].toLong(), parts[1], parts[3])
                "delivered" -> DeliveredUpdate("delivered",  parts[2].toLong(), parts[1])
                "delayed" -> DelayedUpdate("delayed",  parts[2].toLong(), parts[1], parts[3])
                "lost" -> LostUpdate("lost",  parts[2].toLong(), parts[1])
                "canceled" -> CanceledUpdate("canceled",  parts[2].toLong(), parts[1])
                "noteadded" -> NoteAddedUpdate("noteadded", parts[2].toLong(), parts[1], parts[3])
                else -> null
            }
            if (update != null) updates.add(update)
        }
        return updates
    }
}