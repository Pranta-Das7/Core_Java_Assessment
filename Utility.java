package com.cognizant.customer.util;

import java.io.File;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.cognizant.customer.beans.Bookings;
import com.cognizant.customer.beans.Register;
import com.cognizant.customer.beans.room;

public class Utility {
	public static final String xmlFilePath = "C:\\Users\\2080580\\OneDrive - Cognizant\\Desktop\\xml\\customer.xml";
	public static final String xmlFilePath1 = "C:\\Users\\2080580\\OneDrive - Cognizant\\Desktop\\xml\\room.xml";
	public static final String xmlFilePath2 = "C:\\Users\\2080580\\OneDrive - Cognizant\\Desktop\\xml\\booking.xml";
    
	public static void generateXml(List<Register> list) {
		 try {

	            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

	            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

	            Document document = documentBuilder.newDocument();
	          
	            // root element
	            Element root = document.createElement("customers");
	            document.appendChild(root);
	            for(Register d:list) {
	            // employee element
	            Element customer = document.createElement("customer");

	            root.appendChild(customer);

	            // set an attribute to  element
	            Attr attr = document.createAttribute("customerid");
	            attr.setValue(String.valueOf(d.getCustomerid()));
	            customer.setAttributeNode(attr);

	            //you can also use staff.setAttribute("id", "1") for this

	           
	            Element name = document.createElement("name");
	           name.appendChild(document.createTextNode(d.getName()));
	            customer.appendChild(name);

	           

	            // email element
	            Element email = document.createElement("email");
	            email.appendChild(document.createTextNode(d.getEmailid()));
	            customer.appendChild(email);
	            
	            
	            Element phonenumber = document.createElement("phonenumber");
	            phonenumber.appendChild(document.createTextNode(d.getPhoneNumber()));
	            customer.appendChild(phonenumber);

	            // department elements
	            Element password = document.createElement("password");
	            password.appendChild(document.createTextNode(d.getPassword()));
	            customer.appendChild(password);
	            }
	            // create the xml file
	            //transform the DOM Object to an XML File
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource domSource = new DOMSource(document);
	            StreamResult streamResult = new StreamResult(new File(xmlFilePath));

	            // If you use
	            // StreamResult result = new StreamResult(System.out);
	            // the output will be pushed to the standard output ...
	            // You can use that for debugging 

	            transformer.transform(domSource, streamResult);

	            System.out.println("Done creating XML File");

	        } catch (ParserConfigurationException pce) {
	            pce.printStackTrace();
	        } catch (TransformerException tfe) {
	            tfe.printStackTrace();
	        }
		
	}
     public static void generateRoomsXml(List<room> list) {
    	 try {

	            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

	            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

	            Document document = documentBuilder.newDocument();
	          
	            // root element
	            Element root = document.createElement("rooms");
	            document.appendChild(root);
	            for(room d:list) {
	            // employee element
	            Element customer = document.createElement("room");

	            root.appendChild(customer);

	            // set an attribute to  element
	            Attr attr = document.createAttribute("roomid");
	            attr.setValue(String.valueOf(d.getRoomid()));
	            customer.setAttributeNode(attr);

	            //you can also use staff.setAttribute("id", "1") for this

	           
	            Element name = document.createElement("roomtype");
	           name.appendChild(document.createTextNode(d.getRoomtype()));
	            customer.appendChild(name);

	           

	            // email element
	            Element email = document.createElement("price");
	            email.appendChild(document.createTextNode(String.valueOf(d.getPrice())));
	            customer.appendChild(email);
	            
	            
	            Element phonenumber = document.createElement("view");
	            phonenumber.appendChild(document.createTextNode(d.getView()));
	            customer.appendChild(phonenumber);

	            // department elements
	            
	            }
	            // create the xml file
	            //transform the DOM Object to an XML File
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource domSource = new DOMSource(document);
	            StreamResult streamResult = new StreamResult(new File(xmlFilePath1));

	            // If you use
	            // StreamResult result = new StreamResult(System.out);
	            // the output will be pushed to the standard output ...
	            // You can use that for debugging 

	            transformer.transform(domSource, streamResult);

	            System.out.println("Done creating XML File");

	        } catch (ParserConfigurationException pce) {
	            pce.printStackTrace();
	        } catch (TransformerException tfe) {
	            tfe.printStackTrace();
	        }
     }
     public static void generateBookingsXml(List<Bookings> list) {
    	 try {

	            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

	            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

	            Document document = documentBuilder.newDocument();
	          
	            // root element
	            Element root = document.createElement("bookings");
	            document.appendChild(root);
	            for(Bookings d:list) {
	            // employee element
	            Element customer = document.createElement("booking");

	            root.appendChild(customer);

	            // set an attribute to  element
	            Attr attr = document.createAttribute("bookid");
	            attr.setValue(String.valueOf(d.getBookid()));
	            customer.setAttributeNode(attr);

	            //you can also use staff.setAttribute("id", "1") for this

	           
	            Element name = document.createElement("customer_name");
	           name.appendChild(document.createTextNode(d.getCustomername()));
	            customer.appendChild(name);

	           

	            // email element
	            Element email = document.createElement("room_id");
	            email.appendChild(document.createTextNode(String.valueOf(d.getRoomid())));
	            customer.appendChild(email);
	            
	            
	            Element phonenumber = document.createElement("checkin");
	            phonenumber.appendChild(document.createTextNode(d.getCheckin().toString()));
	            customer.appendChild(phonenumber);

	            // department elements
	            Element password = document.createElement("checkout");
	            password.appendChild(document.createTextNode(d.getCheckout().toString()));
	            customer.appendChild(password);
	            
	            Element status = document.createElement("room_status");
		           status.appendChild(document.createTextNode(d.getRoomstatus()));
		            customer.appendChild(status);
	            }
	            // create the xml file
	            //transform the DOM Object to an XML File
	            TransformerFactory transformerFactory = TransformerFactory.newInstance();
	            Transformer transformer = transformerFactory.newTransformer();
	            DOMSource domSource = new DOMSource(document);
	            StreamResult streamResult = new StreamResult(new File(xmlFilePath2));

	            // If you use
	            // StreamResult result = new StreamResult(System.out);
	            // the output will be pushed to the standard output ...
	            // You can use that for debugging 

	            transformer.transform(domSource, streamResult);

	            System.out.println("Done creating XML File");

	        } catch (ParserConfigurationException pce) {
	            pce.printStackTrace();
	        } catch (TransformerException tfe) {
	            tfe.printStackTrace();
	        }
     }
}
