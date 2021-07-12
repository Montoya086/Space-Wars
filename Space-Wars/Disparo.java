import greenfoot.*; 
public class Disparo extends Actor
{
    private boolean remove=false;
    private int v = 3;
    public void act() 
    {
        if(!remove){
            setLocation(getX()+v,getY());
            Actor actor=getOneIntersectingObject(Asteroide.class);
            if(actor!=null){
                ((Asteroide)actor).destruir();
            }
            if(getX()>getWorld().getWidth()+200)remove=true;
        }else{
            getWorld().removeObject(this);
        }
    }    
}
