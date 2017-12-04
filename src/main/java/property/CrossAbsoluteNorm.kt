package property

import entity.bool.BoolFunction
import entity.bool.BoolVector
import property.define.CrossCorrelationFunction
import property.define.SelfCorrelationFunction
import kotlin.math.abs

/**
 * Created by linsixin on 2017/12/4.
 */
object CrossAbsoluteNorm {

    fun resultOf(f: BoolFunction,g:BoolFunction):Int{
        val crossCorrelationFunction = CrossCorrelationFunction(f,g)
        val varLen = f.varLength
        return (0..f.maxInput()).map {
            crossCorrelationFunction.resultOf(BoolVector.createBoolVector(it,varLen))
        }.maxBy { abs(it) } ?:throw IllegalArgumentException("null max")
    }
}