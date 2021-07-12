import greenfoot.*;
public class Nave2 extends Actor
{
    private int bx=0; 
    private boolean remove=false;
    public Nave2(){
        
    }
    public Nave2(int b){
        bx=b;
    }
    public void addtoworld(World Espacio){
        setRotation(180);
    }
    public void mover(){
        setLocation(getX()+bx,getY());
        if(getX()<-200)remove=true;
    }
    public void destruir(){
        for(int i=0;i<10;i++){
            int px=-20+Greenfoot.getRandomNumber(40);
            int py=-20+Greenfoot.getRandomNumber(40);            
            getWorld().addObject(new Pedazos(getImage()),px,py);
        }
        remove=true;
    }
    public void act() 
    {
        if(!remove)
        mover();
        else
        getWorld().removeObject(this);
    }    
}
