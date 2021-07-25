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
        if (jd>0)jd--; //timer de aparicion de los asteroides
        else jd=20;
        if(jd==1){//generación de asteroides
            addObject(new Asteroide(-(2+Greenfoot.getRandomNumber(3))),getWidth()+200, Greenfoot.getRandomNumber(getHeight()));
            int r2=Greenfoot.getRandomNumber(100);
            if(r2>=0 && r2<=10){ //probabilidad de asteroide plateado 10/100
                addObject(new Plateado(-(2+Greenfoot.getRandomNumber(3))),getWidth()+200, Greenfoot.getRandomNumber(getHeight()));
            }
            int r3=Greenfoot.getRandomNumber(200);
            if(r3>=0 && r3<=10){//probabilidad de asteroide dorado 10/200
                addObject(new Dorado(-(2+Greenfoot.getRandomNumber(3))),getWidth()+200, Greenfoot.getRandomNumber(getHeight()));
            }
            int r4=Greenfoot.getRandomNumber(400);
            if(r4>=0 && r4<=10){//probabilidad de asteroide plateado 10/400
                addObject(new Diamante(-(2+Greenfoot.getRandomNumber(3))),getWidth()+200, Greenfoot.getRandomNumber(getHeight()));
            }
        }
    }
    public void aumentar_puntuacion(int cant){//funcion de aumento de puntuación
        cont+=cant;
        contador.add(cont); 
    }
}
