package entity.bool;

/**
 * Created by linsixin on 2017/11/22.
 * This class represent a bool function,
 * providing the method of a bool function
 */
public abstract class BoolFunction implements BoolResult {

    /**
     * 多项式输入变量的长度
     * 如果多项式只有常数项1 , 那么变量的数目无法确定
     * 此时 varLength 为 { @See OneTerm } 的 varLength 也就是 -1
     */
    protected int varLength;

    /**
     * @return 布尔函数的输入变量的个数
     */
    public int getVarLength(){
        return varLength;
    }

    /**
     * 最大的可能输入,目前受限于数组的长度
     * @return 实际上就是变量长度个1的整数形式
     */
    public int maxInput(){
        long max = (long)((1 << varLength) - 1);
        if(max > Integer.MAX_VALUE)
            throw new IllegalArgumentException("var length too large");
        return (int)max;
    }

    /**
     * bool 函数的weight
     * @return
     */
    public abstract int weight();
}
