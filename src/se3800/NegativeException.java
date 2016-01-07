package se3800;
/**
 * Handles a negative value being passed into a function
 * that doesn't allow negative values.
 * @author daviesj
 *
 */
public class NegativeException extends Exception{
    private static final long serialVersionUID = 1L;
    public NegativeException(){
        super("Parameters were negative");
    }
}
