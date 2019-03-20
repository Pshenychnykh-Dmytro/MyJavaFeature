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
		abstract double function();
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
		operation(new Function() {			
			@Override
			double function() {				
				return a+b;
			}
		});	
	}
	
	public void minus(double a, double b) {
		operation(new Function() {
			@Override
			double function() {				
				return a-b;
			}
		});
	}
	
	public void multiply(double a, double b) {
		operation(new Function() {
			@Override
			double function() {				
				return a*b;
			}
		});
	}
	
	public void divide(double a, double b) {
		operation(new Function() {			
			@Override
			double function() {				
				return a/b;
			}
		});
	}
	
	public void sqrt(double a) {
		operation(new Function() {			
			@Override
			double function() {				
				return Math.sqrt(a);
			}
		});
	}
}