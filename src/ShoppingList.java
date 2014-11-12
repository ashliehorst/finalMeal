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
    
    private List<String> commonList;

    /**
     * SHOPPING LIST CONSTRUCTOR
     */
    public ShoppingList() {
        commonList = new ArrayList();
    }

    /**
     * GETTERS
     * @return 
     */
    public List<String> getCommonList() {return commonList;}
    
    /**
     * SETTERS
     * @param commonList 
     */ 
    public void setCommonList(List<String> commonList) {
        this.commonList = commonList;
    }
       
}
