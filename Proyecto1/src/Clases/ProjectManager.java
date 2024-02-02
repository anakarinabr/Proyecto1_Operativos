/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.JTextField;

/**
 *
 * @author Ana Blanco
 */
public class ProjectManager extends Thread {
    javax.swing.JTextField WorkStatus;
    javax.swing.JTextField Faltas;
    javax.swing.JTextField CantDescontada;
    private int salary;
    private int salaryAcc;
    private int salarioDescontado;
    private int contadorFaltas;
    private boolean working;
    private Drive drive;
    private int dayDuration;

    public ProjectManager(JTextField WorkStatus, JTextField Faltas, JTextField CantDescontada, int salary, int salaryAcc, int salarioDescontado, int contadorFaltas, boolean working, Drive drive, int dayDuration) {
        this.WorkStatus = WorkStatus;
        this.Faltas = Faltas;
        this.CantDescontada = CantDescontada;
        this.salary = 40;
        this.salaryAcc = salaryAcc;
        this.salarioDescontado = salarioDescontado;
        this.contadorFaltas = contadorFaltas;
        this.working = false;
        this.drive = drive;
        this.dayDuration = dayDuration;
    }

    
    public boolean getWorking() {
        return working;
    }
    
    public void setWorking (boolean working) {
        this.working = working;
    }
      
    public int getDayDurationInMs() {
        int dayDurationInMs = this.dayDuration * 1000;
        return dayDurationInMs;
    }

    public JTextField getWorkStatus() {
        return WorkStatus;
    }

    public void setWorkStatus(JTextField WorkStatus) {
        this.WorkStatus = WorkStatus;
    }

    public JTextField getFaltas() {
        return Faltas;
    }

    public void setFaltas(JTextField Faltas) {
        this.Faltas = Faltas;
    }

    public JTextField getCantDescontada() {
        return CantDescontada;
    }

    public void setCantDescontada(JTextField CantDescontada) {
        this.CantDescontada = CantDescontada;
    }


    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getSalaryAcc() {
        return salaryAcc;
    }

    public void setSalaryAcc(int salaryAcc) {
        this.salaryAcc = salaryAcc;
    }

    public int getSalarioDescontado() {
        return salarioDescontado;
    }

    public void setSalarioDescontado(int salarioDescontado) {
        this.salarioDescontado = salarioDescontado;
    }

    public int getContadorFaltas() {
        return contadorFaltas;
    }

    public void setContadorFaltas(int contadorFaltas) {
        this.contadorFaltas = contadorFaltas;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }
    
    
    
}
