/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Ana Blanco
 */
public class Developer extends Thread {
 
    private String msg;
    private Semaphore mutex;
    
    public Developer(String msg, Semaphore mutex){
        this.msg = msg;
        this.mutex = mutex;
    }
    
    @Override
    public void run(){
        while(true){
            try{
                mutex.acquire(); //wait
                
                System.out.println(msg); // sección crítica
                sleep(500);
                
                mutex.release(); //signal
                sleep(1000);
                
            }catch(Exception e){
                System.out.println("Falló");
            }
        
        }
    }
    
    public void obtainSalary(){
        
        
    }}
    

