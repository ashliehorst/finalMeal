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
    
    private static String commonItems;
    private static List<Ingredient> shoppingList;   
    private static ShoppingList instance = new ShoppingList();
    
    private ShoppingList(){}
    
    public static ShoppingList getInstance() {
        shoppingList = new ArrayList();        
        commonItems = "";
        return instance;
    }
    

    /**
     * GETTERS
     * @return 
     */
    public String getCommonItem() {return commonItems;}
    public List<Ingredient> getShoppingList() {
        return shoppingList;
    }
     
    /**
     * SETTERS
     * @param commonList 
     */ 
    public void setCommonItem(String commonItem) {
        ShoppingList.commonItems = commonItem;
    }  
    public void setShoppingList(List<Ingredient> shoppingList) {
        ShoppingList.shoppingList = shoppingList;
    }
          
    /**
     * DISPLAY SHOPPING LIST
     * Has commonList and inredientList from scheduleList
     */
    public void displayShoppingList() {
        System.out.println("Common List: ");
        System.out.println(commonItems);
    }
    
     /**
     * Master list of ingredients to add together same ingredients
     * Make xml for ingredients to easily add stuff
     * @param schedule
     */     
    public void searchIngredientList(Schedule schedule) {
        boolean first = true;
        shoppingList.clear();
        for (int count = 0; count < schedule.getWeekIngredientList().size(); count++) {
            Ingredient ing1 = schedule.getWeekIngredientList().get(count);
            // The shoppingList has to have at least one thing in it to traverse
            if (first) {
               Ingredient shop = new Ingredient();
               shop.setName(ing1.getName());
               shop.setNumber(ing1.getNumber());
               shop.setType(ing1.getType()); 
               shoppingList.add(shop);
               first = false;
            }
            else {
                for (int i = 0; i <= shoppingList.size(); i++) {
                    // If you are at the end and it didn't hit the break in the 
                    //   other if statement, that means it is not in the list
                    if (i == shoppingList.size()) {
                        Ingredient shop = new Ingredient();
                        shop.setName(ing1.getName());
                        shop.setNumber(ing1.getNumber());
                        shop.setType(ing1.getType());
                        shoppingList.add(shop);
                        // You don't want to continue and make the Ingredient list
                        break;
                    }
                    Ingredient list = shoppingList.get(i);
                    if (list.getName().equals(ing1.getName())) {
                        list.setNumber(ing1.getNumber() + list.getNumber());
                        // If it's equal, there is no point in looking through the rest of the list
                        break;
                    }  
                    else {} // Hits else to traverse and keep comparing
                }
            }                      
        } // end of first for loop
    }              
}
    
    

