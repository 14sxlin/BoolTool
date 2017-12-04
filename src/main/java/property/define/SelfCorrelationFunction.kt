package property.define

import entity.bool.BoolFunction
import entity.bool.BoolVector

/**
 * Created by linsixin on 2017/12/4.
 * 自相关函数 , 参考 密码学中布尔函数的性质和构造 p12
 */
class SelfCorrelationFunction(boolFunction: BoolFunction):BoolFunction(boolFunction.varLength) {

    private val differential = Differential(boolFunction)

    override fun resultOf(a: BoolVector): Int {
        var result = 0
        (0..maxInput()).forEach {
            val r = differential.resultOf(BoolVector.createBoolVector(it,varLength),a)
            result += neg1Power(r)
        }
        return result
    }

    override fun weight(): Int {
        throw IllegalStateException("should not call this method")
    }


    /**
     * (-1)^pow
     */
    private fun neg1Power(pow: Int)= if (pow % 2 == 0) 1 else -1

}