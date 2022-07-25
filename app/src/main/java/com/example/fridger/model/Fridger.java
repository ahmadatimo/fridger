package com.example.fridger.model;

public class Fridger {


    private Fridge fridge;
    private Recipes recipes;

    public Fridger(){

         recipes = new Recipes(new AllRecipes());
         fridge = new Fridge();


    }

    public Fridge getFridge(){

        return this.fridge;

    }
public Recipes getAllRecipes(){

    return this.recipes;
}

public void AddItem(Item item, int quantity) {

    this.fridge.addItem(item, quantity);
    recipes.setAvailableRecipes(new AllRecipes());
    

}



}
