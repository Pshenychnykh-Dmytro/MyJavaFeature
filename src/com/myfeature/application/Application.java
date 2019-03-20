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
	
	public void plus(double a, double b) {
		try {
			Double result = a + b;		
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
	
	public void minus(double a, double b) {
		try {
			Double result = a - b;		
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
	
	public void multiply(double a, double b) {
		try {
			Double result = a * b;		
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
	
	public void divide(double a, double b) {
		try {
			Double result = a / b;		
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
	
	public void sqrt(double a) {
		try {
			Double result = Math.sqrt(a);		
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
}