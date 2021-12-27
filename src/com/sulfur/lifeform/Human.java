package com.sulfur.lifeform;

import java.util.ArrayList;

public class Human {
    private Brain brain;
    private Eye[] eyes;

    private ArrayList<Nerve> nerves;

    Human() {
        brain = new Brain(this);
        eyes = new Eye[]{new Eye(), new Eye()};

        nerves = new ArrayList<>();

        Nerve nerveAfferentEye1Brain = new Nerve(Nerve.Type.AFFERENT, eyes[0], brain);
        Nerve nerveAfferentEye2Brain = new Nerve(Nerve.Type.AFFERENT, eyes[1], brain);

        nerves.add(nerveAfferentEye1Brain);
        nerves.add(nerveAfferentEye2Brain);
    }

    void test(){
        brain.process();
    }

    void getAfferentData(){
        for(Nerve nerve:nerves) {
            if(nerve.getType() == Nerve.Type.AFFERENT){
                nerve.transfer();
            }
        }
    }

}