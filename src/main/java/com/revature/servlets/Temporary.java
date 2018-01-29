package com.revature.servlets;

import java.io.File;
import java.io.IOException;

public class Temporary {

	public static void main(String[] args) {
		File f = new File("./src/main/resources/runAllTests.xml");
		System.out.println(System.getProperty("user.dir"));
		System.out.println("Absolute");
		System.out.println(f.getAbsolutePath());
		System.out.println(f.getAbsoluteFile());
		System.out.println("Canonical:");
		try {
			System.out.println(f.getCanonicalPath());
			System.out.println(f.getCanonicalFile());
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("============");
		System.out.println("toPath:");
		System.out.println(f.toPath());
		System.out.println(f.exists());
	}

}
