

package com.example.fridger.model;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


import java.util.Timer;
import java.util.TimerTask;

public class Item {

    //variables
    private String name;
    private Type type;
    private int daysLeft;
    private boolean warningLevelOne;
    private boolean warningLevelTwo;

    private Timer timer = new Timer();
    private TimerTask task;

    public Item(String name, int daysLeft, Type type) {

        this.name = name;
        this.type = type;
        this.daysLeft = daysLeft;

        setTimer();

    }

    public Type getType(){
        return this.type;
    }

    public int getDaysLeft(){
        return this.daysLeft;
    }

    public boolean equals(Object obj) {

        if (obj instanceof Item) {
            Item newItem = (Item) obj;
            if (this.name.equals(newItem.name) && this.daysLeft==(newItem.daysLeft)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public void setWarningLevelOne() {

        if (this.type.equals(Type.FRUIT)) {

            if (this.daysLeft < 7) {

                this.warningLevelOne = true;

            } else {
                this.warningLevelOne = false;
            }

        } else if (this.type.equals(Type.VEGETABLE)) {

            if (this.daysLeft < 10) {
                this.warningLevelOne = true;
            } else {
                this.warningLevelOne = false;
            }

        } else if (this.type.equals(Type.LIQUID)) {

            if (this.daysLeft < 4) {
                this.warningLevelOne = true;
            } else {
                this.warningLevelOne = false;
            }

        } else if (this.type.equals(Type.MEAT)) {

            if (this.daysLeft < 30) {
                this.warningLevelOne = true;
            } else {
                this.warningLevelOne = false;
            }

        }

    }

    public void setWarningLevelTwo() {

        if (this.type.equals(Type.FRUIT)) {

            if (this.daysLeft < 4) {

                this.warningLevelTwo = true;
            } else {
                this.warningLevelTwo = false;
            }

        } else if (this.type.equals(Type.VEGETABLE)) {

            if (this.daysLeft < 5) {

                this.warningLevelTwo = true;
            } else {
                this.warningLevelTwo = false;
            }

        } else if (this.type.equals(Type.LIQUID)) {

            if (this.daysLeft < 3) {
                this.warningLevelTwo = true;
            } else {
                this.warningLevelTwo = false;
            }

        } else if (this.type.equals(Type.MEAT)) {

            if (this.daysLeft < 15) {
                this.warningLevelTwo = true;
            } else {
                this.warningLevelTwo = false;
            }
        }

    }
    public boolean getWarningLevelOne(){
        return this.warningLevelOne;
    }

    public boolean getWarningLevelTwo(){
        return this.warningLevelTwo;
    }

    public void setTimer() {

        task = new TimerTask() {
            @Override
            public void run() {

                if(daysLeft>0){

                    daysLeft--;

                }

                setWarningLevelOne();
                setWarningLevelTwo();


            }
        };


        timer.scheduleAtFixedRate(task, 0, 1000*60*60*24);
    }
    public String toString(){

        return this.name;


    }






}
