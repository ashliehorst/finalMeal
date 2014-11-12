/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * SCHEDULE CLASS
 * Has a list of all the recipes that the user has input into the program. 
 * This class will manage the list of recipes to do what we want with them: 
 *   rotate the recipe list in the way the user specifies.
 * @author Ashlie
 */
public class Schedule {
    
    private List<Recipe> recipeList;
    private int count;
    
    /**
     * SCHEDULE CONSTRUCTOR
     */
    public Schedule() {
        recipeList = new ArrayList();
        count = 0;
    }
    
    /**
     * GETTERS
     * @return 
     */
    public List<Recipe> getRecipeList() {return recipeList;}
    public int getCount() {return count;}
   
    /**
     * SETTERS 
     * @param recipeList
     */ 
    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
    public void setCount(int count) {this.count = count;}
    
    /**
     * GET DATE
     * Gets the real date Sun-Sat
     * Returns the date that it gets
     * @return 
     */
    public Date getDate() {
        Date d = new Date();
        return d;
    }
    
    /**
     * REMOVE
     * Removes recipe from the schedule
     */
    public void remove() {
        
    }
    
    /**
     * ADD
     * Adds a recipe to the schedule
     */
    public void add() {
        
    }
    
    /**
     * ROTATE RECIPES
     * For each week, rotate to the next seven recipes that will be on the schedule
     * It needs to know the date Sun-Sat to know when to rotate
     * It needs to keep track of what recipe it last used so that it can start
     *   the new week on the next recipe.
     */
    public void rotateRecipes() {
        
    }
}
