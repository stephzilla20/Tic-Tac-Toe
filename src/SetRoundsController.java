/*
SetRoundsController
Controller class
Created by: Stephen and Ravi
Created: 06/16/22
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SetRoundsController implements ActionListener
{

    private TicTacToe game; //game model
    private static TicTacToeStart startView;
    private JTextField textField; //component linked to controller
    public static int totalRounds;


    //default constructor
    public SetRoundsController(TicTacToe aGame, JTextField aTextfield)
    {
        this.game = aGame;
        this.textField = aTextfield;
    }

    public void actionPerformed(ActionEvent e)
    {
        //if no games have been played, go to game view
        if(game.gamesPlayed==0) {
            totalRounds = Integer.parseInt(this.textField.getText());
            TicTacToe.goGameView();
        }
        //if at least 1 game was played, do not go to default game view when round is entered
        if(game.gamesPlayed!=0) {
            totalRounds = Integer.parseInt(this.textField.getText());
            TicTacToeStart.window.setVisible(false);
        }
    }
}//end of class




