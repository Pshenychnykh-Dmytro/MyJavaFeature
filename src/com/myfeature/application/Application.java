package com.myfeature.application;

/* 
 *	problem #1: unstable work, throwing exceptions;
 *	problem #2: passing problems to 3rd-party developers;
 *	problem #3: delays during work;
 *	problem #4: duplicated code; 
 */
public class Application {
	//delay simulation
	private int delay = 2000;
	
	public double plus(double a, double b) throws Exception, InterruptedException, UnsupportedOperationException {
		Double result = a + b;		
		Thread.sleep(delay);		
		if(Double.isInfinite(result))
			throw new UnsupportedOperationException("zero divide");
		else if(Double.isNaN(result))
			throw new UnsupportedOperationException("complex result");
		else
			return result;		
	}
	
	public double minus(double a, double b) throws Exception, InterruptedException, UnsupportedOperationException {
		Double result = a - b;
		Thread.sleep(delay);
		if(Double.isInfinite(result))
			throw new UnsupportedOperationException("zero divide");
		else if(Double.isNaN(result))
			throw new UnsupportedOperationException("complex result");
		else
			return result;				
	}
	
	public double multiply(double a, double b) throws Exception, InterruptedException, UnsupportedOperationException {
		Double result = a * b;
		Thread.sleep(delay);
		if(Double.isInfinite(result))
			throw new UnsupportedOperationException("zero divide");
		else if(Double.isNaN(result))
			throw new UnsupportedOperationException("complex result");
		else
			return result;			
	}
	
	public double divide(double a, double b) throws Exception, InterruptedException, UnsupportedOperationException {
		Double result = a / b;
		Thread.sleep(delay);
		if(Double.isInfinite(result))
			throw new UnsupportedOperationException("zero divide");
		else if(Double.isNaN(result))
			throw new UnsupportedOperationException("complex result");
		else
			return result;			
	}
	
	public double sqrt(double a) throws Exception, InterruptedException, UnsupportedOperationException {
		Double result = Math.sqrt(a);
		Thread.sleep(delay);
		if(Double.isInfinite(result))
			throw new UnsupportedOperationException("zero divide");
		else if(Double.isNaN(result))
			throw new UnsupportedOperationException("complex result");
		else
			return result;		
	}
}
