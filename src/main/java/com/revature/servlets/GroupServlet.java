package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.testng.ITestNGListener;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlGroups;
import org.testng.xml.XmlRun;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class TesterServlet
 */
public class GroupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public GroupServlet() {
        super();
    }
	
	public static XmlSuite createSuite(List<String> groupsParam) {
		// create <suite name="AllTests">
		XmlSuite suite = new XmlSuite();
		List<XmlClass> classes = new ArrayList<XmlClass>();
		XmlTest test = new XmlTest(suite);
		XmlRun run = new XmlRun();
		XmlGroups xmlgroups = new XmlGroups();
		
		// add all the classes in
		classes.add(new XmlClass("com.revature.tester.OverviewTester"));
		classes.add(new XmlClass("com.revature.tester.BatchTester"));
		classes.add(new XmlClass("com.revature.tester.CurriculumTester"));
		classes.add(new XmlClass("com.revature.tester.LocationTester"));
		classes.add(new XmlClass("com.revature.tester.TrainerTester"));
		classes.add(new XmlClass("com.revature.tester.ReportTester"));
		classes.add(new XmlClass("com.revature.tester.SettingTester"));
		test.setXmlClasses(classes);
		// set suite name
		suite.setName("GroupSuite");
		// create <test name="">
		test.setName("GroupTest");
		// create <groups> and add all groups
		suite.setIncludedGroups(groupsParam);
		for (int i=0;i<groupsParam.size();i++) {
			run.onInclude(groupsParam.get(i));
		}
		xmlgroups.setRun(run);
		suite.setGroups(xmlgroups);
		return suite;
	}
	
	public static ResponseObject runGroups(List<String> groupsParam) {
		// testNG instance
	    TestNG testng = new TestNG();
	    // create list of suites to run with the groups specified
	    List<XmlSuite> suites = new ArrayList<XmlSuite>();
	    suites.add(createSuite(groupsParam));
	    // add suites to testNG
	    testng.setXmlSuites(suites);
	    // create and add test listener which will generate response object
	    ITestNGListener listener = new ListenerTest();
	    testng.addListener(listener);
	    testng.setUseDefaultListeners(false);
	    // programmatically run testNG!!
	    testng.run();
	    // return the response object
	    return ((ListenerTest) listener).getResponseObject();
	}
	
	public ResponseObject getDummyData() {
		ResponseObject robj = new ResponseObject();
		robj.totalNumTests = 2;
		robj.numFailedTests = 1;
		robj.numSuccessfulTests = 1;
		List<TestObject> all = new ArrayList<TestObject>();
		List<TestObject> failures = new ArrayList<TestObject>();
		List<TestObject> successes = new ArrayList<TestObject>();
		TestObject fail = new TestObject(1,"first test","success","Class",null);
		TestObject pass = new TestObject(2,"second test","failure","Class",null);
		all.add(fail); all.add(pass);
		failures.add(fail);
		successes.add(pass);
		robj.allTests = all;
		robj.failedTests = failures;
		robj.successfulTests = successes;
		return robj;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// run the tests and get the object that will be returned as JSON
		String group1 = request.getParameter("name");
		List<String> groupsParam = new ArrayList<String>();
		groupsParam.add(group1);
		ResponseObject robj = runGroups(groupsParam);
		//ResponseObject robj = getDummyData();
        // create Jackson mapper object
		ObjectMapper mapper = new ObjectMapper();
		// send json data back
		System.out.println("Returning test data...");
		response.setContentType("application/json");
		response.getWriter().write(mapper.writeValueAsString(robj));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
