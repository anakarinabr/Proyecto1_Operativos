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
    private int contadorcap;
    private String name;

    public Drive(String name, int AnimacionesEnsamblaje, int EscenariosEnsamblaje, int GuionesEnsamblaje, int DoblajesEnsamblaje, int PlotTwistEnsamblaje, int cantidad) {
        this.animaciones = 0;
        this.escenarios = 0;
        this.guiones = 0;
        this.doblajes = 0;
        this.PlotTwist = 0;
        this.CapituloPlotTwist = 0;
        this.CapituloStandar = 0;
        this.AnimacionesEnsamblaje = AnimacionesEnsamblaje;
        this.EscenariosEnsamblaje = EscenariosEnsamblaje;
        this.GuionesEnsamblaje = GuionesEnsamblaje;
        this.DoblajesEnsamblaje = DoblajesEnsamblaje;
        this.PlotTwistEnsamblaje = PlotTwistEnsamblaje;
        this.cantidad = cantidad;
        this.contadorcap = 0;
        this.name = name;
    }

    public void addPart(int type, int cantidad) {

        switch (type) {
            case 0 -> {
                if (this.name.equalsIgnoreCase("Disney")) {
                    if (this.animaciones <= 55 && (this.animaciones + 2 * cantidad) <= 55) {
                        this.animaciones += 2 * cantidad;
                        System.out.println("animaciones disponibles:" + this.animaciones);
                    } else {
                        this.animaciones = 55;
                    }
                } else {
                    if (this.animaciones <= 55 && (this.animaciones + cantidad) <= 55) {
                        this.animaciones += cantidad;
                        System.out.println("animaciones disponibles:" + this.animaciones);
                    } else {
                        this.animaciones = 55;
                    }
                }
            }
            case 1 -> {
                if (this.escenarios <= 20 && (this.escenarios + cantidad) <= 20) {
                    this.escenarios += cantidad;
                    System.out.println("escenarios disponibles:" + this.escenarios);
                } else {
                    this.escenarios = 20;
                }
            }
            case 2 -> {
                if (this.guiones <= 25 && (this.guiones + cantidad) <= 25) {
                    this.guiones += cantidad;
                    System.out.println("guiones disponibles:" + this.guiones);
                } else {
                    this.guiones = 25;
                }
            }
            case 3 -> {
                if (this.name.equalsIgnoreCase("Disney")) {
                    if (this.doblajes <= 35 && (this.doblajes + 3 * cantidad) <= 35) {
                        this.doblajes += 3 * cantidad;
                        System.out.println("doblajes disponibles:" + this.doblajes);
                    } else {
                        this.doblajes = 35;
                    }
                }else{
                    if (this.doblajes <= 35 && (this.doblajes + 5 * cantidad) <= 35) {
                        this.doblajes += 5 * cantidad;
                        System.out.println("doblajes disponibles:" + this.doblajes);
                    } else {
                        this.doblajes = 35;
                    }
                }
            }
            default -> {
                if (this.PlotTwist <= 10 && (this.PlotTwist + cantidad) <= 10) {
                    this.PlotTwist += cantidad;
                    System.out.println("PlotTwist disponibles:" + this.PlotTwist);
                } else {
                    this.PlotTwist = 10;
                }
            }
        }
    }

    public void assembler() {

        if ((this.animaciones - this.AnimacionesEnsamblaje) >= 0 && (this.guiones - this.GuionesEnsamblaje) >= 0 && (this.escenarios - this.EscenariosEnsamblaje) >= 0 && (this.doblajes - this.DoblajesEnsamblaje) >= 0 && this.contadorcap < 2) {
            this.animaciones -= this.AnimacionesEnsamblaje;
            this.guiones -= this.GuionesEnsamblaje;
            this.escenarios -= this.EscenariosEnsamblaje;
            this.doblajes -= this.DoblajesEnsamblaje;
            this.CapituloStandar++;
            this.contadorcap++;
        } else if ((this.PlotTwist - this.PlotTwistEnsamblaje) >= 0 && (this.animaciones - this.AnimacionesEnsamblaje) >= 0 && (this.guiones - this.GuionesEnsamblaje) >= 0 && (this.escenarios - this.EscenariosEnsamblaje) >= 0 && (this.doblajes - this.DoblajesEnsamblaje) >= 0 && this.contadorcap > 2) {
            this.animaciones -= this.AnimacionesEnsamblaje;
            this.guiones -= this.GuionesEnsamblaje;
            this.escenarios -= this.EscenariosEnsamblaje;
            this.doblajes -= this.DoblajesEnsamblaje;
            this.PlotTwist -= this.PlotTwistEnsamblaje;
            this.CapituloPlotTwist++;
            this.contadorcap = 0;
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
