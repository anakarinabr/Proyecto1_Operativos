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
    }
}
