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
    private int AnimacionesEnsamblaje;
    private int EscenariosEnsamblaje;
    private int GuionesEnsamblaje;
    private int DoblajesEnsamblaje;
    private int PlotTwistEnsamblaje;
    private int cantidad;
    
    
    public Drive(int AnimacionesEnsamblaje, int EscenariosEnsamblaje,int GuionesEnsamblaje, int DoblajesEnsamblaje, int PlotTwistEnsamblaje, int cantidad){
        this.animaciones = 0;
        this.escenarios = 0;
        this.guiones = 0;
        this.doblajes = 0;
        this.PlotTwist = 0;
        this.CapituloPlotTwist = 0;  //Esto no se si se va a quedar así
        this.CapituloStandar = 0;
        this.AnimacionesEnsamblaje = AnimacionesEnsamblaje;
        this.EscenariosEnsamblaje = EscenariosEnsamblaje;
        this.GuionesEnsamblaje = GuionesEnsamblaje;
        this.DoblajesEnsamblaje = DoblajesEnsamblaje;
        this.PlotTwistEnsamblaje = PlotTwistEnsamblaje;
        this.cantidad = cantidad;
    }
    
    public void addPart(int type){
        
        switch (type) {
            case 0 -> {
                if (this.animaciones <= 55){
                this.animaciones += 2;
                System.out.println("animaciones disponibles:" + this.animaciones);
                }
            }
            case 1 -> {
                if(this.escenarios <= 20){
                this.escenarios += 1;
                System.out.println("escenarios disponibles:" + this.escenarios);
                }
            }
            case 2 -> {
                if(this.guiones <= 25 ){
                this.guiones += 1;
                System.out.println("guiones disponibles:" + this.guiones);
                }
            }
            case 3 -> {
                if(this.doblajes <= 35){
                this.doblajes += 5;
                System.out.println("doblajes disponibles:" + this.doblajes);
                }
            }
            default -> {
                if(this.PlotTwist <= 10){
                this.PlotTwist += 1;
                System.out.println("PlotTwist disponibles:" + this.PlotTwist);
                }
            }
        }
    }
    
    public void assembler(){
        
        
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
