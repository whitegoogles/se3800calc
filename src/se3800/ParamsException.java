package se3800;
/**
 * Handles a function where an insufficient number of parameters are passed in.
 * @author daviesj
 *
 */
public class ParamsException extends Exception{
    private static final long serialVersionUID = 1L;
    public ParamsException(){
        super("Provided parameters were incorrect");
    }
}
