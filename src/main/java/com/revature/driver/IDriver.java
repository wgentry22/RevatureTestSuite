package com.revature.driver;

public interface IDriver {
	
	void openApp();
	void writeIntoElement(String id, String value);
	void submit();
	void closeApp();
}
