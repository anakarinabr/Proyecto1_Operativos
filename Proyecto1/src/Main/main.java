/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Main;

import Clases.Estudio;
import java.util.concurrent.Semaphore;
import Clases.FunctionTXT;
import Interfaces.Global;
import Interfaces.Interfaz_principal;

/**
 *
 * @author Ana Blanco
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        FunctionTXT s = new FunctionTXT();
        try {
            Estudio[] estudios = s.leer_txt();
            Global global = new Global(estudios[0], estudios[1], s);
            Interfaz_principal principal = new Interfaz_principal(global);
            
            principal.setVisible(true);
        } catch (Exception e) {
            System.out.println("Algo fallo en la lectura de el archivo!!");
        }

//        int dayDuration = 3000;
//        Semaphore mainMutex = new Semaphore(1);
//        Drive drive = new Drive(2,1,1,4,3,2);
//
//        
//        Developer hilo1 = new Developer(0, dayDuration,"Jose", drive, mainMutex);
//        Developer hilo2 = new Developer(2, dayDuration,"Joaquin",drive, mainMutex);
//        Developer hilo3 = new Developer(3, dayDuration, "Jonas", drive, mainMutex);
//
//        hilo1.start();
//        hilo2.start();
//        hilo3.start();
    }
}
