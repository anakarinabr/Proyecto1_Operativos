/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.JLabel;

/**
 *
 * @author Ana Blanco
 */
public class ProjectManager extends Thread {

    private String WorkStatus;
    private int faltas;
    private int CantDescontada;
    private int salary;
    private int salaryAcc;
    private int salarioDescontado;
    private boolean working;
    private Drive drive;
    private int dayDuration;
    private int diasSobrantes;
    private int diasPasados;
    private int horas;
    private long mediahora;
    private JLabel label;

    public ProjectManager(Drive drive, int dayDuration) {
        this.WorkStatus = "Trabajando";
        this.faltas = 0;
        this.CantDescontada = 0;
        this.salary = 40;
        this.salaryAcc = 0;
        this.salarioDescontado = 100;
        this.working = true;
        this.drive = drive;
        this.dayDuration = dayDuration;
        this.diasPasados = 0;
        this.horas = 0;
        this.mediahora = 0;
        this.label = null;
    }

    @Override

    public void run() {
        while (true) {
            try {
                
                for (int i = 0; i <= 48; i++) {
                    valores();
                    this.horas++;
                    if (this.horas <= 32 && this.horas % 2 != 0 && working != true) {
                        
                        this.working = true;
                        this.WorkStatus = "Trabajando";
                        sleep(this.mediahora * 1000);
                    } else if (this.horas <= 32 && this.horas % 2 == 0 && working != false) {
                        
                        this.working = false;
                        this.WorkStatus = "Viendo anime";
                        sleep(this.mediahora * 1000);
                    } else if (this.horas > 32) {
                        this.working = true;
                        this.WorkStatus = "Trabajando";
                        sleep(this.mediahora * 1000);
                    }
                    if (this.label != null) {
                        actualizarlabel(this.label);
                    }
                }

                this.horas = 0;
                obtainSalary();

            } catch (Exception e) {
                System.out.println("Falló");
            }

        }
    }

    public void actualizarlabel(JLabel label) {
        label.setText(this.WorkStatus);
    }

    public void llamar(JLabel label) {
        this.label = label;
    }

    public void valores() {
        this.mediahora = (30 * this.dayDuration) / 1440;
    }

    public void obtainSalary() {
        this.salaryAcc += this.salary * 24;
    }

    public boolean getWorking() {
        return working;
    }

    public void setWorking(boolean working) {
        this.working = working;
    }

    public String getWorkStatus() {
        return WorkStatus;
    }

    public void setWorkStatus(String WorkStatus) {
        this.WorkStatus = WorkStatus;
    }

    public int getFaltas() {
        return faltas;
    }

    public void setFaltas(int Faltas) {
        this.faltas = Faltas;
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

    public int getDiasSobrantes() {
        return diasSobrantes;
    }

    public void setDiasSobrantes(int diasSobrantes) {
        this.diasSobrantes = diasSobrantes;
    }

    public int getDiasPasados() {
        return diasPasados;
    }

    public void setDiasPasados(int diasPasados) {
        this.diasPasados = diasPasados;
    }

}
