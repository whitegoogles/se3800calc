package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import se3800.ConsoleApp;

public class ConsoleAppTester {

ConsoleApp console;

    @Before
    public void setUp() throws Exception {
        console = new ConsoleApp();
    }
    @Test
    public void testGetBadCommands(){
        String [] badCommands = {"add1","sub2","first","12","eme","1234","1.2","asdfj","%&(*&(@#","","    ","thank you asdf"};
        for(int i = 0; i<badCommands.length; i+=1){
            assertEquals("Command not recognized\n",console.parseLine(badCommands[i]));
        }
    }
    @Test
    public void testGetHistory() {
    }
    @Test
    public void testClearHistory() {
        console.parseLine("add 1,2,3"); //Add some stuff to the history
        console.parseLine("sub 1,2,3"); 
        console.parseLine("clear");
        console.parseLine("hist");
    }
    /**
     * Should this work???
     */
    @Test
    public void testClearHistoryWithParams() {
        console.parseLine("clear 1 2 3 4 5 6 7 ");
    }
    
    /***************************************************/
    /*     parseLine tests written by Nick Boddy       */
    /***************************************************/
    @Test
    public void testParseLine1() {
        String testLine = "add 1 2";
        String expected = "3\n";
        String actual = console.parseLine(testLine);
        assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testParseLine2() {
        String testLine = "sub 2 1";
        String expected = "1\n";
        String actual = console.parseLine(testLine);
        assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testParseLine3() {
        String testLine = "mult 2 5";
        String expected = "10\n";
        String actual = console.parseLine(testLine);
        assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testParseLine4() {
        String testLine = "div 13 2";
        String expected = "6\n";
        String actual = console.parseLine(testLine);
        assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testParseLine5() {
        String testLine = "fact 6";
        String expected = "720\n";
        String actual = console.parseLine(testLine);
        assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testParseLine6() {
        String testLine = "fact";
        String expected = "Incorrect parameters provided\n";
        String actual = console.parseLine(testLine);
        System.out.println(actual);
        assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testParseLine7() {
        String testLine = "add";
        String expected = "Provided parameters were incorrect\n";
        String actual = console.parseLine(testLine);
        System.out.println(actual);
        assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testParseLine8() {
        String testLine = "exit";
        String expected = "Exiting...\n";
        String actual = console.parseLine(testLine);
        System.out.println(actual);
        assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testParseLine9() {
        String testLine = "";
        String expected = "Command not recognized\n";
        String actual = console.parseLine(testLine);
        System.out.println(actual);
        assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testParseLine10() {
        String testLine = "sub";
        String expected = "Provided parameters were incorrect\n";
        String actual = console.parseLine(testLine);
        System.out.println(actual);
        assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testParseLine11() {
        String testLine = "mult";
        String expected = "Provided parameters were incorrect\n";
        String actual = console.parseLine(testLine);
        System.out.println(actual);
        assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testParseLine12() {
        String testLine = "div";
        String expected = "Provided parameters were incorrect\n";
        String actual = console.parseLine(testLine);
        System.out.println(actual);
        assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testParseLine13() {
        String testLine = "fact -3";
        String expected = "Parameters were negative\n";
        String actual = console.parseLine(testLine);
        System.out.println(actual);
        assertTrue(expected.equals(actual));
    }
    
    @Test
    public void testParseLine14() {
        console.parseLine("add 1 2");
        console.parseLine("mult 3 -2");
        String testLine = "sub !2 !1";
        String expected = "9\n";
        String actual = console.parseLine(testLine);
        System.out.println(actual);
        assertTrue(expected.equals(actual));
    }
    
}
