package entity.walsh

import entity.bool.BoolVector
import entity.multinomial.BoolPolymerization
import entity.multinomial.BoolPolymerization.BoolTerm
import entity.multinomial.BoolPolymerization.ONE_TERM
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Created by linsixin on 2017/11/26.
 */
class TestLinearWalsh {

    companion object {
        val varLength = 2
        val terms = setOf(
                BoolTerm.create(varLength,0,1),
                BoolTerm.create(varLength,0),
                BoolTerm.create(varLength,1)).toHashSet()

        val boolfun = BoolPolymerization(terms)
        val linearWalsh = LinearWalsh(boolfun,varLength)
    }

    @Test
    fun testGetMaxInput(){
        assertEquals(Integer.parseInt("1111",2),
                LinearWalsh(null,4).maxInput())
        assertEquals(Int.MAX_VALUE,
                LinearWalsh(null,31).maxInput())
    }

    @Test
    fun testWalshResult(){

        assertTrue(0 ==
                boolfun.resultOf(BoolVector.createBoolVector("00",varLength)))
        assertTrue(1 ==
                boolfun.resultOf(BoolVector.createBoolVector("01",varLength)))
        assertTrue(1 ==
                boolfun.resultOf(BoolVector.createBoolVector("10",varLength)))
        assertTrue(1 ==
                boolfun.resultOf(BoolVector.createBoolVector("11",varLength)))


        assertEquals(  3 ,
                linearWalsh.resultOf(BoolVector.createBoolVector("00",varLength)))
        assertEquals( -1 ,
                linearWalsh.resultOf(BoolVector.createBoolVector("01",varLength)))
        assertEquals( -1 ,
                linearWalsh.resultOf(BoolVector.createBoolVector("10",varLength)))
        assertEquals( -1 ,
                linearWalsh.resultOf(BoolVector.createBoolVector("11",varLength)))
    }


    @Test
    fun testWalshResult1(){
        val varLength = 2
        val terms = setOf(
                BoolTerm.create(varLength,0,1),
                ONE_TERM).toHashSet()

        val boolfun = BoolPolymerization(terms)
        assertTrue(1 ==
                boolfun.resultOf(BoolVector.createBoolVector("00",varLength)))
        assertTrue(1 ==
                boolfun.resultOf(BoolVector.createBoolVector("01",varLength)))
        assertTrue(1 ==
                boolfun.resultOf(BoolVector.createBoolVector("10",varLength)))
        assertTrue(0 ==
                boolfun.resultOf(BoolVector.createBoolVector("11",varLength)))

        val linearWalsh = LinearWalsh(boolfun,varLength)
        assertEquals(  3,
                linearWalsh.resultOf(BoolVector.createBoolVector("00",varLength)))
        assertEquals( 1,
                linearWalsh.resultOf(BoolVector.createBoolVector("01",varLength)))
        assertEquals( 1 ,
                linearWalsh.resultOf(BoolVector.createBoolVector("10",varLength)))
        assertEquals( -1 ,
                linearWalsh.resultOf(BoolVector.createBoolVector("11",varLength)))
    }
}