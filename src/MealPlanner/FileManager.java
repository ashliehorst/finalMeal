package MealPlanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * FILE MANAGER CLASS
 * The File Manager class will be taking care of XML and a TXT file types.
 * It will build and save XML and TXT files.
 * Files will be stored in a properties file.
 * @author Ashlie
 */
public class FileManager {
    
    /**
     * BUILD XML DOCUMENT
     * @param schedule
     * @return 
     */
    public Document buildXmlDocument(Schedule schedule) {
        Document doc = null;
        try {
                DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
		// root elements
		doc = docBuilder.newDocument();
		Element rootElement = doc.createElement("lists");
                
		doc.appendChild(rootElement);
                
                Element recList = doc.createElement("recipeList");
                rootElement.appendChild(recList);
                
                // Recipe elements
                for (Recipe recipe : schedule.getRecipeList()) { 
                    Element rec = doc.createElement("recipe");
                    recList.appendChild(rec);
                    rec.setAttribute("title", recipe.getTitle());
                    
                    for (Ingredient ingredient : recipe.getIngredientList()) {
                        Element ing = doc.createElement("ingredient");
                        rec.appendChild(ing);
                        ing.setAttribute("name", ingredient.getName());
                        ing.setAttribute("number", Double.toString(ingredient.getNumber()));
                        ing.setAttribute("type", ingredient.getType());                 
                    }
                    
                    Element directions = doc.createElement("directions");  
                    rec.appendChild(directions);
                    directions.appendChild(doc.createTextNode(recipe.getDirections()));
                } 
                
                Element rotList = doc.createElement("rotateList");
                rootElement.appendChild(rotList);
                for (Recipe rotate : schedule.getRotateList()) { 
                    Element rot = doc.createElement("rotate");
                    rotList.appendChild(rot);
                    rot.setAttribute("title", rotate.getTitle());
                    
                    for (Ingredient ingredient : rotate.getIngredientList()) {
                        Element ing = doc.createElement("ingredient");
                        rot.appendChild(ing);
                        ing.setAttribute("name", ingredient.getName());
                        ing.setAttribute("number", Double.toString(ingredient.getNumber()));
                        ing.setAttribute("type", ingredient.getType());                 
                    }
                    
                    Element directions = doc.createElement("directions");  
                    rot.appendChild(directions);
                    directions.appendChild(doc.createTextNode(rotate.getDirections()));
                } 
                
	  } catch (ParserConfigurationException pce) {
                System.out.println("Error in buildXmlDocument");
	  }
        return doc;
    }
    
    /**
     * SAVE XML DOCUMENT
     * @param doc
     * @param fileName
     */
    public void saveXmlDocument(Document doc, String fileName) {
        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            
            DOMSource source = new DOMSource(doc);           
            StreamResult result = new StreamResult(fileName);
            
            t.transform(source, result);
                   
            System.out.println("File saved!");
        } catch (IllegalArgumentException | TransformerException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

         
    /**
     * SAVE TXT
     * Save the text file 
     * @param fileName
     * @param shoppinglist
     * @throws java.io.FileNotFoundException
     */
    public void writeToTxtFile(String fileName, ShoppingList shoppinglist) throws FileNotFoundException {  
        try{
            try (PrintWriter writer = new PrintWriter(fileName, "UTF-8")) {
                for (Ingredient item : shoppinglist.getShoppingList()){
                    writer.println(item);
                }
            }
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(ShoppingList.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Written to txt file...");
    }
    
    /**
     * READ XML FILE
     * It will get the file from the Properties class
     * @param schedule
     * @param fileName
     */
    public void readXmlFile(Schedule schedule, String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document;
            document = builder.parse(fileName);
                 
            System.out.println("Loading " + document.getDocumentURI());            
            document.normalize();
            
            // Iterating throught the nodes and extracting the data
            NodeList nodeList = document.getElementsByTagName("recipe");
            
            for (int i = 0; i < nodeList.getLength(); i++) {              
                Node node = nodeList.item(i);
                if (node instanceof Element) {
                    Recipe recipe = new Recipe();
                    readRecipeContent(node, recipe);
                    schedule.getRecipeList().add(recipe);
                }             
            } // end of recipe for-loop
            
            NodeList rotateList = document.getElementsByTagName("rotate");
            
            for (int i = 0; i < rotateList.getLength(); i++) {              
                Node node = rotateList.item(i);
                if (node instanceof Element) {
                    Recipe recipe = new Recipe();
                    readRecipeContent(node, recipe);
                    schedule.getRotateList().add(recipe);
                }             
            } // end of recipe for-loop
        } catch (ParserConfigurationException | SAXException | IOException | NumberFormatException | DOMException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * GET RECIPE CONTENT
     * A function that splits up the functionality of READ XML FILE
     * @param node
     * @param recipe 
     */
    public void readRecipeContent(Node node, Recipe recipe) {
        String title;
        String directions;
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element aElement = (Element) node;
            title = aElement.getAttribute("title");
                        
            recipe.setTitle(title);   
                        
            NodeList ingredList = aElement.getElementsByTagName("ingredient");
                        
            for (int it = 0;it < ingredList.getLength(); it++){
                Ingredient ing = new Ingredient();
                Node sNode = ingredList.item(it);
                Element iElement = (Element)sNode;
                ing.setName(iElement.getAttribute("name"));
                ing.setNumber(Double.parseDouble(iElement.getAttribute("number")));
                ing.setType(iElement.getAttribute("type"));
                            
                recipe.getIngredientList().add(ing);
            } // end of ingredient for loop
                        
            directions = aElement.getElementsByTagName("directions").item(0).getTextContent();
                        
            directions = directions.trim();
            directions = directions.replaceAll("\\n\\s+", "\n");
                        
            recipe.setDirections(directions);
        } // end of element_node if statement
    }
    

    
    public void run() {
//        Schedule schedule = new Schedule();
//        Property prop = new Property();
//        String file = prop.getFile(); 
//        readXmlFile(schedule, file);
//        //display(schedule);
//        //ShoppingList shoppingList = new ShoppingList();
//        //shoppingList.displayShoppingList();
    }
    
    /**
     * TEST DISPLAY
     * 
     */
    public void display(Schedule schedule) {
        for (Recipe recipe : schedule.getRecipeList()) {                     
            System.out.println(recipe.getTitle());              
            for (Ingredient ingredient : recipe.getIngredientList()) {
                System.out.println(ingredient.getName());
                System.out.println(ingredient.getNumber());
                System.out.println(ingredient.getType());
            } 
        }
    }
}

