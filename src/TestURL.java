




import java.io.File;
import java.io.IOException;
import junit.framework.*;
import org.junit.Test;


	public class TestURL extends TestCase {
	   
	    String  value2,value1 ;
	   
	   // assigning the values
	   protected void setUp() throws IOException {
		 
	      value1 = "http://wiprodigital.com";
	   }

	  
	   
	   // test method to add  matching  URl;
    
	   @Test
	   public void testAdd() throws IOException {
		   value2 = "http://wiprodigital.com";
		 
		   File file = new File("/Users/user1/Documents/workspace/Web_Crawler1/record.txt");
		   boolean e =crawler.checkExist(value2, file);
		   assertEquals(crawler.checkExist(value2, file), e);
           crawler.processPage(value2);
		  assertTrue(value1 == value2);
	   }
	}
	
	


