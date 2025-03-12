package org.example;

import java.util.List;
import java.util.Random;

public class CabinasTelefonicas {
    //variables

    private String nonbre;
    private int llamadasRealizadas;
    private int duracioTotal;
    private double costoTotal;
    private int llamadaLocal = 50;
    private int llamadaDidtancia = 350;
    private int llamadaCelular = 150;

    // contructores


    public CabinasTelefonicas() {
    }

    public CabinasTelefonicas(String nonbre) {
        this.nonbre = nonbre;
        this.llamadasRealizadas = 0;
        this.duracioTotal = 0;
        this.costoTotal = 0.0;
        this.llamadaLocal = llamadaLocal;
        this.llamadaDidtancia = llamadaDidtancia;
        this.llamadaCelular = llamadaCelular;
    }

   /* public CabinasTelefonicas(String nonbre, int llamadasRealizadas, int duracioTotal, double costoTotal, int llamadaLocal, int llamadaDidtancia, int llamadaCelular) {
        this.nonbre = nonbre;
        this.llamadasRealizadas = llamadasRealizadas;
        this.duracioTotal = duracioTotal;
        this.costoTotal = costoTotal;
        this.llamadaLocal = llamadaLocal;
        this.llamadaDidtancia = llamadaDidtancia;
        this.llamadaCelular = llamadaCelular;
    }*/
    // metodos get y set


    public String getNonbre() {
        return nonbre;
    }

    public void setNonbre(String nonbre) {
        this.nonbre = nonbre;
    }

    public int getLlamadasRealizadas() {
        return llamadasRealizadas;
    }

    public void setLlamadasRealizadas(int llamadasRealizadas) {
        this.llamadasRealizadas = llamadasRealizadas;
    }

    public int getDuracioTotal() {
        return duracioTotal;
    }

    public void setDuracioTotal(int duracioTotal) {
        this.duracioTotal = duracioTotal;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }

    // metodos
    public void registrarLlamada(String tipo){
        Random aleatorio = new Random();
        // la duracion sera entre 0 y 60 segundos
        int duracion = aleatorio.nextInt(61);
        int duracionMinuto = duracion / 60;

        double costo = 0.0;
        switch (tipo){
            case "local":
                costo = duracionMinuto * llamadaLocal;
                break;
            case "larga Distancia"   :
                costo = duracionMinuto * llamadaDidtancia;
                break;
            case "celular":
                costo = duracionMinuto * llamadaCelular;
                break;
            default:
                System.out.println("El tipo de llamada es no valida");
                return;
        }

        llamadasRealizadas ++;
        duracioTotal += duracionMinuto;
        costoTotal += costo;

        System.out.println("Las llamadas registradas son de tipo:" + tipo +"con una duracion de " + duracionMinuto + "minutos  y un costo de: "+ costo );

    }

    public  void mostrarInformacion(){
        System.out.println("cabina" + nonbre);
        System.out.println("Numero de llamadas realizadas" + llamadasRealizadas);
        System.out.println("Duracion total de las llamadas son de :" +duracioTotal + "minutos" );
        System.out.println("El costo total de las llamdas fue de : " + costoTotal);

    }

   public static void mostrarConsolidado(List<CabinasTelefonicas> cabinas){
        int totalLlamadas = 0;
        int totalDuracion = 0;
        double totalCosto = 0;
        // se recorre todas las cabinas acomulando la informacion encontrada
        for(CabinasTelefonicas cabina: cabinas){

            totalLlamadas += cabina.getLlamadasRealizadas();
            totalDuracion += cabina.getDuracioTotal();
            totalCosto += cabina.getCostoTotal();
        }
        System.out.println("El consolidado total es:");
        System.out.println("Numero total de llamadas realizadas son: "+ totalLlamadas);
        System.out.println("La duracion total de las llamadas son " + totalDuracion + " minutos");
        System.out.println("El costo total de las llamadas fue de : " + totalCosto);
    }
    public void reiniciarcabina(){
        llamadasRealizadas = 0;
        duracioTotal = 0;
        costoTotal = 0.0;
        System.out.println("La cabina " + " " + nonbre+ " se ha reiniciado");
    }
    public static CabinasTelefonicas buscarCabina(List<CabinasTelefonicas> cabinas,String nonbre){
        for(CabinasTelefonicas cabina: cabinas){
            if(cabina.getNonbre().equalsIgnoreCase(nonbre)){
                return cabina; // retorne la cabina si la llega a encontrar
            }

        }
        return null; // si no encuentra la cabina retorna null
    }


}
