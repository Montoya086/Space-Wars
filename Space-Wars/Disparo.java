import greenfoot.*; 
public class Disparo extends Actor
{
    private boolean remove=false;
    private int v = 3;
    public void act() 
    {
        if(!remove){
            setLocation(getX()+v,getY());
            if(getX()>getWorld().getWidth()+200)remove=true;
        }else{
            getWorld().removeObject(this);
        }
    }    
}
