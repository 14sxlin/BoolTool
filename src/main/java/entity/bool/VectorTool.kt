package entity.bool

/**
 * Created by linsixin on 2017/11/29.
 */
fun setOfVectors(varLen:Int, weight:Int) : Set<BoolVector> {
    if(varLen < 0 || weight <= 0)
        throw IllegalArgumentException("Illegal varLen = $varLen or weight =$weight")
    if(weight > varLen)
        throw IllegalArgumentException("weight($weight) should <= varLen($varLen)")
    if(weight == varLen)
        return setOf(BoolVector.createBoolVector(IntArray(varLen){ 1 }))

    var set = setOf<BoolVector>()
    val ints = IntArray(varLen){ 0 }
    fun gen(currentLen:Int,currentWeight:Int){
        if(currentLen == varLen){
            if(currentWeight == weight){
//                println("add ${ints.joinToString(" ")}")
                set += BoolVector.createBoolVector(ints)
            }
        }else{
            val rest = varLen - currentLen
            val needWeight = weight - currentWeight
            if(currentWeight > weight || currentWeight + rest < weight)
            {
//                println("skip ${ints.joinToString(" ")}")
                return
            }
            if(currentWeight < weight){
                ints[currentLen] = 1
                gen(currentLen + 1,currentWeight + 1)
            }
            if( needWeight < rest){
                ints[currentLen] = 0
                gen(currentLen + 1,currentWeight)
            }
        }
    }
    gen(0,0)
    return set
}