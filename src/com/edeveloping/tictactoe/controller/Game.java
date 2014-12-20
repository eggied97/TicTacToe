package com.edeveloping.tictactoe.controller;

import com.edeveloping.tictactoe.GUI.mainGame;
import com.edeveloping.tictactoe.GUI_Interface;
import com.edeveloping.tictactoe.enums.player;

import javax.swing.*;

/**
 * Created by Egbert Dijkstra on 20-12-2014.
 */
public class Game implements GUI_Interface{

    mainGame mG;
    int[][] mBoard = new int[3][3]; // 0 is emtpy; 1 = x; 2 = o;
    player pX = player.X;
    player pO = player.O;

    player currentPlayer;

    public Game(){
        init();
    }

    private void init(){

        setCurrentPlayer(pX);

        for(int x = 0; x < 3; x++){
            for(int y = 0; y < 3; y++){
                mBoard[x][y] = 0;
            }
        }

        initGUI();


    }

    private void initGUI(){
        mG = new mainGame();

        mG.setInterface(this);
        mG.pack();
        mG.setVisible(true);


        mG.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

    }

    @Override
    public void cellClicked(int x,int y){

        if(mBoard[x][y] != 0){
            //full
            System.out.println("Cell is full");
        }else{
            mBoard[x][y] = currentPlayer.getMark();

            if(currentPlayer == pX) { setCurrentPlayer(pO); }else { setCurrentPlayer(pX); };


            player pWinner = checkForWin();

            if(pWinner != null){
                System.out.println(pWinner.getName()+" WON :D");
            }

            updateGUI();
        }
    }

    private void updateGUI(){
        mG.updateView(mBoard);
    }

    private void setCurrentPlayer(player p){
        currentPlayer = p;

        System.out.println(p.getName());
    }

    public player checkForWin(){

        //HORIZONTAL

        for(int y = 0; y < 3; y++){
            if(mBoard[0][y] == mBoard[1][y] && mBoard[1][y] == mBoard [2][y] && mBoard[2][y] != 0){
                //for every horizontal line
                return mBoard[0][y] == 1 ? player.X : player.O;
            }
        }

        //VERTICAL

        for(int x = 0; x < 3; x++){
            if(mBoard[x][0] == mBoard[x][1] && mBoard[x][1] == mBoard [x][2] && mBoard[x][2] != 0){
                //for every vertical line
                return mBoard[x][0] == 1 ? player.X : player.O;
            }
        }

        //LEFT_HIGH->RIGHT_LOW
        if(mBoard[0][0] == mBoard[1][1] && mBoard[1][1] == mBoard [2][2] && mBoard[2][2] != 0){
            //for every vertical line
            return mBoard[0][0] == 1 ? player.X : player.O;
        }

        //LEFT_LOW->RIGHT_HIGH
        if(mBoard[0][2] == mBoard[1][1] && mBoard[1][1] == mBoard [2][0] && mBoard[2][0] != 0){
            //for every vertical line
            return mBoard[2][0] == 1 ? player.X : player.O;
        }

        return null;
    }
}
