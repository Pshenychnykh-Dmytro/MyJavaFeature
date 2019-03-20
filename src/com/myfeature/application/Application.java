package com.myfeature.application;

/* 
 *	problem #1: unstable work, throwing exceptions; - RESOLVED
 *	problem #2: passing problems to 3rd-party developers; -RESOLVED
 *	problem #3: delays during work;
 *	problem #4: duplicated code; 
 *	problem #5: encapsulate display logic(only console display);
 */
public class Application {
	//delay simulation
	private int delay = 2000;
	
	abstract class Function{
		protected double a;
		protected double b;
		
		Function(double a, double b){
			this.a = a;
			this.b = b;			
		}
		
		Function(double a){
			this.a = a;
		}
		
		abstract double function();
	}
	
	class FunctionPlus extends Function{

		FunctionPlus(double a, double b) {
			super(a, b);
		}

		@Override
		double function() {
			return a+b;
		}		
	}
	
	class FunctionMinus extends Function{

		FunctionMinus(double a, double b) {
			super(a, b);
		}

		@Override
		double function() {
			return a-b;
		}		
	}
	
	class FunctionMultiply extends Function{

		FunctionMultiply(double a, double b) {
			super(a, b);
		}

		@Override
		double function() {
			return a*b;
		}		
	}
	
	class FunctionDivide extends Function{

		FunctionDivide(double a, double b) {
			super(a, b);
		}

		@Override
		double function() {
			return a/b;
		}		
	}
	
	class FunctionSqrt extends Function{

		FunctionSqrt(double a) {
			super(a);
		}

		@Override
		double function() {
			return Math.sqrt(a);
		}		
	}
	
	private void operation(Function function) {
		try {
			Double result = function.function();		
			Thread.sleep(delay);		
			if(Double.isInfinite(result))
				throw new UnsupportedOperationException("zero divide");
			else if(Double.isNaN(result))
				throw new UnsupportedOperationException("complex result");
			else
				System.out.println(result);
		}
		catch(InterruptedException e) {
			System.err.println(e.getLocalizedMessage());			
		}
		catch(UnsupportedOperationException e) {
			System.err.println(e.getLocalizedMessage());		
		}		
	}
	
	public void plus(double a, double b) {
		operation(new FunctionPlus(a, b));	
	}
	
	public void minus(double a, double b) {
		operation(new FunctionMinus(a, b));
	}
	
	public void multiply(double a, double b) {
		operation(new FunctionMultiply(a, b));
	}
	
	public void divide(double a, double b) {
		operation(new FunctionDivide(a, b));
	}
	
	public void sqrt(double a) {
		operation(new FunctionSqrt(a));
	}
}