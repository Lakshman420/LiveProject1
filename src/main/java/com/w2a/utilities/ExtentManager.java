package com.w2a.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	
    public static ExtentReports createInstance(String fileName) {
        ExtentSparkReporter reporter = new ExtentSparkReporter(fileName);
       
        
        reporter.config().setTheme(Theme.STANDARD);
        reporter.config().setDocumentTitle(fileName);
        reporter.config().setEncoding("utf-8");
        reporter.config().setReportName(fileName);
        
        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Automation Tester", "Rahul Arora");
        extent.setSystemInfo("Organization", "Way2Automation");
        extent.setSystemInfo("Build no", "W2A-1234");
        
        
        return extent;
    }

}
