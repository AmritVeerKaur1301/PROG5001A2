import java.awt.EventQueue;
import javax.swing.JFrame;

public class AVK_SnakeGame extends JFrame {

    public AVK_SnakeGame() {        
        setTitle("The Snake Game: Amrit Veer Kaur");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();        
    }
    
    public static void main(String[] args) {        
        EventQueue.invokeLater(() -> {
            //create the game with a game title as follow: The Snake Game (C) Your_Name
            JFrame sgame = new AVK_SnakeGame();
            sgame.setVisible(true);
        });
    }
}
