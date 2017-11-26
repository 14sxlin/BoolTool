package entity.bool

import org.junit.Test
import kotlin.test.assertTrue

/**
 * Created by linsixin on 2017/11/26.
 */
class TestBoolValue{

    @Test
    fun testAsBool(){
        assertTrue(!BoolValue.ZERO.toBool)
        assertTrue(BoolValue.ONE.toBool)
    }

    @Test
    fun testAsInt(){
        assert(BoolValue.ZERO.toInt == 0)
        assert(BoolValue.ONE.toInt == 1)
//        assertEquals(0,BoolValue.ZERO.toInt)
//        assertEquals(1,BoolValue.ONE.toInt)
    }
}