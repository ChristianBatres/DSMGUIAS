/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.util.Scanner;

/**
 *
 * @author cbatr
 */
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        int n,valor,m,par,impar;
        par=0;
        impar=0;
         System.out.print("Ingrese la cantidad de numeros :");
         n=teclado.nextInt();
         for( int i=1; i<=n; i++ ){
            System.out.print("Ingrese el numero de la posicion "+i+" :");
            valor=teclado.nextInt();
            m=valor%2;
            if(m==0){
             par++;
             }
             else{
                impar++;
             }
         }
        System.out.println("Cantidad de numeros par: "+par);
        System.out.println("Cantidad de numeros impar: "+impar);
    }
    
}
