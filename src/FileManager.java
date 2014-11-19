/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * FILE MANAGER CLASS
 * The File Manager class will be taking care of XML and a TXT file types.
 * It will build and save XML and TXT files.
 * Files will be stored in a properties file.
 * @author Ashlie
 */
public class FileManager {
    
    /*****************
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
		Element rootElement = doc.createElement("recipe");
		doc.appendChild(rootElement);
                
                // Entry elements
                for (Recipe recipe : schedule.getRecipeList()) {                     
                    Element rec = doc.createElement("title");
                    rootElement.appendChild(rec);
                    
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
	  } catch (ParserConfigurationException pce) {
		pce.printStackTrace();
	  }
        return doc;
    }
    
    /*****************
     * SAVE XML DOCUMENT
     * @param doc
     * @param file
     */
    public void saveXmlDocument(Document doc, String file) {
    
    }
         
    /*****************
     * SAVE TXT
     * Save the text file 
     * @param doc
     * @param fileName
     */
    public void saveTxt(Document doc, String fileName) {  
        try {
            Transformer t = TransformerFactory.newInstance().newTransformer();
            
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            
            DOMSource source = new DOMSource(doc);
            
            StreamResult result = new StreamResult(fileName);
            
            try {
                t.transform(source, result);
            } catch (TransformerException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("File saved!");
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /*********************
     * READ XML FILE
     * It will get the file from the Properties class
     * @param fXmlFile
     */
    public void readXmlFile(String fXmlFile) {
        
    }
}
