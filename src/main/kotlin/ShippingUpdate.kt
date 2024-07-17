abstract class ShippingUpdate(var newStatus: String, var timestamp: Long, var shipmentID: String)
{
    abstract fun applyUpdate(shipment: Shipment)

    override fun toString(): String {
        return newStatus
    }
}