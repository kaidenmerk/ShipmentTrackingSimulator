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
}