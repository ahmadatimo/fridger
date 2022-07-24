package com.example.fridger.model;

public class Fridger {

private Fridge fridge;
private User user;
private Recipes recipes;

public Fridger(String username, String password){

fridge = new Fridge();
user = new User(username, password);


}

public Fridge getFridge(){
    return this.fridge;
}

public Recipes getAllRecipes(){
    return this.recipes;
}
public void AddItem(Item item, int quantity){

    this.fridge.addItem(item, quantity);

}
public User getUser(){

    return this.user;
}

}
