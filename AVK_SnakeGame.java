import java.awt.EventQueue;
import javax.swing.JFrame;

public class SnakeGame extends JFrame {

    public SnakeGame() {        
        setTitle("The Snake Game: Amrit Veer Kaur");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();        
    }
    
    public static void main(String[] args) {        
        EventQueue.invokeLater(() -> {
            //create the game with a game title as follow: The Snake Game (C) Your_Name
            JFrame sgame = new SnakeGame();
            sgame.setVisible(true);
        });
    }
}
