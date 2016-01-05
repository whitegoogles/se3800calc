package se3800;

import java.util.List;

public class Calculator implements CalculatorInterface{
	
	public double add(List<Double> doubles) throws ParamsException{
		paramsCheck(doubles);
		double dblSum = 0;
		for(double curDbl: doubles){
			dblSum+=curDbl;
		}
		return dblSum;
	}
	public double sub(List<Double> doubles) throws ParamsException{
        paramsCheck(doubles);
        double dblSum = doubles.remove(0);
        for(double curDbl: doubles){
            dblSum-=curDbl;
        }
        return dblSum;
    }
	public double div(List<Double> doubles) throws ParamsException{
		paramsCheck(doubles);
		double quotient = doubles.remove(0);
		for(double curDbl:doubles){
			quotient/=curDbl;
			
			//Its only supposed to return the quotient, not the remainder or w/e
			quotient = Math.floor(quotient); 
		}
		return quotient;  
	}
	public double mult(List<Double> doubles) throws ParamsException{
		paramsCheck(doubles);
		double product = 1;
		for(double curDbl: doubles){
			product*=curDbl;
		}
		return product;
	}
	public double factorial(long factorial) throws ParamsException {
	    if(factorial<0){
	        throw new ParamsException();
	    }
	    else if(factorial == 0){
	        return 1;
	    }
	    else{
	        double result = 1;
	        for(long i = factorial; i>0; i--){
	            result*=i;
	        }
	        return result;
	    }
	}
	public void paramsCheck(List longs) throws ParamsException{
		if(longs.size()<2){
			throw new ParamsException();
		}
	}
}
