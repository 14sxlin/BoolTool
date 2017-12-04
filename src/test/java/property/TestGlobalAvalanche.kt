package property

import entity.multinomial.BoolPolymerization
import org.junit.Test
import property.define.TestDifferential
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by linsixin on 2017/12/3.
 */
class TestGlobalAvalanche {

    private val total = 4
    private val terms1 =
            arrayOf(BoolPolymerization.BoolTerm.create(total, 1, 3),
                    BoolPolymerization.BoolTerm.create(total, 2, 3),
                    BoolPolymerization.BoolTerm.create(total, 0,1),
                    BoolPolymerization.ONE_TERM)
    val bent = BoolPolymerization(*terms1)

    @Test
    fun testIsSAC(){
        println(bent)
        bent.printBoolTable(4)
        assertTrue(GlobalAvalanche.isSAC(bent))

        println(TestDifferential.poly2)
        println(GlobalAvalanche.isSAC(TestDifferential.poly2))
    }

    @Test
    fun testPof(){
        assertEquals(4,GlobalAvalanche.pcOf(bent))
        TODO("use bent function to check ")
    }
}