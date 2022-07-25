
package com.example.fridger.model;

public class Recipe implements Comparable{

    private String name;
    private String howToMake;
    private String[] ingredients;
    private Quantity[] quantity;

    public Recipe(String name , String[] ingredients , Quantity[] quantity , String howToMake){

        this.name = name;
        this.howToMake = howToMake;
        this.ingredients = ingredients;
        this.quantity = quantity;

    }

    public String getName(){

        return this.name;

    }
    public String getHowToMake(){

        return this.howToMake;

    }
    public String getIngredientsByIndex(int index){

        return this.ingredients[index];

    }

    public Quantity getQuantityByIndex(int index){

        return this.quantity[index];

    }
    public String toString(){

        return this.name;
    }
    public int compareTo(Object obj ){

        if(obj instanceof Recipe){

            Recipe newRecipe = (Recipe)obj;


            if(this.name.compareTo(newRecipe.name)>0){

                return 1;

            }
            else if(this.name.compareTo(newRecipe.name)<0){

                return -1;
            }
            else{
                return 0;
            }

        }
        else{
            return -1;
        }

    }

}