package entity.multinomial;

import entity.bool.BoolResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

/**
 * Created by linsixin on 2017/11/22.
 */
public final class BoolPolymerization
        extends Polymerization<BoolPolymerization.BoolTerm>{


    public static final OneTerm ONE_TERM = new OneTerm();

    public BoolPolymerization(){
        terms = new HashSet<>();
    }

    /**
     * 初始化一个多项式
     * @param terms 多项式的项
     */
    public BoolPolymerization(HashSet<BoolTerm> terms){
        if(terms == null)
            throw new IllegalArgumentException();
        this.terms = terms;
        checkAndInitVarLength();
    }

    /**
     * 初始化一个多项式,这个多项式中只有一个项
     * @param terms 唯一的项
     */
    public BoolPolymerization(BoolTerm ...terms){
        if(terms == null)
            throw new IllegalArgumentException();
        this.terms = new HashSet<>();
        Collections.addAll(this.terms, terms);
        checkAndInitVarLength();
    }


    /**
     * 标准的布尔函数的多项式的项
     */
    public static class BoolTerm extends Term {

        public static BoolTerm create(int total,int ...varIndex){
            boolean[] elems = new boolean[total];
            for(int i:varIndex)
                elems[i] = true;
            return new BoolTerm(elems);
        }


        BoolTerm(){ // 给OneTerm调用的
            super();
        }

        BoolTerm(boolean elems[]){
            super(elems);
        }

        public BoolTerm multiply(BoolTerm term) {
            if(term == ONE_TERM)
                return new BoolTerm(elems); // 解决其他term * one_term的问题
            assert term.elems.length == elems.length;

            boolean newElems[] = new boolean[elems.length];
            for(int i=0;i<elems.length; i++){
                newElems[i] = elems[i] || term.elems[i];
            }

            return new BoolTerm(newElems);  // 为了不改变原来集合的元素
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof BoolTerm)) return false;

            BoolTerm boolTerm = (BoolTerm) o;

            return Arrays.equals(elems, boolTerm.elems);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(elems);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<elems.length; i++){
                if(elems[i])
                    sb.append("x").append(i);
            }
            return sb.toString();
        }
    }

    /**
     * 标准的布尔函数中的常数项 1
     */
    private static final class OneTerm extends BoolTerm{

        //解决了 one_term * 其他term 的问题 与 one_term * one_term 的问题
        @Override
        public BoolTerm multiply(BoolTerm term) {
            if(term == ONE_TERM)
                return ONE_TERM;
            return new BoolTerm(term.elems);  //hash set 迭代的时候 不能改变元素的值
        }

        @Override
        public String toString() {
            return "1";
        }

        /**
         * 初始化多项式的时候,需要检查元素的变量的长度的一致性
         * 但是 1 项是没有长度, 规定为 -1
         * {@see checkAndInitVarLength}
         * @return -1
         */
        @Override
        public int getVarLen() {
            return -1;
        }
    }


    /**
     * 多项式乘上一个项
     * @param otherTerm BoolTerm
     */
    public void multiplyTerm(BoolTerm otherTerm){
        HashSet<BoolTerm> newSet = new HashSet<>();
        BoolTerm result;
        for(BoolTerm thisTerm: terms){
            result = thisTerm.multiply(otherTerm);
            System.out.println(thisTerm.toString() + " * "+otherTerm.toString()+ " = " + result.toString());
            addTermsWithoutDuplication(newSet,result);
        }
        this.terms = newSet;
    }

    /**
     * 多项式乘上一个多项式
     * @param poly BoolPolymerization
     */
    public void multiplyPoly(BoolPolymerization poly){
        HashSet<BoolTerm> newSet = new HashSet<>();
        BoolTerm result;
        for(BoolTerm thisTerm:terms){
            for(BoolTerm otherTerm : poly.terms) {
                result = thisTerm.multiply(otherTerm);
                System.out.println(thisTerm.toString() + " * "+otherTerm.toString()+ " = " + result.toString());
                addTermsWithoutDuplication(newSet,result);
            }
        }
        this.terms = newSet;
    }

    /**
     * 多项式加 新的项
     * @param term 项
     */
    public void addTerm(BoolTerm term){
        addTermsWithoutDuplication(terms,term);
    }

    /**
     *  多项式 + 多项式
     * @param poly 多项式
     */
    public void addPoly(BoolPolymerization poly){
        for(BoolTerm term: poly.terms)
            addTerm(term);
    }

    /**
     * 如果要加入的元素已经存在,那么将该元素从集合中删除(布尔运算)
     * @param set 要加入元素的集合
     * @param toAdd 要加入的元素
     */
    private void addTermsWithoutDuplication(HashSet<BoolTerm> set, BoolTerm toAdd){
        if(set.contains(toAdd))
            set.remove(toAdd);
        else set.add(toAdd);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(BoolTerm term : terms){
            sb.append(term.toString()).append(" + ");
        }
        return sb.toString();
    }


}
