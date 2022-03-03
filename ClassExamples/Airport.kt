import Airport.Plane
class Airport(private val code: String) {
    open class Plane {
        // Can access private properties:
        fun contact(airport: Airport) =
            "Contacting ${airport.code}"
    }
    private class PrivatePlane : Plane()
    fun privatePlane(): Plane = PrivatePlane()
}
fun main() {
    val denver = Airport("DEN")
    var plane = Plane() // [1] try deleting the import
    plane.contact(denver)

    val frankfurt = Airport("FRA")
    plane = frankfurt.privatePlane()

    plane.contact(frankfurt)
}

