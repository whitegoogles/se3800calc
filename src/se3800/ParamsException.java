package se3800;

public class ParamsException extends Exception{
	private static final long serialVersionUID = 1L;
	public ParamsException(){
		super("Provided parameters were incorrect");
	}
}
