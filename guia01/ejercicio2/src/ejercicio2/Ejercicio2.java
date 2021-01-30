/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio2;

import java.util.Scanner;

/**
 *
 * @author cbatr
 */
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         Scanner teclado = new Scanner(System.in);
        int n,nota, ma, me;
        ma=0;
        me=0;
        n=0;
         for( int i=0; i<=9; i++ ){
             n=i+1;
            System.out.print("Ingrese la nota "+n+" :");
            nota=teclado.nextInt();
            if(nota>=7){
            ma++;
            }
            else{
            me++;
            }
         }
        System.out.println("Cantidad de notas Mayores o iguales que 7: "+ma);
        System.out.println("Cantidad de notas Menores que 7: "+me);
    }
    
}
