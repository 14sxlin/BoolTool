package property.define

import entity.bool.BoolFunction
import entity.bool.BoolVector

/**
 * Created by linsixin on 2017/12/4.
 * 互相关函数 , 参考 密码学中布尔函数的性质和构造 p12
 */
class CrossCorrelationFunction(val f:BoolFunction,val g:BoolFunction):BoolFunction(f.varLength) {

    init{
        assert(f.varLength == g.varLength)
    }

    private fun crossResultOf(x:BoolVector,a:BoolVector):Int{
        return f.resultOf(x) + g.resultOf(x.boolAdd(a))
    }

    override fun resultOf(a: BoolVector): Int {
        return (0..maxInput()).fold(0){ result,x ->
            result + neg1Power(
                    crossResultOf(BoolVector.createBoolVector(x,varLength),a)
            )
        }
    }

    override fun weight(): Int {
        throw IllegalAccessException("should not call this function")
    }

    /**
     * (-1)^pow
     */
    private fun neg1Power(pow: Int) = if (pow % 2 == 0) 1 else -1
}