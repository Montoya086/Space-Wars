import greenfoot.*; 
public class Disparo extends Actor
{
    private boolean remove=false;
    private int v = 3;
    private Actor actor=null; 
    public void act() 
    {
        if(!remove){
            setLocation(getX()+v,getY());
            actor=getOneIntersectingObject(Asteroide.class);
            if(actor!=null){ // disparo a asteroide normal
                ((Asteroide)actor).destruir();
                remove=true;
            }
            actor=getOneIntersectingObject(Dorado.class);
            if (actor!=null){// disparo a asteroide dorado
                ((Dorado)actor).destruir();
                remove=true;
            }
            actor=getOneIntersectingObject(Plateado.class);
            if (actor!=null){ // disparo a asteroide plateado
                ((Plateado)actor).destruir();
                remove=true;
            }
            actor=getOneIntersectingObject(Diamante.class);
            if (actor!=null){ // disparo a asteroide de diamante
                ((Diamante)actor).destruir();
                remove=true;
            }
            if(getX()>getWorld().getWidth()+200)remove=true;
        }else{ // eliminar el disparo luego de la colisión
            getWorld().removeObject(this);
        }
    }
}
