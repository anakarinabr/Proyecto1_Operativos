/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interfaces;

import Clases.Estudio;
import Clases.FunctionTXT;

/**
 *
 * @author Ana Blanco
 */
public class Global {
    
    private Estudio disney;
    private Estudio Cartoon;
    private FunctionTXT s;

    public Global(Estudio disney, Estudio Cartoon, FunctionTXT s) {
        this.disney = disney;
        this.Cartoon = Cartoon;
        this.s = s;
    }

    public Estudio getDisney() {
        return disney;
    }

    public Estudio getCartoon() {
        return Cartoon;
    }

    public FunctionTXT getS() {
        return s;
    }
    
    
    
    
    
}
