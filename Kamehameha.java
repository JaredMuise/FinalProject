import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class fireBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Kamehameha extends Actor
{
    private GreenfootImage fire = new GreenfootImage("Kamehameha.png");

    private int actCycle = 0;
    private int y = -4;
    private int ySpeed = 3;
    private int up = -8;
    private boolean cannotJump = false;
    private boolean lookingRight = true;

    public Kamehameha()
    {
        setImage(fire);
        getImage().scale(100, 120);
    }

    /**
     * Kamehameha will cunstuct a Kamehameha wave to scale 
     * @param There is no paramters
     * @return fireBall is returned 
     */
    public Kamehameha(Goku goku)
    {

        setImage(fire);
        getImage().scale(100, 120);
        lookingRight = goku.getRight();

        if( lookingRight == false)
        {
            getImage().mirrorHorizontally();

        }

    }

    /**
     * act handles the actions must be taken everytime the program is run also the act will make the Kamehameha wave extend longer when fired.
     * @param There is no paramters
     * @return Nothing is returned 
     */
    public void act() 
    {
        move();

        ScrollerWorld myWorld = (ScrollerWorld)getWorld();
        Goku goku = myWorld.getObjects(Goku.class).get(0);
        if( isTouching(Sibamen .class))
        {
            getWorld().removeObject(getOneIntersectingObject(Sibamen .class) );
            myWorld.addToScore();
        }
        else if( getX() + getImage().getWidth()/2 >= 499 || getX() - getImage().getWidth()/2 <= 0)
        {
            getWorld().removeObject(this);
            goku.setMove(true);
        }
        actCycle ++;
        getImage().scale(actCycle+30, getImage().getHeight());

    }

    /**
     * move will make the Kamehameha move in the proper direaction   
     * @param There is no paramters
     * @return Nothing is returned 
     */
    private void move()
    {   
        if( actCycle % 2 == 0 )
        {
            if( lookingRight == true ) 
            {
                setLocation(getX() + 1, getY());
            }    
            else
            {
                setLocation(getX() - 1, getY()); 
            }
        }
        cannotJump = true;

    }

}
