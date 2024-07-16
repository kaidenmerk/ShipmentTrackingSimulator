class Shipment(id: String) : Observable {
    val status: String = ""
    val id: String = id
    val notes: MutableList<String> = mutableListOf()
    val updateHistory: MutableList<ShippingUpdate> = mutableListOf()
    val expectedDeliveryDateTimestamp: Long? = null
    val currentLocation: String = ""
    private val observers: MutableList<Observer> = mutableListOf()

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        observers.forEach {
            it.update(this)
        }
    }

    // Applying update applies to status, updateHistory, expectedDeliveryDateTimestamp, and currentLocation
    fun addUpdate(update: ShippingUpdate) {
        updateHistory.add(update)
        update.applyUpdate(this)
    }

    fun addNote (note: String) {
        notes.add(note)
    }
}