import entity.bool.maxBoolVectorValueOf
import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by linsixin on 2017/12/4.
 */
class TestTool {

    @Test
    fun testMaxOfLength(){
        assertEquals(3, maxBoolVectorValueOf(2))
        assertEquals(1, maxBoolVectorValueOf(1))
    }
}