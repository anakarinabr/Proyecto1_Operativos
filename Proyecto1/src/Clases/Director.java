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
    
    private Semaphore nuevo;
    private int salary;
    private int deadline;
    private boolean revisarManager;
    private int salaryPM;
    private int salaryPMAcc;
    private boolean continuarTrabajando;
    private ProjectManager manager;
    private int salaryAcc; // total del director
    private Drive drive;
    private int gananciaCapitulos;
    private int gananciaCapituloPlotTwist;
    private int gananciaAccEstudio;
    private long dayDuration;
    private boolean entro;
    private String WorkStatus;
    private int diasrestantes;
    private long onehour;
    private Semaphore mutex;
    private JLabel status;
    private JLabel descontadoManager;
    private JLabel faltalabel;
    private JLabel corte;
    private JLabel standar;
    private JLabel plot;
    private JLabel ganancias;

    public Director(Semaphore nuevo, int deadline, Drive drive, int gananciaCapitulosStandar, int gananciaCapitulosPlotTwist, long dayDuration, ProjectManager manager, Semaphore mutex) {
        this.nuevo =  nuevo;
        this.salaryAcc = 0;
        this.deadline = deadline;
        this.revisarManager = false;
        this.salary = 60;
        this.drive = drive;
        this.gananciaCapitulos = gananciaCapitulosStandar;
        this.gananciaCapituloPlotTwist = gananciaCapitulosPlotTwist;
        this.gananciaAccEstudio = 0;
        this.dayDuration = dayDuration;
        this.manager = manager;
        this.WorkStatus = "Trabajando";
        this.diasrestantes = deadline;
        this.salaryPM = 40;
        this.salaryPMAcc = 0;
        this.onehour = 0;
        this.mutex = mutex;
        this.status = null;
        this.descontadoManager = null;
        this.faltalabel = null;
        this.corte = null;
        this.standar = null;
        this.plot = null;
        this.ganancias = null;

    }

    @Override
    public void run() {
        long randomHour;
        while (true) {

            try {
                obtainSalary();
                calcularSalaryManager();
                if (this.diasrestantes == 0 ) {
                    this.WorkStatus = "Enviando capitulos";
                    entro = true;
                    if (this.status != null) {
                        actualizarlabel(this.plot,this.standar,this.status, this.descontadoManager, this.faltalabel, this.corte);
                    }
                    enviarCapitulos();
                    if (this.status != null) {
                        actualizarlabel(this.plot,this.standar,this.status, this.descontadoManager, this.faltalabel, this.corte);
                    }

                    this.diasrestantes = this.deadline;
                    sleep(this.dayDuration * 1000);
                } else {
                    
                    valores();
                    randomHour = this.getRandomHour();
                    for (int i = 0; i < 24; i++) {
                        if (randomHour == i) {

                            this.setWorkStatus("Revisando Manager");
                            verificarPM();
                            if (this.status != null) {
                                actualizarlabel(this.plot,this.standar,this.status, this.descontadoManager, this.faltalabel, this.corte);
                            }
                            long revisar = (long) (this.onehour * 0.6);

                            long tiempoEspera = Math.max(revisar, 1);
                            sleep(tiempoEspera * 1000);

                            this.WorkStatus = "Trabajando";
                            long rest = (long) (this.onehour * 0.4);

                            if (this.status != null) {
                                actualizarlabel(this.plot,this.standar,this.status, this.descontadoManager, this.faltalabel, this.corte);
                            }

                            long tiempoEspera1 = Math.max(revisar, this.dayDuration - 1);
                            sleep(tiempoEspera1 * 1000);

                        } else {
                            this.WorkStatus = "Trabajando";

                            if (this.corte != null) {
                                actualizarlabel(this.plot,this.standar,this.status, this.descontadoManager, this.faltalabel, this.corte);
                            }
                            sleep(this.onehour * 1000);

                        }

                    }

                    this.diasrestantes--;
                }

            } catch (InterruptedException ex) {
                System.out.println("FALLO ALGO");
            }
        }
    }
    
    public void obtainSalary() {
        this.salaryAcc += this.salary * 24 ;
    }
    
    public void calcularSalaryManager(){
        this.salaryPMAcc += this.salaryPM *24;
    }

    public void actualizarlabel(JLabel plot,JLabel standar,JLabel statusDirector, JLabel descontado, JLabel faltas, JLabel corte) {
        corte.setText(Integer.toString(this.diasrestantes));
        statusDirector.setText(this.WorkStatus);
        descontado.setText(Integer.toString(this.manager.getSalarioDescontado()));
        faltas.setText(Integer.toString(this.manager.getFaltas()));
        standar.setText(Integer.toString(this.drive.getCapituloStandar()));
        plot.setText(Integer.toString(this.drive.getCapituloPlotTwist()));
    }

    public void llamar(JLabel ganancias, JLabel plot1, JLabel statusDirector, JLabel descontado, JLabel faltas, JLabel Corte, JLabel standar) {
        this.setStatus(statusDirector);
        this.setDescontadoManager(descontado);
        this.setFaltalabel(faltas);
        this.setCorte(Corte);
        this.setStandar(standar);
        this.setPlot(plot1);
        this.ganancias = ganancias;
    }

    public void valores() {
        this.onehour = (this.dayDuration) / 24;
    }

    public void enviarCapitulos() {
        try {
//            this.mutex.acquire();
            this.gananciaAccEstudio += this.drive.getCapituloStandar() * this.gananciaCapitulos + this.drive.getCapituloPlotTwist() * this.gananciaCapituloPlotTwist;
            this.ganancias.setText(Integer.toString(this.gananciaAccEstudio*1000));  
            this.drive.setCapituloStandar(0);
            this.drive.setCapituloPlotTwist(0);
//            this.mutex.release();
        } catch (Exception e) {
            System.out.println("Algo falló en enviar capitulos");
        }

    }

    public void verificarPM() {

        if (!this.manager.getWorking()) {

            this.manager.setFaltas(this.manager.getFaltas() + 1);
            this.manager.setSalarioDescontado(this.manager.getFaltas() * 100);
        } else {

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

    public void setStandar(JLabel standar) {
        this.standar = standar;
    }

    public void setPlot(JLabel plot) {
        this.plot = plot;
    }

    public int getSalaryAcc() {
        return salaryAcc;
    }

    public int getGananciaAccEstudio() {
        return gananciaAccEstudio;
    }

    public int getSalaryPMAcc() {
        return salaryPMAcc;
    }
    
    
}
