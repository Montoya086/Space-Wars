import greenfoot.*;
public class Explosion extends Actor
{
    private int jd=5;
    public void act() 
    {
        if(jd>0)jd--;//tiempo de animación de la explosión
        else getWorld().removeObject(this);
        
    }    
}
