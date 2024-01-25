/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Clases;

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
        
        Developer hilo1 = new Developer("Hilo1", mainMutex);
        Developer hilo2 = new Developer("Hilo2", mainMutex);
        Developer hilo3 = new Developer("Hilo3", mainMutex);
        
        hilo1.start();
        hilo2.start();
        hilo3.start();
    
    }}
