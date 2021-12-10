package cl.vk.mangos.transmision;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLutils {

	Logger logger = LoggerFactory.getLogger(XMLutils.class);
	
	public String parseXML(String xml) {
		String response = "";
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setFeature("http://xml.org/sax/features/external-general-entities", false);
			factory.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.parse(new InputSource(new StringReader(xml)));

			XPathFactory xPathFactory = XPathFactory.newInstance();
			XPath path = xPathFactory.newXPath();
			XPathExpression expr = path.compile("//result/text()");

			NodeList res = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			for (int x = 0; x < res.getLength(); x++) {
				response = res.item(x).getNodeValue();
			}
		} catch (ParserConfigurationException e) {
			logger.error("Error al parsear ", e);
		} catch (SAXException e) {
			logger.error("Error SAXON ", e);
		} catch (IOException e) {
			logger.error("Error IO ", e);
		} catch (XPathExpressionException e) {
			logger.error("Error XPath ", e);
		}

		return response;
	}

}