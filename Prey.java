/**
 * Class Prey represents any prey object.
 *
 * @AMRIT VEER KAUR 
 * @Snakegame 1.0
**/



public abstract class Prey {
    /**
     * Constructor for objects of class Prey
     */
    public Prey()
    {
        
    }   

    /**
     * random location of prey to display on board     
     * @param  y  (when snake eats the old prey and at the start of game)
     * @return    random location of prey 
     */
    public abstract int locateprey();
   

 

}
