
import java.awt.EventQueue;
import javax.swing.JFrame;
/*
 * Class to make frame for the snake game.
 * @author Amrit Veer Kaur
 */
public class AVK_SnakeGame extends JFrame {

    public AVK_SnakeGame() {
        
        add(new AVK_GameBoard());  // to add gameboard panel into frame
        
        setResizable(false);
        pack();
        
        setTitle("Snake Game");  // to set title of the game
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
    }
        
}
     