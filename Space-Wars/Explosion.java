import greenfoot.*;

public class Explosion extends Actor
{
    private int jd=5;
    public void addtoworld(World Espacio){
        GreenfootImage imagen = new GreenfootImage(110,110);
        imagen.setColor(new Color(255,255,0,180));
        imagen.fillOval(0,0,imagen.getWidth()-1,imagen.getHeight()-1);
        setImage(imagen);
        jd=5;
    }
    public void act() 
    {
        if(jd>0)jd--;
        else getWorld().removeObject(this);
        
    }    
}
