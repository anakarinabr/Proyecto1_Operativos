/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto1;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Ana Blanco
 */
public class Hilo extends Thread {
 
    private String msg;
    private Semaphore mutex;
    
    public Hilo(String msg, Semaphore mutex){
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
    
}
