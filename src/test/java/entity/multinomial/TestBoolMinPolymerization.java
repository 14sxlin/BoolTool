package entity.multinomial;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;

import static entity.multinomial.BoolMinPolymerization.MinTerm;
import static org.junit.Assert.assertEquals;

/**
 * Created by linsixin on 2017/11/23.
 */
public class TestBoolMinPolymerization {

    private HashSet<Integer> negative = new HashSet<>();
    private MinTerm minTerm = new MinTerm(new boolean[]{true,false,true},negative);

    @Before
    public void setup(){
        negative.add(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAssertAnyTrueInitMinTerm(){
        new MinTerm(new boolean[]{false},new HashSet<>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAssertNotNullInitMinTerm(){
        new MinTerm(null,new HashSet<>());
    }

    @Test
    public void testMinTermToString(){
        assertEquals("x0^1x2^0",minTerm.toString());
    }

    @Test
    public void testMinTermToPoly_MultiplyTerm(){
        BoolPolymerization poly = minTerm.toPolymerization();
        String act = poly.toString();
        System.out.println(act);
       assertEquals("x0x2 + x0 + ",act);
    }

    @Test
    public void testMinTermToPoly_MultiplyPoly(){
        negative.add(0);
        BoolPolymerization poly = minTerm.toPolymerization();
        String act = poly.toString();
        System.out.println(act);
        assertEquals("1 + x0x2 + x2 + x0 + ",act);
    }

    @Test
    public void testMinPolyToNormalPoly(){
        MinTerm minTerm1 = new MinTerm(new boolean[]{false,false,true},negative);
        BoolMinPolymerization minPoly =
                new BoolMinPolymerization(minTerm,minTerm1);
        BoolPolymerization poly = minPoly.toPolymerization();
        System.out.println(poly.toString());
    }


}
