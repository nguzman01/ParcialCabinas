package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        List<CabinasTelefonicas> cabinas = new ArrayList<>();
        Scanner teclado = new Scanner(System.in);
        String opcion;

        do {
            System.out.println("Menu");
            System.out.println("1. Crear Cabina");
            System.out.println("2. Escoger cabina y registrar una llamada de acuedo con la cabina");
            System.out.println("3. Mostrar la informacion detallada por cabina");
            System.out.println("4. Mostar un consolidado total de todas las cabinas");
            System.out.println("5. Reiniciar ");
            System.out.println("6. Salir");
            opcion = teclado.nextLine();

            switch (opcion){

                case "1":
                    System.out.println("Ingrese el nombre de la cabina");
                    String nombreCabina = teclado.nextLine();
                    cabinas.add(new CabinasTelefonicas(nombreCabina));
                    System.out.println("La cabina llamada :" + " " + nombreCabina + " " + ",se creo exitosamente" );
                    break;
                case "2":
                    System.out.println("Ingrese el nombre de la cabina");
                    String nombre = teclado.nextLine();
                    CabinasTelefonicas cabina = CabinasTelefonicas.buscarCabina(cabinas, nombre);
                    if(cabina != null){
                        System.out.println("Ingresar el tipo de llamada (local/larga/celular):");
                        String tipoLlamada = teclado.nextLine();
                        cabina.registrarLlamada(tipoLlamada);
                    }else {
                        System.out.println("La cabina no fue encontrada");
                    }
                    break;
                case "3":
                    System.out.println("Ingrese el nombre de la cabina");
                    String nombreInfor = teclado.nextLine();
                    CabinasTelefonicas cabinaInfor = CabinasTelefonicas.buscarCabina(cabinas, nombreInfor);
                    if(cabinaInfor != null){
                        cabinaInfor.mostrarInformacion();
                    }else{
                        System.out.println("La cabina no fue encontrada");
                    }
                    break;

                case "4":
                    CabinasTelefonicas.mostrarConsolidado(cabinas);
                    break;
                case "5":
                    System.out.println("Ingrese el nombre de la cabina");
                    String nombreReinicio = teclado.nextLine();
                    CabinasTelefonicas cabinaReinicio = CabinasTelefonicas.buscarCabina (cabinas, nombreReinicio);
                    if(cabinaReinicio != null){
                        cabinaReinicio.reiniciarcabina();
                    }else{
                        System.out.println("La cabina no fue encontrada");
                    }
                    break;
                case "6":
                    System.out.println("Saliste ");
                    break;

                default:
                    System.out.println("Opcion no validad vuelva a intentarlo");
                    break;
            }


        } while (opcion != "6");

        teclado.close();



    }

}