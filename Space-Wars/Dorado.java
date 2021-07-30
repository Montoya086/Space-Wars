import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dorado here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dorado extends Actor
{
    private int bx=0; 
    private int r;
    private boolean remove=false;
    private int cont=0;
    public Dorado(){
        
    }
    public Dorado(int b){
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
    public void destruir(){ //Animación y accion de destruir asteroides
        if(cont>=5){//contador de la vida del asteroide
        for(int i=0;i<10;i++){
            int px=-20+Greenfoot.getRandomNumber(40);
            int py=-20+Greenfoot.getRandomNumber(40);           
            getWorld().addObject(new Pedazos(getImage()),getX()+px,getY()+py);
        }
        getWorld().addObject(new Explosion(),getX(),getY());
        GreenfootSound explosion = new GreenfootSound("Explosion.wav");
        explosion.setVolume(70);
        explosion.play();
        remove=true;
        Espacio juego = (Espacio) getWorld();
        juego.aumentar_puntuacion(10);
    }
    else{
        cont++;
    }
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
