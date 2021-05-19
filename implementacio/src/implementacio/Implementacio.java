/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacio;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Aleix
 */
public class Implementacio {
    
    public static final String RED = "\u001B[41m";
    public static final String GREEN = "\u001B[42m";
    
    public static void novesFotos(K k, Scanner in){
        
        System.out.println(GREEN +"Command accepted: novesFotos()"+GREEN);
        
        System.out.println("Introdueix un indret (Enter to skip):");
        String nom = in.nextLine();

        while (!nom.isEmpty()){

            k.introduirIndret(nom); // ES1

            System.out.println("BUCLE: Introduint nova foto...");
            System.out.println("Introdueix un any (Enter to skip): ");
            String res1 = in.nextLine();


            while (!res1.isEmpty()){
                int any = Integer.parseInt(res1);

                System.out.println("Introdueix una descripcio:");
                String descripcio = in.nextLine();

                k.introduirFoto(any, descripcio); //ES2

                System.out.println("Introdueix una etiqueta (Enter to skip): ");
                String res2 = in.nextLine();

                while (!res2.isEmpty()){
                    String titol = res2;
                    k.introduirEtiqueta(titol);

                    System.out.println("Introdueix una etiqueta (Enter to skip): ");
                    res2 = in.nextLine();
                }

                System.out.println("BUCLE: Introduint nova foto...");
                System.out.println("Introdueix un any (Enter to skip): ");
                res1 = in.nextLine();


            }
            System.out.println("Introdueix un indret (Enter to Skip):");
            nom = in.nextLine();
        }

        System.out.println(k);
    }  
    public static void nouAlbum(K k, Scanner in){
        
        System.out.println(GREEN +"Command accepted: nouAlbum()"+GREEN);
        
        System.out.println("Introdueix un titol:");
        String titol = in.nextLine();
        System.out.println("Introdueix una descripcio");
        String descripcio = in.nextLine();

        k.iniAlbum(titol, descripcio); // ES1

        int i = 0;
        List <Foto> fotos = new ArrayList<>();
        System.out.println("Fotos disponibles: {");
        for (String name: k.mpVendibles.keySet()) {
            Vendible v = k.mpVendibles.get(name);
            if (v.getType()=="foto"){
                fotos.add(v.getFoto());
                System.out.println("["+i+"]: "+"codi: "+v.codi()+", descripcio: "+ v.descripcio());
                i++;
            }
        }
        System.out.println("}");

        System.out.println("[BUCLE] Selecciona una foto (Enter to skip):");
        String index = in.nextLine();


        while (!index.isEmpty()){
            Foto f = fotos.get(Integer.parseInt(index));
            k.seleccionaFoto(f); // ES2
            System.out.println("[BUCLE] Selecciona una foto (Enter to skip):");
            index = in.nextLine();
        }

        k.fiAlbum(); //ES3
        System.out.println(k);
    }
    public static void novaComanda (K k, Scanner in){
        System.out.println(GREEN +"Command accepted: novaComanda()"+GREEN);
                    
        System.out.println("Introdueix el teu nickname:");

        String nickname = in.nextLine();

        k.iniComanda(nickname);

        System.out.println("Introduir foto(f) o album(a) (Enter to skip): ");
        String res1 = in.nextLine();

        while (!res1.isEmpty()){

            if (res1.equals("f")) {
                List <Foto> fotos = new ArrayList<>();
                System.out.println("Fotos disponibles: {");
                for (String name: k.mpVendibles.keySet()) {
                    Vendible v = k.mpVendibles.get(name);
                    if (v.getType()=="foto"){
                        fotos.add(v.getFoto());
                        System.out.println("codi: "+v.codi()+", descripcio: "+ v.descripcio());
                    }
                }   
                System.out.println("}");
                System.out.println("Introdueix un codi:");
                String codi = in.nextLine();
                System.out.println("Introdueix un numero de variacions:");
                String num = in.nextLine();

                k.inclouFoto(codi, Integer.parseInt(num));
            } else if (res1.equals("a")) {
                List <Album> albums = new ArrayList<>();
                System.out.println("Albums disponibles: {");
                for (String name: k.mpVendibles.keySet()) {
                    Vendible v = k.mpVendibles.get(name);
                    if (v.getType()=="album"){
                        albums.add(v.getAlbum());
                        System.out.println("codi: "+v.codi()+", descripcio: "+ v.descripcio());
                    }
                }   
                System.out.println("}");

                System.out.println("Introdueix un codi:");
                String codi = in.nextLine();
                k.inclouAlbum(codi);
            }

            System.out.println("Introduir foto(f) o album(a) (Enter to skip): ");
            res1 = in.nextLine();
        }

        System.out.println(k);
    }
    
    public static void reiniciaPunts(K k, Scanner in) {
        System.out.println(GREEN +"Command accepted: reiniciaPunts()"+GREEN);
        if(k.iniReinici()) {
            System.out.println(GREEN +"S'han reiniciat els punts"+GREEN);
            System.out.println(k);
        }
        else System.out.println(RED +"Encara no han passat 5 anys des de l'últim reinici!"+RED);
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String [] predefinides = {
               "personatge", "edifici", "cotxe",
                "paisatge", "muntanya", "costa",
                "gastronomia", "cultura", "viatges"
        };
        String [] clients = {
               "Meren", "Jesus", "Aleix"
        };
        
        K k = new K(predefinides, clients);
        System.out.println("Les comandes existents són les següents: "
            + "\n\t novesfotos \n\t noualbum \n\t novacomanda \n\t reiniciapunts");
        Scanner in = new Scanner(System.in);
        System.out.println("Introdueix comanda (Enter to skip): ");
        
        String cmd = in.nextLine().toUpperCase();

        //cmd = "NOUALBUM";
        // Aquesta es la logica per executar els casos d'us
        while (!cmd.isEmpty()) {
            // Lectura de comanda
            switch(cmd){
                case "NOVESFOTOS":
                    // Tractament
                    novesFotos(k, in);
                    break;
                case "NOUALBUM":
                    // Tractament
                    nouAlbum(k, in);
                    break;
                case "NOVACOMANDA":
                    // Tractament
                    novaComanda(k, in);
                    break;
                case "REINICIAPUNTS":
                    // Tractament
                    reiniciaPunts(k, in);
                    break;
                default:
                    // Validacio
                    System.out.println(RED + "Aquesta comanda es erronea" + RED);
                    System.out.println("Les comandes existents són les següents: "
                            + "\n\t novesfotos \n\t noualbum \n\t novacomanda \n\t reiniciapunts");
                    break;
            }
            
            System.out.println("Introdueix comanda: ");
            cmd = in.nextLine().toUpperCase();
            
            
            
            // Tractament
            // 
        }
        
    }
    
}
