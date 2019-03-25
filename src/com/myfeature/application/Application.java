package com.myfeature.application;

import com.myfeature.actions.Action1;
import com.myfeature.actions.Action2;
import com.myfeature.delegate.Delegate;
import com.myfeature.functions.Function;

/* 
 *	problem #1: unstable work, throwing exceptions; - RESOLVED
 *	problem #2: passing problems to 3rd-party developers; -RESOLVED
 *	problem #3: delays during work;
 *	problem #4: duplicated code; - RESOLVED
 *	problem #5: encapsulate display logic(only console display) - RESOLVED;
 *	problem #6: Inversion of control problem(depend on extra component) - RESOLVED;
 *	problem #7: Security problem(Invoking should be encapsulated)
 */
public class Application {
	public enum OperationType{
		plus, minus, multiply, divide, sqrt
	}
	//delay simulation
	private int delay = 2000;
	public Delegate<Action2<Double, OperationType>> onSuccessResult = new Delegate<>();
	public Delegate<Action1<Exception>> onFailResult = new Delegate<>();
	
	private void operation(Function<Double> function, OperationType operationType) {
		try {
			Double result = function.function();		
			Thread.sleep(delay);		
			if(Double.isInfinite(result))
				throw new UnsupportedOperationException("zero divide");
			else if(Double.isNaN(result))
				throw new UnsupportedOperationException("complex result");
			else
				onSuccessResult.Invoke(c -> c.action(result, operationType));
		}
		catch(Exception e) {
			onFailResult.Invoke(c -> c.action(e));
		}			
	}
	
	public void plus(double a, double b) {
		operation(() -> a + b, OperationType.plus);	
	}
	
	public void minus(double a, double b) {
		operation(() -> a - b, OperationType.minus);
	}
	
	public void multiply(double a, double b) {
		operation(() -> a * b, OperationType.multiply);
	}
	
	public void divide(double a, double b) {
		operation(() -> a / b, OperationType.divide);
	}
	
	public void sqrt(double a) {
		operation(() -> Math.sqrt(a), OperationType.sqrt);
	}
}