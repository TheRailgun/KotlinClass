import kotlin.random.Random

class DecimalsClass(double:Double){
    var d = double; //this might be wrong but seemed needed to secure
    override fun toString() : String{
        return d.toString()
    }
}

class PlanesTrainsAutomobiles(time: Int, steve: Int){
    var timeToDestination = time
    var steveMartinIrritationIndex = steve

    fun plusTime(){
        timeToDestination += 1
        steveMartinIrritationIndex += Random.nextInt(1,4)//(inclusive, exclusive)
        println("new time: $timeToDestination")//here for debuging/to show it works
        println("new steve: $steveMartinIrritationIndex")
    }

}


class RewardMiles(val nameOfCustomer: String,val miles: Int) {
 override fun toString():String{//I cannot do the auto generated toString method as I use visual studio and I think that is an intelij feature. I will switch if the course ends up requiring it but will use VS until then since my auto completion in Intelij isnt working.
    return nameOfCustomer//maybe meant to be a pair? not really sure what this is meant to return
 }
}

class Customer(val checkingInit:Int,val savingInit:Int,val iraInit:Int){
    val account = mapOf("Checkings" to checkingInit,"Savings" to savingInit,"IRA" to iraInit)//Would maybe want a mutable map 

    fun totalNetWorth():Int{
        val set = account.values
        var result = 0
        set.forEach{result += it.toInt()}

        return result
    }

}


fun main(args : Array<String>) {
    //Part 1 Main
    var decimal = DecimalsClass(8.9)
    println(decimal) 

    //Part 2 Test
    var pta = PlanesTrainsAutomobiles(1, 0)//its only going to take one hour, how irratated could Mr. Martin be?
    pta.plusTime()
    pta.plusTime()
    pta.plusTime()

    //Part 3 Main
    val customer = RewardMiles("Thomas", 10000)
    println(customer)

    //Part 4 Main
    var ezList = mutableListOf("12", "1.2", "1,2", "1.2e0", "1.2e1","1.2e2", "1.2e3", "1.2e10", "12.3e10","1.2e-1", "1.2e-10")//expected values/easier way in this instance
    var myList = mutableListOf("12") //starting with first value, not sure how to declare it as empty list of String type 
    myList.add("1.2") 
    myList.add( "1.2") 
    myList.add("1.2e0") 
    myList.add("1.2e1") 
    myList.add("1.2e2") 
    myList.add("1.2e3") 
    myList.add("1.2e10")
    myList.add("12.3e10")  
    myList.add("1.2e-1") 
    myList.add("1.2e-10")
    myList.forEach {println(it.toDouble())}
    //This didn't throw errors so I'm not really sure what exception I should be printing...
    
    //Part 5 Main
    val Tom = Customer(13266, 5206, 7448)
    val Harry = Customer(17820, 10548, 1472)
    val Sally = Customer(13266, 7672, 12808)

    println(Tom.totalNetWorth())//For assignments like this I think it would help to know expected outputs. 
    println(Harry.totalNetWorth())
    println(Sally.totalNetWorth())

}