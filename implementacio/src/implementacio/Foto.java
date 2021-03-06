package implementacio;

import java.util.Map;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aleix
 */
public class Foto extends Vendible {
    
    public static final String GREEN = "\u001B[42m";
    public static final String RESET = "\u001B[0m";    
    
    // Propietats atributives
    private int any;
    private int puntuacio;
    private Map <String, Vendible> mpVariacions;

    
    
    public Foto (int any, String descripcio, Indret in){
        super(descripcio, "foto");
        this.any = any;
        this.puntuacio = 0;
        this.setPreponderant(in);
        in.publicaVendible(this);
    }


    public int puntuacio() {
        return puntuacio;
    }
    
    
    
    //Cas d'us 1: novesFotos
    public void novaEtiqueta (Etiqueta et){
        this.mpEtiquetes.put(et.titol(), et);
        et.publicaFoto(this);
    } 
    
    // Cas d'us 2: nouAlbum
    
    public void etiquetacioAlbum(Album a){
        for (String name: this.mpEtiquetes.keySet()) {
            
            Etiqueta et = this.mpEtiquetes.get(name);
            
            et.etiquetacioAlbum(a);
            
            if (!et.mpVendibles.containsKey(a.codi())){ // addx
                et.mpVendibles.put(a.codi(), a);
            }
            
        }
    }
    
    // Cas d'us 3: novaComanda
    
    public void actualitzaEstadistiques(int num){
        this.puntuacio+=10;
        //variacions
        this.obtenirPreponderant().actualitzaEstadistiques(num);
    }
    
    // Cas d'ús 4: reiniciaPunts
    public void reiniciVendible() {
        this.puntuacio = 0;
    }

}
