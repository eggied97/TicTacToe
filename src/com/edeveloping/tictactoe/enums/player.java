package com.edeveloping.tictactoe.enums;

/**
 * Created by Egbert Dijkstra on 20-12-2014.
 */
public enum  player {
    X(1 , "X"),
    O(2 , "O");


    int mark;
    String name;

    player(int a , String m){
       mark = a;
        name = m;
    }

    public int getMark(){return this.mark;}

    public String getName(){return this.name;}

}
