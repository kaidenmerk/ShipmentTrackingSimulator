class Shipment(
    val id: String,
    private var status: String,
    private val notes: MutableList<String> = mutableListOf(),
    private val updateHistory: MutableList<ShippingUpdate> = mutableListOf(),
    private var expectedDeliveryDateTimestamp: Long? = null,
    private var currentLocation: String = "",
    private val observers: MutableList<Observer> = mutableListOf()
) : Observable {
    fun addNote(note: String) {
        notes.add(note)
        notifyObservers()
    }

    fun addUpdate(update: ShippingUpdate) {
        updateHistory.add(update)
        update.applyUpdate(this)
        notifyObservers()
    }

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        observers.forEach { it.update(this) }
    }
    fun getStatus() = status
    fun setStatus(newStatus: String) {
        status = newStatus
    }

    fun getExpectedDeliveryDateTimestamp() = expectedDeliveryDateTimestamp
    fun setExpectedDeliveryDateTimestamp(timestamp: Long) {
        expectedDeliveryDateTimestamp = timestamp
    }

    fun getCurrentLocation() = currentLocation
    fun setCurrentLocation(location: String) {
        currentLocation = location
    }
}