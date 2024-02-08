/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Ana Blanco
 */
public class Estudio {
    
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
    private int gananciaStandar;
    private int gananciaPlotTwist;
    private int gananciaTotal;
    private int totaltrabajadores;
    private int maxtrabajadores;
    

    public Estudio(int max, Drive drive, Director director, ProjectManager manager, Developer guionistas, Developer diseñadores, Developer animadores, Developer actores, Developer plotTwist, Developer ensambladores, int duracion, int deadline,  int ganaciaStandar, int gananciaPlotTwist) {
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
        this.gananciaPlotTwist = gananciaPlotTwist;
        this.gananciaStandar = gananciaStandar;
        this.gananciaTotal = 0;
        this.totaltrabajadores = guionistas.getTrabajadores()+diseñadores.getTrabajadores()+animadores.getTrabajadores()+actores.getTrabajadores()+plotTwist.getTrabajadores();
        this.maxtrabajadores = max;
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
