package com.sulfur.lifeform;

public class Brain extends Organ{
    private Body body;

    public Brain(Body body){
        this.body = body;
        this.start();
    }

    @Override
    public void input(String input) {
        String[] inputList = input.split(";");
        switch(inputList[0]) {
            case "V":

                break;
        }
    }

    void elaborateImage(){

    }

    @Override
    public void run() {
        while(body.isAlive()) {
            body.getAfferentData();
        }
    }

}
