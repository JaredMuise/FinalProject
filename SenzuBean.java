import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Flower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SenzuBean extends Actor
{
    private GreenfootImage SenzuBean = new GreenfootImage("SenzuBean.png");

    /**
     * SenzuBean will scale the image and display a picture for the class
     * @param There is no paramters
     * @return a flower is returned 
     */
    public SenzuBean()
    {
        SenzuBean.scale(25, 25);
        setImage(SenzuBean);

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
