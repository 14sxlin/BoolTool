package property

import entity.bool.setOfVectors
import entity.walsh.TestLoopWalsh
import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.fail

/**
 * Created by linsixin on 2017/11/29.
 */
class TestCorrelationImmunity {

    @Test
    fun testVectorTool(){
        val weight = 2
        val set = setOfVectors(4,weight)
        assertEquals(6,set.size)
        for(vector in set)
            assertEquals(weight,vector.weight())
    }

    /**
     * 测试一下最高能求出多少长度的
     */
    @Test
    @Ignore
    fun testMaxVectorsOfWeight(){
        /*
        set of 10/9 using time : 0.069s
        set of 10/8 using time : 0.004s
        set of 10/7 using time : 0.02s
        set of 10/6 using time : 0.013s
        set of 10/5 using time : 0.003s
        set of 10/4 using time : 0.003s
        set of 10/3 using time : 0.001s
        set of 10/2 using time : 0.0s
        set of 10/1 using time : 0.0s
         */


        time("set of 20/14") { setOfVectors(20,14) }
        time("set of 20/13") { setOfVectors(20,13) }
        time("set of 20/12") { setOfVectors(20,12) }
        time("set of 20/11") { setOfVectors(20,11) }
        time("set of 20/10") { setOfVectors(20,10) }
        time("set of 20/9") { setOfVectors(20,9) }
        time("set of 20/8") { setOfVectors(20,8) }

        /*
        set of 20/1 using time : 0.0s
        set of 20/2 using time : 0.006s
        set of 20/3 using time : 0.085s
        set of 20/4 using time : 0.931s
        set of 20/5 using time : 10.416s
        set of 20/6 using time : 59.461s
        set of 20/7 using time : 271.0s

        set of 20/14 using time : 63.449s
        set of 20/15 using time : 13.939s
        set of 20/16 using time : 1.169s
        set of 20/17 using time : 0.03s
        set of 20/18 using time : 0.001s
        set of 20/19 using time : 0.0s
         */
    }

    private fun time(message:String ="",run:() -> Unit){
        val begin = System.currentTimeMillis()
        run()
        val consume = System.currentTimeMillis() - begin
        println("$message using time : ${consume * 1.0 / 1000}s")
    }

    @Test
    @Ignore
    fun genTestTimeCode(){
        val varLen = 20
        val maxWeight = varLen-1
        for(weight in 1..maxWeight){
            println("time(\"set of $varLen/$weight\") { setOfVectors($varLen,$weight) }")
        }
    }

    @Test
    fun testRank(){
        print("rank is ${CorrelationImmunity.rankOf(TestLoopWalsh.loopWalsh)}")
        fail("not implement yet")
    }
}