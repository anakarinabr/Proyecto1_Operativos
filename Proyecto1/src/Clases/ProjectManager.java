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
    private int diasSobrantes;
    private int diasPasados;

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
        this.diasPasados = 0;
    }

    @Override
        
    public void run() {
        while(true) {
                try {      
            for (int i = 0; i < 32; i++) {
                //es 32 porque en 16 horas cambia su modo de trabajo 32 veces
            }
            if (working){
                setWorking(false);
            }else{ 
                setWorking(true);
            }
            this.salarioDescontado = cantDescontada; 
            this.salaryAcc =(- salarioDescontado + this.salaryAcc);
                if (working) {
                    WorkStatus.setText("Trabajando");
                }else{
                    WorkStatus.setText("Viendo Anime");
                }
            Faltas.setText(String.valueOf(faltas));
            CantDescontada.setText(String.valueOf(discountedSalary));

            sleep(getMinutosTrabajandoInMs());
            }
                    setWorking(true);
                    this.setDiasSobrantes(this.getDiasSobrantes()-1);
                    this.setDiasPasados(this.getDiasPasados()+1);
                    this.salary();
                    sleep(HorasRestantes());
                } catch (InterruptedException ex) {
                    //terminar catch
            }
                
        }
    
    public int Horasrestantes(){
        int HorasRestantes = this.getDayDurationInMs() - getMinutosTrabajandoInMs();
        return HorasRestantes;
        
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
    
    public int getMinutosTrabajandoInMs() {
        int dayInHours = 24;
        int sixteenHours =  (((16 * this.getDayDurationInMs())/dayInHours)/32);
        return sixteenHours;
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
