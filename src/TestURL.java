

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


import junit.framework.*;
import org.junit.Test;
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.File;
//import java.io.FileInputStream;


	public class TestURL extends TestCase {
	   
	    String  value2,value1 ;
	   
	   // assigning the values
	   protected void setUp() throws IOException {
		 
	      value2 = "http://wiprodigital.com";
	      File dir = new File(".");
			String loc = dir.getCanonicalPath() + File.separator + "record.txt";
			// System.out.println(loc);
			FileWriter fstream = new FileWriter(loc, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.newLine();
			out.close();
	   }

	   // test method to add  matching  URl;
	   
	 
	   @Test
	   public void testAdd() throws IOException {
		   File dir = new File(".");
		   String loc = dir.getCanonicalPath() + File.separator ;
		   File file = new File(loc);
		   boolean e =crawler.checkExist(value1, file);
		   assertEquals(crawler.checkExist(value1, file), e);
           crawler.processPage(value2);
		   assertEquals(crawler.checkExist(value1, file),e);
		   assertTrue(value1 == value2);
	   }
	}
	
	


