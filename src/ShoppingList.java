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
    
    public void searchIngredientList() {
        int count = 0;
        for (Ingredient ing1 : shoppingList) {
            for (int i = 0; i < shoppingList.size(); i++) {
                Ingredient ing2 = shoppingList.get(i);
                if (count == i) {}
                else {
                   if (ing1.getName().equals(ing2.getName())) {
                       ing1.setNumber(ing1.getNumber() + ing2.getNumber());
                       shoppingList.remove(ing2);                     
                   }
                }
            }          
            count++;
        }    
    }
}
    
    

