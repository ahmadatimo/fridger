package com.example.fridger.model;
import java.util.ArrayList;

public class AllRecipes {

ArrayList<Recipe> recipes;
private int totalRecipes;

AllRecipes(){

String[] pastaIngredients =  {"Pasta","White Sauce","Mushroom"};
Quantity[] pastaQuantities = {new Quantity("100", Measure.GR) , new Quantity("3/4", Measure.PACKET) , new Quantity("150", Measure.GR)};
recipes.add(new Recipe("Creamy Mushroom pasta",pastaIngredients, "bro", pastaQuantities, "Cook the Pasta by boiling water then add the pasta, after you are done adding the pasta make your favorite white sauce, cut some mushroom in order to add it to the dish later. When the pasta is cooked add the white sauce and the mushrooms to your dish."));
    totalRecipes++;
String[] dolmaIngredients = {"Grape leaves" , "Rice" , "Meat" };
Quantity[] dolmaQuantities = {new Quantity("100", Measure.GR) , new Quantity("50", Measure.GR) , new Quantity("50", Measure.GR)};
recipes.add(new Recipe("Stuffed Grape Leaves", dolmaIngredients, "bro", dolmaQuantities, "You need to  put the cooked rice on the grapes leaves, then turn the grapes leaves as they contain the rice and close on them before the rice goes out.then take another grape leave and make sure to put it as another layer to protect the inner grapeleaves from cracking."));
totalRecipes++;

}
public int getTotalRecipes(){
    return totalRecipes;
}

public Recipe getRecipeByIndex(int index){

    return this.recipes.get(index);
}

public boolean isIncluded(Item item){

    for(int i = 0 ; i<recipes.size() ; i++){

        for(int j = 0 ; j<3 ; j++){
            
            if(this.recipes.get(i).getIngredientsByIndex(j).equals(item.getName())){
                return true;
            }
        }
    }
    return false;
}

public ArrayList<Recipe> getIncludedRecipes(Item item){

    ArrayList<Recipe> availableRecipes = new ArrayList<>();

    for(int i = 0 ; i<recipes.size() ; i++){

        for(int j = 0 ; j<3 ; j++){
            
            if(this.recipes.get(i).getIngredientsByIndex(j).equals(item.getName())){
                return this.recipes;
            }
        }
    }
    return null;
}


    
}
