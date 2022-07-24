
package com.example.fridger.model;

import java.util.ArrayList;
public class ShoppingList {

    private static AllRecipes allRecipes;
    private Fridge fridge;
    private ArrayList<Recipe> unavailableRecipes;
    private ArrayList<ArrayList<String>> ingredients;
    private ArrayList<ArrayList<Integer>> countOfIngredients;
    private ArrayList<ArrayList<Quantity>> quantitiesOfIngredients;


ShoppingList(Fridge fridge){

this.fridge = fridge;
unavailableRecipes = new ArrayList<Recipe>();
ingredients = new ArrayList<ArrayList<String>>();
countOfIngredients = new ArrayList<ArrayList<Integer>>();
quantitiesOfIngredients = new ArrayList<ArrayList<Quantity>>();
setUnavailableRecipes();

}

public void setUnavailableRecipes(){

int count = 0;

for(int i = 0 ; i< allRecipes.getTotalRecipes() ; i++ ){

for(int j = 0 ; j<fridge.getItemCount() ; i++){

for(int k = 0 ; k<3 ; k++){

    if(allRecipes.getRecipeByIndex(i).getIngredientsByIndex(k).equals(fridge.getItemByIndex(j).getName())){
        count++;

    }
    
}
if(count==1 || count==2){

unavailableRecipes.add(allRecipes.getRecipeByIndex(i));

}
}

}
//tomato
//rice
//chicken








}
public ArrayList<Recipe> getUnavailableRecipes(){
    return unavailableRecipes;
}

public void setIngredients(){

   for(int i = 0 ; i< this.unavailableRecipes.size() ; i++){
    for(int j = 0 ; j< 3 ; j++){

        this.ingredients.get(i).add(this.unavailableRecipes.get(i).getIngredientsByIndex(j));

    }
   }
   setCount();

    
}

private void setCount(){

    for(int i = 0 ; i<unavailableRecipes.size() ; i++){
        for(int j = 0 ; j<3 ; j++){

            countOfIngredients.get(i).add(1);

        }
    }
    setQuantityOfIngredients();

}
private void setQuantityOfIngredients(){

    for(int i = 0 ; i< unavailableRecipes.size() ; i++){

        for(int j = 0 ; j<3 ; j++){
            this.quantitiesOfIngredients.get(i).add(unavailableRecipes.get(i).getQuantityByIndex(j));
        }
    }

}
public void incrementCount(int index , int index2){

countOfIngredients.get(index).set(index2, countOfIngredients.get(index).get(index2)+1);

}
public void decrementCount(int index , int index2){

    countOfIngredients.get(index).set(index2, countOfIngredients.get(index).get(index2)-1);

    
}




    
}
