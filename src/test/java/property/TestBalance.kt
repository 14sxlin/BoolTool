package property

import entity.table.SimpleBoolTable
import entity.walsh.TestLinearWalsh
import entity.walsh.TestLoopWalsh
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.test.fail

/**
 * Created by linsixin on 2017/11/30.
 */
class TestBalance {

    @Test
    fun testWeight(){
        assertEquals(3,Balance.weightOf(TestLinearWalsh.boolfun))
        assertEquals(3,Balance.weightOf(TestLoopWalsh.boolfun))
        fail("not implement")
    }

    @Test
    fun testIsBalance(){
        assertFalse {  Balance.isBalance(TestLinearWalsh.boolfun) }
        assertFalse {  Balance.isBalance(TestLoopWalsh.boolfun)   }

        val valueTable = intArrayOf(1,1,1,1,0,0,0,0)
        val balanceBool= SimpleBoolTable(valueTable,3)
        assertTrue {  Balance.isBalance(balanceBool) }
    }
}