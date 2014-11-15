/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
    private List<Recipe> scheduleList;
    private int count;
    private boolean flag;
      
    /**
     * SCHEDULE CONSTRUCTOR
     */
    public Schedule() {
        recipeList = new ArrayList();
        rotateList = new ArrayList();
        scheduleList = new ArrayList();
        count = 0;
        flag = false;
    }

    public List<Recipe> getRotateList() {
        return rotateList;
    }

    public void setRotateList(List<Recipe> rotateList) {
        this.rotateList = rotateList;
    }
    
    /**
     * GETTERS
     * @return 
     */
    public List<Recipe> getRecipeList() {return recipeList;}
    public int getCount() {return count;}
    public List<Recipe> getScheduleList() {
        return scheduleList;
    }
 
    /**
     * SETTERS 
     * @param recipeList
     */ 
    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }
    public void setCount(int count) {this.count = count;}
    public void setScheduleList(List<Recipe> scheduleList) {
        this.scheduleList = scheduleList;
    }
    
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
     * DAY TRACKER
     * This method calls the rotateRecipes when Saturday 
     * arrives
     */
    private void dayTracker(){
        // if day is Saturday
        if (Calendar.DAY_OF_WEEK == 6) {
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
        int day = Calendar.DAY_OF_WEEK;
        switch (day){
            case 0:
                // Sunday
                return scheduleList.get(day);
            case 1:
                // Monday
                return scheduleList.get(day);
            case 2:
                // Tuesday
                return scheduleList.get(day);
            case 3:
                // Wednesday
                return scheduleList.get(day);
            case 4:
                // Thursday
                return scheduleList.get(day);
            case 5:
                // Friday
                return scheduleList.get(day);
            case 6:
                // Saturday
                return scheduleList.get(day);
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
        
        scheduleList.clear(); // clear every time before new week
        for (int i = 0; i < 7; i++){
            if (count == rotateList.size()) {
                count = 0;
            }
            scheduleList.add(rotateList.get(count));
            count++;
        }
    }
}
