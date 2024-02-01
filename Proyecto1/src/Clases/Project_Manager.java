/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

/**
 *
 * @author Ana Blanco
 */
public class Project_Manager extends Thread {
    
    private int dayCounter;
    private int dayDuration;
    private String workStatus;
    private int salary;
    private int salaryAcc;

    public Project_Manager(int dayCounter, int dayDuration, String workStatus, int salaryAcc) {
        this.dayCounter = dayCounter;
        this.dayDuration = dayDuration;
        this.workStatus = workStatus;
        this.salary = 40;
        this.salaryAcc = salaryAcc;
    }

    public void workingHours() throws InterruptedException{
        
        for (int i = 0; i< 30; i++){
            this.setWorkStatus("Viendo anime");
        }this.setWorkStatus("Trabajando");
           
    }
    
    public int getDayCounter() {
        return dayCounter;
    }

    public void setDayCounter(int dayCounter) {
        this.dayCounter = dayCounter;
    }

    public int getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(int dayDuration) {
        this.dayDuration = dayDuration;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
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
    
    
    
    
}
