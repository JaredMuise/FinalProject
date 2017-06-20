import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goku extends Actor
{
    private GreenfootImage original = new GreenfootImage( "Goku.png" );
    

    private int y = 0;
    private int ySpeed = 1;
    private int smallUp = -9;
    private int up = -15;
    private boolean cannotJump = false;
    private boolean lookingRight = true;
    private int live = 1;
    private int reloadTimer = 100;
    private int gokuSz = 1;
    private boolean canMove = true; 
    //Number will change to 1,2,3 depending on different interactions to change
    //the Heros appearance  
    /**
     * Hero will cunstuct a Hero to scale and the right direction 
     * @param There is no paramters
     * @return Hero is returned 
     */  
        public Goku()
    {
        original.scale(30, 30);
        
        original.mirrorHorizontally();
        setImage(original);

    }

    /**
     * act handles the actions must be taken everytime the program is run 
     * @param There is no paramters
     * @return Nothing is returned 
     */
    public void act() 
    {
        movement();

        checkCollision();

        ScrollerWorld myWorld = (ScrollerWorld)getWorld();
        if ( gokuSz ==3 )//if marioSz = 3, then only will the Hero be able to throw fireBalls
        {

            if( Greenfoot.isKeyDown("space") )
            {
                if(reloadTimer >= 100)
                {
                    if( lookingRight == true ) 
                    {
                        myWorld.addObject(new Kamehameha(this), getX() + 30, getY());
                        canMove = false;
                        reloadTimer = 0;
                    }
                    else
                    { 
                        myWorld.addObject(new Kamehameha(this), getX() - 30, getY());
                        canMove = false;
                        reloadTimer = 0;
                    }
                }
                reloadTimer++;
            }

        }

    }

    /**
     * movement will determine which way to move, rotate, and the Hero's apperance  
     * @param There is no paramters
     * @return Nothing is returned 
     */
    private void movement()
    {
        if( canMove == true )
        {
            if( Greenfoot.isKeyDown("right") )
            { 

                if (lookingRight == false)
                {
                    original.mirrorHorizontally();
                   
                }

                lookingRight = true; 
                setLocation( getX()+3, getY() );

            }

            if( Greenfoot.isKeyDown("left") )
            { 

                if (lookingRight == true)
                {
                    original.mirrorHorizontally(); 
                   

                }

                lookingRight = false; 
                setLocation( getX()-3, getY() );        

            }

            if( Greenfoot.isKeyDown("up") )
            { 

                if (cannotJump == false)
                {

                  
                    y = up;
                    fall();

                }

            }

            if( getY() >= 350 )
            { 
                setLocation( getX(), 365 );
                y = 0; 
            }  
        }

    }
    
    /**
     * fall will make the Kamehameha fall to the platform when its in the air  
     * @param There is no paramters
     * @return Nothing is returned 
     */
    private void fall()
    {
        cannotJump = true;
        setLocation( getX(), getY()+y ); 
        y = y + ySpeed;
    }

    /**
     * -- checkCollision will determine how to react when the Hero comes in contact with different classes,
     * 
     * 
     * @param There is no paramters
     * @return Nothing is returned
     */
    private void checkCollision()
    {
        ScrollerWorld myWorld = (ScrollerWorld)getWorld();
        HealthBar bar = getWorld().getObjects(HealthBar.class).get(0);

        if(getOneObjectAtOffset(0, getImage().getHeight()-15, Sibamen.class) != null)
        {
            getWorld().removeObject(getOneObjectAtOffset(0, getImage().getHeight()-15, Sibamen.class));
            myWorld.addToScore(); 
            y = smallUp;// will make the Hero bounce off the enemy 
            fall();// will bring the Hero back to the Platform
        }

        else if( isTouching(Sibamen.class))
        {

            if(gokuSz == 3)//Will set the Hero back to its original apperance and mamke marioSz = 1
            {                
                getWorld().removeObject(getOneIntersectingObject(Sibamen.class) );
                setImage(original);
                gokuSz = 1;
            }
            else if(gokuSz == 2)//Will set the Hero back to its original apperance and mamke marioSz = 1
            {                
                getWorld().removeObject(getOneIntersectingObject(Sibamen.class) );
                setImage(original);
                gokuSz = 1;
            } 
            
            bar.add(-25);
            getWorld().removeObject(getOneIntersectingObject(Sibamen.class) );
        }
        else if(getOneObjectAtOffset(0, getImage().getHeight()-15, Platform.class) != null)
        {
            //This else if statment will allow the Hero to junp again and set the Hero to the correct appearance
            if(gokuSz == 1)
            {
                setImage(original);
            }           
            cannotJump = false;
            y = 0;

        }
        else//if nothing else happens he will fall to the Platform
        {
            fall();
        }

        if(getOneObjectAtOffset(0, getImage().getHeight()-15, Nimbus.class) != null)
        {
            //This if statment will allow the Hero to junp again and set the Hero to the correct appearance
            if(gokuSz == 1)
            {
                setImage(original);
            }

            cannotJump = false;
            y = 0;

        }
        else if(isTouching(Nimbus.class))
        {
            fall();
        }


        if( isTouching(SenzuBean.class))
        {
            getWorld().removeObject(getOneIntersectingObject(SenzuBean.class) );
            gokuSz = 3;
        }
    }
    
    public boolean getMove()
    {
        return canMove;
    }
    
    public void setMove(boolean move)
    {
        canMove = move;
    }
    
    public boolean getRight()
    {
        return lookingRight;
    }
}
