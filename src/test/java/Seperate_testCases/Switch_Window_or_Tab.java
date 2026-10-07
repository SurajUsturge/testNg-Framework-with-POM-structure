package Seperate_testCases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import testNg_common_functions.RunnerFunctions;

public class Switch_Window_or_Tab extends RunnerFunctions{
  
	
	 @Test
	  public void case8() throws InterruptedException
	  {
		  switchToChildWindows();
		  switchWidnow();
	  }
}
