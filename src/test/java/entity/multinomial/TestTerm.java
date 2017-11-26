package entity.multinomial;

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
        term.resultOf(new boolean[]{false,true,false,true,true});
    }

    @Test
    public void testResultOfTerm_BooleanArray(){
        boolean[] x = new boolean[]{false,true,false,true}; //0101
        assertEquals(1,term.resultOf(x));

        boolean[] x0 = new boolean[]{true,false,true,false}; //1010
        assertEquals(0,term.resultOf(x0));

        boolean[] x1 = new boolean[]{false,false,false,true}; // 0001
        assertEquals(0,term.resultOf(x1));
    }

    @Test
    public void testResultOfTerm_Int(){
        assertEquals(1,term.resultOf(Integer.valueOf("0101",2)));
        assertEquals(0,term.resultOf(Integer.valueOf("1010",2)));
        assertEquals(0,term.resultOf(Integer.valueOf("0001",2)));
    }


}
