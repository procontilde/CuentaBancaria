package com.politecnicomalaga.entidadbancaria;

import com.google.gson.Gson;
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainCuentaBancaria {

    private static Scanner miScan = new Scanner(System.in);
    private static Cliente miCliente = new Cliente("", "", "", null);
    private static Cuenta miCuenta = new Cuenta("0000", 0, "NADA", miCliente);
    private static Documento miDoc = new Documento("", "");

    public static void main(String[] args) {

        char option;

        do {

            System.out.print("Seleccione una opción: \n\n"
                    + "a. Empezar \n"
                    + "b. Salir");
            option = Character.toLowerCase(miScan.nextLine().charAt(0));

            switch (option) {

                case 'a':

                    menuEmpezar(miCuenta);
                    break;

                case 'b':

                    System.out.println("Saliendo del programa...");
                    break;

                default:

                    System.out.println("Introduzca una opción válida.");
                    break;

            }

        } while (option != 'b');

    }

    public static void menuEmpezar(Cuenta miCuenta) {
        char option;

        do {

            System.out.println("Menu Empezar:\n\n"
                    + "Seleccione una opción: \n"
                    + "a. Dar datos de la cuenta\n"
                    + "b. Cargar Cliente de la cuenta desde fichero JSON \n"
                    + "c. Realizar ingreso efectivo\n"
                    + "d. Realizar retirada efectivo\n"
                    + "e. Grabar cuenta a fichero JSON\n"
                    + "f. Cargar cuenta desde fichero JSON\n"
                    + "g. Exportar datos a texto (toString) hacia pantalla y fichero\n"
                    + "h. Salir");
            option = Character.toLowerCase(miScan.nextLine().charAt(0));

            switch (option) {

                case 'a':

                    try {

                        System.out.println("Introduzca los datos de la cuenta: \n" + "CCC: \n");
                        String ccc = miScan.nextLine();
                        System.out.print("SALDO: ");
                        float saldo = Float.valueOf(miScan.nextLine());
                        System.out.print("FECHA DE APERTURA: ");
                        String fecha = miScan.nextLine();
                        miCuenta.setCcc(ccc);
                        miCuenta.setSaldo(saldo);
                        miCuenta.setFechaApertura(fecha);

                        System.out.println("Cliente añadido correctamente.");

                    } catch (InputMismatchException i) {

                        i.getMessage();

                    }

                    break;

                case 'b':

                    System.out.println("Introduzca el path del JSON: ");
                    String path = miScan.nextLine();
                    miCliente = readJsonCliente(path);
                    miCuenta.setMiCliente(miCliente);
                    break;

                case 'c':

                    System.out.println("Introduzca la cantidad: ");
                    float cantidad = Float.valueOf(miScan.nextLine());
                    System.out.println("Introduzca la fecha: ");
                    String fecha = miScan.nextLine();
                    miCuenta.ingresarEfectivo(cantidad, fecha);
                    break;

                case 'd':

                    System.out.println("Introduzca la cantidad: ");
                    float nCantidad = Float.valueOf(miScan.nextLine());
                    System.out.println("Introduzca la fecha: ");
                    String nFecha = miScan.nextLine();
                    miCuenta.retirarEfectivo(nCantidad, nFecha);
                    break;

                case 'e':

                    System.out.println("Introduzca el path del JSON: ");
                    String nPath = miScan.nextLine();
                    writeJson(nPath);
                    break;

                case 'f':

                    System.out.println("Introduzca el path del JSON: ");
                    String nPAth = miScan.nextLine();
                    miCuenta = readJsonCuenta(nPAth);
                    break;

                case 'g':

                    System.out.print("Seleccione una opción: \n\n"
                            + "a. Escribir en fichero \n"
                            + "b. Escribir en consola");
                    char nOption = miScan.nextLine().charAt(0);

                    switch (nOption) {

                        case 'a':

                            System.out.println("Introduzca el path: ");
                            String paTh = miScan.nextLine();
                            writeInFile(paTh);
                            break;

                        case 'b':

                            System.out.println(miCuenta.toString());
                            break;

                    }

                    break;

                case 'h':

                    break;

                default:

                    System.out.println("Introduzca una opción válida.");
                    break;

            }

        } while (option != 'h');

    }

    public static Cuenta readJsonCuenta(String json) {

        BufferedReader bR = null;

        try {
            bR = new BufferedReader(new FileReader(json));
            return new Gson().fromJson(bR, Cuenta.class);

        } catch (IOException e) {

            e.printStackTrace();
            return null;

        }finally {

            try{

                if(bR != null) bR.close();

            }catch (IOException iO){

                iO.getMessage();

            }

        }

    }

    public static Cliente readJsonCliente(String json) {

        BufferedReader bR = null;

        try  {
            bR = new BufferedReader(new FileReader(json));
            return new Gson().fromJson(bR, Cliente.class);

        } catch (IOException e) {

            e.printStackTrace();
            return null;

        }finally {

            try{

                if(bR != null) bR.close();

            }catch (IOException iO){

                iO.getMessage();

            }

        }
    }

    private static void WriteText(String text, String path) {

        BufferedWriter bW = null;

        try  {

            bW = new BufferedWriter(new FileWriter(path));
            bW.write(text);

            bW.flush();
            bW.close();
            bW = null;

        } catch (IOException e) {

            e.printStackTrace();

        }finally {

            try{

                if(bW != null) bW.close();

            }catch (IOException iO){

                iO.getMessage();

            }

        }

    }

    private static void writeJson(String path) {

        WriteText(new Gson().toJson(miCuenta), path);

    }

    private static void writeInFile(String path) {

        WriteText(miCuenta.toString(), path);

    }

    private static void ConsoleReadingFromFile(String path) {

        BufferedReader bR = null;

        try  {

            bR = new BufferedReader(new FileReader(path));

            String linea;
            while ((linea = bR.readLine()) != null) {

                System.out.println(linea);

            }

        } catch (IOException e) {

            e.printStackTrace();

        }finally {

            try{

                if(bR != null) bR.close();

            }catch (IOException iO){

                iO.getMessage();

            }

        }

    }
}
