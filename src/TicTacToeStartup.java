/*
TicTacToeStartup
Main class
Created by: Stephen and Ravi
Created: 06/16/22
 */

import javax.swing.*;
import java.awt.*;


public class TicTacToeStartup
{

    public static void main (String [] args)
    {
        JFrame s = new JFrame("Tic Tac Toe");
        TicTacToe game = new TicTacToe();          //The game model
        TicTacToeStart startView = new TicTacToeStart(game, s); //the start view

        //Initialize the Frame
        s.setSize(300,260);
        s.setLocation(300,200);
        s.setLayout(new BorderLayout());
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setContentPane(startView);
        s.setVisible(true);

    }//end of main
}//end of class