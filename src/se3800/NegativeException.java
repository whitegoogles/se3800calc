package se3800;

public class NegativeException extends Exception{
    private static final long serialVersionUID = 1L;
    public NegativeException(){
        super("Parameters were negative");
    }
}
