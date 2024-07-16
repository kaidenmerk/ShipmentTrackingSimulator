abstract class ShippingUpdate(var newStatus: String, var timestamp: Long, var shipmentID: String, var previousStatus: String?)
{
    abstract fun applyUpdate(shipment: Shipment)
}