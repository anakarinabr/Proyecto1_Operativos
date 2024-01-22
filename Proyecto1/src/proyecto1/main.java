/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Ana Blanco
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Semaphore mainMutex = new Semaphore(1);
        
        Hilo hilo1 = new Hilo("Hilo1", mainMutex);
        Hilo hilo2 = new Hilo("Hilo2", mainMutex);
        Hilo hilo3 = new Hilo("Hilo3", mainMutex);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
    
    }}
