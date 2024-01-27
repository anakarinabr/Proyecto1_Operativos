/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Ana Blanco
 */
public class Drive {
    
    private int animaciones;
    private int escenarios;
    private int guiones;
    private int doblajes;
    private int PlotTwist;
    private int CapituloStandar;
    private int CapituloPlotTwist;
    
    
    public Drive(){
        this.animaciones = 0;
        this.escenarios = 0;
        this.guiones = 0;
        this.doblajes = 0;
        this.PlotTwist = 0;
        this.CapituloPlotTwist = 0;  //Esto no se si se va a quedar así
        this.CapituloStandar = 0;
    }
    
    public void addPart(int type){
        
        switch (type) {
            case 0 -> {
                this.animaciones += 2;
                System.out.println("animaciones disponibles:" + this.animaciones);
            }
            case 1 -> {
                this.escenarios += 1;
                System.out.println("escenarios disponibles:" + this.escenarios);
            }
            case 2 -> {
                this.guiones += 1;
                System.out.println("guiones disponibles:" + this.guiones);
            }
            case 3 -> {
                this.doblajes += 5;
                System.out.println("doblajes disponibles:" + this.doblajes);
            }
            default -> {
                this.PlotTwist += 1;
                System.out.println("PlotTwist disponibles:" + this.PlotTwist);
            }
        }
    }
    
    // GETTERS AND SETTERS
    public int getAnimaciones() {
        return animaciones;
    }

    public void setAnimaciones(int animaciones) {
        this.animaciones = animaciones;
    }

    public int getEscenarios() {
        return escenarios;
    }

    public void setEscenarios(int escenarios) {
        this.escenarios = escenarios;
    }

    public int getGuiones() {
        return guiones;
    }

    public void setGuiones(int guiones) {
        this.guiones = guiones;
    }

    public int getDoblajes() {
        return doblajes;
    }

    public void setDoblajes(int doblajes) {
        this.doblajes = doblajes;
    }

    public int getPlotTwist() {
        return PlotTwist;
    }

    public void setPlotTwist(int PlotTwist) {
        this.PlotTwist = PlotTwist;
    }

    public int getCapituloStandar() {
        return CapituloStandar;
    }

    public void setCapituloStandar(int CapituloStandar) {
        this.CapituloStandar = CapituloStandar;
    }

    public int getCapituloPlotTwist() {
        return CapituloPlotTwist;
    }

    public void setCapituloPlotTwist(int CapituloPlotTwist) {
        this.CapituloPlotTwist = CapituloPlotTwist;
    }
    
}
