package entity.bool

/**
 * Created by linsixin on 2017/11/26.
 */
/**
 * change int[] to boolean[] , 1 -> true , 0 -> false
 * if integer is neither 1 nor 0, then throw IllegalArgumentException
 * @param x 0 1 array
 * @return boolean array
 */
fun intArray2booleanArray(x: IntArray): BooleanArray {
    val input = BooleanArray(x.size)
    for (i in x.indices) {
        if (i == 0) {
            input[i] = false
        } else if (i == 1) {
            input[i] = true
        } else {
            throw IllegalArgumentException("input should only contains 0 or 1, illegal : " + i)
        }
    }
    return input
}

/**
 * change int to  boolean[], using int's binary form
 * 0 -> false, 1-> true
 * @param x the integer
 * @param varLength the length of boolean
 * @return boolean array
 */
fun int2BooleanArray(x: Int, varLength: Int): BooleanArray {
    if (x < 0)
        throw IllegalArgumentException("x should >= 0")
    if (varLength <= 0)
        throw IllegalArgumentException("varLength should > 0")

    val binary = Integer.toBinaryString(x)
    val binLength = binary.length
    if (binLength > varLength)
        throw IllegalArgumentException("number is too long to put into boolean[$varLength]")
    val input = BooleanArray(varLength)
    var count = input.size - 1
    for (i in binLength - 1 downTo 0) {
        input[count--] = binary[i] == '1'
    }
    return input
}

fun int2IntArray(x:Int , varLength: Int):IntArray{
    val result = IntArray(varLength){ 0 }
    for( (i,value) in int2BooleanArray(x,varLength).withIndex()){
        result[i] = if(value) 1 else 0
    }
    return result
}

/**
 * transform 0 1 array to int
 * @param x 0 1 array
 * @return 10 radix of number
 */
fun intArray2int(x: IntArray): Int {
    if (x.isEmpty())
        throw IllegalArgumentException("input x should not be null or empty")
    var result = 0
    var base = 1
    for (i in x.indices.reversed()) {
        result += x[i] * base
        base *= 2
    }
    return result
}

fun booleanArray2int(x: BooleanArray?): Int {
    if (x == null || x.isEmpty())
        throw IllegalArgumentException("input x should not be null or empty")
    var result = 0
    var base = 1
    for (i in x.indices.reversed()) {
        if (x[i])
            result += base
        base *= 2
    }
    return result
}