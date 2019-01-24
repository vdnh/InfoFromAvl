package xmlparser;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *
 * @author vdnh
 */
public class Xmlparser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
        // TODO code application logic here
        //URL url = new URL("https://www.avltrack.com/en/home.html");  // file:///C:/CTS/test/testxml.xml
        URL url = new URL("file:///C:/CTS/test/testxml.xml");
        InputStream is = url.openStream();
        int ptr = 0;
        StringBuffer buffer = new StringBuffer();
        while ((ptr = is.read()) != -1) {
            buffer.append((char)ptr);
        }
        //String siteContent = new URL("https://www.avltrack.com/en/home.html").toString();
        System.out.println("site content: " + buffer.toString());
    }
    
}
