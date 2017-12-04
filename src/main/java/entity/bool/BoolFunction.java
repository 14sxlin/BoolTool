package entity.bool;

import java.util.Formatter;

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

    public BoolFunction(int varLength){
        this.varLength = varLength;
    }

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
        if(varLength > 31 || varLength <=0)
            throw new IllegalArgumentException("var length too large");
        return (1 << varLength) - 1;
    }

    /**
     * bool 函数的weight
     */
    public abstract int weight();

    public void printBoolTable(int gap){
        assert gap > 0;
        for(int i=0;i<=maxInput();i++){
            String s = Integer.toBinaryString(i);
            int firstNum = s.charAt(0) - '0';
            int len = s.length()-1;
            System.out.print(
                    String.format("%0"+(varLength-len)+"d%s : %d\t",
                            firstNum,
                            s.substring(1),
                            resultOf(BoolVector.createBoolVector(i,varLength))));
            if((i+1) % gap == 0) System.out.println();
        }
    }
}
