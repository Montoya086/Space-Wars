import greenfoot.*;  
public class Nave1 extends Actor
{
    private int objtx=0,objty=0;
    private int jd=0;
    private boolean remove=false;
    public void addtoworld(World Espacio){
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
    public void act() 
    {
        if(Greenfoot.mouseMoved(null)){
            MouseInfo mouse=Greenfoot.getMouseInfo();
            objtx=mouse.getX();
            objty=mouse.getY();
            mover();
        }
            if(jd>0)jd--;
            if(jd==1)getWorld().addObject(new Disparo(),getX()+100,getY());
            if(jd==0)jd=40;
        
    }    
}
