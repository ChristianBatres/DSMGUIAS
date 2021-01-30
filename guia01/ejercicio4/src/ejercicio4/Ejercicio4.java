/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio4;

import java.util.Scanner;

/**
 *
 * @author cbatr
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        int n,x,y,c1,c2,c3,c4;
        c1=0;
        c2=0;
        c3=0;
        c4=0;
         System.out.print("Ingrese la cantidad de puntos a evaluar en los distintos cuadrantes 1,2,3 y 4:");
         n=teclado.nextInt();
         for( int i=1; i<=n; i++ ){
            System.out.print("Ingrese la coordenada x del punto numero "+i+" :");
            x=teclado.nextInt();
            System.out.print("Ingrese la coordenada y del punto numero "+i+" :");
            y=teclado.nextInt();
            if(x>=0){
                if(y>=0){
                c1++;
                }
                else{
                c4++;    
                }
            }
            else{
                if(y>=0){
                 c2++;
                 }
                 else{
                 c3++;    
                 }
            }
         }
        System.out.println("Cantidad de puntos en el cuadrante 1: "+c1);
        System.out.println("Cantidad de puntos en el cuadrante 2: "+c2);
        System.out.println("Cantidad de puntos en el cuadrante 3: "+c3);
        System.out.println("Cantidad de puntos en el cuadrante 4: "+c4);
        
    }
    
}
