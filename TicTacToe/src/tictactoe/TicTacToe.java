/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tictactoe;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author carol.dong
 */
public class TicTacToe extends JFrame{
    Button [][] buttonGrid;
    static int ROWS = 3;
    static int COLS = 3;
    static int X = 0;
    static int O = 1;
    int currentPlayer;
    boolean gameOver;
    JLabel message;
    
    public TicTacToe() {
        super("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        JPanel messagePanel = new JPanel();
        message = new JLabel("X's turn! :D 💦💦");
        
        messagePanel.add(message, BorderLayout.NORTH);
      
        this.add(messagePanel);
        GridLayout lm = new GridLayout(ROWS, COLS);
        JPanel buttonPanel = new JPanel(lm);
        buttonGrid = new Button[ROWS][COLS];
        
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                Button b = new Button();
                TileClickHandler tch = new TileClickHandler(this);
                b.addActionListener(tch);
                buttonGrid[i][j] = b;
                buttonPanel.add(b);
            }
        }
        this.add(buttonPanel, BorderLayout.SOUTH);
       
        this.pack();
        currentPlayer = X;
        gameOver= false;
    }
    public void move(Button tile) {
        if (!tile.claimed && !gameOver) {
            tile.claim(currentPlayer);
            currentPlayer++;
            currentPlayer %= 2;
            if (currentPlayer == X) {
            message.setText("X's Turn!");    
            } else {
                message.setText("Y's Turn!");  
            }
            
            int winner = checkWin();
            if (winner!=-1) {
                gameOver = true;
                if (winner == X) {
                    message.setText("X Won >:D");
                } else {
                    message.setText("O Won D:<💋");
                }              
        }
    }
    }
    /**
     *
     * @return
     */
    public int checkWin() {
        // Check each row for 3 of the same thing 
        int winner = -1;
        for (int r = 0; r < ROWS; r++) {
            boolean cond1= buttonGrid[r][0].owner == buttonGrid[r][1].owner;
            boolean cond2 = buttonGrid[r][0].owner == buttonGrid[r][2].owner;
            boolean cond3 = buttonGrid[r][0].owner!=-1;
            if (cond1 && cond2 && cond3) {
                winner= buttonGrid[r][0].owner;
            }
        }
        // Check each column
        for (int c = 0; c < COLS; c++) {
            boolean cond1= buttonGrid[0][c].owner == buttonGrid[1][c].owner;
            boolean cond2 = buttonGrid[0][c].owner == buttonGrid[2][c].owner;
            boolean cond3 = buttonGrid[0][c].owner!=-1;
            if (cond1 && cond2 && cond3) {
                winner= buttonGrid[0][c].owner;
        }   
    }
        // Check diagonals 
        boolean cond1= buttonGrid[0][0].owner == buttonGrid[1][1].owner;
        boolean cond2 = buttonGrid[1][1].owner == buttonGrid[2][2].owner;
        boolean cond3 = buttonGrid[0][0].owner!=-1;
        if (cond1 && cond2 && cond3) {
                winner= buttonGrid[0][0].owner;
        }
        cond1= buttonGrid[0][2].owner == buttonGrid[1][1].owner;
        cond2 = buttonGrid[1][1].owner == buttonGrid[2][0].owner;
        cond3 = buttonGrid[0][2].owner != -1;
        if (cond1 && cond2 && cond3) {
                winner= buttonGrid[0][0].owner;}
        
        return winner;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        TicTacToe game = new TicTacToe(); 
    }}
    
    

