import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;

/**
 * Write a description of class HealthBar here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HealthBar extends Actor
{
    private GreenfootImage frame;
    private GreenfootImage healthBar;

    private Color good;
    private Color warning;
    private Color danger;

    private int target; 
    private int current;
    private int max;
    private int speed;

    public HealthBar()
    {
        frame = new GreenfootImage( 200,30 );
        healthBar = new GreenfootImage( 200,30 );
        frame.setColor( Color.GRAY );
        frame.fillRect( 0, 0, 200, 30 );

        good = Color.GREEN;
        warning = Color.YELLOW;
        danger = Color.RED;

        max = 1000;
        current = 600;
        target = current;

        speed = 1;

        updateBar();
    }

    public HealthBar(int c, int m, int s)
    {
        frame = new GreenfootImage( 200,30 );
        healthBar = new GreenfootImage( 200,30 );
        frame.setColor(Color.GRAY);
        frame.fillRect(0, 0, 200, 30);

        good = Color.GREEN;
        warning = Color.YELLOW;
        danger = Color.RED;

        max = m;
        current = c;
        target = current;

        speed = s;

        updateBar();
    }

    public HealthBar(int c, int m, int s, Color g, Color w, Color d)
    {
        frame = new GreenfootImage( 200,30 );
        healthBar = new GreenfootImage( 200,30 );
        frame.setColor(Color.GRAY);
        frame.fillRect(0, 0, 200, 30);

        good = g;
        warning = w;
        danger = d;

        max = m;
        current = c;
        target = current;

        speed = s;

        updateBar();
    }

    /**
     * Act - do whatever the HealthBar wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if( current > target )
        {
            current = current - speed;
            if( current <= target )
            {
                current = target;
            }
        }
        else
        {
            current = current + speed;
            if( current >= target )
            {
                current = target;
            }
        }

        updateBar();
    }

    /**
     * updateBar updates the healthBar image
     * 
     * @param There are no parameters
     * @return Nothing is returned 
     */
    private void updateBar()
    {
        ScrollerWorld myWorld = (ScrollerWorld)getWorld();
        GreenfootImage text = new GreenfootImage( 200,30 );
        double ratio = current / ( max * 1.0 );
        int healthWidth = ( int )Math.round( ratio*frame.getWidth() );

        if( current > max/2 )
        {
            healthBar.setColor(good);
        }
        else if( current > max/4)
        {
            healthBar.setColor(warning);
        }
        else
        {
            healthBar.setColor(danger);
        }

        healthBar.clear();
        healthBar.fillRect( 0, 0, healthWidth, 30 );

        text.clear();
        text.setColor( Color.BLACK );
        text.setFont(new Font( "Times New Roman", Font.PLAIN, 20 ) );
        text.drawString( current + "/" + max, 0, 30 - text.getFont().getSize()/2 );

        frame.clear();
        frame.setColor( Color.GRAY );
        frame.fillRect( 0,0,200,30);
        frame.drawImage( healthBar, 0, 0 );
        frame.drawImage( text, frame.getWidth()/3, 0 );

        setImage( frame );

        if ( current == 0 )
        {
            myWorld.gameOver(); 
        }
    }

    /**
     * add, changes the target by a specific number 
     * 
     * @param int change is a value that will change target 
     * @return Nothing is returned 
     */
    public void add( int change )
    {
        target = target + change;

        if( target > max )
        {
            target = max;
        }

        if( target < 0 )
        {
            target = 0;
        }
    }

    /**
     * setTarget sets target to t
     * 
     * @param int t will set target to equal t
     * @return Nothing is returned 
     */
    public void setTarget( int t )
    {
        target = t;
    }

    /**
     * setCurrent sets target to c
     * 
     * @param int c will set current to equal c
     * @return Nothing is returned 
     */
    public void setCurrent( int c )
    {
        current = c;
    }

    /**
     * setMax sets target to m
     * 
     * @param int m will set max to equal m
     * @return Nothing is returned 
     */
    public void setMax( int m)
    {
        max = m;
    }

    /**
     * setSpeed sets target to s
     * 
     * @param int s will set speed to equal s
     * @return Nothing is returned 
     */
    public void setSpeed( int s )
    {
        speed = s;
    }

    /**
     * getMax will return max
     * 
     * @param nothig is returned
     * @return max is returned 
     */
    public int getMax()
    {
        return max;
    }

    /**
     * getCurrent will retuen current 
     * 
     * @param nothig is returned
     * @return current is returned
     */
    public int getCurrent()
    {
        return current;
    }
}
