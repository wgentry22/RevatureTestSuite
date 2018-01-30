package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class TestPath {
	public static void main(String[] args) {
		new TestPath().showResource();
	}

	public void showResource() {
		Properties p = new Properties();
		try {
			URL resource = this.getClass().getClassLoader().getResource("locators.properties");
			System.out.println(resource.getFile());
			System.out.println(resource.getProtocol());
			InputStream is = resource.openStream();
			p.load(is);
			System.out.println(p.getProperty("WaitTimeBeforeClosing"));
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
