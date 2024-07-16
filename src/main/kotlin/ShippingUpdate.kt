abstract class ShippingUpdate(var newStatus: String, var timestamp: Long, var shipmentID: String, var additionalInfo: String?, var previousStatus: String?)
{
    abstract fun applyUpdate(shipment: Shipment)
}