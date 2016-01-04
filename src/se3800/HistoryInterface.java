package se3800;

/**
 * An interface to be implemented by the History class.
 * This outlines the different public methods available and
 * what they do.
 * @author boddyn
 * @version 2016.01.04.1
 */
public interface HistoryInterface {
    
    /**
     * Returns the result in the history with the given ID.
     * ID is determined by its chronological position, with
     * ID=1 being the most recent.
     * @param resultId  the chronological position of the desired result
     * @return  the associated value
     */
    public abstract String getResult(int resultId);
    
    /**
     * Adds the given string to the history as the most recent result.
     * If the new result pushes a different result off the history, that
     * removed result will be returned; otherwise, null is returned.
     * @param result  the value to be added
     * @return  pushed-off result, otherwise null
     */
    public abstract String addResult(String result);
    
    /**
     * Clears all values in the history.
     */
    public abstract void clear();
}
