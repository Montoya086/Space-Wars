import greenfoot.*;
public class Score extends Actor
{
    private int largo;
    private int valor=0;
    private String texto;
    private int contador=0;
    public Score(){
        this("");
    }
    public Score(String text){
        texto=text;
        largo = (text.length() + 2) * 16;

        setImage(new GreenfootImage(largo, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));
        image.setColor(Color.WHITE);
        
        updateImage();
    }
    public void act() 
    {
        updateImage();
    }
    public void add(int score){
        valor = score;
    }
    private void updateImage(){
        GreenfootImage imagen=getImage();
        imagen.clear();
        imagen.drawString(texto+valor,1,18);
    }
}
