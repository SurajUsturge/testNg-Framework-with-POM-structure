package parameters;

import java.util.jar.Attributes.Name;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameters_in_testNg {
     
	//parameter used to pass local or global parameter to specific test.so that we can change it as per 
//	requirement by using XML file.
	
//	when parameter is specified then we cannot run test method. we need to run XML file.
	
//launch specific url 
	@BeforeMethod
	@Parameters({"qa_env"})
	public void Environ(String envurl)
	{
		if (envurl.contains("example")) {
          System.out.println("url1");
        } 
		else if (envurl.contains("google")) 
        {
       	 System.out.println("url2");
       	 } 
        else {
        	 System.out.println("url3");
        	}

			System.out.println("specific 1"+ envurl);
	}
	

	@Test
	public void case11()
	{
		System.out.println("testing test method");	
	}
	
	
	
}
