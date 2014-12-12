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
    
    private static Map<Ingredient, Ingredient> ingredientMap;
    
    private static ShoppingList instance = new ShoppingList();
    
    public ShoppingList(){}
    // Error My test to add ingredients doesn't work now that shoppingList is static...
    public static ShoppingList getInstance() {
        shoppingList = new ArrayList();
        
        commonItems = "";
        ingredientMap = new HashMap<>();
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
        double num = 0;
        for (int count = 0; count < schedule.getWeekIngredientList().size(); count++) {
            Ingredient ing1 = schedule.getWeekIngredientList().get(count);
            for (int i = 0; i < schedule.getWeekIngredientList().size(); i++) {
                Ingredient ing2 = schedule.getWeekIngredientList().get(i);
                if (count == i) {}
                else {
                    if (ing1.getName().equals(ing2.getName())) {
                        num += ing1.getNumber() + ing2.getNumber();
                        schedule.getWeekIngredientList().remove(ing2);  // Something is weird with this remove. The next value will be the same as the first one.
                        i--;
                    }
                }
            }   
            ing1.setNumber(num);       
        }    
        
    }
    
   /* public void searchIngredientList(Schedule schedule) {
        boolean first = true;
        for (int count = 0; count < schedule.getWeekIngredientList().size(); count++) {
            Ingredient ing1 = schedule.getWeekIngredientList().get(count);
            if (first) {
               shoppingList.add(ing1); // this is adding by reference,  not by value
               first = false;
            }
            for (Ingredient list : shoppingList) {
                list.getName();
                if (list.getName().equals(ing1.getName())) {
                    // I think it has something to do with the fact that I am setting an ingredient number...
                    // list and ing1 have the same address!!!!!
                    list.setNumber(ing1.getNumber() + list.getNumber());
                } 
                else {
                   shoppingList.add(ing1);
                }  
                System.out.println("Did one for loop");
            }                      
        }
    }  */        
     
}
    
    

