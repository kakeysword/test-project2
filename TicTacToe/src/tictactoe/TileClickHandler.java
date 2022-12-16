/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author carol.dong
 */


public class TileClickHandler implements ActionListener {
    //ActionListener is an interface which means it has abstract methods 
    //and can't be used to make objects
    TicTacToe game;
    public TileClickHandler(TicTacToe game){
        this.game = game;
        
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        Button button = (Button)ae.getSource();
        game.move(button);
        
    }
    
}
