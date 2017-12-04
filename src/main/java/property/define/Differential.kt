package property.define

import entity.bool.BoolFunction
import entity.bool.BoolVector

/**
 * Created by linsixin on 2017/12/3.
 * 导数,布尔函数关于a的导数
 */
class Differential constructor(val boolFunction: BoolFunction) : BoolFunction(boolFunction.varLength) {

    private lateinit var a:BoolVector

    constructor(boolFunction: BoolFunction,a:BoolVector):this(boolFunction){
        if(boolFunction.varLength != a.length)
            throw IllegalArgumentException("x.length should = a.length")
        this.a = a
    }

    override fun resultOf(x:BoolVector):Int {
        return resultOf(x,this.a)
    }

    fun resultOf(x:BoolVector,a:BoolVector):Int {
        if(boolFunction.varLength != a.length)
            throw IllegalArgumentException("x.length should = a.length")
        return (boolFunction.resultOf(x)
                + boolFunction.resultOf(a.boolAdd(x))) % 2
    }

    override fun weight(): Int {
        val len = boolFunction.varLength
        return (0..boolFunction.maxInput()).count {
            resultOf(BoolVector.createBoolVector(it,len)) == 1
        }
    }

    fun printTable(gap: Int = 4) {
        assert(gap > 0)
        val varLength = boolFunction.varLength
        for (i in 0..boolFunction.maxInput()) {
            val s = Integer.toBinaryString(i)
            val firstNum = s[0] - '0'
            val len = s.length - 1
            print(String.format("%0" + (varLength - len) + "d%s : %d\t",
                            firstNum,
                            s.substring(1),
                            resultOf(BoolVector.createBoolVector(i, varLength))))
            if ((i + 1) % gap == 0) println()
        }
    }
}