/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ana Blanco
 */
public class Developer extends Thread {
 
     private String name;
    private int type;
    private float salaryAcc;
    private int dayDuration;
    private int salary = 30;
    private Drive drive;
    private float acc;
    private Semaphore mutex;
    
    public Developer(int type, int duration, String name, Drive d, Semaphore m){
      this.type = type;
      this.salaryAcc = 0;
      this.dayDuration = duration;
      this.name = name;
      this.drive = d;
      this.acc = 0;
      this.mutex = m;
    }
    
    
    @Override
    public void run(){
        while(true) {
            
            try {
                obtainSalary();
                work();
                System.out.println("Trabajador: "+ this.name + " gana: "+this.salaryAcc+"$");
                sleep(this.dayDuration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Developer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void obtainSalary(){
        this.salaryAcc += this.salary*24;
    }
    
    public void work(){
        this.acc += 0.34;
        if (this.acc >= 1){
            try {
                this.mutex.acquire(); //wait
                this.drive.addPart(this.type);//critica
                this.mutex.release();// signal
                this.acc = 0;
                
            } catch (InterruptedException ex) {
                Logger.getLogger(Developer.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
    }}
    

