import kotlin.test.Test
import kotlin.test.assertEquals

//THIS STUFF DOESNT WORK CAUSE IM NOT USING INTELIJI RIGHT NOW

internal class AddMilesTest{

private vale testAddMiles: AddMiles = AddMiles()

        @Test
        fun testSum(){

            val expected = 20000
            assertEquals(expected,testAddMiles.sum(5000,15000))//checks if the main code is returning expected value
        }
}