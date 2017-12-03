package entity.bool

import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by linsixin on 2017/11/26.
 */
class TestBoolVector{

    @Test
    fun testBoolIntAt(){
        val boolVector = BoolVector.createBoolVector(4, setOf(1,3))
        assert(boolVector.boolAt(1) && boolVector.boolAt(3))
        assert(boolVector.intAt(1) == 1)
        assert(boolVector.intAt(3) == 1)
        assert(!boolVector.boolAt(0))
        assert(!boolVector.boolAt(2))
    }

    @Test
    fun testBoolAdd(){
        val bool1 = BoolVector.createBoolVector(4, setOf(0,1))
        val bool2 = BoolVector.createBoolVector(4, setOf(2,3))
        val result = bool1.boolAdd(bool2)
        assertEquals(4,result.weight())

        assertEquals(0,bool1.boolAdd(bool1).weight())

        val bool3 = BoolVector.createBoolVector(4, setOf(0,2))
        val r2 = bool1.boolAdd(bool3)
        assertEquals(2,r2.weight())
        assertEquals(false,r2.boolAt(0))
        assertEquals(true,r2.boolAt(1))
        assertEquals(true,r2.boolAt(2))

    }

    @Test
    fun testBoolMultiply(){
        val bool1 = BoolVector.createBoolVector(4, setOf(0,1))
        val bool2 = BoolVector.createBoolVector(4, setOf(2,3))
        assertEquals(0,bool1.multiply(bool2))
        assertEquals(0,bool1.multiply(bool1))
    }

    @Test
    fun testIntValue(){
        val bool1 = BoolVector.createBoolVector(4, setOf(0,1))
        val bool2 = BoolVector.createBoolVector(4, setOf(2,3))
        assertEquals(12,bool1.intValue())
        assertEquals(3,bool2.intValue())

    }
}