//import GoldCard
sealed class CreditCard
//cannot use external classes & prevents people inherieting your class
//make else redundant cause it knows the only types of creditcards that could be given


data class PlatinumCard(
    val name:String
):CreditCard()

data class TitaniumCard(
    val name:String,
    val annualFees:Int 
):CreditCard()

data class GoldCard(
    val goldName:String,
    val goldFees:Int
):CreditCard()

fun greet(card:CreditCard)=
    when(card){
        is PlatinumCard -> "Welcome Platinum Card Member ${card.name} "
        is TitaniumCard -> "Welcome Platinum Card Member ${card.name}, your annual fees is ${card.annualFees}"
        is GoldCard -> "Welcome Platinum Card Member ${card.goldName}, your annual fees is ${card.goldFees}"
        //else -> "I dont recognize you." //not needed when sealed class
    }


fun main(){
    var myPlatinumCard = PlatinumCard("Amelia")
    var myTitaniumCard = TitaniumCard("Johnny",89)
    var myGoldCard = TitaniumCard("Golden",66)

    println(greet(myPlatinumCard))
    println(greet(myTitaniumCard))
    println(greet(myGoldCard))
    
}

