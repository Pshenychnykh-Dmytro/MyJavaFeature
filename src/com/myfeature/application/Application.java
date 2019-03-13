package com.myfeature.application;

public class Application {
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
		Double result = Math.sqrt(a);;
		Thread.sleep(delay);
		if(Double.isInfinite(result))
			throw new UnsupportedOperationException("zero divide");
		else if(Double.isNaN(result))
			throw new UnsupportedOperationException("complex result");
		else
			return result;		
	}
}
