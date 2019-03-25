package com.myfeature.delegate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Delegate<TAction> {
	private List<TAction> actions;
	
	public Delegate() {
		this.actions = new ArrayList<>();				
	}
	
	public Delegate(TAction action) {
		super();
		this.actions.add(action);
	}
	
	public void Add(TAction action) {
		this.actions.add(action);		
	}
	
	public void Remove(TAction action) {
		this.actions.remove(action);		
	}
	
	public void Invoke(Consumer<TAction> consumer) {
		this.actions.forEach(consumer);		
	}
}
