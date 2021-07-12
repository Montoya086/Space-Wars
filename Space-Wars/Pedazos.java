import greenfoot.*;
public class Pedazos extends Actor
{
    public int bx=0,by=0,rt=0;
    public Pedazos(GreenfootImage image){
        GreenfootImage imag=new GreenfootImage(10,10);
        imag.drawImage(image,-Greenfoot.getRandomNumber(image.getWidth()),-Greenfoot.getRandomNumber(image.getHeight()));
        setImage(imag);
    }
    public void addtoworld(World Espacio){
        bx=-5+Greenfoot.getRandomNumber(10);
        by=-5+Greenfoot.getRandomNumber(10);
        rt=-10+Greenfoot.getRandomNumber(20);
        if(bx==0)bx=1;
        if(by==0)by=1;
    }
    public void act() 
    {
        setLocation(getX()+bx,getY()+by);
        setRotation(getRotation()+rt);
        if(getX()<-200 || getY()<-200 || getX()>getWorld().getWidth()+200 || getY()>getWorld().getHeight()+200){
            getWorld().removeObject(this);
        }
    }    
}
