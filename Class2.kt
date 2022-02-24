import kotlin.math.*

fun main(args : Array<String>) {

    println(PI)

    fun division(a:Int, b:Int): Double{
        if(a==0||b==0){
            throw IllegalArgumentException(
                "Months cant be 0"
            ) 
        } else
         return a.toDouble()/b.toDouble()
    }

    println(division(3,2))
    //println(division(3,0))//this throws the above exception
}