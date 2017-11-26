package entity.bool

import org.junit.Test

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
}