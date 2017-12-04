package property

import entity.bool.BoolFunction
import entity.bool.setOfVectors

/**
 * Created by linsixin on 2017/12/3.
 */
object GlobalAvalanche {
    /**
     * 是否满足严格雪崩准则,也就是对于 wt(a)=1 的该布尔函数的关于 a 的导数都是平衡函数
     */
    fun isSAC(boolFunction: BoolFunction):Boolean {
        setOfVectors(boolFunction.varLength,1)
                .asSequence()
                .map {
                    println("a : " + it.toBinaryString())
                    Differential(boolFunction, it)
                }
                .forEach {
                    it.printTable()
                    println()
                    if(!Balance.isBalance(it))
                        return false
                }
        return true
    }

    /**
     * 求布尔函数的 p次扩散准则 对于 1 <= wt(a) <= p 的该布尔函数的关于 a 的导数都是平衡函数
     */
    fun pcOf(boolFunction: BoolFunction):Int {
        var order = 0
        for( p in 1 .. boolFunction.varLength){
            if(satisfyP(boolFunction,p))
                order = p
            else return order
        }
        return order
    }

    /**
     * wt(a) = p 的时候 Df(a)是不是平衡函数
     * @return
     */
    private fun satisfyP(boolFunction: BoolFunction,p:Int):Boolean {
        setOfVectors(boolFunction.varLength,p)
                .asSequence()
                .map { Differential(boolFunction, it) }
                .forEach {
                    it.printTable()
                    if(!Balance.isBalance(it))
                        return false
                }
        return true
    }
}