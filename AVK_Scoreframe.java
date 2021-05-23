import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingUtilities;
import javax.swing.BorderFactory;
import java.awt.Color;
import javax.swing.border.Border;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.*;

/*
 * this class is created toadd the labels with scores and to restart the game when over.
 *@author Amrit Veer Kaur 
 */

public class AVK_Scoreframe extends JFrame{
    
    private int B_WIDTH = 550;
    private int B_HEIGHT = 350;
    private JLabel labelTopScore;
    private JLabel labelScore;
    private JLabel labelgameover;
    private JLabel labelpic;
    private JLabel labelplay;  
    private JLabel labelDetails; 
    private JButton buttonQuit;
    String Color;
    private int s;


    public AVK_Scoreframe() {        
        super("Snake Game: Amrit Veer Kaur");
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        
        //prey.showprey();
        labelgameover = new JLabel("Game Over");
        labelplay = new JLabel("Click to Play");  
        labelTopScore = new JLabel("TOP LAYER’s SCORE");
        labelScore = new JLabel("CURRENT PLAYER SCORE");   
        labelDetails = new JLabel("PROG5001: 2021" + "\n" + "Amrit Veer Kaur");
        buttonQuit = new JButton("QUIT");
        
        String img = "images/snakelogo1.png";
        ImageIcon i = new ImageIcon(img);
        labelpic = new JLabel();
        labelpic.setIcon(i);
         
        JPanel mainpanel1 = new JPanel(); //  main panel to add sub panels
        JPanel background = new JPanel(); // panel to add screen for game 
        JPanel game = new JPanel(new GridBagLayout()); // to display labels for scores
         
        mainpanel1.setLayout(new GridLayout(1, 2));
   
    
        background.setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 1));
        background.setBackground(new Color(0,0,0));
        background.setLayout(new GridLayout(2, 1));
        
        labelplay.setForeground(new Color(255,255,255));
        labelgameover.setForeground(new Color(255,255,255));
        labelplay.setHorizontalAlignment(JLabel.CENTER);
        labelgameover.setHorizontalAlignment(JLabel.CENTER);
        
        // adding labels to the panel background
        background.add(labelplay);
        background.add(labelgameover);
         
        // set border for panel game
        game.setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 1)); 
        
          //use contrains to control the gridbaglayout
          // arrange the labels in sequence with gridbaglayout 
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 10, 10, 10);
        
        // add components to the panel
        constraints.gridx = 0;
        constraints.gridy = 0;  
        constraints.gridwidth = 10;
        game.add(labelTopScore, constraints);
        labelTopScore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0) , 1));
        
        constraints.gridx = 0;
        constraints.gridy = 1;  
        constraints.gridwidth = 10;
        game.add(labelScore, constraints);
        labelScore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0) , 1));
        
        constraints.gridx = 0;
        constraints.gridy = 2;  
        constraints.gridwidth = 10;
        game.add(labelpic, constraints);
        constraints.anchor = GridBagConstraints.CENTER;
        labelScore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0) , 1));
        
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 10;
        constraints.anchor = GridBagConstraints.CENTER;
        game.add(buttonQuit, constraints);
        buttonQuit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0) , 1));
        
        mainpanel1.add(background);
        mainpanel1.add(game);
         
          
        add(mainpanel1);
    
        pack(); 
        setLocationRelativeTo(null);   
        
        
        //s = new AVK_GameBoard().score;
        //System.out.println(s);
        //labelScore.setText(toString(s));
        
        // adding click event to label play 
        // to run the game again on clicking label
        labelplay.addMouseListener(new MouseAdapter()  
       {  
            public void mouseClicked(MouseEvent e)  
            {  
       
              AVK_SnakeGame snake = new AVK_SnakeGame();
              snake.setVisible(true);
              dispose();

            }  
       }); 
     }
         

    }
    

