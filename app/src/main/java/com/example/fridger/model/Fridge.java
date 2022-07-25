package com.example.fridger.model;

import java.util.Date;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class Fridge {

    private ArrayList<Item> items;
    private int itemCount;

    private Timer timer = new Timer();
    private TimerTask task;

    Fridge(){
        items = new ArrayList<Item>();
        itemCount = 0;
    }
    public int getItemCount(){

        return itemCount;
    }
    public Item getItemByIndex(int index){

        return this.items.get(index);
    }

    public void addItem(Item item , int quantity){

        for(int i = 0 ; i< quantity ; i++){

            items.add(item);
            itemCount++;

        }
        setTimer();

    }
    public void deleteItem(Item item){

        for(int i = 0 ; i < items.size() ; i++){

            if(items.get(i).equals(item)){
                items.remove(i);
                itemCount--;
            }
        }

    }
    public void checkForExpiredItems(){

        for(int i = 0 ; i<items.size() ; i++){
            if(items.get(i).getDaysLeft()==0){
                deleteItem(items.get(i));
            }
        }
    }
    public void setTimer() {

        task = new TimerTask() {

            @Override
            public void run() {
                checkForExpiredItems();

            }
        };

        timer.scheduleAtFixedRate(task, 0, 1000*60*60*24);
    }

    public ArrayList<Item> getFruits(){

        ArrayList<Item> fruits = new ArrayList<Item>();

        for(int i = 0 ; i<this.itemCount ; i++){

            if(this.items.get(i).getType().equals(Type.FRUIT)){

                fruits.add(this.items.get(i));
            }

        }
        return fruits;
    }
    public ArrayList<Item> getVegetables(){

        ArrayList<Item> vegetables = new ArrayList<Item>();

        for(int i = 0 ; i<this.itemCount ; i++){

            if(this.items.get(i).getType().equals(Type.VEGETABLE)){

                vegetables.add(this.items.get(i));
            }

        }
        return vegetables;
    }
    public ArrayList<Item> getMeats(){

        ArrayList<Item> meats = new ArrayList<Item>();

        for(int i = 0 ; i<this.itemCount ; i++){

            if(this.items.get(i).getType().equals(Type.MEAT)){

                meats.add(this.items.get(i));
            }

        }
        return meats;
    }
    public ArrayList<Item> getLiquids(){

        ArrayList<Item> liquids = new ArrayList<Item>();

        for(int i = 0 ; i<this.itemCount ; i++){

            if(this.items.get(i).getType().equals(Type.LIQUID)){

                liquids.add(this.items.get(i));
            }

        }
        return liquids;
    }

}
