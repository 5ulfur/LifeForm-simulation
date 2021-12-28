package com.sulfur.lifeform;

public abstract class Organ extends Thread{

    void input(String input){

    }

    String output(){
        return "";
    }

    public abstract void run();
}
