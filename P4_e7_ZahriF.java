/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.p4_e7_zahrif;

import java.util.Scanner;

/**
 *
 * @author naw12
 */
public class P4_e7_ZahriF {
    //Definim els valors de les constants

    private static final int ID_MIN = 1;
    private static final int ID_MAX = 999;
    private static final int BORSA_MIN = 0;
    private static final int BORSA_MAX = 4;
    private static final int CODI_MIN = 10;
    private static final int CODI_MAX = 999;
    private static final int TIPUS_COMPRA = 0;
    private static final int TIPUS_VENDA = 1;
    private static final int IMPORT_MIN = 0;
    private static final int IMPORT_MAX = 100000;
    private static final int DIA_MIN = 1;
    private static final int DIA_MAX = 31;
    private static final int MES_MIN = 1;
    private static final int MES_MAX = 12;
    private static final int ANY_MIN = 2023;
    private static final int ANY_MAX = 2050;
    private static final int BORSANY = 0;
    private static final int BORSAMAD = 1;
    private static final int BORSAPAR = 2;
    private static final int BORSALON = 3;
    private static final int BORSAFRAN = 4;
    private static final String NOMBORSANY = "NY ";
    private static final String NOMBORSAMAD = "Madrid  ";
    private static final String NOMBORSAPAR = "Paris  ";
    private static final String NOMBORSALON = "Londres ";
    private static final String NOMBORSAFRAN = "Frankfurt ";
    private static final String NOMCOMPRA = "Compra ";
    private static final String NOMVENDA = "Venda ";
    private static final int COMPRA = 0;
    private static final int VENDA = 1;
    private static final int MAX_INTENTS = 3;
    private static final int MAX_MOVIMENTS = 10;

