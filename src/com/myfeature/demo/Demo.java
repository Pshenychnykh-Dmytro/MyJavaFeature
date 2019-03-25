package com.myfeature.demo;
import com.myfeature.application.Application;

public class Demo {
	
	public static void main(String[] args) throws UnsupportedOperationException, InterruptedException, Exception {
		new Demo().start();
	}
	
	private final String line = "--------------------------------------";		
	
	private void showResult(Double result, Application.OperationType operation) {
		System.out.println(result+" : "+operation);		
	}
	
	private void showError(Exception exception) {
		System.err.println(exception.getLocalizedMessage()+" : "+exception.getClass().getName());				
	}
	
	private Application app = new Application((result, operation) -> showResult(result, operation), exception -> showError(exception));
	
	public void start() {
		System.out.println("Start demo:");
		System.out.println(line);				
		app.plus(28, 31);		
		app.minus(13, 26);
		app.multiply(12, 12);		
		app.divide(45, 90);		
		app.sqrt(81);		
		System.out.println(line);		
		app.divide(45, 0);
		app.sqrt(-81);
		System.out.println("Stable end");		
	}
}
