fun main(){

    var i = 0
    var nums = mutableListOf(0)
    do{
        i+=4
        if(i==3) continue
        if(i==30) break
        nums.add(i)
    } while (i<100)

    //println(nums)

    val mylist: (List<>)->List<> = {listOf(1,2,3,4,5,6,7,8,9,10)}
    println(mylist)
    }
