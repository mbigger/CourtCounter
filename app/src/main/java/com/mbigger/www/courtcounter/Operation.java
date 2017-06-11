package com.mbigger.www.courtcounter;

/**
 * Created by Administrator on 2017/4/20.
 */


public class Operation {
    private Role role;
    private int score;

    Operation(Role role, int score) {
        this.role = role;
        this.score = score;
    }

    public Role getRole(){
        return role;
    }

    public int getScore(){
        return score;
    }

}
