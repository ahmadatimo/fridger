
package com.example.fridger.model;
import java.util.ArrayList;
import java.util.Collections;

public class Recipes {

    private ArrayList<Recipe> availableRecipes ;
    private int count;
    private Fridge fridge;

    Recipes(AllRecipes recipes){

        availableRecipes = new ArrayList<Recipe>();
        fridge = new Fridge();
        setAvailableRecipes(new AllRecipes());

    }

    public void setAvailableRecipes(AllRecipes allrecipes){

        for(int i = 0 ; i< allrecipes.getTotalRecipes() ; i++){

            for(int j = 0 ; j<this.fridge.getItemCount() ; j++){

                for(int k = 0 ; k<3 ; k++){

                    if(allrecipes.getRecipeByIndex(i).getIngredientsByIndex(k).equals(fridge.getItemByIndex(j).getName())){

                        availableRecipes.add(allrecipes.getRecipeByIndex(i));
                        count++;
                    }

                }
            }
        }
        Collections.sort(availableRecipes);
        String prev = "";

        for(int i = 0 ; i<availableRecipes.size() ; i++){

            if(!prev.equals(availableRecipes.get(i).getName())){

                availableRecipes.remove(availableRecipes.get(i));
                prev = availableRecipes.get(i).getName();

            }

        }



    }

    public ArrayList<Recipe> getAvailableRecipes(){

        return this.availableRecipes;
    }

    public int getCount(){
        return count;
    }




}
