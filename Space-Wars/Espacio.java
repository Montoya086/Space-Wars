import greenfoot.*;
public class Espacio extends World
{
    private int jd=0;
    private Score contador;
    private int cont=0;
    public Espacio()
    {    
        super(960, 600, 1,false);
        addObject(new Nave1(), 100,300);
        contador = new Score("Puntuación: ");
        addObject(contador, 120,30);
    }
    public void act(){
        if (jd>0)jd--;
        else jd=20;
        if(jd==1){
            int r=Greenfoot.getRandomNumber(getHeight());
            addObject(new Asteroide(-(2+Greenfoot.getRandomNumber(3))),getWidth()+200, r);
        }
    }
    public void aumentar_puntuacion(){
        cont++;
        contador.add(cont); 
    }
}
