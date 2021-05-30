
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.GridLayout;

/*
 * Class to make frame for the snake game.
 * @author Amrit Veer Kaur
 */
public class AVK_SnakeGame extends JFrame {

    public AVK_SnakeGame() {
        
        setLayout(new GridLayout(1, 2,2,2));
        setResizable(false);
        pack();
        setBounds(10,10,600,400);
        
        setTitle("Snake Game: Amrit");  // to set title of the game
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AVK_GameBoard gb = new AVK_GameBoard();
        add(gb);  // to add gameboard panel into frame
        
        AVK_Scoreframe sf = new AVK_Scoreframe();
        add(sf);
        
        
    }
        
}
     