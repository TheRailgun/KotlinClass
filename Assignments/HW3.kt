import java.lang.Math.abs

/*
* Complete the 'diagonalDifference' function below.
* The function is expected to return an INTEGER.
* The function accepts 2D_INTEGER_ARRAY arr as parameter.
*/

fun diagonalDifference(arr: Array<Array<Int>>): Int {
    var ans = 0
    var tot1 =0
    var tot2 =0
    var size = arr.size - 1 //2 for 3 by 3


    for(i in 0..size){
        tot1 += arr[i][i]
        tot2 += arr[i][size-i]
    }

    println(tot1)
    println(tot2)

    ans = kotlin.math.abs(tot2 - tot1)

    return ans
}
fun main(args: Array<String>) {
    val n = readLine()!!.trim().toInt()
    val arr = Array<Array<Int>>(n, { Array<Int>(n, { 0 }) })
    for (i in 0 until n) {
        arr[i] = readLine()!!.trimEnd().split(" ").map{ it.toInt() }.toTypedArray()
    }
        val result = diagonalDifference(arr)
        println(result)
}