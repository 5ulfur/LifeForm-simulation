package com.sulfur.lifeform;

public class Brain extends Organ{
    private Human human;

    public Brain(Human human){
        this.human = human;
    }

    @Override
    public void input(String input) {
        String[] inputList = input.split(";");
        switch(inputList[0]) {
            case "V":

                break;
        }
    }

    void process(){
        while(true){
            human.getAfferentData();
        }
    }

    void elaborateImage(){

    }

}