package entity.walsh

import entity.bool.BoolVector
import entity.multinomial.BoolPolymerization
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by linsixin on 2017/11/27.
 */
class TestLoopWalsh{

    companion object {
        val varLength = 2
        private val terms = setOf(
                BoolPolymerization.BoolTerm.create(varLength,0,1),
                BoolPolymerization.BoolTerm.create(varLength,0),
                BoolPolymerization.BoolTerm.create(varLength,1)).toHashSet()
        val boolfun = BoolPolymerization(terms)
        val loopWalsh = LoopWalsh(boolfun,varLength)
    }

    @Test
    fun testResult(){

        assertTrue(0 ==
                boolfun.resultOf(BoolVector.createBoolVector("00",varLength)))
        assertTrue(1 ==
                boolfun.resultOf(BoolVector.createBoolVector("01",varLength)))
        assertTrue(1 ==
                boolfun.resultOf(BoolVector.createBoolVector("10",varLength)))
        assertTrue(1 ==
                boolfun.resultOf(BoolVector.createBoolVector("11",varLength)))

        assertEquals(  -2 ,
                loopWalsh.resultOf(BoolVector.createBoolVector("00",varLength)))
        assertEquals( 2 ,
                loopWalsh.resultOf(BoolVector.createBoolVector("01",varLength)))
        assertEquals( 2 ,
                loopWalsh.resultOf(BoolVector.createBoolVector("10",varLength)))
        assertEquals( 2 ,
                loopWalsh.resultOf(BoolVector.createBoolVector("11",varLength)))
    }

    @Test
    fun testResult1(){
        val varLength = 2
        val terms = setOf(
                BoolPolymerization.BoolTerm.create(varLength,0,1),
                BoolPolymerization.ONE_TERM).toHashSet()
        val boolfun = BoolPolymerization(terms)
        val loopWalsh = LoopWalsh(boolfun,varLength)
        assertEquals(  -2 ,
                loopWalsh.resultOf(BoolVector.createBoolVector("00", Companion.varLength)))
        assertEquals( -2 ,
                loopWalsh.resultOf(BoolVector.createBoolVector("01", Companion.varLength)))
        assertEquals( -2 ,
                loopWalsh.resultOf(BoolVector.createBoolVector("10", Companion.varLength)))
        assertEquals( 2 ,
                loopWalsh.resultOf(BoolVector.createBoolVector("11", Companion.varLength)))
    }
}