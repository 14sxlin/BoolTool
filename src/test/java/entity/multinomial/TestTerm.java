package entity.multinomial;

import entity.bool.BoolVector;
import entity.multinomial.BoolPolymerization.BoolTerm;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by linsixin on 2017/11/23.
 */
public class TestTerm {

    private BoolTerm term = BoolTerm.create(4,1,3);

    @Test(expected = IllegalArgumentException.class)
    public void testLengthNotEqualToTerm(){
        term.resultOf(BoolVector.createBoolVector(new boolean[]{false,true,false,true,true}));
    }

    @Test
    public void testResultOfTerm_BooleanArray(){
        boolean[] x = new boolean[]{false,true,false,true}; //0101
        assertEquals(1,term.resultOf(BoolVector.createBoolVector(x)));

        boolean[] x0 = new boolean[]{true,false,true,false}; //1010
        assertEquals(0,term.resultOf(BoolVector.createBoolVector(x0)));

        boolean[] x1 = new boolean[]{false,false,false,true}; // 0001
        assertEquals(0,term.resultOf(BoolVector.createBoolVector(x1)));
    }

    @Test
    public void testResultOfTerm_Int(){
        assertEquals(1,term.resultOf(BoolVector.createBoolVector(Integer.valueOf("0101",2),4)));
        assertEquals(0,term.resultOf(BoolVector.createBoolVector(Integer.valueOf("1010",2),4)));
        assertEquals(0,term.resultOf(BoolVector.createBoolVector(Integer.valueOf("0001",2),4)));
    }


}
