import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
 
public class crawler {
 
	public static void main(String[] args) throws IOException {
 
		File dir = new File(".");
	
	//location of work space  of file /Users/user1/Documents/workspace/Web_Crawler1/record.txt
		
		
		
		File f = new File("/Users/user1/Documents/workspace/Web_Crawler1/record.txt");
		if(f.exists()) { 
		    // do something
			f.delete();
		}
		
		String loc = dir.getCanonicalPath()  + File.separator  + "record.txt" ;
		
		 System.out.println(loc);
		 
		FileWriter fstream = new FileWriter(loc, true);
		BufferedWriter out = new BufferedWriter(fstream);
		out.newLine();
		out.close();
 
		processPage("http://wiprodigital.com");
		
	
	}
 
	// givn a String, and a File
	// return if the String is contained in the File
	public static boolean checkExist(String s, File fin) throws IOException {
 
		FileInputStream fis = new FileInputStream(fin);
		// //Construct the BufferedReader object
		BufferedReader in = new BufferedReader(new InputStreamReader(fis));
 
		String aLine = null;
		while ((aLine = in.readLine()) != null) {
			// //Process each line
			if (aLine.trim().contains(s)) {
				
				in.close();
				fis.close();
				return true;
			}
		}
 
		// do not forget to close the buffer reader
		in.close();
		fis.close();
 
		return false;
	}
 
	public static void processPage(String URL) throws IOException {
 
		File dir = new File(".");
		
		String loc = dir.getCanonicalPath()   + File.separator + "record.txt";
 
		// invalid link
		if (URL.contains(".pdf") || URL.contains("@") 
				|| URL.contains("adfad") || URL.contains(":80")
				|| URL.contains("fdafd") || URL.contains(".jpg")
				|| URL.contains(".pdf") || URL.contains(".jpg"))
			return;
 
		// process the url first
		if (URL.contains("wiprodigital.com") && !URL.endsWith("/")) {
 
		} else if(URL.contains("wiprodigital.com") && URL.endsWith("/")){
			URL = URL.substring(0, URL.length()-1);
		}else{
			// url of other site -> do nothing
			return;
		}
		
 
		File file = new File(loc);
		
		// check existance
		boolean e = checkExist(URL, file);
		if (!e) {
			System.out.println("------ :  " + URL);
			// insert to file
			FileWriter fstream = new FileWriter(loc, true);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(URL);
			out.newLine();
			out.close();
 
			Document doc = null;
			try {
				doc = Jsoup.connect(URL).get();
			} catch (IOException e1) {
				e1.printStackTrace();
				return;
			}
 
			if (doc.text().contains("digital")) {
				//System.out.println(URL);
			}
 
			Elements questions = doc.select("a[href]");
			for (Element link : questions) {
				processPage(link.attr("abs:href"));
			}
		} else {
			// do nothing
			return;
		}
 
	}
}



