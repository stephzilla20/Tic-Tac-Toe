/*
NewGameController
Controller class
Created by: Stephen and Ravi
Created: 06/16/22
 */


import javax.swing.*;
import java.awt.event.*;

public class NewGameController implements ActionListener
{

    private TicTacToe game; //game model
    private JButton button;

    //default constructor
    public NewGameController(TicTacToe aGame, JButton aButton) {
        this.game = aGame;
        this.button = aButton;

    }

    //displays start screen and makes new game screen
    public void actionPerformed(ActionEvent e)
    {
        TicTacToeGame.updateStartView();
        TicTacToeGame.displayNew();
    }
}//end of class
