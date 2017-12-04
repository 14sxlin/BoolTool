package property

import entity.bool.BoolVector
import entity.multinomial.BoolPolymerization
import org.junit.Ignore
import org.junit.Test
import kotlin.test.assertFailsWith
import entity.multinomial.BoolPolymerization.BoolTerm
/**
 * Created by linsixin on 2017/12/3.
 */
class TestDifferential {

    companion object{
        private val total = 4
        private val terms1 =
                arrayOf(BoolTerm.create(total, 1, 3),
                        BoolTerm.create(total, 2, 3),
                        BoolPolymerization.ONE_TERM)
        val poly1 = BoolPolymerization(*terms1)


        private val terms2 =
                arrayOf(BoolTerm.create(total, 1, 3),
                        BoolTerm.create(total, 1, 2),
                        BoolPolymerization.ONE_TERM)
        val poly2 = BoolPolymerization(*terms2)
    }


    @Ignore
    @Test
    fun testInit(){
        val boolFun = BoolPolymerization()
        val a = BoolVector.createBoolVector("1001",4)
        assertFailsWith(IllegalArgumentException::class){
            Differential(boolFun,a)
        }

    }

    @Test
    fun testResultOf(){
        val a =
                BoolVector.createBoolVector("1001",4)

        println(poly1.toString())
        poly1.printBoolTable(4)
        println("------Differential-----------")
        val d1 = Differential(poly1,a)
        d1.printTable(4)

        println("\n\n\n")
        println(poly2.toString())
        poly2.printBoolTable(4)
        println("------Differential-----------")
        val d2 = Differential(poly2,a)
        d2.printTable(4)
        TODO("not implement")
    }

}