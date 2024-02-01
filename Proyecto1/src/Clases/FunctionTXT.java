/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.concurrent.Semaphore;
import javax.swing.JOptionPane;

/**
 *
 * @author Ana Blanco
 */
public class FunctionTXT {

    public void leer_txt() {

        try {
            File archivo = new File("test\\Information.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);

            String info;
            String txt = "";

            while ((info = br.readLine()) != null) {

                if (!info.isEmpty() && !info.isBlank()) {
                    txt += info + "\n";

                }
            }
            fr.close();
            br.close();
            txt = txt.trim();
            System.out.println(txt);
            Semaphore Mainmutex = new Semaphore(1);
            String[] info1 = txt.split("Trabajadores");

            String[] tiempos = info1[0].split(",");
            String[] trabajadores = info1[1].split(",");
            

            int[] disney = {2, 1, 1, 4, 3}; // animaciones, escenarios, guiones, doblajes, plotTwist para ensamblaje
            int[] cartoon = {6, 2, 1, 5, 1};
            
            // CREACIÓN OBJETOS DISNEY
            Drive driveDisney = new Drive("Disney", disney[0], disney[1], disney[2], disney[3], disney[4], 2);
            Developer animadores = new Developer(0, Integer.parseInt(tiempos[1]), driveDisney, Mainmutex, "Disney", Integer.parseInt(trabajadores[1]));
            Developer disenadores = new Developer(1, Integer.parseInt(tiempos[1]), driveDisney, Mainmutex, "Disney", Integer.parseInt(trabajadores[3]));
            Developer guionistas = new Developer(2, Integer.parseInt(tiempos[1]), driveDisney, Mainmutex, "Disney", Integer.parseInt(trabajadores[5]));
            Developer actores = new Developer(3, Integer.parseInt(tiempos[1]), driveDisney, Mainmutex, "Disney", Integer.parseInt(trabajadores[7]));
            Developer plotTwist = new Developer(4, Integer.parseInt(tiempos[1]), driveDisney, Mainmutex, "Disney", Integer.parseInt(trabajadores[9]));
            Developer ensambladores = new Developer(5, Integer.parseInt(tiempos[1]), driveDisney, Mainmutex, "Disney", Integer.parseInt(trabajadores[11]));
//            Director director = new Director(driveDisney, );
//            Project_Manager manager = new Project_Manager();
//            Estudio disney = new Estudio();
            

            // CREACIÓN OBJETOS CARTOON
           

            
        } catch (Exception e) {
            System.out.println("No se pudo leer el txt");
        }

    }

    public void escribir_txt(Estudio estudio) {

        String guardar = "Duración,";

        guardar += estudio.getDuracion() + "\n";
        guardar += "Días,";
        guardar += estudio.getDeadline() + "\nTrabajadores\nGuionista,";
        guardar += Integer.toString(estudio.getGuionistas().getTrabajadores()) + "\nDiseñador,";
        guardar += Integer.toString(estudio.getDiseñadores().getTrabajadores()) + "\nAnimador,";
        guardar += Integer.toString(estudio.getAnimadores().getTrabajadores()) + "\nActores,";
        guardar += Integer.toString(estudio.getActores().getTrabajadores()) + "\nPlotTwist,";
        guardar += Integer.toString(estudio.getPlotTwist().getTrabajadores()) + "\nEnsambladores,";
        guardar += Integer.toString(estudio.getEnsambladores().getTrabajadores());

        try {
            PrintWriter pw = new PrintWriter("test\\Information.txt");
            pw.print(guardar);
            pw.close();
            JOptionPane.showMessageDialog(null, "Se ha guardado la información exitosamente!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No es posible guardar la información");
        }
    }

}
