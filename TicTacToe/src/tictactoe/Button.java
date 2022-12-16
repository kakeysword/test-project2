/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;

/**
 *
 * @author carol.dong
 */
public class Button extends JButton{
    boolean claimed;
    int owner;
    

    @Override
    public void setFont(Font font) {
        super.setFont(font); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Button() {
        Dimension dmnsn = new Dimension(100,100);
        this.setPreferredSize(dmnsn);
        this.setBackground(Color.white);
        Font font = new Font(Font.MONOSPACED, Font.BOLD, 50);
        this.setFont(font);
        claimed = false;
        owner = -1;

}
    public void claim(int player){
        if (player == TicTacToe.X) {
            this.setText("X");
        }
        else {   
            this.setText("O");
        }
        claimed = true;
        owner = player;
}
}
