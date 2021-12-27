package com.sulfur.lifeform;

public class Nerve {
    enum Type {
        EFFERENT,
        AFFERENT
    }

    private final Type type;
    private final Organ organFrom;
    private final Organ organTo;

    public Nerve(Type type, Organ organFrom, Organ organTo) {
        this.type = type;
        this.organFrom = organFrom;
        this.organTo = organTo;
    }

    public Type getType() {
        return type;
    }

    public void transfer(){
        organTo.input(organFrom.output());
    }

}