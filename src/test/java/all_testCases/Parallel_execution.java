package all_testCases;

import org.testng.annotations.Test;

import testNg_common_functions.RunnerFunctions;

public class Parallel_execution extends RunnerFunctions {
  
	
  @Test
  public void case1() {
	  loginToPortal_with_valid_Credentials();
  }

  @Test
  public void case2() throws InterruptedException {
	  registrationForm();
  }
  
  @Test
  public void case3() throws InterruptedException {
	  alertshandling();
  }
  
	@Test
	  public void case4() {
		  mouseHover();
	  }
	
	
	@Test
	  public void case5() {
		  SelectMultipleCheckbox();
	  }
	
	 @Test
	  public void case6() {
		  SelectMultipleOptionInDropdown();
	  }
	@Test
	 public void case7()
	 {
		 getOptionsInDropdown();
	 }
  
	@Test
	  public void case8()
	  {
		  Handle_Iframes();
	  }
  
	 @Test
	  public void case9() throws InterruptedException
	  {
		  switchToChildWindows();
		  switchWidnow();
	  }
  
}
