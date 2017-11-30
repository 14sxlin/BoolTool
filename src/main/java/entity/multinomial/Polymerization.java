package entity.multinomial;

import entity.bool.BoolFunction;
import entity.bool.BoolVector;

import java.util.HashSet;

/**
 * Created by linsixin on 2017/11/24.
 * 代表了 GF(2) -> GF(2) 的多项式
 */
public abstract class Polymerization<T extends Term> extends BoolFunction{

    HashSet<T> terms;
    int weight = -1;

    void checkAndInitVarLength(){
        int length = -1;
        for(Term term:terms){
            if(length == -1)
                length = term.getVarLen();
            else{
                if(length != term.getVarLen())
                    throw new IllegalArgumentException("terms should have same variable length");
            }
        }
        this.varLength = length;
    }


    @Override
    public int resultOf(BoolVector x) {
        if(varLength == -1) // only OneTerm,no matter what input , result is 1
            return 1;
        int result = 0;
        for(Term term:terms){
            result += term.resultOf(x);
            result %= 2;
        }
        return result;
    }


    @Override
    public int weight() {
        if(weight != -1)
            return weight;
        int varLength = getVarLength();
        int count = 0;
        for(int i=0; i<= maxInput(); i++){
            if(resultOf(BoolVector.createBoolVector(i,varLength)) == 1)
                count++;
        }
        weight = count;
        return count;
    }
}
