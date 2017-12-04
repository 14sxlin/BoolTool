package property

import entity.bool.BoolFunction
import entity.bool.BoolVector
import property.define.SelfCorrelationFunction

/**
 * Created by linsixin on 2017/12/4.
 * 平方和指标
 */
object QuadraticSumNorm {

    fun resultOf(boolFunction: BoolFunction):Int {
        val varLen = boolFunction.varLength
        val self = SelfCorrelationFunction(boolFunction)
        return (0..boolFunction.maxInput()).fold(0){ acc,a ->
            val v= self.resultOf(BoolVector.createBoolVector(a,varLen))
            acc + v * v
        }
    }
}