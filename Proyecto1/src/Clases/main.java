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

        int dayDuration = 3000;
        Semaphore mainMutex = new Semaphore(1);
        Drive drive = new Drive();

        Developer hilo1 = new Developer(0, dayDuration,"Jose", drive, mainMutex);
        Developer hilo2 = new Developer(2, dayDuration,"Joaquin",drive, mainMutex);
        Developer hilo3 = new Developer(3, dayDuration, "Jonas", drive, mainMutex);

        hilo1.start();
        hilo2.start();
        hilo3.start();

    }
}
