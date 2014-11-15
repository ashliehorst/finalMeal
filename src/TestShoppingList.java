
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ashlie
 */
public class TestShoppingList {
    
    ShoppingList s = new ShoppingList();
    
    public static void main(String[] args) {
        new TestShoppingList().run();
    }
    
    public void run() {
        makeAddCommonItem();
        
        System.out.println("Print out list" + s.getCommonList());
        
        System.out.println("The for loop for common list");
        for (String li: s.getCommonList()) {
            System.out.println(li);
        }
    }
    
    /**
     * Make and add a common item onto the common list
     */
    public void makeAddCommonItem() {
        String bread = "bread";
        s.setCommonItem(bread);
        s.getCommonList().add(s.getCommonItem());
        System.out.println(s.getCommonList());
    }
    
    /**
     * MAKE SHOPPING LIST
     * Has commonList and inredientList from scheduleList
     */
    public void makeShoppingList() {
        for (String c : s.getCommonList()) {
            System.out.println("Common List:");
            s.getShoppingList().add(c); 
        }
        
        //for (String d : getScheduleList()) {
        //    for (String a : getIngredientList()) {
        //        System.out.println("Menu Ingredient List:");
        //        s.getShoppingList().add(a);
        //    }
        // }
        
    }
    
    /**
     * Master list of ingredients to add together same ingredients
     * Make xml for ingredients to easily add stuff together
     */
    
}
