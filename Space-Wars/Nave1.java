import greenfoot.*;  
public class Nave1 extends Actor
{
    private int objtx=0,objty=0;
    private int jd=0;
    private boolean remove=false;
    public void addedToWorld(World Espacio){
        objtx=getX();
        objty=getY();
    }
    public void mover(){
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
    public void destruir(){ //Animación y accion de destruir naves enemigas
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
        if(!remove)
            mover();
            else
            getWorld().removeObject(this);
            if(jd>0)jd--;
            if(jd==1)getWorld().addObject(new Disparo(),getX()+100,getY());
            if(jd==0)jd=80;
        
    }    
}
