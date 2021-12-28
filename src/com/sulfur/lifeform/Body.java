package com.sulfur.lifeform;

import java.util.ArrayList;

public class Body {
    private boolean alive;
    private Brain brain;
    private Eye[] eyes;

    private ArrayList<Nerve> nerves;

    Body() {
        alive = true;

        eyes = new Eye[]{new Eye(this, 1, 100, 100)/*, new Eye(this, 30, 100, 100)*/};

        nerves = new ArrayList<>();

        //brain = new Brain(this);

        //Nerve nerveAfferentEye1Brain = new Nerve(Nerve.Type.AFFERENT, eyes[0], brain);
        //Nerve nerveAfferentEye2Brain = new Nerve(Nerve.Type.AFFERENT, eyes[1], brain);

        //nerves.add(nerveAfferentEye1Brain);
        //nerves.add(nerveAfferentEye2Brain);

    }

    public boolean isAlive() {
        return alive;
    }

    void getAfferentData(){
        for(Nerve nerve:nerves) {
            if(nerve.getType() == Nerve.Type.AFFERENT){
                nerve.transfer();
            }
        }
    }

}
