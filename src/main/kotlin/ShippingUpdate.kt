abstract class ShippingUpdate(var newStatus: String, var timestamp: Long, var shipmentID: String, var previousStatus: String? = null)
{
    abstract fun applyUpdate(shipment: Shipment)
}