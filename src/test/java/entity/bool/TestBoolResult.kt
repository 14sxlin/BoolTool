package entity.bool

import org.junit.Test
import kotlin.test.assertFails

/**
 * Created by linsixin on 2017/11/26.
 */
class TestBoolResult {

    @Test
    fun testBoolArray2Int() {
        assert( 1 ==
                booleanArray2int(booleanArrayOf(false,false,false,true)))
        assert(0 ==
                booleanArray2int(booleanArrayOf(false,false,false,false)))
        assert( Integer.parseInt("1111",2) ==
                booleanArray2int(booleanArrayOf(true,true,true,true)))
        assert( Integer.parseInt("1011",2) ==
                booleanArray2int(booleanArrayOf(true,false,true,true)))
        assert( Integer.MAX_VALUE ==
                booleanArray2int(BooleanArray(32){ true })
        )
        assertFails { booleanArray2int(booleanArrayOf()) }
        assertFails { booleanArray2int(null) }
    }

    @Test
    fun testIntArray2Int(){
        assert(0 == intArray2int(intArrayOf(0)))
        assert(1 == intArray2int(intArrayOf(1)))
        assert(Integer.parseInt("1100",2) == intArray2int(intArrayOf(1,1,0,0)))
        assert(Integer.MAX_VALUE ==
                intArray2int(IntArray(32){ 1 }))
        assertFails { intArray2int(intArrayOf()) }

    }

    @Test
    fun testInt2BoolArray(){
        assert(booleanArrayOf(false,false,false,false).contentEquals(
                int2BooleanArray(0,4)))
        assert(booleanArrayOf(false,false,false,true).contentEquals(
                int2BooleanArray(1,4)))
        assert(BooleanArray(32){true}.contentEquals(
                int2BooleanArray(Int.MAX_VALUE,32)))
        assertFails { int2BooleanArray(1,0) }
        assertFails { int2BooleanArray(-100,10) }
    }
}