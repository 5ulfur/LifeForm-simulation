package com.sulfur.lifeform;

public class Brain extends Organ{
    private Body body;
    private String[] memories;
    private int memoryIndex;

    public Brain(Body body){
        this.body = body;
        memories = new String[1000];
        for(int i = 0; i < 1000; i++){
            memories[i] = "";
        }
        memoryIndex = 0;
        this.start();
    }

    @Override
    public void run() {
        while(body.isBodyAlive()) {
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            body.getAfferentData();
        }
    }

    @Override
    public void input(String inputString) {
        String[] inputSplit = inputString.split(";");
        switch(inputSplit[0]) {
            case "V":

                break;
        }
        if(recognize(inputString)) {
            System.out.println("Already seen!");
        }else{
            System.out.println("I don't remember");
            memories[memoryIndex] = inputString;
            memoryIndex++;
        }
    }

    boolean recognize(String input) {
        int differences = 0;
        String[] inputSplit = input.split(";");
        for(String memory:memories){
            String[] memorySplit = memory.split(";");
            if(inputSplit[0].equals(memorySplit[0])) {
                for(int i = 1; i < memorySplit.length; i++) {
                    if(!memorySplit[i].equals(inputSplit[i])) {
                        differences++;
                    }
                }
                if(differences <= 20) {
                    return true;
                }
                differences = 0;
            }
        }
        return false;
    }

}
