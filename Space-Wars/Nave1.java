import greenfoot.*;  
public class Nave1 extends Actor
{
    private int objtx=0,objty=0;
    private int jd=0;
    private boolean remove=false;
    private int r=0;
    private boolean b=true;
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
        GreenfootSound explosion = new GreenfootSound("Explosion2.wav");
        explosion.setVolume(80);
        explosion.play();
        remove=true;
    }
    public void act() 
    {
        if(Greenfoot.mouseMoved(null)){ // detección de la posicion del mouse
            MouseInfo mouse=Greenfoot.getMouseInfo();
            objtx=mouse.getX();
            objty=mouse.getY();
            
        }
        if(!remove){//si no se ha destruido, puede seguir moviendose y disparando
            mover();
            String tecla =Greenfoot.getKey();
            if("space".equals(tecla)){//disparos
                GreenfootSound disparo = new GreenfootSound("Disparo.wav");
                disparo.setVolume(70);
                getWorld().addObject(new Disparo(),getX()+100,getY());
                disparo.play();
            }
            if(b==true)
                if("x".equals(tecla)){//disparos
                    GreenfootSound disparo = new GreenfootSound("Disparo.wav");
                    disparo.setVolume(70);
                    getWorld().addObject(new Disparo(),getX()+100,getY());
                    getWorld().addObject(new Disparo(),getX()+100,getY()-30);
                    getWorld().addObject(new Disparo(),getX()+100,getY()+30);                    
                    disparo.play();
                    b=false;
                 }
            if(r>0)r--;
            if(r==1)b=true;
            if(r==0)r=150;
        }
        else
        getWorld().removeObject(this);
            
            
            
            
        
    }    
}
