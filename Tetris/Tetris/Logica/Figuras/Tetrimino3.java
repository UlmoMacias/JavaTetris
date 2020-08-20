package Tetris.Logica.Figuras;

import Tetris.utils.Punto2D;
import java.awt.Color;

 public class Tetrimino3 extends Figura{

    private final Color fill=new Color(230,95,0);
    private final Color border=new Color(179,179,251);
    private Punto2D[] puntos0;
    private Punto2D[] puntos90;
    private Punto2D[] puntos180;
    private Punto2D[] puntos270;
    private int posicion;

    public Tetrimino3(){
        posicion=0;
        puntos0=new Punto2D[]{new Punto2D(2,0),new Punto2D(0,1),new Punto2D(1,1),new Punto2D(2,1)};
        puntos90=new Punto2D[]{new Punto2D(0,0),new Punto2D(0,1),new Punto2D(0,2),new Punto2D(1,2)};
        puntos180=new Punto2D[]{new Punto2D(0,0),new Punto2D(1,0),new Punto2D(2,0),new Punto2D(0,1)};
        puntos270=new Punto2D[]{new Punto2D(0,0),new Punto2D(1,0),new Punto2D(1,1),new Punto2D(1,2)};
    }
    /*
    *metodo que  rota a la derecha
    *
    */
    public void rotateRigth(){
        posicion=(posicion+1)%4;
    }
    /*
    *metodo que  rota a la izquierda
    *
    */
    public void rotateLeft(){
        posicion--;
        if(posicion<0){
            posicion=3;
        }
    }
    /*
    *metodo que obtiene puntos
    *
    */
    public Punto2D[] getPuntos(){
        return translate(new Punto2D());
    }
    /*
    *metodo que traslada un punto
    *
    */
    public Punto2D[] translate(Punto2D dxy) {
        Punto2D[] aux=new Punto2D[4];
        switch(posicion){
            case 1:               
                for(int i=0;i<4;i++){
                    aux[i]=puntos90[i].clone();
                    aux[i].move(dxy.getX(), dxy.getY());
                }
                break;
            case 2:
                for(int i=0;i<4;i++){
                    aux[i]=puntos180[i].clone();
                    aux[i].move(dxy.getX(), dxy.getY());
                }
                break;
            case 3:
                for(int i=0;i<4;i++){
                    aux[i]=puntos270[i].clone();
                    aux[i].move(dxy.getX(), dxy.getY());
                }
                break;
            default:
                for(int i=0;i<4;i++){
                    aux[i]=puntos0[i].clone();
                    aux[i].move(dxy.getX(), dxy.getY());
                }
        }
        return aux;
    }
        /*
    *metodo que pinta la figura
    *
    */
    public Color getFillColor(){
        return fill;
    }
    /*
    *metodo que pinta los bordes
    *
    */
    public Color getBorderColor(){
        return border;
    }
    /*
    *metodo que reestablece el valor posicion
    *
    */
    public void restablece() {
        posicion=0;
    }
}