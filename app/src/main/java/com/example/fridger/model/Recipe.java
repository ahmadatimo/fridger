

public class Recipe{

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





    

}