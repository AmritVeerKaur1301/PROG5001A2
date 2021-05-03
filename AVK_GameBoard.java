import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public abstract class AVK_GameBoard extends JPanel {    
    int xcells = 30;    
    int ycells = 30;
    int szcell = 10;        

    public AVK_GameBoard() {
        setPreferredSize(new Dimension(xcells * szcell, ycells * szcell));        
        setBackground(Color.black); // to set the background color of gameboard
        setFocusable(true);        
    }

    /**
     * This collision method to check the collsion of snake with the board and itself.
     */
    public void collision()
    {
        // put your code here

    }

    /**
     * game over to show the message that game is over after the collision
     * @ return message to display that game is over 
     */
    public int gameover(int y)
    {
        // put your code here
        return y;
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

}
