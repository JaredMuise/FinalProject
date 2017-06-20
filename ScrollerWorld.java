 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Jared Muise) 
 * @version (Final Project)
 */
public class ScrollerWorld extends World
{
    //Add platformCounter and score variables here

    private int platformCounter = 25;
    private int score = 0;
    private int live = 1;

    /**
     * Constructor for objects of class ScrollerWorld.
     * 
     */
    public ScrollerWorld()
    {    
        super(500, 200, 1);
        
        setPaintOrder(Nimbus.class, Goku.class);

        prepareWorld();

        displayScore();
        
    }

    /**
     * prepareWorld adds objects to world to prepare the game for use
     * @param There are no parameters
     * @return Nothing is returned
     */
    private void prepareWorld()
    {
        for( int i = 0; i <= getWidth()/50; i++ )
        {
            addObject(new Platform(), i*50, getHeight() - 8);
        }

        addObject(new Goku(), 30, getHeight() - 30);

        HealthBar healthbar = new HealthBar();
        addObject(healthbar,264,65);
        healthbar.setLocation(260,25);
    }

    /**
     * act handles the actions must be taken everytime the program is run 
     * @param There is no paramters
     * @return Nothing is returned 
     */
    public void act()
    {
        if( Greenfoot.isKeyDown("right") )
        { 
            if( platformCounter >= 25 )
            {
                platformCounter = 0;
                addObject(new Platform(), getWidth()-25, getHeight()-8 );
            }

            platformCounter ++; 

        } 

        if(Greenfoot.getRandomNumber(100) < 1)
        {
            addObject(new Sibamen(), 559, getHeight() - 27);
        }

        if(Greenfoot.getRandomNumber(550) < 1)
        {
            addObject(new Nimbus(), 559, getHeight() - 100);
        }

        
        if(Greenfoot.getRandomNumber(900) < 1)
        {
            addObject(new SenzuBean(), 559, getHeight() - 27);
        }

        displayScore();
      
    }   

    /**
     * gameOver display a message along with the score and stop the prgram from running  
     * @param There is no paramters
     * @return Nothing is returned 
     */    
    public void gameOver()
    {
        showText("You have been defeated! Score:" + score,getWidth()/2, getHeight()/2);
        Greenfoot.stop();

    }

    /**
     * displayScore will display the score at the given x and y coordinate
     * @param There is no paramters
     * @return Nothing is returned 
     */    
    public void displayScore()
    {
        showText("Scroe: " +score, 50, 25);

    }

    /**
     * addToScore will increase the players score by a value of one
     * @param There is no paramters
     * @return Nothing is returned 
     */      
    public void addToScore()
    {
        score++;
        displayScore();

    }

}
