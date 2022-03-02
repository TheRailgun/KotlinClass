import kotlin.random.Random
//Part 1
private var counter = 0
class customer(name:String, age:Int){
    val uniqueID : String
    init{
        uniqueID = "$name [$counter]" //I think I misunderstood what you wanted by "outputting a pair". This technically isn't a pair however since it's an output and not a return, should be fine
        counter++
    }

}

fun customer.output(customers: List<customer>, vararg select:Int) {//I was trying to have 2 varargs which isn't possible. I figured an option to select 1 does what we're after, but I can see this being not what was desired.
    if(select.isNotEmpty()) {
        println(customers[select[0]].uniqueID)
    } else {
        customers.forEach{
            println(it.uniqueID)
        }
    }
}



fun main(){

    //Part 1 Main
    val custList = listOf<customer>(
        customer("Amy",23),
        customer("Brad",41),
        customer("Cathy",63),
        customer("Diego",86),
        customer("Elle",29),
        customer("Frances",17),
        customer("Gustavo",31),
        customer("Hendrick",49),
        customer("Ismail",22),
        customer("John",33)
    )
    custList[0].output(custList) //there might be another way to call this however this is what I got working. Looking forward to seeing how else it is done.
    custList[0].output(custList, Random.nextInt(10))

    //Part 2 Main
    val list2D = listOf(
        listOf("Walmart", 102.32),
        listOf("Costco", 431.02),
        listOf("Kroger", 43.23),
        listOf("Macys", 321.32)
    )
    println(list2D.flatten())

    //Part 3 Main
    val nameList = listOf("Sam","Tim","Usher","Virgil")
    println(nameList.zipWithNext())

    //Part 4 Main
    val numList = List(20){
        it+1
    }
    val evenList = List(10){// I did this before I realized the exact answer was in my notes LOL
        (it+1)*2
    }
    //println(evenList)
    println(numList.filter{(it%2==0)})

    //Part 5 Main
    val listOf13 = List(10){//Modified what I wrote earlier
        (it+1)*13
    }
    println(listOf13)
}