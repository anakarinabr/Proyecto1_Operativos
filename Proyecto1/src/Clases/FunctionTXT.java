/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.PrintWriter;
import javax.swing.JOptionPane;

/**
 *
 * @author Ana Blanco
 */
public class FunctionTXT {
    
    public void leer_txt(){
        
        
    
    }
    
    public void escribir_txt(Estudio estudio){
        
        String guardar = "Duración,";
        
        guardar += estudio.getDuracion() + "\n";
        guardar += "Días,";
        guardar += estudio.getDeadline() + "\nTrabajadores\nGuionista,";
        guardar += Integer.toString(estudio.getGuionistas().getTrabajadores())+ "\nDiseñador,";
        guardar += Integer.toString(estudio.getDiseñadores().getTrabajadores())+ "\nAnimador,";
        guardar += Integer.toString(estudio.getAnimadores().getTrabajadores())+ "\nActores,";
        guardar += Integer.toString(estudio.getActores().getTrabajadores())+ "\nPlotTwist,";
        guardar += Integer.toString(estudio.getPlotTwist().getTrabajadores())+ "\nEnsambladores,";
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
