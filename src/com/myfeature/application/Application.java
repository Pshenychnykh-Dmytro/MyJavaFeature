package com.myfeature.application;

import java.util.function.Consumer;

import com.myfeature.actions.Action1;
import com.myfeature.actions.Action2;
import com.myfeature.delegate.Delegate;
import com.myfeature.event.Event;
import com.myfeature.functions.Function;

/* 
 *	problem #1: unstable work, throwing exceptions; - RESOLVED
 *	problem #2: passing problems to 3rd-party developers; -RESOLVED
 *	problem #3: delays during work;
 *	problem #4: duplicated code; - RESOLVED
 *	problem #5: encapsulate display logic(only console display) - RESOLVED;
 *	problem #6: Inversion of control problem(depend on extra component) - RESOLVED;
 *	problem #7: Security problem(Invoking should be encapsulated) - RESOLVED PERFECT!
 *  problem #8: Performance problem, adding async operation - RESOLVED! 
 */
public class Application {
	private static class EventImpl<TAction> implements Event<TAction>{
		private Delegate<TAction> delegate = new Delegate<>();

		@Override
		public void subscribe(TAction action) {
			delegate.Add(action);
		}

		@Override
		public void unsubscribe(TAction action) {
			delegate.Remove(action);
		}
		
		private static <T> void invoke(Event<T> event, Consumer<T> consumer) {
			((EventImpl<T>)event).delegate.Invoke(consumer);
		}
		
	}
	
	public enum OperationType{
		plus, minus, multiply, divide, sqrt, power
	}
	//delay simulation
	private int delay = 2000;
	public Event<Action2<Double, OperationType>> onSuccessResult = new EventImpl<>();
	public Event<Action1<Exception>> onFailResult = new EventImpl<>(); 
	
	private void operation(Function<Double> function, OperationType operationType) {
		new Thread(() -> {
			try {
				Double result = function.function();		
				Thread.sleep(delay);		
				if(Double.isInfinite(result))
					throw new UnsupportedOperationException("zero divide");
				else if(Double.isNaN(result))
					throw new UnsupportedOperationException("complex result");
				else
					EventImpl.invoke(onSuccessResult, c -> c.action(result, operationType));
				
			}
			catch(Exception e) {
				EventImpl.invoke(onFailResult, c -> c.action(e));
			}			
		}).start();
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
	
	public void power(double x, double power) {
		operation(() -> Math.pow(x, power), OperationType.power);		
	}
}