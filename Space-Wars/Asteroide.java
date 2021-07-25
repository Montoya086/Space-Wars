import greenfoot.*;
public class Asteroide extends Actor
{
    private int bx=0; 
    private int r;
    private boolean remove=false;
    public Asteroide(){
        
    }
    public Asteroide(int b){
        bx=b;
    }
    public void addedToWorld(World Espacio){ 
        setRotation(180);
    }
    public void mover(){   // movimiento de los asteroides
        setLocation(getX()+bx,getY());
        Actor actor = getOneIntersectingObject(Nave1.class);
        if(actor!=null){
            ((Nave1)actor).destruir();
        }
        if(getX()<-200)remove=true;
    }
    public void destruir(){ //Animación y accion de destruir Asteroides
        for(int i=0;i<10;i++){
            int px=-20+Greenfoot.getRandomNumber(40);
            int py=-20+Greenfoot.getRandomNumber(40);            
            getWorld().addObject(new Pedazos(getImage()),getX()+px,getY()+py);
        }
        getWorld().addObject(new Explosion(),getX(),getY());
        remove=true;
        Espacio juego = (Espacio) getWorld();
        juego.aumentar_puntuacion(1);//aumento de la puntuación
    }
    public void act() 
    {
        if(r>0)//timer de rotaciónes del asteroide
            r--;
        if(r==1)
            setRotation(getRotation()+Greenfoot.getRandomNumber(360));
        if(r==0) 
            r=10;
        if(!remove)//detección de colisión
            mover();
        else
            getWorld().removeObject(this);
    }    
}
