/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package implementacio;

import java.util.Scanner;

/**
 *
 * @author Aleix
 */
public class Implementacio {
    
    public static final String RED = "\u001B[41m";
    public static final String GREEN = "\u001B[42m";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Scanner in = new Scanner(System.in);
        System.out.println("Introdueix comanda: ");
        String cmd = in.nextLine().toUpperCase();
        String [] predefinides = {
               "personatge", "edifici", "cotxe",
                "paisatge", "muntanya", "costa",
                "gastronomia", "cultura", "viatges"
        };
        
        K k = new K(predefinides);
        
        // Aquesta es la logica per executar els casos d'us
        while (cmd != "EXIT") {
            // Lectura de comanda
            switch(cmd){
                case "NOVESFOTOS":
                    // Tractament
                    System.out.println(GREEN +"Command accepted: novesFotos()"+GREEN);
                    
                    System.out.println("Introdueix un indret (Enter to skip):");
                    String nom = in.nextLine();
                    System.out.println("nom=("+nom+")");
                    
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
                    
                    
                    break;
                case "NOUALBUM":
                    // Tractament
                    System.out.println(GREEN +"Command accepted: nouAlbum()"+GREEN);
                    break;
                case "NOVACOMANDA":
                    // Tractament
                    System.out.println(GREEN +"Command accepted: novaComanda()"+GREEN);
                    break;
                case "REINICIAPUNTS":
                    // Tractament
                    System.out.println(GREEN +"Command accepted: reiniciaPunts()"+GREEN);
                    break;
                //case "\n":
                  //  System.out.println(RED + "Aquesta comanda es erronea" + RED);
                    //break;
                default:
                    // Validacio
                    System.out.println(RED + "Aquesta comanda es erronea" + RED);
                    break;
            }
            
            System.out.println("Introdueix comanda: ");
            cmd = in.nextLine().toUpperCase();
            
            
            
            // Tractament
            // 
        }
        
    }
    
}
