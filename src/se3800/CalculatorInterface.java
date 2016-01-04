package se3800calc.src.se3800;

import java.util.List;

public interface CalculatorInterface {
	public double add(List<Long> longs) throws ParamsException;
	public double sub(List<Long> longs) throws ParamsException;
	public double mult(List<Long> longs) throws ParamsException;
	public double div(List<Long> longs) throws ParamsException;
	public double factorial(List<Long> longs) throws ParamsException;
}
