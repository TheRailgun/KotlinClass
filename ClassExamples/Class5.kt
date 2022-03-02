
private var counter = 0 
class customer(val name:String){
    private val uniqueID : String
    init{
        counter++
        uniqueID = "[$counter] $name"
    }
    override fun toString() = uniqueID
}



open class CreditCard(){
    var expirationYears = 4
    var annualFees = 100

    //fun info() = "Expiration years: $expirationYears Annual Fees: $annualFees"
}

fun CreditCard.info() = "Expiration years: $expirationYears Annual Fees: $annualFees"

open class PlatinumCreditCard:CreditCard(){
    
}

open class Pet(){

open fun speak() = "Pet"
}

class Dog:Pet(){
    override fun speak() = "Bow"
}

class Cat:Pet(){
    override fun speak() = "Meow"
}

fun talk(pet:Pet) = pet.speak()

fun main(){

    println(talk(Pet()))
    println(talk(Dog()))
    println(talk(Cat()))

    var list = listOf(
        listOf(1,2),
        listOf(4,5),
        listOf(7,8)
    )
    //println(list)
    println(list.flatten())

    val newCustomer = customer("Kevin")
    //val newCustomer2 = customer("Laura")
    println(newCustomer.toString())
    //println(newCustomer2.toString())

    println(PlatinumCreditCard().info())
    //val plat = PlatinumCreditCard()
    //print(plat.info())

}




