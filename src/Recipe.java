/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.ArrayList;
import java.util.List;

/**
 * RECIPIE CLASS
 * The Recipe class has a list of ingredient objects which will make up a recipe.
 * It will also have a name of the recipe, cooking directions, 
 *   and will have a picture associated with it that the user can include.
 * @author Ashlie
 */
public class Recipe {
    
    private String title;
    private List<Ingredient> ingredientList;
    private String directions;
    
    /**
     * RECIPE CONSTRUCTOR
     */
    public Recipe() {
        // We need something for a picture
        title = "";
        ingredientList = new ArrayList<>();
        directions = "";
    }

    /**
     * GETTERS
     * @return 
     */
    public String getTitle() {return title;}
    public String getDirections() {return directions;}
    public List<Ingredient> getIngredientList() {return ingredientList;}
    
    /**
     * SETTERS
     * @param title 
     */
    public void setTitle(String title) {this.title = title;}
    public void setDirections(String directions) {this.directions = directions;}
    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }
    
    
}
