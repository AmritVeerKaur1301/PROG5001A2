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
 * this class is used to upload the smily as prey for the game.
 * @author Amrit Veer Kaur
 */

public class AVK_Prey extends JPanel {
    Image img;
    public AVK_Prey() {
        img = new ImageIcon("images/smily.png").getImage();
        //img = img.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        Dimension size = new Dimension(15, 15);
        setPreferredSize(size);
    }
    
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
        repaint();
    }
}

