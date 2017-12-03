package property

import entity.bool.BoolFunction
import entity.bool.BoolVector

/**
 * Created by linsixin on 2017/12/3.
 * 导数,布尔函数关于a的导数
 */
class Differential constructor(val boolFunction: BoolFunction, val a:BoolVector) {

    init {
        if(boolFunction.varLength != a.length)
            throw IllegalArgumentException("x.length should = a.length")
    }

    fun resultOf(x:BoolVector):Int {
        return (boolFunction.resultOf(x)
                + boolFunction.resultOf(a.boolAdd(x))) % 2
    }

    fun printTable(gap: Int) {
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