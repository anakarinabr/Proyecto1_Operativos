/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.util.Random;

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
    private int ganancia; //ganancia por ser director
    private int gananciaAccCapitulos;
    private Drive drive;
    private int faltasCounter;
    private int gananciaCapitulos;
    private int gananciaCapituloPlotTwist;
    private int dayDuration;
    private String WorkStatus;

    public Director( int deadline, Drive drive, int gananciaCapitulosStandar, int gananciaCapitulosPlotTwist, int dayDuration, ProjectManager manager) {
        this.salary = 0;
        this.deadline = deadline;
        this.revisarManager = false;
        this.continuarTrabajando = true;
        this.ganancia = 60;
        this.gananciaAccCapitulos = 0;
        this.drive = drive;
        this.faltasCounter = 0;
        this.gananciaCapitulos = gananciaCapitulos;
        this.dayDuration = dayDuration;
        this.manager = manager;
        this.WorkStatus= "Trabajando";
    }


    
    @Override
    public void run() {
        long randomHour;
        long MinutosVigilandoPM = this.getMinutosVigilandoInMs();
        while(this.continuarTrabajando){
            try {
                if (this.deadline == 0){
                    enviarCapitulos(); //faltacrearla
                }else{
                    randomHour = this.getRandomHourInMs();
                    sleep(randomHour);
                    this.setRevisarManager(true);
                    verificarPM();
//                    WorkStatus.setText("trabajando");
                    long Dayrest = (long) (this.getDayInMs() - (randomHour + MinutosVigilandoPM));
                    this.getSalary();
                    sleep(Dayrest);
                
                }
                
                
            }catch(InterruptedException ex){
                
            }
        }
    }
    
    public void enviarCapitulos(){
//        try {
//            this.drive.setCapituloStandar(0);
//            
//        } catch (InterruptedException ex){
//            
//        }
        
    }
    
    
    
    public void verificarPM(){
        long MinutosVigilandoPM = getMinutosVigilandoInMs();
        if (isRevisarManager()){
//            WorkStatus.setText("Vigilando");
            if(!this.manager.getWorking()){
                try{
                    this.setRevisarManager(false);
                    this.manager.setSalaryAcc(this.manager.getSalaryAcc()-100);
                    this.manager.setSalarioDescontado(this.manager.getSalarioDescontado() + 100);
                    this.setFaltasCounter(this.getFaltasCounter() +1);
                    sleep(MinutosVigilandoPM);
                }catch (InterruptedException ex) {
                    //terminar catch
                }
            }else {
                try {
                    sleep(MinutosVigilandoPM);
                    this.setRevisarManager(false);
                } catch (InterruptedException ex){
                    //terminar catch
                }
            }
//            WorkStatus.setText("Trabajando");
        }
    }
    
    public long getRandomHourInMs(){
        long hourInMs = (long) (this.getDayInMs()/24);
        Random random = new Random();
        long randomHour = random.nextInt(24);
        return randomHour * hourInMs;
    }
    
    public int getDayInMs() {
        int dayDurationInMs = this.dayDuration * 1000;
        return dayDurationInMs;
    }
    
    public long getMinutosVigilandoInMs(){
        int dayInMinutes =1440;
        long MinutosVigilandoPM = (long) ((35 * this.dayDuration)/dayInMinutes); //14440000 es un dia en ms
        return MinutosVigilandoPM;         
    }
    
    
    
//  GETTERS AND SETTERS
    
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

  


//    public int getGanancia() {
//        return ganancia;
//    }
//
//    public void setGanancia(int ganancia) {
//        this.ganancia = ganancia;
//    }
//
//    public int getGananciaAccCapitulos() {
//        return gananciaAccCapitulos;
//    }
//
//    public void setGananciaAccCapitulos(int gananciaAccCapitulos) {
//        this.gananciaAccCapitulos = gananciaAccCapitulos;
//    }
//
//    public int getChaptersCreated() {
//        return chaptersCreated;
//    }
//
//    public void setChaptersCreated(int chaptersCreated) {
//        this.chaptersCreated = chaptersCreated;
//    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public int getFaltasCounter() {
        return faltasCounter;
    }

    public void setFaltasCounter(int faltasCounter) {
        this.faltasCounter = faltasCounter;
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


    
    
}
