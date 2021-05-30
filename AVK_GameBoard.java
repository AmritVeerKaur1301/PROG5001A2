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
    
    private final int GB_Width = 300;
    private final int GB_Hgt = 400;
    private final int S_dot = 10;
    private final int ALL_DOTS = 950;
    private final int RAND_POS = 28;
    private final int DELAY = 115;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

     int snake_length;
    private int prey_x;
    private int prey_y;
    int score = 0;
    int s;
    
    
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
        initGame();
        
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
        
        AVK_Prey prey = new AVK_Prey();  // object of prey class to access images 
        smily = prey.img;
        
        AVK_SnakeBody sb = new AVK_SnakeBody(); // // object of snake class to access snake head and body images
        snakeh = sb.snake_head;
        snakeb = sb.snake_body;

    }

    private void initGame() {

        snake_length = 4;

        for (int i = 0; i < snake_length; i++) {
            x[i] = 50 - i * 10;
            y[i] = 50;
        }
        
        locatePrey();

        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
    }
    
    private void doDrawing(Graphics g) {
        
        if (playGame) {

            g.drawImage(smily, prey_x, prey_y, this);

            for (int i = 0; i < snake_length; i++) {
                if (i == 0) {
                    g.drawImage(snakeh, x[i], y[i], this);
                } else { g.drawImage(snakeb, x[i], y[i], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {
            gameOver(g);
    }
}

    private void gameOver(Graphics g) {
        
       
        setLayout(new GridLayout(2,1));
        labelplay.setForeground(new Color(255,255,255));
        labelgameover.setForeground(new Color(255,255,255));
        labelplay.setHorizontalAlignment(JLabel.CENTER);
        
        labelgameover.setHorizontalAlignment(JLabel.CENTER);
        add(labelplay);
        add(labelgameover);
        
        
         
    }

    public void checkPrey() {
        
        if ((x[0] == prey_x) && (y[0] == prey_y)) {
            
            snake_length++;
            score = score + 1;
            
            System.out.println("Score = " + score);
            System.out.println("length = " + snake_length);
            
            
            locatePrey();
        }
        
    }

     public int getscore() {
        return s;
    }

    
    private void movesnake() {

        for (int i = snake_length; i > 0; i--) {
            x[i] = x[(i - 1)];
            y[i] = y[(i - 1)];
        }

        if (left_side) {
            x[0] -= S_dot;
        }

        if (right_side) {
            x[0] += S_dot;
        }

        if (up_side) {
            y[0] -= S_dot;
        }

        if (down_side) {
            y[0] += S_dot;
        }
    }

    private void checkhit() {

        for (int i = snake_length; i > 0; i--) {

            if ((i > 4) && (x[0] == x[i]) && (y[0] == y[i])) { // i>4
                playGame = false;
            }
        }

        if (y[0] >= GB_Hgt) {
            playGame = false;
        }

        if (y[0] < 0) {
            playGame = false;
        }

        if (x[0] >= GB_Width) {
            playGame = false;
        }

        if (x[0] < 0) {
            playGame = false;
        }
        
        if (!playGame) {
            timer.stop();
        }
    }

    private void locatePrey() {

        int r = (int) (Math.random() * RAND_POS);
        prey_x = ((r * S_dot));

        r = (int) (Math.random() * RAND_POS);
        prey_y = ((r * S_dot));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (playGame) {

            checkPrey();
            checkhit();
            movesnake();
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
