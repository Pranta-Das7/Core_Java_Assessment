package com.cognizant.customer.util;


	


    import java.io.File;
    import javax.xml.parsers.DocumentBuilderFactory;
    import javax.xml.parsers.DocumentBuilder;
    import org.w3c.dom.Document;
    import org.w3c.dom.NodeList;
    import org.w3c.dom.Node;
    import org.w3c.dom.Element;
    public class UtilityTest {
    	public static final String xmlFilePath = "C:\\Users\\2080580\\OneDrive - Cognizant\\Desktop\\xml\\customer.xml";
    	public static final String xmlFilePath1 = "C:\\Users\\2080580\\OneDrive - Cognizant\\Desktop\\xml\\room.xml";
    	public static final String xmlFilePath2 = "C:\\Users\\2080580\\OneDrive - Cognizant\\Desktop\\xml\\booking.xml";
        
       public static void customerxml() {
    	
    		   
          try {
             File inputFile = new File(xmlFilePath);
             DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
             DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
             Document doc = dBuilder.parse(inputFile);
             doc.getDocumentElement().normalize();
             System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
             NodeList nList = doc.getElementsByTagName("customer");
             System.out.println("----------------------------");

             for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                   Element eElement = (Element) nNode;
                   System.out.println("customerid : " 
                      + eElement.getAttribute("customerid"));
                   System.out.println(" customer name: " 
                      + eElement
                      .getElementsByTagName("name")
                      .item(0)
                      .getTextContent());
                   System.out.println("email : " 
                      + eElement
                      .getElementsByTagName("email")
                      .item(0)
                      .getTextContent());
                   System.out.println("phone number: " 
                      + eElement
                      .getElementsByTagName("phonenumber")
                      .item(0)
                      .getTextContent());
                   System.out.println("password " 
                      + eElement
                      .getElementsByTagName("password")
                      .item(0)
                      .getTextContent());
                }
             }
          } catch (Exception e) {
             e.printStackTrace();
          }
       }
       public static void roomXmlTest() {
    	   try {
               File inputFile = new File(xmlFilePath1);
               DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
               DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
               Document doc = dBuilder.parse(inputFile);
               doc.getDocumentElement().normalize();
               System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
               NodeList nList = doc.getElementsByTagName("room");
               System.out.println("----------------------------");

               for (int temp = 0; temp < nList.getLength(); temp++) {
                  Node nNode = nList.item(temp);
                  System.out.println("\nCurrent Element :" + nNode.getNodeName());

                  if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                     Element eElement = (Element) nNode;
                     System.out.println("roomid : " 
                        + eElement.getAttribute("roomid"));
                     System.out.println(" room type: " 
                        + eElement
                        .getElementsByTagName("roomtype")
                        .item(0)
                        .getTextContent());
                     System.out.println("price: " 
                        + eElement
                        .getElementsByTagName("price")
                        .item(0)
                        .getTextContent());
                     System.out.println("view: " 
                        + eElement
                        .getElementsByTagName("view")
                        .item(0)
                        .getTextContent());
                    
                  }
               }
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
       public static void bookingXmlTest() {
       try {
           File inputFile = new File(xmlFilePath2);
           DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
           DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
           Document doc = dBuilder.parse(inputFile);
           doc.getDocumentElement().normalize();
           System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
           NodeList nList = doc.getElementsByTagName("booking");
           System.out.println("----------------------------");

           for (int temp = 0; temp < nList.getLength(); temp++) {
              Node nNode = nList.item(temp);
              System.out.println("\nCurrent Element :" + nNode.getNodeName());

              if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                 Element eElement = (Element) nNode;
                 System.out.println("bookid : " 
                    + eElement.getAttribute("bookid"));
                 System.out.println(" customer name: " 
                    + eElement
                    .getElementsByTagName("customer_name")
                    .item(0)
                    .getTextContent());
                 System.out.println("room id : " 
                    + eElement
                    .getElementsByTagName("room_id")
                    .item(0)
                    .getTextContent());
                 System.out.println("checkin: " 
                    + eElement
                    .getElementsByTagName("checkin")
                    .item(0)
                    .getTextContent());
                 System.out.println("checkout :" 
                    + eElement
                    .getElementsByTagName("checkout")
                    .item(0)
                    .getTextContent());
                 System.out.println("room status: " 
                         + eElement
                         .getElementsByTagName("room_status")
                         .item(0)
                         .getTextContent());
              }
           }
        } catch (Exception e) {
           e.printStackTrace();
        }
     }
       
       
   }