package com.myfeature.demo;
import com.myfeature.application.Application;

public class Demo {
	
	public static void main(String[] args) throws UnsupportedOperationException, InterruptedException, Exception {
		new Demo().start();
	}
	
	private final String line = "--------------------------------------";		
	
	private Application app = new Application();
	
	public void start() throws UnsupportedOperationException, InterruptedException, Exception {
		System.out.println("Start demo:");
		System.out.println(line);
				
		System.out.println(app.plus(28, 31));		
		System.out.println(app.minus(13, 26));
		System.out.println(app.multiply(12, 12));		
		System.out.println(app.divide(45, 90));		
		System.out.println(app.sqrt(81));		
		System.out.println(line);		
		System.out.println(app.divide(45, 0));
		System.out.println(app.sqrt(-81));	
	}
}
