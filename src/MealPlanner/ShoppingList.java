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
    private List<Ingredient> shoppingList;
    
    private static Map<Ingredient, Ingredient> ingredientMap;
    
    private static ShoppingList instance = new ShoppingList();
    
    public ShoppingList(){
    shoppingList = new ArrayList();
    }
    // Error My test to add ingredients doesn't work now that shoppingList is static...
   /* public static ShoppingList getInstance() {
        shoppingList = new ArrayList();
        
        commonItems = "";
        ingredientMap = new HashMap<>();
        return instance;
    }*/
    

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
        this.shoppingList = shoppingList;
    }
          
    /**
     * DISPLAY SHOPPING LIST
     * Has commonList and inredientList from scheduleList
     */
    public void displayShoppingList() {
        System.out.println("Common List: ");
        System.out.println(commonItems);
            
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
     * Make xml for ingredients to easily add stuff
     * @param schedule
     * @param scheduletogether
     */     
    public void searchIngredientList(Schedule schedule) {
        boolean first = true;
        for (int count = 0; count < schedule.getWeekIngredientList().size(); count++) {
            Ingredient ing1 = schedule.getWeekIngredientList().get(count);
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
                    if (i == shoppingList.size()) {
                        Ingredient shop = new Ingredient();
                        shop.setName(ing1.getName());
                        shop.setNumber(ing1.getNumber());
                        shop.setType(ing1.getType());
                        shoppingList.add(shop);
                        break;
                    }
                    Ingredient list = shoppingList.get(i);
                    if (list.getName().equals(ing1.getName())) {
                        list.setNumber(ing1.getNumber() + list.getNumber());
                        // If it does equal, there is no point in looking through the rest of the list
                        break;
                    }  
                    else {}   
                }
            }                      
        } // end of first for loop
    }              
}
    
    

