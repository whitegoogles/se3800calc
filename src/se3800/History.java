package se3800;

import java.util.ArrayList;
import java.util.List;

/**
 * This class manages a list of values to describe a history.
 * The history has a set maximum number of values it can hold.
 * @author boddyn
 * @version 2016.01.05.1
 */
public class History implements HistoryInterface {
    
    // The maximum number of values allowed for storage
    private static int maxNumValues = 10;
    
    // The structure that holds the values as strings
    private static List<String> history;
    
    /**
     * Constructor
     * Creates a history object, initializes the history, and sets the max number of values.
     * @param maxNumValues  the maximum number of values allowed
     */
    public History(int maxNumValues) {
        history = new ArrayList<String>();
        if (maxNumValues > 0) {
            this.maxNumValues = maxNumValues;
        }
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
        String retStr = "";
        if (resultId < 1 || resultId > history.size()) {
            throw new IndexOutOfBoundsException("Index " + resultId + 
                    " is not between 1 and " + history.size() + ".");
        }
        retStr = history.get(resultId - 1);
        return retStr;
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
        String removedStr = null;
        if (history.size() == maxNumValues) {
            removedStr = history.get(maxNumValues - 1);
        }
        history.add(0, result);
        history.remove(history.size() - 1);
        return removedStr;
    }

    /**
     * Clears all values in the history.
     */
    @Override
    public void clear() {
        history.clear();
    }
}
