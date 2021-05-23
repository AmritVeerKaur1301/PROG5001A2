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

/*
 * Gameboard class is created to add the snake, prey to the board to play game.
 * to move the snake and after eaten the prey to display on random location.
 * @author Amrit Veer Kaur
 */

public class AVK_GameBoard extends JPanel implements ActionListener {

    private final int GB_Width = 320;
    private final int GB_Hgt = 320;
    private final int S_dot = 10;
    private final int ALL_DOTS = 920;
    private final int RAND_POS = 28;
    private final int DELAY = 120;

    private final int x[] = new int[ALL_DOTS];
    private final int y[] = new int[ALL_DOTS];

    private int size;
    private int prey_x;
    private int prey_y;
    int score = 0;
    
    private boolean leftDirection = false;
    private boolean rightDirection = true;
    private boolean upDirection = false;
    private boolean downDirection = false;
    private boolean playGame = true;
    private boolean pauseGame = false;

    private Timer timer;
    private Image snakeb;
    private Image smily;
    private Image snakeh;

    public AVK_GameBoard() { 
        // setting the panel background, size and apply key functions to play game.
        addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);

        setPreferredSize(new Dimension(GB_Width, GB_Hgt));
        uploadImages();    // to upload the images of snake and prey
        initGame();
        
    }
    
    private void uploadImages() {
        
        AVK_Prey prey = new AVK_Prey();  // object of prey class to access images 
        smily = prey.img;
        
        AVK_SnakeBody sb = new AVK_SnakeBody(); // // object of snake class to access snake head and body images
        snakeh = sb.snake_head;
        snakeb = sb.snake_body;

    }

    private void initGame() {

        size = 4;

        for (int i = 0; i < size; i++) {
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

            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    g.drawImage(snakeh, x[i], y[i], this);
                } else {
                    g.drawImage(snakeb, x[i], y[i], this);
                }
            }

            Toolkit.getDefaultToolkit().sync();

        } else {
            
            gameOver(g);
           
        }        
    }

    private void gameOver(Graphics g) {
    
        AVK_Scoreframe sf = new AVK_Scoreframe();
        sf.setVisible(true);
         
    }

    private void checkPrey() {
        
        if ((x[0] == prey_x) && (y[0] == prey_y)) {
            
            size++;
            
            score = score + 1;
            System.out.println(score);
            locatePrey();
        }
        
    }

    private void movesnake() {

        for (int i = size; i > 0; i--) {
            x[i] = x[(i - 1)];
            y[i] = y[(i - 1)];
        }

        if (leftDirection) {
            x[0] -= S_dot;
        }

        if (rightDirection) {
            x[0] += S_dot;
        }

        if (upDirection) {
            y[0] -= S_dot;
        }

        if (downDirection) {
            y[0] += S_dot;
        }
    }

    private void checkhit() {

        for (int i = size; i > 0; i--) {

            if ((i > 4) && (x[0] == x[i]) && (y[0] == y[i])) {
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

    private class TAdapter extends KeyAdapter {

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
            
            if ((key == KeyEvent.VK_LEFT) && (!rightDirection)) {
                leftDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_RIGHT) && (!leftDirection)) {
                rightDirection = true;
                upDirection = false;
                downDirection = false;
            }

            if ((key == KeyEvent.VK_UP) && (!downDirection)) {
                upDirection = true;
                rightDirection = false;
                leftDirection = false;
            }

            if ((key == KeyEvent.VK_DOWN) && (!upDirection)) {
                downDirection = true;
                rightDirection = false;
                leftDirection = false;
            }
        }
    }
}
