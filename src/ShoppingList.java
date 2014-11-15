/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;

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
    private List<String> shoppingList;
    private List<String> commonList;

    /**
     * SHOPPING LIST CONSTRUCTOR
     */
    public ShoppingList() {
        shoppingList = new ArrayList();
        commonList = new ArrayList();
        commonItem = "";
    }

    /**
     * GETTERS
     * @return 
     */
    public List<String> getCommonList() {return commonList;}
    public String getCommonItem() {return commonItem;}

    public List<String> getShoppingList() {
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
    public void setShoppingList(List<String> shoppingList) {
        this.shoppingList = shoppingList;
    }
          
    /**
     * MAKE SHOPPING LIST
     * Has commonList and inredientList from scheduleList
     */
    public void makeShoppingList() {
        for (String c : getCommonList()) {
            System.out.println("Common List:");
            getShoppingList().add(c); 
        }
        
        //for (String d : getScheduleList()) {
        //    for (String a : getIngredientList()) {
        //        System.out.println("Menu Ingredient List:");
        //        getShoppingList().add(a);
        //    }
        // }
        
    }
    
    /**
     * Master list of ingredients to add together same ingredients
     * Make xml for ingredients to easily add stuff together
     */
       
}
