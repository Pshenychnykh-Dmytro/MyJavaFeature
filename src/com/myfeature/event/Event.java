package com.myfeature.event;

public interface Event<TAction> {
	public void subscribe(TAction action);
	
	public void unsubscribe(TAction action);
}
