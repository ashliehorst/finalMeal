/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import MealPlanner.FileManager;
import MealPlanner.Ingredient;
import MealPlanner.Property;
import MealPlanner.Recipe;
import MealPlanner.Schedule;
import MealPlanner.ShoppingList;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.Document;

/**
 *
 * @author paul
 */
public class ScheduleTester {
    
    Schedule s = Schedule.getInstance();
    ShoppingList shoppingList = ShoppingList.getInstance();
    FileManager files = new FileManager();
    Property prop = new Property();
        
    public ScheduleTester() {
    }
  
    public void recipeTest() {
        Recipe spag = new Recipe();
        spag.setTitle("1");
        s.getRecipeList().add(spag);
        
        Recipe food1 = new Recipe();
        food1.setTitle("2");
        s.getRecipeList().add(food1);
        
        Recipe food2 = new Recipe();
        food2.setTitle("3");
        s.getRecipeList().add(food2);
    }
    
    @Test
    public void rotateRecipeListTest(){
        String file = prop.getFile(); 
        files.readXmlFile(s, file);

        // Make sure that the recipe list works (it does)
        for (Recipe recipe : s.getRecipeList()){
            // Add to roate list
            s.getRotateList().add(recipe);
            System.out.println("Recipe: " + recipe.getTitle());
        }

        // Make sure that the rotate list works (it does)
        /*for (Recipe rotate : s.getRotateList()) {
            System.out.println("Rotate: " + rotate.getTitle());
        }*/
            
        // Now assign your schedule list
        s.rotateRecipes();
        
        // Make sure that your schedule list works 
        //   with proper rotations (it does!!!)
       /* for (Recipe schedule : s.getWeekList()) {
            System.out.println("Schedule: " + schedule.getDirections());
        }*/

      
        s.makeWeekIngredient();
        
        // Ingredient list before the merge
        for (Ingredient ing1 : s.getWeekIngredientList()) {
            System.out.println("Ingredients before: " + ing1.getName());         
        }
        
        shoppingList.searchIngredientList(s);
        
        // Ingredient list after the merge
        for (Ingredient ing1 : shoppingList.getShoppingList()) {
            System.out.println("Ingredients after: " + ing1.getName() + " " + ing1.getNumber()); 
            
        } 
        
        Document xml = null;
        xml = files.buildXmlDocument(s);
        files.saveXmlDocument(xml, file);

        s.iterateThruSchedule();
    }
    

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }
}
