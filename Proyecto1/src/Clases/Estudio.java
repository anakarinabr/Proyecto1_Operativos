/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author Ana Blanco
 */
public class Estudio extends Thread {
    
    
    private Drive drive;
    private Director director;
    private ProjectManager manager;
    private Developer guionistas;
    private Developer diseñadores;
    private Developer animadores;
    private Developer actores;
    private Developer plotTwist;
    private Developer ensambladores;
    private int duracion;
    private int deadline;
    private int gananciaTotal;   //Ganancia de los capitulos sin gastos
    private int costos;
    private int totaltrabajadores;
    private int maxtrabajadores;
//    De aqui para abajo, se utilizan para modificar los labels
    private boolean inicio;
    private JLabel guiones;
    private JLabel doblajes;
    private JLabel animaciones;
    private JLabel escenarios;
    private JLabel plotTwists;
    private JLabel Standar;
    private JLabel CapPlotTwist;
    private JLabel costoslabel;
    private JLabel gananciasLabel;
    private JLabel utilidadLabel;
    private JLabel descuento;

    public Estudio(int max, Drive drive, Director director, ProjectManager manager, Developer guionistas, Developer diseñadores, Developer animadores, Developer actores, Developer plotTwist, Developer ensambladores, int duracion, int deadline, int ganaciaStandar, int gananciaPlotTwist) {
       
        this.drive = drive;
        this.director = director;
        this.manager = manager;
        this.guionistas = guionistas;
        this.diseñadores = diseñadores;
        this.animadores = animadores;
        this.actores = actores;
        this.plotTwist = plotTwist;
        this.ensambladores = ensambladores;
        this.deadline = deadline; //dias en el txt
        this.duracion = duracion;
        this.costos = 0;
        this.gananciaTotal = 0;
        this.totaltrabajadores = guionistas.getTrabajadores() + diseñadores.getTrabajadores() + animadores.getTrabajadores() + actores.getTrabajadores() + plotTwist.getTrabajadores();
        this.maxtrabajadores = max;
        this.inicio = false;
        this.guiones = null;
        this.doblajes = null;
        this.animaciones = null;
        this.escenarios = null;
        this.plotTwists = null;
        this.Standar = null;
        this.CapPlotTwist = null;
        this.costoslabel = null;
        this.utilidadLabel = null;
        this.gananciasLabel = null;
        this.descuento =null;
    }

    @Override
    public void run() {
        while (true) {
            calcularCostos();
            calcularGanancia();
            if (this.costoslabel != null) {
                actualizarEstadisticas(this.costoslabel, this.utilidadLabel, this.gananciasLabel, this.descuento);

            }
            if (inicio) {
                actualizar(this.Standar, this.CapPlotTwist, this.guiones, this.doblajes, this.animaciones, this.escenarios, this.plotTwists);
            }
            try {
                sleep(this.duracion * 1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Estudio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void calcularCostos() {
        this.costos = this.animadores.getSalaryAcc() + this.diseñadores.getSalaryAcc() + this.guionistas.getSalaryAcc() + this.plotTwist.getSalaryAcc() + this.ensambladores.getSalaryAcc() + this.actores.getSalaryAcc() + this.director.getSalaryAcc() + this.director.getSalaryPMAcc();
    }

    public void calcularGanancia() {
        this.gananciaTotal = this.director.getGananciaAccEstudio();

    }

    public void actualizarEstadisticas(JLabel costos, JLabel utilidad, JLabel ganancias, JLabel descuento ) {
        costos.setText(Integer.toString(this.costos));
        utilidad.setText(Integer.toString((this.gananciaTotal*1000) - this.costos + Integer.parseInt(descuento.getText())));
    }

    public void llamarEstadisticas(JLabel costos, JLabel utilidad, JLabel ganancias, JLabel descuento) {
        this.costoslabel = costos;
        this.utilidadLabel = utilidad;
        this.gananciasLabel = ganancias;
        this.descuento = descuento;
    }

    public void actualizar(JLabel Standar, JLabel CapPlotTwist, JLabel guiones, JLabel doblajes, JLabel animaciones, JLabel escenarios, JLabel plotTwist1) {
        guiones.setText(Integer.toString(this.drive.getGuiones()));
        doblajes.setText(Integer.toString(this.drive.getDoblajes()));
        animaciones.setText(Integer.toString(this.drive.getAnimaciones()));
        escenarios.setText(Integer.toString(this.drive.getEscenarios()));
        plotTwist1.setText(Integer.toString(this.drive.getPlotTwist()));
        Standar.setText(Integer.toString(this.drive.getCapituloStandar()));
        CapPlotTwist.setText(Integer.toString(this.drive.getCapituloPlotTwist()));

    }

    public void llamar(JLabel Standar, JLabel plot, JLabel guiones, JLabel doblajes, JLabel animaciones, JLabel escenarios, JLabel plotTwists) {
        inicio = true;
        this.guiones = guiones;
        this.doblajes = doblajes;
        this.animaciones = animaciones;
        this.escenarios = escenarios;
        this.plotTwists = plotTwists;
        this.Standar = Standar;
        this.CapPlotTwist = plot;

    }

    // Getters and Setters
    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public ProjectManager getProducer() {
        return manager;
    }

    public void setProducer(ProjectManager manager) {
        this.manager = manager;
    }

    public Developer getGuionistas() {
        return guionistas;
    }

    public void setGuionistas(Developer guionistas) {
        this.guionistas = guionistas;
    }

    public Developer getDiseñadores() {
        return diseñadores;
    }

    public void setDiseñadores(Developer diseñadores) {
        this.diseñadores = diseñadores;
    }

    public Developer getAnimadores() {
        return animadores;
    }

    public void setAnimadores(Developer animadores) {
        this.animadores = animadores;
    }

    public Developer getActores() {
        return actores;
    }

    public void setActores(Developer actores) {
        this.actores = actores;
    }

    public Developer getPlotTwist() {
        return plotTwist;
    }

    public void setPlotTwist(Developer plotTwist) {
        this.plotTwist = plotTwist;
    }

    public Developer getEnsambladores() {
        return ensambladores;
    }

    public void setEnsambladores(Developer ensambladores) {
        this.ensambladores = ensambladores;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public int getTotaltrabajadores() {
        return totaltrabajadores;
    }

    public void setTotaltrabajadores(int totaltrabajadores) {
        this.totaltrabajadores = totaltrabajadores;
    }

    public int getMaxtrabajadores() {
        return maxtrabajadores;
    }

    public void setMaxtrabajadores(int maxtrabajadores) {
        this.maxtrabajadores = maxtrabajadores;
    }
}
