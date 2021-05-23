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
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * this class is used to upload the snakebody and head from the folder.
 * @author Amrit Veer Kaur
 */

public class AVK_SnakeBody extends JPanel {
    Image snake_head;
    Image snake_body;
    public AVK_SnakeBody() {
        snake_head = new ImageIcon("images/snakeh.jpg").getImage();
        snake_body = new ImageIcon("images/body.png").getImage();
        Dimension size = new Dimension(15, 15);
        setPreferredSize(size);
    
    }
    
    
}





 
