
package com.example.fridger.model;
import java.util.ArrayList;

public class Recipes {

private ArrayList<Recipe> availableRecipes ;
private int count;

Recipes(AllRecipes recipes, Fridge fridge){

availableRecipes = new ArrayList<Recipe>();
setAvailableRecipes(recipes,fridge);

}

private void setAvailableRecipes(AllRecipes allrecipes, Fridge fridge){

for(int i = 0 ; i< allrecipes.getTotalRecipes() ; i++){

for(int j = 0 ; j<fridge.getItemCount() ; j++){

for(int k = 0 ; k<3 ; k++){

    if(allrecipes.getRecipeByIndex(i).getIngredientsByIndex(k).equals(fridge.getItemByIndex(j).getName())){

        availableRecipes.add(allrecipes.getRecipeByIndex(i));
        count++;
    }

}
}
}

}

public ArrayList<Recipe> getAvailablRecipes(){
    return this.availableRecipes;
} 
public int getCount(){
    return count;
}



    
}
