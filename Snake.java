/**
 * Write a description of class Snake here.
 *
 * @AMRIT VEER KAUR 
 * @Snakegame 1.0(date - 25-04-2021)
 */
import javax.swing.JFrame;
public abstract class Snake extends JFrame       // to add the frame and its properties to the snake game.
{
    /**
     * Constructor for objects of class Snake
     */
    public Snake() {
        // initialise instance variables   
        setTitle("Snake");      // to set the game title

    }

    /**
     * to move the snake 
     */
    public void movesnake()
    {

    }

    /**
     * to chnage the direction of snake when keys are pressed   
     */
    public void keypressed()
    {

    }
    /**
     * create a snake
     *
     * it will run automatically
     */
    public abstract void snakemake();
    
    


}
