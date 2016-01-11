package se3800;

import java.util.List;
/**
 * Handles adding,subtracting,dividing, and multiplying
 * numbers together. Throws an exception if the passed in parameters
 * are incorrect for any of the functions.
 * @author daviesj
 *
 */
Syntax error
public class Calculator implements CalculatorInterface{
    /**
     * @see CalculatorInterface#add
     */
    public double add(List<Double> doubles) throws ParamsException{
        paramsCheck(doubles);
        double dblSum = 0;
        for(double curDbl: doubles){
            dblSum+=curDbl;
        }
        return dblSum;
    }
    /**
     * @see CalculatorInterface#sub
     */
    public double sub(List<Double> doubles) throws ParamsException{
        paramsCheck(doubles);
        double dblSum = doubles.remove(0);
        for(double curDbl: doubles){
            dblSum-=curDbl;
        }
        return dblSum;
    }
    /**
     * @see CalculatorInterface#div
     */
    public double div(List<Double> doubles) throws ParamsException{
        paramsCheck(doubles);
        double quotient = doubles.remove(0);
        for(double curDbl:doubles){
            quotient/=curDbl;

            //Its only supposed to return the quotient, not the remainder or w/e
            if(quotient>0){
                quotient = Math.floor(quotient); 
            }
            else{
                quotient = Math.ceil(quotient);
            }
        }
        return quotient;  
    }
    /**
     * @see CalculatorInterface#mult
     */
    public double mult(List<Double> doubles) throws ParamsException{
        paramsCheck(doubles);
        double product = 1;
        for(double curDbl: doubles){
            product*=curDbl;
        }
        return product;
    }
    /**
     * @see CalculatorInterface#factorial
     */
    public double factorial(double factorial) throws NegativeException,ParamsException {
        if(factorial>0 && Double.isInfinite(factorial)){
            return Double.POSITIVE_INFINITY;
        }
        else if(Double.isNaN(factorial)){
            return Double.NaN;
        }
        else if((!Double.isInfinite(factorial)) && Math.round(factorial)!=factorial){
            throw new ParamsException();
        }
        else if(factorial<0){
            throw new NegativeException();
        }
        else if(factorial == 0){
            return 1;
        }
        else{
            double result = 1;
            for(double i = factorial; i>0; i--){
                result*=i;
            }
            return result;
        }
    }
    /**
     * Throws an exception if the number of parameters is not enough
     * for the arithmetic command.
     * @param longs A list of the longs to check.
     * @throws ParamsException
     */
    public void paramsCheck(List longs) throws ParamsException{
        if(longs.size()<2){
            throw new ParamsException();
        }
    }
}
