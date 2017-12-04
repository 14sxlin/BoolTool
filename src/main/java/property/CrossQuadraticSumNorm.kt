package property

import entity.bool.BoolFunction
import entity.bool.BoolVector
import property.define.CrossCorrelationFunction
import property.define.SelfCorrelationFunction

/**
 * Created by linsixin on 2017/12/4.
 */
class CrossQuadraticSumNorm {

    fun resultOf(f: BoolFunction,g:BoolFunction):Int {
        val varLen = f.varLength
        val crossCorrelationFunction = CrossCorrelationFunction(f,g)
        return (0..f.maxInput()).fold(0){ acc,a ->
            val v= crossCorrelationFunction.resultOf(BoolVector.createBoolVector(a,varLen))
            acc + v * v
        }
    }
}