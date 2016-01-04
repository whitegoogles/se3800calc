package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import se3800.History;
import se3800.HistoryInterface;

public class HistoryTester {
    HistoryInterface myHistory;
    @Before
    public void setUp() throws Exception {
        myHistory = new History();
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testAddHistory(){
        String [] results = {"mas","aig rean","ad audi","First","Chain",
                             "1","2","12","x","aksdfj","kasdjf"}; 
        for(String result: results){
            myHistory.addResult(result);
        }
        for(int i = 0; i<results.length; i++){
            assertEquals(results[i],myHistory.getResult(i));
        }
    }
    @Test
    public void testMaxHistory(){
        for(int i = 0; i<=1001; i++){
            myHistory.addResult(""+i);
        }
        for(int i = 0; i<1000; i++){
            assertEquals(i+1,myHistory.getResult(i));
        }
    }
    @Test
    public void testEmptyHistory(){
        String [] addMe = {"a","b","d","e"};
        for(String a: addMe){
            myHistory.addResult(a);
        }
        myHistory.clear();
        
        //This should throw an exception or something
        myHistory.getResult(0); 
        fail(); 
    }
    
    @Test
    public void testClearHistoryEmpty(){
        
    }
    
    @Test
    public void testGetHistoryBadIndex(){        
        //This should throw an exception or something
        myHistory.getResult(0); 
        fail(); 
    }
}
