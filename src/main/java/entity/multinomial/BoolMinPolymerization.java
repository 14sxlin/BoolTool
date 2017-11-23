package entity.multinomial;

import java.util.Collections;
import java.util.HashSet;

/**
 * Created by linsixin on 2017/11/22.
 * 布尔函数的小项表示
 */
public class BoolMinPolymerization {

    private HashSet<MinTerm> terms;

    public BoolMinPolymerization(MinTerm ...terms){
        if(terms == null)
            throw new IllegalArgumentException();
        this.terms = new HashSet<>();
        Collections.addAll(this.terms, terms);
    }

    public BoolMinPolymerization(HashSet<MinTerm> terms){
        if(terms == null)
            throw new IllegalArgumentException();
        this.terms = terms;
    }

    public BoolPolymerization toPolymerization(){
        BoolPolymerization poly = new BoolPolymerization();
        for(MinTerm minTerm : terms){
            poly.addPoly(minTerm.toPolymerization());
        }
        return poly;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(MinTerm term : terms){
            sb.append(term.toString()).append(" + ");
        }
        return sb.toString();
    }



    /**
     *  布尔函数小项表示中的项
     */
    public static class MinTerm extends Term{

        /**
         * 表示上标为0(小项表示)的下标集合
         * 如果一个下标在negativeSet中,那么这个下标的上标是0
         * 比如 elems = [true,false,true]
         *      negativeSet = { 2 }
         *      表示 x0^1x2^0
         */
        HashSet<Integer> negativeSet;

        public MinTerm(boolean[] elems,HashSet<Integer> negativeSet){
            this.elems = elems;
            this.negativeSet = negativeSet;
            elemsCheck();
            if(negativeSet == null)
                throw new IllegalArgumentException("negative set shouldn't be null");
        }


        public BoolPolymerization toPolymerization(){
            if(negativeSet.isEmpty())
                return new BoolPolymerization(this.toBoolTerm());

            System.out.println("term: " + toString());

            //负元素转化成 (负元素 + 1) 的多项式  运用多项式的乘法将它们乘起来
            BoolPolymerization current,total = null;
            for(int negIndex:negativeSet){
                if(total == null){
                    total = createPolyWithOne(negIndex);
                }else{
                    current = createPolyWithOne(negIndex);
                    total.multiplyPoly(current);
                }
            }
            assert total != null; // 因为一开始已经检查了 negativeSet.isEmpty()

            // 找到非负的元素
            boolean anyTrue = false;
            boolean[] notNegElems = new boolean[elems.length];
            for(int i=0; i< elems.length; i++){
                notNegElems[i] = elems[i] && !negativeSet.contains(i);
                anyTrue = anyTrue || notNegElems[i];
            }

            //如果有非负的项的话,将非负元素x变为 项 ,乘上多项式
            if(anyTrue) {
                BoolPolymerization.BoolTerm notNegativeTerm =
                        new BoolPolymerization.BoolTerm(notNegElems);
                total.multiplyTerm(notNegativeTerm);
            }

            return total;

        }

        private BoolPolymerization createPolyWithOne(int negIndex){
            HashSet<BoolPolymerization.BoolTerm> terms = new HashSet<>();
            boolean[] negElem = new boolean[elems.length];
            negElem[negIndex] = true;
            terms.add(new BoolPolymerization.BoolTerm(negElem));
            terms.add(BoolPolymerization.ONE_TERM);
            return new BoolPolymerization(terms);
        }

        private BoolPolymerization.BoolTerm toBoolTerm(){
            return new BoolPolymerization.BoolTerm(this.elems);
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<elems.length; i++){
                if(elems[i]){
                    if(negativeSet.contains(i))
                        sb.append("x").append(i).append("^").append("0");
                    else
                        sb.append("x").append(i).append("^").append("1");
                }

            }
            return sb.toString();
        }
    }

}
