import greenfoot.*;  
public class Nave1 extends Actor
{
    private int objtx=0,objty=0;
    private int jd=0;
    private boolean remove=false;
    public void addedToWorld(World Espacio){//se obtienen las coordenadas cuando se alñade al mundo
        objtx=getX();
        objty=getY();
    }
    public void mover(){ // Se mueve con el movimiento del mouse
        double rx=objtx-getX();
        double ry=objty-getY();
        double r=Math.sqrt(rx*rx+ry*ry);
        int vel=20;
        int posx=0;
        int posy=0;
        if(r>vel){
            posx=(int)(getX()+vel*rx/r);
            posy=(int)(getY()+vel*ry/r);
        }else{
            posx=objtx;
            posy=objty;
        }
        setLocation(posx,posy);
    }
    public void destruir(){ //Animación y accion de destruir 
        for(int i=0;i<10;i++){
            int px=-20+Greenfoot.getRandomNumber(40);
            int py=-20+Greenfoot.getRandomNumber(40);            
            getWorld().addObject(new Pedazos(getImage()),getX()+px,getY()+py);
        }
        getWorld().addObject(new Explosion(),getX(),getY());
        remove=true;
    }
    public void act() 
    {
        if(Greenfoot.mouseMoved(null)){
            MouseInfo mouse=Greenfoot.getMouseInfo();
            objtx=mouse.getX();
            objty=mouse.getY();
            
        }
        if(!remove)//si no se ha destruido, puede seguir moviendose y disparando
            mover();
            else
            getWorld().removeObject(this);
            if("space".equals(Greenfoot.getKey())){//disparos
                getWorld().addObject(new Disparo(),getX()+100,getY());
            }
            
        
    }    
}
