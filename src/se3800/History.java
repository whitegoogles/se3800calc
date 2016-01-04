package se3800;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author boddyn
 *
 */
public class History implements HistoryInterface {
    
    private static final int MAX_NUM_VALUES = 10;
    
    private static List<String> history;
    
    public History() {
        history = new ArrayList<String>();
    }

    /**
     * Returns the result in the history with the given ID.
     * ID is determined by its chronological position, with
     * ID=1 being the most recent.
     * @param resultId  the chronological position of the desired result
     * @return  the associated value
     */
    @Override
    public String getResult(int resultId) {
     // TODO Auto-generated method stub
        return null;
    }

    /**
     * Adds the given string to the history as the most recent result.
     * If the new result pushes a different result off the history, that
     * removed result will be returned; otherwise, null is returned.
     * @param result  the value to be added
     * @return  pushed-off result, otherwise null
     */
    @Override
    public String addResult(String result) {
        // TODO Auto-generated method stub
        return null;
    }

    /**
     * Clears all values in the history.
     */
    @Override
    public void clear() {
        // TODO Auto-generated method stub
    }
}
