package se3800;

import java.util.List;
/**
 * Defines an object that can add, multiply, divide, subtract and compute
 * the factorial of a list of doubles.
 * @author daviesj
 *
 */
public interface CalculatorInterface {
    /**
     * Adds a list of n doubles
     * Uses the same rules doubles do to handle overflow
     * @param doubles The list of values to add
     * @return The sum of all of the passed in doubles
     * @throws ParamsException
     */
	public double add(List<Double> doubles) throws ParamsException;
	/**
	 * Subtracts a list of doubles from the first provided double
	 * Uses the same rules as doubles for overflow
	 * @param doubles The list of values to subtract
	 * @return The difference between the first number and the rest of the numbers
	 * @throws ParamsException
	 */
	public double sub(List<Double> doubles) throws ParamsException;
	/**
	 * Multiplies a list of doubles 
	 * Uses the same rules as doubles for overflow
	 * @param doubles The list of values to multiply together
	 * @return The product of the list
	 * @throws ParamsException
	 */
	public double mult(List<Double> doubles) throws ParamsException;
	/**
	 * Divides the first provided double by a list of doubles
	 * Uses the same rules as doubles for dividing by zero
	 * @param doubles The list of doubles to divide
	 * @return The quotient of the list
	 * @throws ParamsException
	 */
	public double div(List<Double> doubles) throws ParamsException;
	/**
	 * Returns the factorial of the provided long, where
	 * factorial is defined as n*(n-1)*....*(1), where 
	 * n is a positive long.
	 * Handles overflow the same way doubles do for multiplication.
	 * @param factorial The number to find the factorial for
	 * @return The factorial of the provided number
	 * @throws ParamsException
	 */
	public double factorial(long factorial) throws ParamsException;
}
