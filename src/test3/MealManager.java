/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test3;

import MealPlanner.Schedule;

/**
 *
 * @author paul
 */
public class MealManager {
    
    private static MealManager instance = new MealManager();
    private MealManager(){
        
    }
    
    public static MealManager getInstance() {
//        if (instance == null) {
//            instance = new MealManager();
//        }
        return instance;
    }
    
}
