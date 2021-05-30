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
 * @author Amrit Veer Kaur
 * this class is created toadd the labels with scores and to restart the game when over.
 */

public class AVK_Scoreframe extends JPanel{
    
  //  private int B_WIDTH = 550;
   // private int B_HEIGHT = 350;
    private JLabel labelTopScore;
    JLabel labelScore;
    private JLabel labelgameover;
    private JLabel labelpic;
    private JLabel labelplay;  
    private JLabel labelDetails; 
    private JButton buttonQuit;
    String Color;
    int s;
    int l;


    public AVK_Scoreframe() {        
        //super("Snake Game: Amrit Veer Kaur");
        
        labelTopScore = new JLabel("TOP LAYER’s SCORE",JLabel.CENTER);
        labelScore = new JLabel("CURRENT PLAYER SCORE",JLabel.CENTER);   
        labelDetails = new JLabel("PROG5001: 2021" + "\n" + "Amrit Veer Kaur",JLabel.CENTER);
        buttonQuit = new JButton("QUIT");
        
        String img = "images/snakelogo1.png";
        ImageIcon i = new ImageIcon(img);
        labelpic = new JLabel(i,JLabel.CENTER);
        
    
        setLayout(new GridLayout(5, 1,20,20));
        add(labelTopScore);
        labelTopScore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0) , 1));
        add(labelScore);
        labelScore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0) , 1));
        add(labelpic);
        labelpic.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0) , 1));
        add(labelDetails);
        labelDetails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0) , 1));
        add(buttonQuit);  
        buttonQuit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0) , 1));
         
        
         
        setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 1));
          
    
        //System.out.println(s);
         AVK_GameBoard g = new AVK_GameBoard();
         s = g.getscore();
         l = g.snake_length;
         //labelScore.setText(String.valueOf(g.getscore()));
         System.out.println("score = "+ s);
         System.out.println("len = "+ l);
         // s = g.score;
        // labelScore.setText("Current score = " + s);
         
        
        
     }
         

    }
    

