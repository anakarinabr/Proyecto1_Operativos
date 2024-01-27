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
    private int salary;
    private Drive drive;
    private float acc;
    private Semaphore mutex;
    private float valor;

    public Developer(int type, int duration, String name, Drive d, Semaphore m) {

        this.type = type;
        this.salaryAcc = 0;
        this.dayDuration = duration;
        this.name = name;
        this.drive = d;
        this.acc = 0;
        this.mutex = m;

        /* 
      Si type = 0, es un animador de personaje
      Si type =1, es un disenador de escenarios
      Si type =2, es un guionista
      Si type =3, es un actor de doblaje 
      Si type =4, es Guionista de PlotTwist
      Si type =5, es un ensamblador
         */
        if (type == 0) {
            valor += 1;
        } else if (type == 1) {
            valor += 0.34;
        } else if (type == 2) {
            valor += 0.34;
        } else if (type == 3) {
            valor += 1;
        } else if (type == 4) {
            valor += 0.5;
        } else {
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
        int variable = 0;
        while (true) {
            variable++;
            try {
                work();
                sleep(this.dayDuration);
            } catch (InterruptedException ex) {
                Logger.getLogger(Developer.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("Día: " + variable);
        }
    }

    public void obtainSalary() {
        this.salaryAcc += this.salary * 24;
    }

    public void work() throws InterruptedException {

        this.acc += this.valor;
        if (this.acc >= 1 && this.type != 5) {
            try {
                this.mutex.acquire();//wait
                this.drive.addPart(this.type);//critica
                this.mutex.release();// signal
                this.acc = 0;

            } catch (InterruptedException ex) {
                Logger.getLogger(Developer.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
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
}
