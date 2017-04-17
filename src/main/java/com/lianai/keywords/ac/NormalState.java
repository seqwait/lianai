package com.lianai.keywords.ac;

public class NormalState extends AbsState {

    @Override
    public State go(char input) {
        return getNextState(input);
    }

}
