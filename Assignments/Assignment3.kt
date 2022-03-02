/*
 * Complete the 'isBalanced' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING s as parameter.
 */
fun isBalanced(s: String): String {
    var ans = "No"//defaults to no so we can break early
    val arr = s.toCharArray()
    val len = arr.size
    val arrClone = CharArray(len)

        for ((i, brac) in arr.withIndex()) {
            if (brac == '(') {
                if (arr[i + 1] == ')') {
                    arrClone[i] = '('
                    arrClone[i + 1] = ')'
                } else {
                    for (j in 1..((len - 1 - i) / 2)) {
                        if((i + 1 + (2 * j))<len) {
                            if (arr[i + 1 + (2 * j)] == ')') {
                                arrClone[i] = '('
                                arrClone[i + 1 + (2 * j)] = ')'
                            }
                        }
                    }
                }
            } else if (brac == '[') {
                if (arr[i + 1] == ']') {
                    arrClone[i] = '['
                    arrClone[i + 1] = ']'
                } else {
                    for (j in 1..((len - 1 - i) / 2)) {
                        if((i + 1 + (2 * j))<len) {
                            if (arr[i + 1 + (2 * j)] == ']') {
                                arrClone[i] = '['
                                arrClone[i + 1 + (2 * j)] = ']'
                            }
                        }
                    }
                }
            } else if (brac == '{') {
                if (arr[i + 1] == '}') {
                    arrClone[i] = '{'
                    arrClone[i + 1] = '}'
                } else {
                    for (j in 1..((len - 1 - i) / 2)) {
                        if((i + 1 + (2 * j))<len){
                                if (arr[i + 1 + (2 * j)] == '}') {
                                    arrClone[i] = '{'
                                    arrClone[i + 1 + (2 * j)] = '}'
                                }
                            }
                    }
                }
            }
        }
        println(arr)
        println(arrClone)

    if(arr.contentEquals(arrClone)){
        ans = "Yes"
    }
    return ans
}
fun main() {
    val t = readLine()!!.trim().toInt()
    for (tItr in 1..t) {
        val s = readLine()!!
        val result = isBalanced(s)
        println(result)
    }
} 
