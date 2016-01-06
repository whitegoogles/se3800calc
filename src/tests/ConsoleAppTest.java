package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import se3800.ConsoleApp;

public class ConsoleAppTest {

ConsoleApp console;
@Rule
public Timeout globalTimeout = Timeout.seconds(1);

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
        console.parseLine("div 1 2 3"); 
        console.parseLine("mult 1 a c"); 
        console.parseLine("sub");
        String[] hist = console.parseLine("hist").split("\n");
        assertEquals("3: 6",hist[0].trim());
        assertEquals("2: -4",hist[1].trim());
        assertEquals("1: 0",hist[2].trim());
    }
    @Test
    public void testClearHistory() {
        console.parseLine("add 1,2,3"); //Add some stuff to the history
        console.parseLine("sub 1,2,3"); 
        console.parseLine("clear");
        assertEquals("",console.parseLine("hist").trim());
    }

    @Test
    public void testClearHistoryWithParams() {
        console.parseLine("add 1,2,3"); //Add some stuff to the history
        console.parseLine("sub 1,2,3"); 
        console.parseLine("clear 1 2 3 a '' meme");
        assertEquals("",console.parseLine("hist").trim());
    }
    @Test
    public void testGetHistoryWithParams() {
        console.parseLine("add 1 2 3"); //Add some stuff to the history
        console.parseLine("sub 1 2 3"); 
        console.parseLine("div 1 2 3"); 
        console.parseLine("mult 1 a c"); 
        console.parseLine("sub");
        String[] hist = console.parseLine("hist 1 meme 2 3 asdfkja 980&&&%()!A!@!1").split("\n");
        assertEquals("3: 6",hist[0].trim());
        assertEquals("2: -4",hist[1].trim());
        assertEquals("1: 0",hist[2].trim());
    }
}
