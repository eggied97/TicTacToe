package com.edeveloping.tictactoe.GUI;

import com.edeveloping.tictactoe.GUI_Interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Egbert Dijkstra on 20-12-2014.
 */
public class mainGame extends JDialog{
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JPanel contentPane;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;

    private JButton[] row1 = {button1, button2, button3};
    private JButton[] row2 = {button4, button5, button6};
    private JButton[] row3 = {button7, button8, button9};

    private JButton[][] buttonArray = { row1, row2 , row3};

    GUI_Interface i;

    public mainGame(){
        setContentPane(contentPane);
        setModal(true);

        for(int x = 0; x < buttonArray.length; x++){
            for(int y = 0; y < buttonArray[0].length; y++){

                final int mY = y, mX = x;

                buttonArray[x][y].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        i.cellClicked(mX,mY);
                        System.out.println(mX+mY +" clicked");
                    }
                });
            }
        }

    }

    public void setInterface(GUI_Interface ii){
        this.i = ii;


    }

    public void updateView(int[][] a){

        for(int x = 0; x < a.length; x++){
            for(int y = 0; y < a[0].length; y++){
                switch(a[x][y]){
                    case 0:
                        break;
                    case 1:

                        buttonArray[x][y].setText("X");
                        buttonArray[x][y].setEnabled(false);

                        break;
                    case 2:

                        buttonArray[x][y].setText("O");
                        buttonArray[x][y].setEnabled(false);

                        break;
                }
            }
        }

    }
}
