package property

import entity.bool.BoolFunction
import entity.bool.BoolVector
import property.define.SelfCorrelationFunction
import kotlin.math.abs

/**
 * Created by linsixin on 2017/12/4.
 */
object AbsoluteNorm {

    fun resultOf(f: BoolFunction):Int{
        val self = SelfCorrelationFunction(f)
        val varLen = f.varLength
        return (0..f.maxInput()).map {
            self.resultOf(BoolVector.createBoolVector(it,varLen))
        }.maxBy { abs(it) } ?:throw IllegalArgumentException("null max")
    }

}