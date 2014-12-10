package MealPlanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * SHOPPING LIST CLASS
 * The Shopping List class makes a one-week shopping list based on the 
 * recipes that will be made that week. 
 * This includes the list of ingredients for the recipes as well as the 
 * common shopping list holding basic food items.
 * @author Ashlie
 */
public class ShoppingList {
    
    private String commonItem;
    private List<Ingredient> shoppingList;
    private List<String> commonList;
    
    private Map<Ingredient, Ingredient> ingredientMap;
    /**
     * SHOPPING LIST CONSTRUCTOR
     */
    public ShoppingList() {
        shoppingList = new ArrayList();
        commonList = new ArrayList();
        commonItem = "";
        ingredientMap = new HashMap<>();
    }

    /**
     * GETTERS
     * @return 
     */
    public List<String> getCommonList() {return commonList;}
    public String getCommonItem() {return commonItem;}

    public List<Ingredient> getShoppingList() {
        return shoppingList;
    }
     
    /**
     * SETTERS
     * @param commonList 
     */ 
    public void setCommonList(List<String> commonList) {
        this.commonList = commonList;
    }
    public void setCommonItem(String commonItem) {
        this.commonItem = commonItem;
    }  
    public void setShoppingList(List<Ingredient> shoppingList) {
        this.shoppingList = shoppingList;
    }
          
    /**
     * DISPLAY SHOPPING LIST
     * Has commonList and inredientList from scheduleList
     */
    public void displayShoppingList() {
        System.out.println("Common List: ");
        for (String c : getCommonList()) {
           System.out.println(c);
        }
            
        System.out.println("Schedule List: ");
        //for (Ingredient ing : schedule.getWeekIngredientList()) {
        //   System.out.println(ing);
        //}
    }
  
   
        
        //for (String d : getScheduleList()) {
        //    for (String a : getIngredientList()) {
        //        System.out.println("Menu Ingredient List:");
        //        getShoppingList().add(a);
        //    }
        // }
    
     /**
     * Master list of ingredients to add together same ingredients
     * Make xml for ingredients to easily add stuff together
     */   
    /*public void searchIngredientList(Schedule schedule) {
        for (int count = 0; count < schedule.getWeekIngredientList().size(); count++) {
            Ingredient ing1 = schedule.getWeekIngredientList().get(count);
            for (int i = 0; i < schedule.getWeekIngredientList().size(); i++) {
                Ingredient ing2 = schedule.getWeekIngredientList().get(i);
                if (count == i) {}
                else {
                    if (ing1.getName().equals(ing2.getName())) {
                        ing1.setNumber(ing1.getNumber() + ing2.getNumber());
                        schedule.getWeekIngredientList().remove(ing2);  // Something is weird with this remove. The next value will be the same as the first one.
                        i--;
                    }
                }
            }          
        }    
    }*/
    
    public void searchIngredientList(Schedule schedule) {
        boolean first = true;
        for (int count = 0; count < schedule.getWeekIngredientList().size(); count++) {
            Ingredient ing1 = schedule.getWeekIngredientList().get(count);
            if (first) {
               shoppingList.add(ing1);
               first = false;
            }
            for (Ingredient list : shoppingList) {
                list.getName();
                if (list.getName().equals(ing1.getName())) {
                    // I think it has something to do with the fact that I am setting an ingredient number...
                    list.setNumber(ing1.getNumber() + list.getNumber());
                } 
                else {
                   shoppingList.add(ing1);
                }   
            }                      
        }
    }          
     
}
    
    

