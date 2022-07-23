package com.example.fridger.model;

public class User {

private String username;
private String password;
private Icon icon;

public User(String username, String password ){

    this.username = username;
    this.password = password;
    this.icon = new Icon("G0 FKY5","/Users/amirahani/Desktop/WORK/Fridger/Icons/psycho_lover.png");


}
public String getRealPassword(){

    return this.password;

}
public String getPassword(){

    int length = this.password.length();
    String newPass = "";

    for(int i = 0 ; i< length ; i++){
        newPass+="*";
    }

    return newPass;
}
public String getUsername(){

    return this.username;

}
public Icon getIcon(){

    return this.icon;
}
public void setIcon(Icon icon){

    this.icon = icon;
}

public void setPassword(String password){

    this.password = password;

}

public void setUsername(String username){

    this.username = username;
}
    
}
  