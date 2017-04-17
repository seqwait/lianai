package com.lianai.keywords.ac;

public class ZeroState extends AbsState {

    private State nullState = null;

    @Override
    public State go(char input) {
        State nextState = getNextState(input);
        return null == nextState ? nullState : nextState;
    }

    public void shift() {
        super.setFailState(this);
        this.nullState = this;
    }

}
