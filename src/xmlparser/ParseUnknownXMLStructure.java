package xmlparser;

/**
 *
 * @author vdnh
 */
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ParseUnknownXMLStructure
{
   public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
   {
      //Get Docuemnt Builder
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      //*
      URL url = new URL("file:///C:/CTS/test/testxml.xml");
      InputStream is = url.openStream();
      int ptr = 0;
      StringBuffer buffer = new StringBuffer();
      while ((ptr = is.read()) != -1) {
        buffer.append((char)ptr);
      }
      
      //*/
      //Build Document
      Document document = builder.parse(new File("employees.xml"));
      //Document document = builder.parse(buffer.toString());
      //Normalize the XML Structure; It's just too important !!
      document.getDocumentElement().normalize();
      
      //Here comes the root node
      Element root = document.getDocumentElement();
      System.out.println(root.getNodeName());
      
      //Get all employees
      NodeList nList = document.getElementsByTagName("unit");// ("employee");  //
      System.out.println("============================");
      
      visitChildNodes(nList);
   }

   //This function is called recursively
   private static void visitChildNodes(NodeList nList)
   {
      for (int temp = 0; temp < nList.getLength(); temp++)
      {
         Node node = nList.item(temp);
         if (node.getNodeType() == Node.ELEMENT_NODE)
         {
            System.out.println("Node Name = " + node.getNodeName() + "; Value = " + node.getTextContent());
            //Check all attributes
            if (node.hasAttributes()) {
               // get attributes names and values
               NamedNodeMap nodeMap = node.getAttributes();
               for (int i = 0; i < nodeMap.getLength(); i++)
               {
                   Node tempNode = nodeMap.item(i);
                   System.out.println("Attr name : " + tempNode.getNodeName()+ "; Value = " + tempNode.getNodeValue());
               }
               if (node.hasChildNodes()) {
                  //We got more childs; Let's visit them as well
                  visitChildNodes(node.getChildNodes());
               }
           }
         }
      }
   }
}