
package com.example.fridger.model;

public class Recipe implements Comparable{

private String name;
private String howToMake;
private String[] ingredients;
private String fileName;
private Quantity[] quantity;

public Recipe(String name , String[] ingredients , String fileName , Quantity[] quantity , String howToMake){

       this.name = name;
       this.howToMake = howToMake;
       this.ingredients = ingredients;
      this.fileName = fileName;
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
public String getFileName(){

    return this.fileName;
    
}
public Quantity getQuantityByIndex(int index){

    return this.quantity[index];

}


    @Override
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