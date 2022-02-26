import kotlin.math.roundToInt

fun main(args : Array<String>) {
    val users = mapOf(
        "abe" to 323532342,
        "ben" to 234295435,
        "cathy" to 939534012,
        "don" to 202934543,
        "elle" to 330394011,
        "frances" to 839047202,
        "test" to 901239409
    )   
    
    val purchases = arrayOf(
        arrayOf(323532342, 5281),
        arrayOf(234295435, 6162),
        arrayOf(939534012, 9111),
        arrayOf(202934543, 2954),
        arrayOf(330394011, 2982),
        arrayOf(839047202, 1434),
        arrayOf(901239409, 310),
        arrayOf(939534012, 5392),
        arrayOf(202934543, 6873),
        arrayOf(330394011, 3594),
        arrayOf(839047202, 755),
        arrayOf(901239409, 270)
    )


    
    fun importPurchases(){}//would import purchases array from file

    fun importUsers(){}//would import users & ids from file

    fun spentReport(name: String, purchaseList: Array<Array<Int>>){
        val id = users.get(name.toLowerCase())
        var totalSpent = 0.0
        if(id == null){
            throw IllegalArgumentException(
                "User not found in database"
            ) 
        } else {
            for(purchase in purchaseList){ //checks to see if the user purchased each item and add the value to totalSpent if so
                if(purchase[0]==id){
                    totalSpent += (purchase[1].toDouble()/100)
                    totalSpent = (totalSpent*100.0).roundToInt()/100.0
                }
            }
            val capitalName = name.capitalize()
            println("$capitalName spent $$totalSpent.")
        }
    }

    for((k) in users){
        spentReport(k, purchases)
    }

}
