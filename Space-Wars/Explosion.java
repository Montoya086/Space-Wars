import greenfoot.*;
public class Explosion extends Actor
{
    private int jd=5;
    public void act() 
    {
        if(jd>0)jd--;
        else getWorld().removeObject(this);
        
    }    
}
