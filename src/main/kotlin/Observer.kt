package shipmentTrackingSim

interface Observer {
    fun update(shipment: Shipment)
}