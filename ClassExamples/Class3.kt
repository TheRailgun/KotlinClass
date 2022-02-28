fun main(args : Array<String>) {


    class AddMiles(){

        fun sum(a:Int,b:Int):Int{
            return a + b
        }
    }

    fun color(red:Int, green: Int, blue: Int) = "($red,$green,$blue)"

    println(color(red=76,green=89,blue=0))


    fun compute(a:Int):Pair<String,Int>{
        val b = a*12
        var c = "Future Loyal Customer"
        if(a>5){
            c = "Loyal Customer"
        }   
        return Pair(c,b)
    }
    println(compute(7).toString())
}