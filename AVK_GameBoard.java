// https://zetcode.com/javagames/snake// help taken

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/*
 * Gameboard class is created to add the snake, prey to the board to play game.
 * to move the snake and after eaten the prey to display on random location.
 */

public class AVK_GameBoard extends JPanel implements ActionListener {
    
    private final int GB_Width = 300;  // width of gameboard class
    private final int GB_Hgt = 400;    // height of gameboard class
    private final int Size_stp = 10;   // size of snake tail and prey
    private final int Total_dotcount = 1200;  // number of dots on board(calculated as (w*h/size_stp*size_stp))
    private final int Prey_randpos = 28;  // to calculate prey's random position which is constant
    private final int Game_speed = 115;   // determines the speed of game

    private final int s_x[] = new int[Total_dotcount]; // two arrays to store the x & y coordinates
    private final int s_y[] = new int[Total_dotcount]; // of the joints of snake

    int snake_length;
    private int Prey_x;  
    private int Prey_y;
    int score = 0;
    
    
    
    private boolean left_side = false;
    private boolean right_side = false;   
    private boolean up_side = false;
    private boolean down_side = true;// snake will move towards the down direction at starting
    
    private boolean playGame = true;
    private boolean pauseGame = false;

    private Timer timer;
    private Image snakeb;       
    private Image smily;       
    private Image snakeh;
    
    private JLabel labelgameover;
    private JLabel labelplay;  

    public AVK_GameBoard() { 
        // setting the panel background, size and apply key functions to play game.
        addKeyListener(new click_action()); 
        setBackground(Color.black);
        setFocusable(true);
        setBorder(BorderFactory.createLineBorder(new Color(0,0,0), 1));
        setPreferredSize(new Dimension(GB_Width, GB_Hgt));
        uploadImages();    // to upload the images of snake and prey
        initializationphase_of_game(); // to initialize the game
        
        labelgameover = new JLabel("Game Over",JLabel.CENTER);
        labelplay = new JLabel("Click to Play"); 
        labelplay.addMouseListener(new MouseAdapter()  
       { 
            public void mouseClicked(MouseEvent e)  
            {  
       
              //AVK_GameBoard();
              
              AVK_SnakeGame s = new AVK_SnakeGame();
              s.setVisible(true);
              
              
              
            }  
    });

    }
    
    private void uploadImages() {
        // to upload the images of the snake and prey on the board
        AVK_Prey prey = new AVK_Prey();  // object of prey class to access images 
        smily = prey.img;
        
        AVK_SnakeBody sb = new AVK_SnakeBody(); // // object of snake class to access snake head and body images
        snakeh = sb.snake_head;
        snakeb = sb.snake_body;

    }

    private void initializationphase_of_game() {
        // this methods create the snake on the panel, will locate the prey and 
        // start the timer for the game
        
        snake_length = 4;

        for (int i = 0; i < snake_length; i++) {
            s_x[i] = 50 - i * 10;
            s_y[i] = 50;
        }
        
        addPrey();

        timer = new Timer(Game_speed, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (playGame) {

            g.drawImage(smily, Prey_x, Prey_y, this);

            for (int i = 0; i < snake_length; i++) {
                if (i == 0) {
                    g.drawImage(snakeh, s_x[i], s_y[i], this);
                } else { g.drawImage(snakeb, s_x[i], s_y[i], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {
            gameOver(g);
    }
}

    private void gameOver(Graphics g) {
        
       // when game is over show two options that game is over
       // 2nd label is to play the game again
        setLayout(new GridLayout(2,1));
        labelplay.setForeground(new Color(255,255,255));
        labelgameover.setForeground(new Color(255,255,255));
        labelplay.setHorizontalAlignment(JLabel.CENTER);
        
        labelgameover.setHorizontalAlignment(JLabel.CENTER);
        add(labelplay);
        add(labelgameover);
        
        
         
    }

    public void findPrey() {
        // when the snake head will hit the prey than the lenth of snake will 
        // increase and it will give a call to addprey method to add new prey on
        // random position
        
        if ((s_x[0] == Prey_x) && (s_y[0] == Prey_y)) {
            
            snake_length++;
            score = score + 1;
            
            
            System.out.println("Score = " + score);
            System.out.println("length = " + snake_length);
            
            
            addPrey();
        }
        
    }

     public int getscore() {
        return score;
    }

    
    private void Movement_of_snake() {
        // movement of the snake is controled in this method
        // when the snake is moving towards left of panel value of x is decreasing 
        // so the position of s_x[3] will change to the s_x[2].
        // similiarly other positions according to the snake direction. 
        
        for (int i = snake_length; i > 0; i--) {
            s_x[i] = s_x[(i - 1)];
            s_y[i] = s_y[(i - 1)];    // here the joints are moved to each others position
        }

        if (left_side) {
            s_x[0] -= Size_stp;    // it moves the head of snake to the left
        }

        if (right_side) {
            s_x[0] += Size_stp;
        }

        if (up_side) {
            s_y[0] -= Size_stp;
        }

        if (down_side) {
            s_y[0] += Size_stp;
        }
    }

    private void on_hit() {
        // here weare going to check the collision of snake 
        // both collision with wall of panel and 
        // collision of snake head with tail.
        
        for (int i = snake_length; i > 0; i--) {

            if ((i > 4) && (s_x[0] == s_x[i]) && (s_y[0] == s_y[i])) { 
                playGame = false;
            }      // if the snake hits its joints, any joint with the head
                   // play false means game is over.
        }

        if (s_y[0] >= GB_Hgt) {
            playGame = false;     // game is over if snake hits the bottom of the board  
        }

        if (s_y[0] < 0) {
            playGame = false;
        }

        if (s_x[0] >= GB_Width) {
            playGame = false;
        }

        if (s_x[0] < 0) {
            playGame = false;
        }
        
        if (!playGame) {
            timer.stop();
        }
    }

    private void addPrey() {
        // this method provides random position to the prey on the board
        
        int r = (int) (Math.random() * Prey_randpos);
        Prey_x = ((r * Size_stp));

        r = (int) (Math.random() * Prey_randpos);
        Prey_y = ((r * Size_stp));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (playGame) {

            findPrey();
            on_hit();
            Movement_of_snake();
        }

        repaint();
    }

    private class click_action extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();
            
            // code to pause and play the game with space button
            if  (key == KeyEvent.VK_SPACE){
                  pauseGame = !pauseGame;
            if  (pauseGame) {
                  timer.stop();
            }
            else{
                  timer.restart();
            }
                  repaint();
            }
           
            // code to change the direction of snake with the keys left, right, up and down
            
            if ((key == KeyEvent.VK_LEFT) && (!right_side)) {
                left_side = true;
                up_side = false;
                down_side = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!left_side)) {
                right_side = true;
                up_side = false;
                down_side = false;
            }

            if ((key == KeyEvent.VK_UP) && (!down_side)) {
                up_side = true;
                right_side = false;
                left_side = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!up_side)) {
                down_side = true;
                right_side = false;
                left_side = false;
            }
        }
        
    }

}
