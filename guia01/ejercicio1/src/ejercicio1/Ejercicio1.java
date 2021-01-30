/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejercicio1;
import java.util.Scanner;
/**
 *
 * @author cbatr
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner teclado = new Scanner(System.in);
        int n1,n2,m;
        System.out.print("Ingrese el primer numero: ");
        n1=teclado.nextInt();
        System.out.print("Ingrese el segundo numero: ");
        n2=teclado.nextInt();
        m=n1%n2;
        if(m==0){
            System.out.println("Son divisibles");
        }
        else{
            System.out.println("No son divisibles");
        }
    }
    
}
