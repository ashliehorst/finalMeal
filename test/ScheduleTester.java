/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 *
 * @author paul
 */
public class ScheduleTester {
    
    Schedule s = new Schedule();
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
        
        Recipe food3 = new Recipe();
        food3.setTitle("4");
        s.getRecipeList().add(food3);
        
        Recipe food4 = new Recipe();
        food4.setTitle("5");
        s.getRecipeList().add(food4);
        
        Recipe food5 = new Recipe();
        food5.setTitle("6");
        s.getRecipeList().add(food5);
        
//        Recipe food6 = new Recipe();
//        food6.setTitle("7");
//        s.getRecipeList().add(food6);
        
//        Recipe food7 = new Recipe();
//        food7.setTitle("8");
//        s.getRecipeList().add(food7);
    }
    
    @Test
    public void rotateRecipeListTest(){
        // Make your test recipies
        recipeTest();
        // Make sure that the recipe list works (it does)
        for (Recipe recipe : s.getRecipeList()){
            // Add to roate list
            s.getRotateList().add(recipe);
            System.out.println("Recipe: " + recipe.getTitle());
        }
        
        // Make sure that the rotate list works (it does)
        for (Recipe rotate : s.getRotateList()) {
            System.out.println("Rotate: " + rotate.getTitle());
        }
            
        // Now assign your schedule list
        s.rotateRecipes();
        
        // Make sure that your schedule list works 
        //   with proper rotations (it does!!!)
        for (Recipe schedule : s.getScheduleList()) {
            System.out.println("Schedule: " + schedule.getTitle());
        }
        
        // This, however does not work
        Assert.assertNotEquals(s.iterateThruSchedule(), null);          
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
