package entity.multinomial;

import org.junit.Test;

import static entity.multinomial.BoolPolymerization.BoolTerm;
import static org.junit.Assert.assertEquals;

/**
 * Created by linsixin on 2017/11/23.
 */
public class TestBoolPolymerization {

    BoolPolymerization poly1 = new BoolPolymerization();

    @Test
    public void testAddPoly(){
        final int total = 4;
        BoolTerm[] terms1 = new BoolTerm[]{
            BoolTerm.create(total,1,3),
            BoolTerm.create(total,2,3),
            BoolPolymerization.ONE_TERM
        };
        BoolTerm[] terms2 = new BoolTerm[]{
                BoolTerm.create(total,1,3),
                BoolTerm.create(total,1,2),
                BoolPolymerization.ONE_TERM
        };
        BoolPolymerization poly1 = new BoolPolymerization(terms1);
        BoolPolymerization poly2 = new BoolPolymerization(terms2);
        System.out.println(poly1.toString());
        System.out.println(poly2.toString());
        poly1.addPoly(poly2);
        assertEquals("x2x3 + x1x2 + ",poly1.toString());
        System.out.println(poly1.toString());
    }

    @Test
    public void testAddTerm(){
        final int total = 4;
        BoolTerm[] terms1 = new BoolTerm[]{
                BoolTerm.create(total,1,3),
                BoolTerm.create(total,2,3),
                BoolPolymerization.ONE_TERM
        };
        BoolPolymerization poly1 = new BoolPolymerization(terms1);
        System.out.println(poly1.toString());
        System.out.println(BoolPolymerization.ONE_TERM);
        poly1.addTerm(BoolPolymerization.ONE_TERM);
        assertEquals("x2x3 + x1x3 + ",poly1.toString());
        System.out.println(poly1.toString());

        poly1.addTerm(BoolTerm.create(total,1,3));
        assertEquals("x2x3 + ",poly1.toString());
        System.out.println(poly1.toString());

        poly1.addTerm(BoolTerm.create(total,0,3));
        assertEquals("x0x3 + x2x3 + ",poly1.toString());
        System.out.println(poly1.toString());
    }
}
