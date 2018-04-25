package xmlparser;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.StringReader;
import org.xml.sax.InputSource;

public class XMLparser {

	 public static void main(String[] args) {

			try {

				 String fXmlFile = "<?xml version=\"1.0\" encoding=\"utf-16\"?>\n"
								 + "<TransactionResponse>\n"
								 + "  <TransactionID>2675568</TransactionID>\n"
								 + "  <Status>001</Status>\n"
								 + "  <StatusMessage>Request was successfully processed</StatusMessage>\n"
								 + "  <TransactionDate>2018/04/25 13:48:09</TransactionDate>\n"
								 + "  <TransactionBalance>24500.00</TransactionBalance>\n"
								 + "  <Cards>\n"
								 + "    <Card>\n"
								 + "      <Serial>W12A0001364</Serial>\n"
								 + "      <Pin>782603945116</Pin>\n"
								 + "    </Card>\n"
								 + "  </Cards>\n"
								 + "</TransactionResponse>";
				 DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				 DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				 Document doc = dBuilder.parse(new InputSource(new StringReader(fXmlFile)));

				 doc.getDocumentElement().normalize();

				 System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				 NodeList nList = doc.getElementsByTagName("Card");
				 for (int temp = 0; temp < nList.getLength(); temp++) {
						Node nNode = nList.item(temp);
						System.out.println("Card Details");
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							 Element eElement = (Element) nNode;
							 System.out.println("Serial : " + eElement.getElementsByTagName("Serial").item(0).getTextContent());
							 System.out.println("Pin : " + eElement.getElementsByTagName("Pin").item(0).getTextContent());
						}
				 }
			} catch (Exception e) {
				 e.printStackTrace();
			}

	 }

}
