package com.example.fridger.model;
import java.util.ArrayList;

public class AllIcons {

private ArrayList<Icon> icons;

AllIcons(){
    
icons = new ArrayList<Icon>();

}
public Icon getIconByIndex(int index){
    if(index>icons.size() || index<0){
        return null;
    }
    else{
        return this.icons.get(index);
    }
}
    
}
