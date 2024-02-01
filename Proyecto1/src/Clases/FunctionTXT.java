/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
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
