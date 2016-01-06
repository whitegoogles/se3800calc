package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se3800.Calculator;
import se3800.CalculatorInterface;
import se3800.ParamsException;

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
        double expected = 8;
        double actual = 0;
        try {
            actual = myCalculator.add(doubles);
        } catch (ParamsException e) {
            fail();
        }
        
        assertEquals(expected, actual, 0.001);
    }
    
    @Test
    public void testAdd2() {
        fail();
    }
    
    @Test
    public void testAdd3() {
        fail();
    }
    
    @Test
    public void testAdd4() {
        fail();
    }
    
    @Test
    public void testAdd5() {
        fail();
    }
}