    public static void main(String[] args) {

        //Definim les variables
        int id = 0, borsa = 0, codi = 0, tipus = 0, importe = 0, dia = 0, mes = 0, any = 0, i = 0;
        int intents = 0;
        //int i;
        int moviEntrats = 0;
        int seguir = 0;
        int tipusConsulta;
        int numCompres = 0;
        int numVendes = 0;
        int totalCompres = 0;
        int totalVendes = 0;
        Scanner lector = new Scanner(System.in);
        String nomborsa = "";
        String nomtipus = "";
        boolean valorok = true, introMes;

        //Declarem noves arrays bidimensionals:
        int[][] moviments = new int[MAX_MOVIMENTS][8];

        moviments[i][0] = id;
        moviments[i][1] = borsa;
        moviments[i][2] = codi;
        moviments[i][3] = tipus;
        moviments[i][4] = importe;
        moviments[i][5] = dia;
        moviments[i][6] = mes;
        moviments[i][7] = any;

        do { //Bucle do-while per demanar la introducció de mes moviments
            introMes = false;
            do {
                //Demanar la ID del moviment
                System.out.print("Id del moviment?: :");
                //Verificar que la dada es un enter
                valorok = lector.hasNextInt();//Per analitzar tipus dada
                if (valorok) {//si és un numero sencer
                    //Llegim dades
                    moviments[i][0] = lector.nextInt();//guardem dades a l'array
                    if ((moviments[i][0] < ID_MIN) || (moviments[i][0] > ID_MAX)) {
                        valorok = false;
                    }
                }
                if (!valorok) { //condicio per controlar la introducció de dades incorrectes + contador intents
                    System.out.println("Error en dades");
                    intents++;
                }

            } while ((!valorok) && (intents < MAX_INTENTS));

            if (valorok) {
                intents = 0;//Per a cada dada inicialitzem el comptador d'intents a 0
                do {
                    //Demanar en quina borsa de valors es vol operar
                    System.out.println("Borsa de valors?:");
                    System.out.println("\tNY(0)\n" + "\tMadrid (1)\n"
                            + "\tParis (2)\n" + "\tLondres(3)\n" + "\tFrankfurt(4)");
                    valorok = lector.hasNextInt(); //Per analitzar tipus dada
                    if (valorok) { //si és un numero sencer
                        //Llegim dades
                        moviments[i][1] = lector.nextInt();//guardem dades a l'array
                        if ((moviments[i][1] < BORSA_MIN) || (moviments[i][1] > BORSA_MAX)) {
                            valorok = false;
                        } else {  //Si arribem aquí la dada de borsa es correcta
                            switch (moviments[i][1]) {
                                case BORSANY:
                                    nomborsa = NOMBORSANY;
                                    break;
                                case BORSAMAD:
                                    nomborsa = NOMBORSAMAD;
                                    break;
                                case BORSAPAR:
                                    nomborsa = NOMBORSAPAR;
                                    break;
                                case BORSALON:
                                    nomborsa = NOMBORSALON;
                                    break;
                                case BORSAFRAN:
                                    nomborsa = NOMBORSAFRAN;
                                    break;

                            }
                        }
                    }
                    if (!valorok) {//condicio per controlar la introducció de dades incorrectes + contador intents
                        System.out.println("Error en dades");
                        intents++;
                    }

                } while ((!valorok) && (intents < MAX_INTENTS));
            }
            if (valorok) {
                intents = 0;//Per a cada dada inicialitzem el comptador d'intents a 0
                do {
                    //Demanar codi de l'empresa
                    System.out.print("Codi de l'empresa?: ");
                    valorok = lector.hasNextInt(); //Per analitzar tipus dada
                    if (valorok) { //si és un numero sencer
                        //Llegim dades
                        moviments[i][2] = lector.nextInt();//guardem dades a l'array
                        if ((moviments[i][2] < CODI_MIN) || (moviments[i][2] > CODI_MAX)) {
                            valorok = false;
                        }
                    }
                    if (!valorok) {//condicio per controlar la introducció de dades incorrectes + contador intents
                        System.out.println("Error en dades");
                        intents++;
                    }

                } while ((!valorok) && (intents < MAX_INTENTS));
            }
            if (valorok) {
                intents = 0;//Per a cada dada inicialitzem el comptador d'intents a 0
                do {
                    //Demanar el tipus de moviment
                    System.out.println("Tipus de moviment?:");
                    System.out.print("\tCompra (0)\n" + "\tVenda (1)\n");
                    valorok = lector.hasNextInt();//Per analitzar tipus dada
                    if (valorok) { //si és un numero sencer
                        //Llegim dades
                        moviments[i][3] = lector.nextInt();//guardem dades a l'array
                        if ((moviments[i][3] < TIPUS_COMPRA) || (moviments[i][3] > TIPUS_VENDA)) {
                            valorok = false;
                        } else {
                            switch (moviments[i][3]) {
                                case COMPRA:
                                    nomtipus = NOMCOMPRA;
                                    break;
                                case VENDA:
                                    nomtipus = NOMVENDA;
                                    break;
                            }
                        }
                    }
                    if (!valorok) {//condicio per controlar la introducció de dades incorrectes + contador intents
                        System.out.println("Error en dades");
                        intents++;
                    }

                } while ((!valorok) && (intents < MAX_INTENTS));
            }
            if (valorok) {
                intents = 0;//Per a cada dada inicialitzem el comptador d'intents a 0
                do {
                    //Demanar l'import
                    System.out.print("Import de la " + nomtipus + " ?:");
                    valorok = lector.hasNextInt();//Per analitzar tipus dada
                    if (valorok) {//si és un numero sencer
                        //Llegim dades
                        moviments[i][4] = lector.nextInt();//guardem dades a l'array
                        if ((moviments[i][4] < IMPORT_MIN) || (moviments[i][4] > IMPORT_MAX)) {
                            valorok = false;
                        }
                    }
                    if (!valorok) {//condicio per controlar la introducció de dades incorrectes + contador intents
                        System.out.println("Error en dades");
                        intents++;
                    }

                } while ((!valorok) && (intents < MAX_INTENTS));
            }
            if (valorok) {
                //Demanar la Data
                System.out.println("Data?");
                intents = 0;//Per a cada dada inicialitzem el comptador d'intents a 0
                do {

                    //Demanar el dia
                    System.out.print("Dia: ");
                    valorok = lector.hasNextInt();//Per analitzar tipus dada
                    if (valorok) {//si és un numero sencer
                        //Llegim dades
                        moviments[i][5] = lector.nextInt();//guardem dades a l'array
                        if ((moviments[i][5] < DIA_MIN) || (moviments[i][5] > DIA_MAX)) {
                            valorok = false;
                        }
                    }
                    if (!valorok) {//condicio per controlar la introducció de dades incorrectes + contador intents
                        System.out.println("Error en dades");
                        intents++;
                    }

                } while ((!valorok) && (intents < MAX_INTENTS));
            }
            if (valorok) {
                intents = 0;//Per a cada dada inicialitzem el comptador d'intents a 0
                do {
                    //Demanar el mes
                    System.out.print("Mes: ");
                    valorok = lector.hasNextInt();//Per analitzar tipus dada
                    if (valorok) {//si és un numero sencer
                        //Llegim dades
                        moviments[i][6] = lector.nextInt();//guardem dades a l'array
                        if ((moviments[i][6] < MES_MIN) || (moviments[i][6] > MES_MAX)) {
                            valorok = false;
                        }
                    }
                    if (!valorok) {//condicio per controlar la introducció de dades incorrectes + contador intents
                        System.out.println("Error en dades");
                        intents++;
                    }

                } while ((!valorok) && (intents < MAX_INTENTS));
            }
            if (valorok) {
                intents = 0;//Per a cada dada inicialitzem el comptador d'intents a 0
                do {
                    //Demanar l'any
                    System.out.print("Any: ");
                    valorok = lector.hasNextInt();//Per analitzar tipus dada
                    if (valorok) {//si és un numero sencer
                        //Llegim dades
                        moviments[i][7] = lector.nextInt();//guardem dades a l'array
                        if ((moviments[i][7] < ANY_MIN) || (moviments[i][7] > ANY_MAX)) {
                            valorok = false;
                        }
                    }
                    if (!valorok) {//condicio per controlar la introducció de dades incorrectes + contador intents
                        System.out.println("Error en dades");
                        intents++;
                    }

                } while ((!valorok) && (intents < MAX_INTENTS));
            }
            if (valorok) {
                i++;
                moviEntrats++; //comptador número moviments
            } else {
                System.out.println("Programa finalitzat per error en dades");
            }
            //Avaluem si vol introduir més moviments
            if (i < MAX_MOVIMENTS) {
                System.out.println("Es vol introduir més moviments (no: 0/ si:1)?");
                valorok = lector.hasNextInt();
                if (valorok) { // si és un número sencer 
                    seguir = lector.nextInt();
                    if (seguir == 1) {
                        introMes = true;
                    }
                    //Ampliació 3 Millora
                    while (seguir != 1 && seguir != 0) {
                        System.out.println("Opció incorrecta. Si us plau, introdueix 1= Si o 0= No:");
                        seguir = lector.nextInt();
                    }
                }
            }

        } while ((introMes) && (i < MAX_MOVIMENTS));
//Mostrem dades introduides
        System.out.println("id\tborsa\t\tcodi empresa\t\ttipus\t\tImport\t\tdata");
        for (int j = 0; j < i; j++) {
            switch (moviments[j][1]) {
                case BORSANY:
                    nomborsa = NOMBORSANY;
                    break;
                case BORSAMAD:
                    nomborsa = NOMBORSAMAD;
                    break;
                case BORSAPAR:
                    nomborsa = NOMBORSAPAR;
                    break;
                case BORSALON:
                    nomborsa = NOMBORSALON;
                    break;
                case BORSAFRAN:
                    nomborsa = NOMBORSAFRAN;
                    break;

            }
            switch (moviments[j][3]) {
                case COMPRA:
                    nomtipus = NOMCOMPRA;
                    break;
                case VENDA:
                    nomtipus = NOMVENDA;
                    break;
            }
            // Mostrem els valors emmagatzemats a l'array
            System.out.println(moviments[j][0] + "\t" + nomborsa + "\t\t" + moviments[j][2] + "\t\t" + nomtipus + "\t\t" + moviments[j][4] + "\t\t" + moviments[j][5] + "/" + moviments[j][6] + "/" + moviments[j][7]);

        }
        System.out.println("S'han introduït  " + i + " moviments de compra-venda d'accions");
        /*Part 2
        Demanarà si es volen mostrar les dades dels moviments per tipus de moviment 
        realitzat a la borsa de valors
         */
        System.out.println("Vols consultar per tipus de moviment realitzat a la borsa?(no: 0/ si:1)");
        valorok = lector.hasNextInt();
        if (valorok) {
            intents = 0;
            seguir = lector.nextInt();
            if (seguir == 1) {
                do {
                    if (intents >= MAX_INTENTS) {
                        System.out.println("Programa finalitzat per error en dades");
                    }
                    System.out.println("Quin tipus de moviment (Compra: 0/ venda: 1)?");
                    tipusConsulta = lector.nextInt();
                    if (valorok) {
                        if (tipusConsulta == COMPRA || tipusConsulta == VENDA) {
                            System.out.println("Descripció dels moviments realitzats de tipus  " + (tipusConsulta == COMPRA ? "compra" : "venda") + " ordenades per import de menor a major:");
                            for (int j = 0; j < i - 1; j++) {//Algoritme de BubbleSort per ordenar l'array
                                for (int k = j + 1; k < i; k++) {
                                    if (moviments[j][3] == tipusConsulta && moviments[k][3] == tipusConsulta) {
                                        if (moviments[j][4] > moviments[k][4]) {
                                            int tempId = moviments[j][0];
                                            moviments[j][0] = moviments[k][0];
                                            moviments[k][0] = tempId;

                                            int tempBorsa = moviments[j][1];
                                            moviments[j][1] = moviments[k][1];
                                            moviments[k][1] = tempBorsa;

                                            int tempCodi = moviments[j][2];
                                            moviments[j][2] = moviments[k][2];
                                            moviments[k][2] = tempCodi;

                                            int tempTipus = moviments[j][3];
                                            moviments[j][3] = moviments[k][3];
                                            moviments[k][3] = tempTipus;

                                            int tempimporte = moviments[j][4];
                                            moviments[j][4] = moviments[k][4];
                                            moviments[k][4] = tempimporte;

                                            int tempDia = moviments[j][5];
                                            moviments[j][5] = moviments[k][5];
                                            moviments[k][5] = tempDia;

                                            int tempMes = moviments[j][6];
                                            moviments[j][6] = moviments[k][6];
                                            moviments[k][6] = tempMes;

                                            int tempAny = moviments[j][7];
                                            moviments[j][7] = moviments[k][7];
                                            moviments[k][7] = tempAny;
                                        }
                                    }
                                }
                            }
                            //Fi ordenació -------------------------------------
                            //Mostrem ordenats ---------------------------------
                            System.out.println("id\tborsa\t\tcodi empresa\ttipus\t\tImport\t\tdata");
                            for (int j = 0; j < i; j++) {
                                if (moviments[j][3] == tipusConsulta) {
                                    switch (moviments[j][1]) {
                                        case BORSANY:
                                            nomborsa = NOMBORSANY;
                                            break;
                                        case BORSAMAD:
                                            nomborsa = NOMBORSAMAD;
                                            break;
                                        case BORSAPAR:
                                            nomborsa = NOMBORSAPAR;
                                            break;
                                        case BORSALON:
                                            nomborsa = NOMBORSALON;
                                            break;
                                        case BORSAFRAN:
                                            nomborsa = NOMBORSAFRAN;
                                            break;

                                    }
                                    System.out.println(moviments[j][0] + "\t" + nomborsa + "\t\t" + moviments[j][2] + "\t\t" + (moviments[j][3] == COMPRA ? "Compra" : "Venda") + "\t\t" + moviments[j][4] + "\t\t" + moviments[j][5] + "/" + moviments[j][6] + "/" + moviments[j][7]);
                                }
                            }
                        }
                    }
                    if (!valorok) {
                        System.out.println("Error en dades");
                        intents++;
                    }
                    lector.nextLine();
                } while ((tipusConsulta != COMPRA && tipusConsulta != VENDA));
            }
        }
        /*Part 3
        Demanarà si es vol un resum estadístic de les dades. Si s’accepta, mostrarà un resum 
        de les dades principals (tipus, número compres, número vendes, imports acumulats)
         */
        System.out.println("Vols veure un resum estadístic de les dades? (no: 0/ si:1) ");
        valorok = lector.hasNextInt();
        if (valorok) {
            seguir = lector.nextInt();
            if (seguir == 1) {
                for (int j = 0; j < i; j++) {
                    if (moviments[j][3] == COMPRA) {
                        numCompres++;
                        totalCompres += moviments[j][4];
                    } else if (moviments[j][3] == VENDA) {
                        numVendes++;
                        totalVendes += moviments[j][4];
                    }
                }
                //Mostrem resum ---------------------------------
                System.out.println("Número de moviments introduïts: " + i);
                System.out.println("Número de moviments per tipus:");
                System.out.println("compra: " + numCompres);
                System.out.println("venda: " + numVendes);
                System.out.println("Import total acumulat compres: " + totalCompres + " €");
                System.out.println("Import total acumulat vendes: " + totalVendes + " €");
            }
            /*FUNCIONALITAT EXTRA*/

 /*En definir la grandària del array com BORSA_MAX + 1,
s'assegura que hi hagi 5 elements en el array per a emmagatzemar els imports de compres per a cada bossa
ja que borsa max té un valor màxim de 4 (es comença a definir amb 0,1,2,3,4)*/
            int[] importCompresPerBorsa = new int[BORSA_MAX + 1];

            System.out.println("Vols mostrar el percentatge gastat de les compres en cada mercat borsari? (no: 0/ si:1) ");
            valorok = lector.hasNextInt();
            if (valorok) {
                seguir = lector.nextInt();
                if (seguir == 1) {
                    for (int j = 0; j < i; j++) {
                        if (moviments[j][3] == COMPRA) {
                            int bolsa = moviments[j][1];
                            int importeCompra = moviments[j][4];
                            importCompresPerBorsa[bolsa] += importeCompra;
                        }
                    }

                    int importTotalCompres = 0;

// Calcular import total de totes las compres
                    for (int j = 0; j < i; j++) {
                        if (moviments[j][3] == COMPRA) {
                            int importeCompra = moviments[j][4];
                            importTotalCompres += importeCompra;
                        }
                    }
                    System.out.println("Percentatge gastat en cada mercat borsari:");

//El bucle for recorre cada borsa des de BORSA_*MIN fins a BORSA_MAX. 
//Dins del bucle, es realitza el càlcul del percentatge gastat en cada borsa mitjançant la
/* següent fórmula ja vista en exercicis del temari variable /variable *100*/
                    for (int bolsa = BORSA_MIN; bolsa <= BORSA_MAX; bolsa++) {
                        double porcentajeGastado = (double) importCompresPerBorsa[bolsa] / importTotalCompres * 100;
                        String nombreBolsa = "";

                        switch (bolsa) {
                            case BORSANY:
                                nombreBolsa = NOMBORSANY;
                                break;
                            case BORSAMAD:
                                nombreBolsa = NOMBORSAMAD;
                                break;
                            case BORSAPAR:
                                nombreBolsa = NOMBORSAPAR;
                                break;
                            case BORSALON:
                                nombreBolsa = NOMBORSALON;
                                break;
                            case BORSAFRAN:
                                nombreBolsa = NOMBORSAFRAN;
                                break;
                        }

                        System.out.println(nombreBolsa + ": " + porcentajeGastado + "%");
                    }
                }
            }
        }

    }
}
