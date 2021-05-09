import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingUtilities;
import java.awt.Dimension;

public class AVK_SnakeGame extends JFrame {

    private JLabel labelTopScore;
    private JLabel labelScore;
    private JLabel labelgameover;
    private JLabel labelplay;  
    private JLabel labelDetails; 
    private JButton buttonQuit;
    private int B_WIDTH = 500;
    private int B_HEIGHT = 600;
    String Color;
    
    public AVK_SnakeGame() {        
        super("Snake Game: Amrit Veer Kaur");
        setPreferredSize(new Dimension(B_WIDTH, B_HEIGHT));
        
        labelgameover = new JLabel("Game Over"+"\n"+"Click to Play", JLabel.CENTER);
        labelplay = new JLabel("Click to Play");  
        labelTopScore = new JLabel("TOP LAYER’s SCORE");
        labelScore = new JLabel("CURRENT PLAYER SCORE");   
        labelDetails = new JLabel("PROG5001: 2021" + "\n" + "Amrit Veer Kaur");
        buttonQuit = new JButton("QUIT");
         // create a new panel with GridBagLayout manager
         JPanel panelgame = new JPanel(new GridBagLayout());
       
        // use GridBagConstraints to control the grid appearance
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.EAST;
        constraints.fill = GridBagConstraints.NONE;
        constraints.insets = new Insets(10, 10, 10, 10);
            
        // add components to the panel
        
        
        constraints.gridx = 0;
        constraints.gridy = 0;
        labelgameover.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0) , 1));
        labelgameover.setBackground(new Color(0,0,0));
        labelgameover.setOpaque(true);
        panelgame.add(labelgameover, constraints);
       
        constraints.gridx = 20;
        constraints.gridy = 5;
        panelgame.add(labelTopScore, constraints);
        labelTopScore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0) , 1));
         
        constraints.gridx = 20;
        constraints.gridy = 10;    
        panelgame.add(labelScore, constraints);
        labelScore.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0) , 1));
        
        constraints.gridx = 20;
        constraints.gridy = 15;    
        panelgame.add(labelDetails, constraints);
        labelDetails.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0) , 1));

         
        constraints.gridx = 20;
        constraints.gridy = 20;
        constraints.gridwidth = 5;
        constraints.anchor = GridBagConstraints.EAST;
        panelgame.add(buttonQuit, constraints);
        buttonQuit.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0) , 1));
    
           panelgame.setMaximumSize( new Dimension(  B_WIDTH, B_HEIGHT) );    
          // panelgame.setBackground(new Color(0,0,0));
     //add the panel to this frame
        add(panelgame);
         
        //pack();
        pack(); 
        setLocationRelativeTo(null);
        
        
    }
    
    public static void main(String[] args) {        
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            //JFrame frame = new JFrame("Snake Game");
            //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
             //frame.setSize(550, 350);
             //frame.setVisible(true);
            new AVK_SnakeGame().setVisible(true);
            }
        });
    }
}
