/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Semaphore;
import javax.swing.JLabel;

/**
 *
 * @author Ana Blanco
 */
public class Director extends Thread {

    private int salary;
    private int deadline;
    private boolean revisarManager;
    private boolean continuarTrabajando;
    private ProjectManager manager;
    private int ganancia; //ganancia por ser directo
    private Drive drive;
    private int gananciaCapitulos;
    private int gananciaCapituloPlotTwist;
    private int gananciaAccEstudio;
    private long dayDuration;
    private String WorkStatus;
    private int diasrestantes;
    private long onehour;
    private Semaphore mutex;
    private JLabel status;
    private JLabel descontadoManager;
    private JLabel faltalabel;
    private JLabel corte;

    public Director(int deadline, Drive drive, int gananciaCapitulosStandar, int gananciaCapitulosPlotTwist, long dayDuration, ProjectManager manager, Semaphore mutex) {
        this.salary = 0;
        this.deadline = deadline;
        this.revisarManager = false;
        this.ganancia = 60;
        this.drive = drive;
        this.gananciaCapitulos = gananciaCapitulos;
        this.gananciaCapituloPlotTwist = gananciaCapitulosPlotTwist;
        this.gananciaAccEstudio = 0;
        this.dayDuration = dayDuration;
        System.out.println("DAYDURATION "+ this.dayDuration);
        this.manager = manager;
        this.WorkStatus = "Trabajando";
        this.diasrestantes = deadline;
        this.onehour = 0;
        this.mutex = mutex;
        this.status = null;
        this.descontadoManager = null;
        this.faltalabel = null;
        this.corte = null;
    }

    @Override
    public void run() {
        long randomHour;
        while (true) {
            try {
                
                if (this.diasrestantes == 0) {
                    this.WorkStatus = "Enviando capitulos";

                    if (this.status != null) {
                        actualizarlabel(this.status, this.descontadoManager, this.faltalabel, this.corte);
                    }
                    enviarCapitulos();
                    this.diasrestantes = this.deadline;
                    sleep(this.dayDuration * 1000);
                } else {
                    valores();
                    randomHour = this.getRandomHour();
                    for (int i = 0; i < 24; i++) {
                        System.out.println("Random-------"+ randomHour);
                        System.out.println("i--------- "+ i);
                        if (randomHour == i) {
                            System.out.println("VIGILA");
                            this.setWorkStatus("Revisando Manager");
                            verificarPM();
                            if (this.status != null) {
                                System.out.println("ACTUALIZA");
                                actualizarlabel(this.status, this.descontadoManager, this.faltalabel, this.corte);
                            }
                            long revisar = (long) (this.onehour * 0.6);
                            sleep(revisar * 1000);
                            this.WorkStatus = "Trabajando";
                            long rest = (long) (this.onehour * 0.4);
                            sleep(rest * 1000);
                            if (this.status != null) {
                                actualizarlabel(this.status, this.descontadoManager, this.faltalabel, this.corte);
                            }
                            
                        } else {
                            this.WorkStatus = "Trabajando";
                            
                            if (this.corte != null) {
                                actualizarlabel(this.status, this.descontadoManager, this.faltalabel, this.corte);
                            }
                           sleep(this.onehour*1000);
                                                       
                        }

                    }
                   
                    this.diasrestantes--;
                }
                
            } catch (InterruptedException ex) {
                System.out.println("FALLO ALGO");
            }
        }
    }

    public void actualizarlabel(JLabel statusDirector, JLabel descontado, JLabel faltas, JLabel corte) {
        corte.setText(Integer.toString(this.diasrestantes));
        statusDirector.setText(this.WorkStatus);
        System.out.println(statusDirector.getText());
        descontado.setText(Integer.toString(this.manager.getSalarioDescontado()));
        faltas.setText(Integer.toString(this.manager.getFaltas()));
    }

    public void llamar(JLabel statusDirector, JLabel descontado, JLabel faltas, JLabel Corte) {
        this.setStatus(statusDirector);
        this.setDescontadoManager(descontado);
        this.setFaltalabel(faltas);
        this.setCorte(Corte);
    }

    public void valores() {
        this.onehour = (this.dayDuration) / 24;
    }

    public void enviarCapitulos() {
        try {
            this.mutex.acquire();
            this.gananciaAccEstudio += this.drive.getCapituloStandar() * this.gananciaCapitulos + this.drive.getCapituloPlotTwist() * this.gananciaCapituloPlotTwist;
            this.drive.setCapituloStandar(0);
            this.drive.setCapituloPlotTwist(0);
            this.mutex.release();
        } catch (Exception e) {
            System.out.println("Algo falló en enviar capitulos");
        }

    }

    public void verificarPM() {
        
        if (!this.manager.getWorking()) {
            System.out.println("Está viendo anime el manager");
            this.manager.setFaltas(this.manager.getFaltas() + 1);
            this.manager.setSalarioDescontado(this.manager.getFaltas() * 100);
        }else{
            System.out.println("Está trabajando");
        }
    }

    public long getRandomHour() {
        Random random = new Random();
        int randomHour = random.nextInt(25);
        return randomHour;
    }

//  GETTERS AND SETTERS
    public long getDayDuration() {
        return dayDuration;
    }

    public void setDayDuration(long dayDuration) {
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

    public boolean isRevisarManager() {
        return revisarManager;
    }

    public void setRevisarManager(boolean revisarManager) {
        this.revisarManager = revisarManager;
    }

    public boolean isContinuarTrabajando() {
        return continuarTrabajando;
    }

    public void setContinuarTrabajando(boolean continuarTrabajando) {
        this.continuarTrabajando = continuarTrabajando;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public void setStatus(JLabel status) {
        this.status = status;
    }

    public void setDescontadoManager(JLabel descontadoManager) {
        this.descontadoManager = descontadoManager;
    }

    public void setFaltalabel(JLabel faltalabel) {
        this.faltalabel = faltalabel;
    }

    public void setCorte(JLabel corte) {
        this.corte = corte;
    }

    public void setWorkStatus(String WorkStatus) {
        this.WorkStatus = WorkStatus;
    }
    
    
}
