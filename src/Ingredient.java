/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 * INGREDIENT CLASS
 * This class takes care of the ingredient objects for the recipes.
 * It has a name, quantity, and measurement.
 * @author Ashlie
 */
public class Ingredient {
   
    private String name;
    private double number;
    private String type;
    
    /**
     * INGREDIENT CONSTRUCTOR
     * Sets all the variables
     */
    public Ingredient() {
        Ingredient ingredient = new Ingredient();
        name = null;
        number = 0;
        type = null; 
    }
    
    /**
     * GETTERS
     * @return 
     */
    public String getName() {return name;}
    public double getNumber() {return number;}
    public String getType() {return type;}
    
    /**
     * SETTERS
     * @param name 
     */
    public void setName(String name) {this.name = name;}
    public void setNumber(double number) {this.number = number;}
    public void setType(String type) {this.type = type;}
    
}


