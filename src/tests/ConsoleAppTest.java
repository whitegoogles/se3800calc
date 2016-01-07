package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import se3800.ConsoleApp;

public class ConsoleAppTest {

    ConsoleApp console;
    /*
     * Tests written by Josh
     * I wrote most of ConsoleApp, so I tried to test just the things
     * that I didn't write (or were kind of non-coverage/BVA tests).
     */
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
        console.parseLine("add 1 2 3"); //Add some stuff to the history
        console.parseLine("sub 1 2 3"); 
        console.parseLine("mult 1 2 3"); 
        console.parseLine("div"); 
        String[] hist = console.parseLine("hist").split("\n");
        assertEquals("3: 6",hist[0]);
        assertEquals("2: -4",hist[1]);
        assertEquals("1: 6",hist[2]);
    }
    @Test
    public void testClearHistory() {
        console.parseLine("add 1 2 3"); //Add some stuff to the history
        console.parseLine("sub 1 2 3"); 
        assertEquals("History cleared",console.parseLine("clear").trim());
    }

    @Test
    public void testClearHistoryWithParams() {
        String message = console.parseLine("clear 1 2 3 4 5 6 7 ");
        assertEquals("History cleared",message.trim());
    }
    @Test
    public void testGetHistoryWithParams() {
        console.parseLine("add 1 2 3"); //Add some stuff to the history
        console.parseLine("sub 1 2 3"); 
        console.parseLine("mult 1 2 3"); 
        console.parseLine("div"); 
        String[] hist = console.parseLine("hist thug *&^*&68176234128347162349786 18234712 378419284817234").split("\n");
        System.out.println(hist.length);
        assertEquals("3: 6",hist[0]);
        assertEquals("2: -4",hist[1]);
        assertEquals("1: 6",hist[2]);
    }
    @Test
    public void testCommandCombinations(){
        String [] commandCombinations = {"add sub mult","add div mult ","div mult add","sub div add","sub 1 2 div"};
        for(int i = 0; i<commandCombinations.length; i++){
            assertEquals("Incorrect parameters provided",console.parseLine(commandCombinations[i]).trim());
        }
    }
    @Test
    public void testHugeInputs(){
        String bigString ="big";
        for(int i = 0; i<10; i++){
            bigString+=bigString;
        }
        assertEquals("Command not recognized",console.parseLine(bigString).trim());
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
