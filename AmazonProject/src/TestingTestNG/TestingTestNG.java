package TestingTestNG;

import org.testng.annotations.Test;

import jdk.jfr.Enabled;

public class TestingTestNG {

	
	
  @Test (priority = 0)//lower the value higher the priority
  public void testcase1() {
	   
	  System.out.println("TestCase 1"); 
  }
  
  @Test  (priority = -2)//tc can be in negative value as well & @Test annotation is known as to run a tc. 
  public void testcase6() {
	   
	  System.out.println("TestCase 6"); 
  }
  
  @Test  (priority = 1000)//always remember to add tc's priority distance apart bcoz sometimes you need to add a tc in between
  public void testcase4() {
	   
	  System.out.println("TestCase 4"); 
  }
  
  @Test  (priority = 3000, invocationCount = 2)// we don't need main method with these annotations
  public void testcase3() {
	   
	  System.out.println("TestCase 3"); 
  }
  
  
  @Test  (priority = 4000, enabled = false) //here we can disable the tc by enabled=false...by default it will be enabled
  public void testcase8() {
	   
	  System.out.println("TestCase 8"); 
  }
  
  /*Different Types of Reports
   * Report which is in console.
   * Report which is in TestNG tab
   * Refresh your project > In test-output folder > right click on emailable-report > open in browser
   * In test-output folder > check testng.xml file
   * */
  
  /* Different attributes we are having : (priority, enabled, invocationCount) */
}
