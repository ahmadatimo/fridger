package com.example.fridger.model;
import java.util.ArrayList;

public class AllRecipes {

    ArrayList<Recipe> recipes;
    private int totalRecipes;

    AllRecipes(){
        totalRecipes = 0;
        recipes = new ArrayList<Recipe>();
        String[] pastaIngredients =  {"Pasta","Alfredo Sauce","Mushroom"};
        Quantity[] pastaQuantities = {new Quantity("100", Measure.GR) , new Quantity("3/4", Measure.PACKET) , new Quantity("150", Measure.GR)};
        recipes.add(new Recipe("Creamy Mushroom pasta",pastaIngredients, pastaQuantities, "Cook the Pasta by boiling water then add the pasta, after you are done adding the pasta make your favorite white sauce, cut some mushroom in order to add it to the dish later. When the pasta is cooked add the white sauce and the mushrooms to your dish."));
        totalRecipes++;

        String[] dolmaIngredients = {"Grape leaves" , "Rice" , "Meat" };
        Quantity[] dolmaQuantities = {new Quantity("100", Measure.GR) , new Quantity("50", Measure.GR) , new Quantity("50", Measure.GR)};
        recipes.add(new Recipe("Stuffed Grape Leaves", dolmaIngredients, dolmaQuantities, "You need to  put the cooked rice on the grapes leaves, then turn the grapes leaves as they contain the rice and close on them before the rice goes out.then take another grape leave and make sure to put it as another layer to protect the inner grapeleaves from cracking."));
        totalRecipes++;

        String[] chickenCutletIngredients = {"Chicken","Pepper","Shallots"};
        Quantity[] chickenCutleQuantities = {new Quantity("1", Measure.POUND) , new Quantity("1/4", Measure.TABLESPOON), new Quantity("1/2", Measure.CUP)};
        recipes.add(new Recipe("Chicken Cutlet", chickenCutletIngredients, chickenCutleQuantities, "Place a boneless, skinless chicken breast, with the tender removed, on a cutting board, and hold it flat with the palm of your non-knife hand. Using a sharp chef's, boning, or fillet knife, slice the chicken breast horizontally into two even pieces. It helps if you do this close to the edge of the cutting board."));
        totalRecipes++;

        String[] spicyShrimpIngredients = {"Shrimp","Parsley","Butter"};
        Quantity[] spicyShrimpQuantities = {new Quantity("3/4", Measure.POUND) , new Quantity("1/4", Measure.CUP), new Quantity("1", Measure.TABLESPOON)};
        recipes.add(new Recipe("Spicy Shrimp", spicyShrimpIngredients, spicyShrimpQuantities, "Hunan hot and spicy shrimp are tossed in a peppery mix and then seared in a reach-for-the-fire-extinguisher-hot sauce of chiles, ginger, garlic, and shallots"));
        totalRecipes++;

        String[] scallopePastaIngredients = {"Scallops","Parsley","Basil"};
        Quantity[] scallopePastaQuantities = {new Quantity("1/2", Measure.POUND) , new Quantity("1", Measure.CUP) , new Quantity("1", Measure.TABLESPOON) };
        recipes.add(new Recipe("Scallope Pasta", scallopePastaIngredients, scallopePastaQuantities, "howToMake"));


















    }

    public int getTotalRecipes() {
        return totalRecipes;
    }

    public Recipe getRecipeByIndex(int index) {

        return this.recipes.get(index);
    }

    public boolean isIncluded(Item item) {

        for (int i = 0; i < recipes.size(); i++) {

            for (int j = 0; j < 3; j++) {

                if (this.recipes.get(i).getIngredientsByIndex(j).equalsIgnoreCase(item.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public ArrayList<Recipe> getIncludedRecipes(Item item) {

        ArrayList<Recipe> availableRecipes = new ArrayList<>();

        for (int i = 0; i < recipes.size(); i++) {

            for (int j = 0; j < 3; j++) {

                if (this.recipes.get(i).getIngredientsByIndex(j).equalsIgnoreCase(item.getName())) {
                    availableRecipes.add(recipes.get(i));
                }
            }
        }
        return availableRecipes;
    }

}
