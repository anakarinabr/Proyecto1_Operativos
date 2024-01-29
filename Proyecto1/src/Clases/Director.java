/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Ana Blanco
 */
public class Director extends Thread {
    
    private int salary;
    private int dayCounter;
    private String workStatus;
    private int ganancia; //ganancia por capítulo
    private int gananciaAccCapitulos; 
    private int chaptersCreated;
    private Drive drive;
    private int faltasCounter;
    private final int gananciaCapitulos;

    public Director(int dayCounter, String workStatus, int gananciaAccCapitulos, int gananciaCapitulos, int chaptersCreated, Drive drive, int faltasCounter) {
        this.salary = 0;
        this.dayCounter = dayCounter;
        this.workStatus = workStatus;
        this.gananciaAccCapitulos = gananciaAccCapitulos;
        this.gananciaCapitulos = gananciaCapitulos;
        this.chaptersCreated = chaptersCreated;
        this.drive = drive;
        this.faltasCounter = faltasCounter;
    }

    
    public void checkCounter(){
        
        if (dayCounter == 0){
            this.chaptersCreated = 0;         
        }else{
//            dayCounter <= 1
//            random fron 1 to 24 checkPM
//            if PM workStatus != trabajando
//                    salaryacc = -100
        }
  
    }
    
   
    
    
}
