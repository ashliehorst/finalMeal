package MealPlanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ashlie
 */
public class IngredientTest {
    
    Ingredient ingredient;
        
    public void main() {
        testSetIngredient();
        testGetIngredient();
    }
    
    /**
     * TEST SET INGREDIENT
     * Test to see if the setters work
     */
    public void testSetIngredient() {
        ingredient.setName("bread");
        ingredient.setNumber(1.4);
        ingredient.setType("pounds");    
    }
    
    /**
     * TEST GET INGREDIENT
     * Test to see if getters work
     */
    public void testGetIngredient() {
        ingredient.getName();
        ingredient.getNumber();
        ingredient.getType();
    }
    
}
