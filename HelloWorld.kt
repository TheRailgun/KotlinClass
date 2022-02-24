
// Hello World Program

fun main(args : Array<String>) {
    println("TESTING PROGRAM")
    var dog = 43
    println(dog)
    dog += 3
    println(dog)

    val name : String = "this is how you hard declare"
    val lines : String = 
    """ using triple quotes
    can be multiple lines
                        and tabs like this"""
    println(lines)

    val m = 1.3 + 1
    println(m)

    var a = 10

    fun doubleInt(babyInt:Int): Int{
        return babyInt * 2
    }

    fun doubleIntShort(babyInt:Int): Int = babyInt * 2;

    println(doubleInt(a))
    println(doubleIntShort(a))        

    fun checkSign(num:Int): String{
        if(num > 0){
            return "It is positive."
        }else if(num < 0){
            return "It is negative."
        }else
        return "It is zero."
    }

    println(checkSign(-1))
    println(checkSign(11))
    println(checkSign(0))

    var answer = 42
    println("The value of the answer is $answer")
    println(answer in 1..100)

    fun isPalindrome(s:String):Boolean{
            return s.toLowerCase()==s.toLowerCase().reversed();
    }
    var string = "Bob"

    println(isPalindrome(string))

    fun intReverse(i:Int):Int{
        var s = i.toString();
        s = s.reversed();
        return s.toInt();
}
println(intReverse(1243))



}