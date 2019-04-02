package com.myfeature.demo;
import com.myfeature.application.Application;

public class Demo {
	
	public static void main(String[] args) throws UnsupportedOperationException, InterruptedException, Exception {
		new Demo().start();
	}
	
	private final String line = "--------------------------------------";		
	
	private void showResult(Double result, Application.OperationType operation) {
		System.out.println("Display: "+result+" : "+operation);		
	}
	
	private void writeToFileResult(Double result, Application.OperationType operation) {
		System.out.println("Write to file: "+result+" : "+operation);		
	}
	
	private void sendEmailResult(Double result, Application.OperationType operation) {
		System.out.println("Send email: "+result+" : "+operation);		
	}
	
	private void showError(Exception exception) {
		System.err.println(exception.getLocalizedMessage()+" : "+exception.getClass().getName());				
	}
	
	private Application app = new Application();
	
	public void start() {
		System.out.println("Start demo:");
		System.out.println(line);
		app.addOnSuccessResultAction((r, o) -> showResult(r, o));
		app.addOnSuccessResultAction((r, o) -> writeToFileResult(r, o));
		app.addOnSuccessResultAction((r, o) -> sendEmailResult(r, o));
		app.addOnFailResultAction(e -> showError(e));
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
