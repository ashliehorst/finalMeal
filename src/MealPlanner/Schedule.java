/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MealPlanner;

import java.util.ArrayList;
import java.util.Calendar;
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
    
    private List<Recipe> rotateList;
    private List<Recipe> recipeList;
    private List<Recipe> weekList;
    private List<Ingredient> weekIngredientList;
    private int count;
    private boolean flag;
      
    /**
     * SCHEDULE CONSTRUCTOR
     */
    public Schedule() {
        recipeList = new ArrayList();
        rotateList = new ArrayList();
        weekList = new ArrayList();
        weekIngredientList = new ArrayList();
        count = 0;
        flag = false;
    }

    /**
     * GETTERS
     * @return 
     */
    public List<Recipe> getRecipeList() {return recipeList;}
    public int getCount() {return count;}
    public List<Recipe> getWeekList() {return weekList;}
    public List<Ingredient> getWeekIngredientList() {return weekIngredientList;}
    public List<Recipe> getRotateList() {return rotateList;}
 
    /**
     * SETTERS 
     * @param recipeList
     */ 
    public void setRecipeList(List<Recipe> recipeList) {this.recipeList = recipeList;}
    public void setCount(int count) {this.count = count;}
    public void setWeekList(List<Recipe> weekList) {this.weekList = weekList;}
    public void setRotateList(List<Recipe> rotateList) {this.rotateList = rotateList;}
    
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
    
    public void addRecipeToList(Recipe rep){
        recipeList.add(rep);
    }
    
    /**
     * DAY TRACKER
     * This method calls the rotateRecipes when Saturday 
     * arrives
     */
    private void dayTracker(){
        // if day is Saturday
        if (Calendar.DAY_OF_WEEK == 7) {
            rotateRecipes();
        }      
    }
    
    /**
     * ITETERATE THRU SCHEDULE LIST
     * NOTE: The returned recipe is for today's meal
     * Every time the program is opened, this 
     * method needs to execute
     * If null is returned then we have 
     * a problem
     * @return 
     */
    public Recipe iterateThruSchedule() {
        // Days of the week are 1-7 while weekList is an array 0-6
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_WEEK); 
        switch (day){
            case 1:
                // Sunday
                // Get the recipe that is at position 0
                return weekList.get(day - 1);
            case 2:
                // Monday
                // Get the recipe that is at position 1, etc.
                return weekList.get(day - 1);
            case 3:
                // Tuesday
                return weekList.get(day - 1);
            case 4:
                // Wednesday
                return weekList.get(day - 1);
            case 5:
                // Thursday
                return weekList.get(day - 1);
            case 6:
                // Friday
                return weekList.get(day - 1);
            case 7:
                // Saturday
                return weekList.get(day - 1);
        }
        return null;
    }
    
    /**
     * ROTATE RECIPES
     * For each week, rotate to the next seven recipes that will be on the schedule
     * It needs to know the date Sun-Sat to know when to rotate
     * It needs to keep track of what recipe it last used so that it can start
     *   the new week on the next recipe.
     * NOTE: The schedule will update Saturday Morning
     */
    public void rotateRecipes() {
        // "i" keeps track of the seven days
        // Count on number on rotateList
        
        weekList.clear(); // clear every time before new week
        for (int i = 0; i < 7; i++){
            if (count == rotateList.size()) {
                count = 0;
            }
            weekList.add(rotateList.get(count));
            count++;
        }
    }
    
    public void makeWeekIngredient() {
        for (Recipe rec : weekList) {
            for (Ingredient ing : rec.getIngredientList()) {
                weekIngredientList.add(ing);
            }
            
        }
    }
}
