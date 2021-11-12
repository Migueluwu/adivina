/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.juego_adivinanza;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author miguel
 */
public class juego2 {
    
     private static int GeneraAleatorio(int a,int b) {
        int aleatorio;
         Random numAleatorio= new Random();
         aleatorio=numAleatorio.nextInt(b-a)+1;
         
         return aleatorio;
    }
     private static int TuNumero(int a,int b) {
         Scanner entradaTeclado = new Scanner(System.in);
         int eleccion=b+1;
         do {
             System.out.println("introduce un numero entre "+a+" y "+b);
            try {
                eleccion = entradaTeclado.nextInt();
            } catch (InputMismatchException ime) {
                System.out.println("Valor introducido no valido");
                entradaTeclado.nextLine();
            }
            if(eleccion <a || eleccion > b){
                System.out.println("Valor introducido no valido");
            }
        } while (eleccion <a || eleccion > b);
         return eleccion;
    }
     private static boolean MENOR(int a, int b) {
         return (a<b);
     }
    private static int NumeroMinimo() {
        Scanner entradaTeclado = new Scanner(System.in);
        int min=0;
        boolean seguir=false;
         do {
             System.out.println("Introduce el numero mas pequeño que puede ser generado");
            try {
                min = entradaTeclado.nextInt();
                seguir=true;
            } catch (InputMismatchException ime) {
                System.out.println("Valor introducido no valido");
                entradaTeclado.nextLine();
            }
            }while(seguir==false);
         return min;
         }
    
    
    private static int NumeroMaximo(int a) {
        Scanner entradaTeclado = new Scanner(System.in);
        int max=0;
        
         do {
             System.out.println("Introduce el numero mas grande que puede ser generado, "
                     + "tiene que ser mas grande que "+a);
            try {
                max = entradaTeclado.nextInt();
                
            } catch (InputMismatchException ime) {
                System.out.println("Valor introducido no valido");
                entradaTeclado.nextLine();
            }
            if(max<=a){
                System.out.println("El valor introducido es igual o mas pequqeño que eñ minimo");
            }
            }while(max<=a);
         return max;
         }
    
    public static void main(String[] args) {
        // TODO code application logic here
        final int NUMERO_INTENTOS=3;
        final int NUMERO_MAXIMO=15;
        final int NUMERO_MINIMO=0;
        
        int numeroMinimo=NumeroMinimo();
        
        int numeroMaximo=NumeroMaximo(numeroMinimo);
        int numAletorio= GeneraAleatorio(NUMERO_MINIMO, NUMERO_MAXIMO);
        int elegido;
        
        
        for(int i=1;i<=NUMERO_INTENTOS;i++){
            elegido=TuNumero(numeroMinimo, numeroMaximo);
            if(elegido==numAletorio){
                System.out.println("Has acertado");
                break;
            }else{
                System.out.println("Has fallado");
                if(MENOR(elegido,numAletorio)){
                    System.out.println("El numero generado es mas grande");
                }else{
                    System.out.println("El numero generado es mas pequeño");
                }
                if(i==NUMERO_INTENTOS){
                    System.out.println("Has Perdido");
                    System.out.println("el numero era "+numAletorio);
                }
                
            }
        }
        
        
    }
    
}
