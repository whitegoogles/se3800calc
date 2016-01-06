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
}
