/*
EndGameController
Controller class
Created by: Stephen and Ravi
Created: 06/16/22
 */

import javax.swing.*;
import java.awt.event.*;

public class EndGameController implements ActionListener
{

    private TicTacToe game; //game model
    private static JButton button;

    //default constructor
    public EndGameController(TicTacToe aGame, JButton aButton) {
        this.game = aGame;
        this.button = aButton;

    }

    //closes everything
    public void actionPerformed(ActionEvent e)
    {
        game.closeWindow();
    }
}//end of class
