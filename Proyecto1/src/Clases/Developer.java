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

    private String empresa;
    private int type;
    private int salaryAcc;
    private int dayDuration;
    private int salary;
    private Drive drive;
    private float acc;
    private Semaphore mutex;
    private float valor;
    private int trabajadores;
    

    public Developer(int type, int dayduration, Drive d, Semaphore m, String empresa, int trabajadores) {

        this.type = type;
        this.salaryAcc = 0;
        this.dayDuration = dayduration;
        this.drive = d;
        this.acc = 0;
        this.mutex = m;
        this.trabajadores = trabajadores;
        this.empresa = empresa;

        /* 
      Si type = 0, es un animador de personaje   igual
      Si type =1, es un disenador de escenarios  DISTINTO
      Si type =2, es un guionista                DISTINTOS
      Si type =3, es un actor de doblaje         IGUAL
      Si type =4, es Guionista de PlotTwist      DISTINTO
      Si type =5, es un ensamblador              igual
         */
        
        if (type == 0) {
            valor += 1;
        } else if (type == 1 && empresa.equalsIgnoreCase("Disney")) {
            valor += 0.34;
        } else if (type == 2 && empresa.equalsIgnoreCase("Disney")) {
            valor += 0.34;
        } else if (type == 3) {
            valor += 1;
        } else if (type == 4 && empresa.equalsIgnoreCase("Disney")) { 
            valor += 0.34;
        } else if (type == 5){
            valor += 0.5;
        } else if (type == 1 && empresa.equalsIgnoreCase("Cartoon")) {
            valor += 0.25;
        } else if (type == 2 && empresa.equalsIgnoreCase("Cartoon")) {
            valor += 0.25;
        } else if (type == 4 && empresa.equalsIgnoreCase("Cartoon")) { 
            valor += 0.5;
            
        }

        if (type == 0) {
            salary += 40;
        } else if (type == 1) {
            salary += 26;
        } else if (type == 2) {
            salary += 20;
        } else if (type == 3) {
            salary += 16;
        } else if (type == 4) {
            salary += 34;
        } else {
            salary += 50;
        }

        this.valor = valor;
        this.salary = salary;
    }

    @Override
    public void run() {
        while (true) {
            try {
                work();
                obtainSalary();
                sleep((this.dayDuration)*1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Developer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    public void obtainSalary() {
        this.salaryAcc += this.salary * 24 *this.trabajadores;
//        System.out.println(this.salaryAcc);
    }

    public void work() throws InterruptedException {

        this.acc += this.valor;
        if (this.acc >= 1 && this.type != 5) {
            try {
                this.mutex.acquire();//wait
                this.drive.addPart(this.type, this.trabajadores);//critica
                this.mutex.release();// signal
                this.acc = 0;

            } catch (InterruptedException ex) {
                Logger.getLogger(Developer.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if(type ==5) {
           try {
                this.mutex.acquire();//wait
                this.drive.assembler();//critica
                this.mutex.release();// signal
                this.acc = 0;

            } catch (InterruptedException ex) {
                Logger.getLogger(Developer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    //Getters and Setters

    public int getTrabajadores() {
        return trabajadores;
    }

    public void setTrabajadores(int trabajadores) {
        this.trabajadores = trabajadores;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getSalaryAcc() {
        return salaryAcc;
    }

    public void setSalaryAcc(int salaryAcc) {
        this.salaryAcc = salaryAcc;
    }

    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public float getAcc() {
        return acc;
    }

    public void setAcc(float acc) {
        this.acc = acc;
    }

    public Semaphore getMutex() {
        return mutex;
    }

    public void setMutex(Semaphore mutex) {
        this.mutex = mutex;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
}
