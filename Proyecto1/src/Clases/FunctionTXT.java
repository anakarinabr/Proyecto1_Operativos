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
import javax.swing.JSpinner;

/**
 *
 * @author Ana Blanco
 */
public class FunctionTXT {

    public Estudio[] leer_txt() {

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
            
            Semaphore Mainmutex = new Semaphore(1);
            String[] info1 = txt.split("Trabajadores");

            String[] tiempos = info1[0].split(",");
            String[] trabajadores = info1[1].split(",");
            

            int[] disney = {2, 1, 1, 4, 3}; // animaciones, escenarios, guiones, doblajes, plotTwist para ensamblaje
            int[] cartoon = {6, 2, 1, 5, 1};
            String[] separacion = tiempos[1].split("\n");
       
            int duracion =Integer.parseInt(separacion[0]);
            
            String guionistas1 = trabajadores[1].split("\n")[0];
            String guionistas2 = trabajadores[2].split("\n")[0];
            String guionistas3 = trabajadores[3].split("\n")[0];
            String guionistas4 = trabajadores[4].split("\n")[0];
            String guionistas5 = trabajadores[5].split("\n")[0];
            String guionistas6 = trabajadores[6].split("\n")[0];
           
            
            // CREACIÓN OBJETOS DISNEY
            Drive driveDisney = new Drive("Disney", disney[0], disney[1], disney[2], disney[3], disney[4], 2);
            Developer animadores = new Developer(0, duracion, driveDisney, Mainmutex, "Disney", Integer.parseInt(guionistas3));
            Developer disenadores = new Developer(1, duracion, driveDisney, Mainmutex, "Disney", Integer.parseInt(guionistas2));
            Developer guionistas = new Developer(2, duracion, driveDisney, Mainmutex, "Disney", Integer.parseInt(guionistas1));
            Developer actores = new Developer(3, duracion, driveDisney, Mainmutex, "Disney", Integer.parseInt(guionistas4));
            Developer plotTwist = new Developer(4, duracion, driveDisney, Mainmutex, "Disney", Integer.parseInt(guionistas5));
            Developer ensambladores = new Developer(5, duracion, driveDisney, Mainmutex, "Disney", Integer.parseInt(guionistas6));
            
            String deadline = tiempos[2].split("\n")[0];
           
            ProjectManager manager = new ProjectManager(driveDisney, duracion);
            Director director = new Director( Integer.parseInt(deadline), driveDisney,250,600, duracion, manager);
            Estudio disney1 = new Estudio(driveDisney, director, manager, guionistas, disenadores, animadores,actores, plotTwist, ensambladores, duracion, Integer.parseInt(deadline),250, 600);
            
            // CREACIÓN OBJETOS CARTOON
            Semaphore MainmutexC = new Semaphore(1);
            Drive driveCartoon = new Drive("Cartoon", cartoon[0], cartoon[1], cartoon[2], cartoon[3], cartoon[4], 2);
            Developer animadoresC = new Developer(0, duracion, driveCartoon, MainmutexC, "Disney", Integer.parseInt(guionistas1));
            Developer disenadoresC = new Developer(1, duracion, driveCartoon, MainmutexC, "Disney", Integer.parseInt(guionistas2));
            Developer guionistasC = new Developer(2, duracion, driveCartoon, MainmutexC, "Disney", Integer.parseInt(guionistas3));
            Developer actoresC = new Developer(3, duracion, driveCartoon, MainmutexC, "Disney", Integer.parseInt(guionistas4));
            Developer plotTwistC = new Developer(4, duracion, driveCartoon, MainmutexC, "Disney", Integer.parseInt(guionistas5));
            Developer ensambladoresC = new Developer(5, duracion, driveCartoon, MainmutexC, "Disney", Integer.parseInt(guionistas6));
            ProjectManager managerC = new ProjectManager(driveCartoon, duracion);
            Director directorC = new Director( Integer.parseInt(deadline), driveDisney,300,650, duracion, manager);
            Estudio cartoon1 = new Estudio(driveCartoon, directorC, managerC, guionistasC, disenadoresC, animadoresC,actoresC, plotTwistC, ensambladoresC, duracion, Integer.parseInt(deadline),300, 650);
            
            Estudio[] estudios = {disney1, cartoon1};
            
            
//            // Inicialización de los hilos
////          Disney
//            animadores.start();
//            disenadores.start();
//            guionistas.start();
//            actores.start();
//            plotTwist.start();
//            ensambladores.start();
//            manager.start();
//            director.start();
//            
////          Cartoon
//            animadoresC.start();
//            disenadoresC.start();
//            guionistasC.start();
//            actoresC.start();
//            plotTwistC.start();
//            ensambladoresC.start();
//            managerC.start();
//            directorC.start();
//            
            return estudios;
            
        } catch (Exception e) {
            System.out.println("No se pudo leer el txt");
        }
        
        return null;

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

    public void leer_spinners(Estudio disney, Estudio cartoon, JSpinner jSpinnerDuracion, JSpinner jSpinnerDeadline, JSpinner jSpinnerAnimadoresDisney, JSpinner jSpinnerAnimadoresCartoon,JSpinner jSpinnerDisenadoresDisney, JSpinner jSpinnerDisenadoresCartoon, JSpinner jSpinnerActoresDisney, JSpinner jSpinnerActoresCartoon, JSpinner jSpinnerEnsambladoresDisney, JSpinner jSpinnerEnsambladoresCartoon, JSpinner jSpinnerGuionistaDisney, JSpinner jSpinnerGuionistasCartoon, JSpinner jSpinnerPlotTwistDisney, JSpinner jSpinnerPlotTwistCartoon){
        
        disney.setDuracion((int)jSpinnerDuracion.getValue());
        cartoon.setDuracion((int)jSpinnerDuracion.getValue());
        disney.setDeadline((int)jSpinnerDeadline.getValue());
        cartoon.setDeadline((int)jSpinnerDeadline.getValue());
        disney.getAnimadores().setTrabajadores((int)jSpinnerAnimadoresDisney.getValue());
        cartoon.getAnimadores().setTrabajadores((int)jSpinnerAnimadoresCartoon.getValue());
        disney.getDiseñadores().setTrabajadores((int)jSpinnerDisenadoresDisney.getValue());
        cartoon.getDiseñadores().setTrabajadores((int)jSpinnerDisenadoresCartoon.getValue());
        disney.getActores().setTrabajadores((int)jSpinnerActoresDisney.getValue());
        cartoon.getActores().setTrabajadores((int)jSpinnerActoresCartoon.getValue());
        disney.getEnsambladores().setTrabajadores((int)jSpinnerEnsambladoresDisney.getValue());
        cartoon.getEnsambladores().setTrabajadores((int)jSpinnerEnsambladoresCartoon.getValue());
        disney.getGuionistas().setTrabajadores((int)jSpinnerGuionistaDisney.getValue());
        cartoon.getGuionistas().setTrabajadores((int)jSpinnerGuionistasCartoon.getValue());
        disney.getPlotTwist().setTrabajadores((int)jSpinnerPlotTwistDisney.getValue());
        cartoon.getPlotTwist().setTrabajadores((int)jSpinnerPlotTwistCartoon.getValue());
       
        
    }
}
