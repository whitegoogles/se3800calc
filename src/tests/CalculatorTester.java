package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se3800.Calculator;
import se3800.CalculatorInterface;
import se3800.NegativeException;
import se3800.ParamsException;

/**
 * Tests the Calculator class
 * @author boddyn
 * @version 2016.01.06.1
 */
public class CalculatorTester {
    
    CalculatorInterface myCalculator;
    
    @Before
    public void setUp() throws Exception {
        myCalculator = new Calculator();
    }

    @After
    public void tearDown() throws Exception {
        
    }
    
    @Test
    public void testAdd1() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(new Double(5));
        doubles.add(new Double(3));
        Double expected = new Double(8);
        Double actual = Double.NaN;
        try {
            actual = myCalculator.add(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testAdd2() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(new Double(4));
        doubles.add(new Double(7));
        doubles.add(new Double(2));
        double expected = 13;
        double actual = 0;
        try {
            actual = myCalculator.add(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testAdd3() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(new Double(1032));
        doubles.add(new Double(2788));
        Double expected = new Double(3820);
        Double actual = Double.NaN;
        try {
            actual = myCalculator.add(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testAdd4() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(new Double(962210));
        doubles.add(new Double(-18));
        doubles.add(new Double(21));
        Double expected = new Double(962213);
        Double actual = Double.NaN;
        try {
            actual = myCalculator.add(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testAdd5() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.POSITIVE_INFINITY);
        doubles.add(new Double(10));
        Double expected = Double.POSITIVE_INFINITY;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.add(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testAdd6() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.NEGATIVE_INFINITY);
        doubles.add(new Double(10));
        Double expected = Double.NEGATIVE_INFINITY;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.add(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testAdd7() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.NaN);
        doubles.add(new Double(10));
        Double expected = Double.NaN;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.add(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testAdd8() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.POSITIVE_INFINITY);
        doubles.add(Double.NaN);
        doubles.add(new Double(11));
        Double expected = Double.NaN;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.add(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testAdd9() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.POSITIVE_INFINITY);
        doubles.add(Double.NEGATIVE_INFINITY);
        Double expected = Double.NaN;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.add(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testAdd10() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.POSITIVE_INFINITY);
        doubles.add(Double.NEGATIVE_INFINITY);
        doubles.add(new Double(10));
        Double expected = Double.NaN;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.add(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testSub1() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(new Double(5));
        doubles.add(new Double(3));
        Double expected = new Double(2);
        Double actual = Double.NaN;
        try {
            actual = myCalculator.sub(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testSub2() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(new Double(4));
        doubles.add(new Double(7));
        doubles.add(new Double(2));
        Double expected = new Double(-5);
        Double actual = Double.NaN;
        try {
            actual = myCalculator.sub(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testSub3() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(new Double(1032));
        doubles.add(new Double(2788));
        Double expected = new Double(-1756);
        Double actual = Double.NaN;
        try {
            actual = myCalculator.sub(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testSub4() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(new Double(962210));
        doubles.add(new Double(-18));
        doubles.add(new Double(21));
        Double expected = new Double(962207);
        Double actual = Double.NaN;
        try {
            actual = myCalculator.sub(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testSub5() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.POSITIVE_INFINITY);
        doubles.add(new Double(10));
        Double expected = Double.POSITIVE_INFINITY;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.sub(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testSub6() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.NEGATIVE_INFINITY);
        doubles.add(new Double(10));
        Double expected = Double.NEGATIVE_INFINITY;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.sub(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testSub7() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.NaN);
        doubles.add(new Double(10));
        Double expected = Double.NaN;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.sub(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testSub8() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.POSITIVE_INFINITY);
        doubles.add(Double.NaN);
        doubles.add(new Double(11));
        Double expected = Double.NaN;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.sub(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testSub9() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.POSITIVE_INFINITY);
        doubles.add(Double.NEGATIVE_INFINITY);
        Double expected = Double.POSITIVE_INFINITY;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.sub(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testSub10() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.POSITIVE_INFINITY);
        doubles.add(Double.NEGATIVE_INFINITY);
        doubles.add(new Double(10));
        Double expected = Double.POSITIVE_INFINITY;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.sub(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testMult1() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(new Double(5));
        doubles.add(new Double(3));
        Double expected = new Double(15);
        Double actual = Double.NaN;
        try {
            actual = myCalculator.mult(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testMult2() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(new Double(4));
        doubles.add(new Double(7));
        doubles.add(new Double(2));
        Double expected = new Double(56);
        Double actual = Double.NaN;
        try {
            actual = myCalculator.mult(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testMult3() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(new Double(1032));
        doubles.add(new Double(2788));
        Double expected = new Double(2877216);
        Double actual = Double.NaN;
        try {
            actual = myCalculator.mult(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testMult4() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(new Double(962210));
        doubles.add(new Double(-18));
        doubles.add(new Double(21));
        Double expected = new Double(-363715380);
        Double actual = Double.NaN;
        try {
            actual = myCalculator.mult(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testMult5() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.POSITIVE_INFINITY);
        doubles.add(new Double(10));
        Double expected = Double.POSITIVE_INFINITY;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.mult(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testMult6() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.NEGATIVE_INFINITY);
        doubles.add(new Double(10));
        Double expected = Double.NEGATIVE_INFINITY;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.mult(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testMult7() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.NaN);
        doubles.add(new Double(10));
        Double expected = Double.NaN;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.mult(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testMult8() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.POSITIVE_INFINITY);
        doubles.add(Double.NaN);
        doubles.add(new Double(11));
        Double expected = Double.NaN;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.mult(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testMult9() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.POSITIVE_INFINITY);
        doubles.add(Double.NEGATIVE_INFINITY);
        Double expected = Double.NEGATIVE_INFINITY;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.mult(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testMult10() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.POSITIVE_INFINITY);
        doubles.add(Double.NEGATIVE_INFINITY);
        doubles.add(new Double(10));
        Double expected = Double.NEGATIVE_INFINITY;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.mult(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testDiv1() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(new Double(5));
        doubles.add(new Double(3));
        Double expected = new Double(1);
        Double actual = Double.NaN;
        try {
            actual = myCalculator.div(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testDiv2() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(new Double(40));
        doubles.add(new Double(7));
        doubles.add(new Double(2));
        Double expected = new Double(2);
        Double actual = Double.NaN;
        try {
            actual = myCalculator.div(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testDiv3() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(new Double(10320));
        doubles.add(new Double(1000));
        Double expected = new Double(10);
        Double actual = Double.NaN;
        try {
            actual = myCalculator.div(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testDiv4() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(new Double(962210));
        doubles.add(new Double(-18));
        doubles.add(new Double(21));
        Double expected = new Double(-2545);
        Double actual = Double.NaN;
        try {
            actual = myCalculator.div(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testDiv5() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.POSITIVE_INFINITY);
        doubles.add(new Double(10));
        Double expected = Double.POSITIVE_INFINITY;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.div(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testDiv6() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.NEGATIVE_INFINITY);
        doubles.add(new Double(10));
        Double expected = Double.NEGATIVE_INFINITY;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.div(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testDiv7() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.NaN);
        doubles.add(new Double(10));
        Double expected = Double.NaN;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.div(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testDiv8() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.POSITIVE_INFINITY);
        doubles.add(Double.NaN);
        doubles.add(new Double(11));
        Double expected = Double.NaN;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.div(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testDiv9() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.POSITIVE_INFINITY);
        doubles.add(Double.NEGATIVE_INFINITY);
        Double expected = Double.NaN;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.div(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testDiv10() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(Double.POSITIVE_INFINITY);
        doubles.add(Double.NEGATIVE_INFINITY);
        doubles.add(new Double(10));
        Double expected = Double.NaN;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.div(doubles);
        } catch (ParamsException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testFactorial1() {
        Double testValue = new Double(0);
        Double expected = new Double(1);
        Double actual = Double.NaN;
        try {
            actual = myCalculator.factorial(testValue);
        } catch (ParamsException e) {
            fail();
        } catch (NegativeException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testFactorial2() {
        Double testValue = new Double(5);
        Double expected = new Double(120);
        Double actual = Double.NaN;
        try {
            actual = myCalculator.factorial(testValue);
        } catch (ParamsException e) {
            fail();
        } catch (NegativeException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testFactorial3() {
        Double testValue = Double.POSITIVE_INFINITY;
        Double expected = Double.POSITIVE_INFINITY;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.factorial(testValue);
        } catch (ParamsException e) {
            fail();
        } catch (NegativeException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testFactorial4() {
        Double testValue = Double.NEGATIVE_INFINITY;
        try {
            myCalculator.factorial(testValue);
        } catch (ParamsException e) {
            assert false;
        } catch (NegativeException e) {
            assert true;
        }
        assert false;
    }
    
    @Test
    public void testFactorial5() {
        Double testValue = Double.NaN;
        Double expected = Double.NaN;
        Double actual = Double.NaN;
        try {
            actual = myCalculator.factorial(testValue);
        } catch (ParamsException e) {
            fail();
        } catch (NegativeException e) {
            fail();
        }
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testFactorial6() {
        Double testValue = new Double(-5);
        try {
            myCalculator.factorial(testValue);
        } catch (ParamsException e) {
            assert false;
        } catch (NegativeException e) {
            assert true;
        }
        assert false;
    }
    
    @Test
    public void testFactorial7() {
        Double testValue = new Double(4.5);
        try {
            myCalculator.factorial(testValue);
        } catch (ParamsException e) {
            assert true;
        } catch (NegativeException e) {
            assert false;
        }
        assert false;
    }
    
    @Test
    public void testParamsException() {
        List<Double> doubles = new ArrayList<Double>();
        doubles.add(new Double(1));
        try {
            myCalculator.add(doubles);
        } catch (ParamsException e) {
            assert true;
        }
        assert false;
    }

}
