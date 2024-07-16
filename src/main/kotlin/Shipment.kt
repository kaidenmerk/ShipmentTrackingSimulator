class Shipment : Observable {
    val status: String = ""
    val id : String = ""
    val notes: MutableList<String> = mutableListOf()
    val updateHistory: MutableList<String> = mutableListOf()
    val expectedDeliveryDateTimestamp: Long? = null
    val currentLocation: String = ""
    private val observers: MutableList<Observer> = mutableListOf()

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        TODO("Not yet implemented")
    }

    override fun notifyObservers() {
        TODO("Not yet implemented")
    }
}