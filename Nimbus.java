import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nimbus extends Actor
{
    private GreenfootImage block = new GreenfootImage("Nimbus.png");

    public Nimbus()
    {
        block.scale(25, 25);
        setImage(block);
    }
  
    /**
     * act handles the actions must be taken everytime the program is run 
     * @param There is no paramters
     * @return Nothing is returned 
     */
    public void act() 
    {
        Goku goku = getWorld().getObjects(Goku.class).get(0);
        if( goku.getMove() == true )
        {
            if( Greenfoot.isKeyDown("right") )
            { 
                move(-1); 
            } 

            if(getX() < 0)
            {
                getWorld().removeObject(this);
            } 
        }

    }
}
