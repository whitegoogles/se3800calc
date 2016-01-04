package se3800;

import java.util.List;

public interface CalculatorInterface {
	public double add(List<Double> doubles) throws ParamsException;
	public double sub(List<Double> doubles) throws ParamsException;
	public double mult(List<Double> doubles) throws ParamsException;
	public double div(List<Double> doubles) throws ParamsException;
	public double factorial(long factorial) throws ParamsException;
}
