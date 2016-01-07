package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;

import se3800.History;
import se3800.HistoryInterface;
/**
 * Tests the history class in a variety of scenarios.
 * @author daviesj
 *
 */
public class HistoryTest {
    HistoryInterface myHistory;
    @Rule
    public Timeout globalTimeout = Timeout.seconds(20);

    @Before
    public void setUp() throws Exception {
        myHistory = new History(20);
    }

    @After
    public void tearDown() throws Exception {
    }
    @Test
    public void testNegativeHistorySize(){
        myHistory = new History(-1);
        String [] addFive = {"out","my","still","don't","grail"};
        for(String result: addFive){
            myHistory.addResult(result);
        }
        for(int i = 0; i<addFive.length; i++){
            assertEquals(addFive[addFive.length-1-i],myHistory.getResult(i+1));
        }
    }
    @Test
    public void testAddHistory(){
        String [] results = {"mas","aig rean","ad audi","First","Chain",
                "1","2","12","x","aksdfj","kasdjf"}; 
        for(String result: results){
            myHistory.addResult(result);
        }
        for(int i = 0; i<results.length; i++){
            assertEquals(results[results.length-1-i],myHistory.getResult(i+1));
        }
    }
    @Test
    public void testMaxHistory(){
        myHistory = new History(1000);
        for(int i = 0; i<=1001; i++){
            myHistory.addResult(""+i);
        }
        for(int i = 0; i<1000; i++){
            assertEquals(""+(1001-i),myHistory.getResult(i+1));
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
        try{
            myHistory.getResult(1); 
            fail(); 
        }
        catch(Exception e){

        }
    }
    @Test
    public void testTooLargeIndex(){
        try{
            myHistory.getResult(2000000);
            fail();
        }
        catch(Exception e){

        }
    }
    @Test
    public void testGetHistoryBadIndex(){        
        //This should throw an exception or something
        try{
            myHistory.getResult(0);
            fail();
        }
        catch(Exception e){

        }
    }
    @Test
    public void testGetHistoryNegativeIndex(){
        try{
            myHistory.getResult(-1);
            fail();
        }
        catch(Exception e){

        }
    }
    @Test
    public void testReallyLargeHistory(){
        myHistory = new History(5001);
        for(int i =0; i<5001; i++){
            myHistory.addResult(""+i);
        }
        for(int i = 0; i<=5000; i++){
            assertEquals(""+(5000-i),myHistory.getResult(i+1));
        }
    }
    @Test
    public void testWeirdAddValues(){
        myHistory = new History(100);
        String curStr = "1a";
        List<String> values = new ArrayList<String>();
        for(int i = 0; i<20;i++){
            values.add(curStr);
            myHistory.addResult(curStr);
            curStr+=curStr;
        }
        for(int i=0; i<20; i++){
            String expectVal = values.get(20-1-i);
            assertEquals(expectVal,myHistory.getResult(i+1));
        }
    }
    @Test
    public void testInterleaveAddGet(){
        myHistory.addResult("1");
        assertEquals("1",myHistory.getResult(1));
        myHistory.addResult("1aasdfasdf");
        assertEquals("1aasdfasdf",myHistory.getResult(1));
        myHistory.addResult("ly1234");
        assertEquals("ly1234",myHistory.getResult(1));
        myHistory.addResult("%*#(*(%*&#(%");
        assertEquals("%*#(*(%*&#(%",myHistory.getResult(1));
    }
    @Test 
    public void testReallySmallHistory(){
        myHistory = new History(1);
        myHistory.addResult("check");
        assertEquals("check",myHistory.getResult(1));
        myHistory.addResult("man");
        assertEquals("man",myHistory.getResult(1));
    }
    @Test
    public void testClearMultiples(){
        myHistory.addResult("1");
        myHistory.addResult("asldkfjasdf");
        myHistory.addResult("Hurry");
        assertEquals("Hurry",myHistory.getResult(1).trim());
        assertEquals("asldkfjasdf",myHistory.getResult(2).trim());
        assertEquals("1",myHistory.getResult(3).trim());
        myHistory.clear();
        myHistory.addResult("fire");
        myHistory.addResult("test");
        myHistory.addResult("2.876");
        assertEquals("fire",myHistory.getResult(3).trim());
        assertEquals("test",myHistory.getResult(2).trim());
        assertEquals("2.876",myHistory.getResult(1).trim());
        myHistory.clear();      
    }
}
