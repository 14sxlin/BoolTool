package property

import entity.walsh.TestLoopWalsh
import org.junit.Test
import kotlin.test.assertEquals
/**
 * Created by linsixin on 2017/11/27.
 */
class TestNonLinearProp{

    @Test
    fun testResult(){
        assertEquals(2, NonLinearity.maxOfWalsh(TestLoopWalsh.loopWalsh))
        assertEquals(1.0, NonLinearity.of(TestLoopWalsh.loopWalsh))
    }
}