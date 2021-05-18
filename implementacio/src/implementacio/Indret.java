package implementacio;

import java.util.HashMap;
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
public class Indret {
    
    private Map <String, Vendible> mpVendibles;
    private int puntuacio;
    private int compres;
    private final String nom;
    
    public Indret(String nom){
        this.nom = nom;
        this.puntuacio = 0;
        this.compres = 0;
        this.mpVendibles = new HashMap <>();
    }

    public int puntuacio() {
        return this.puntuacio;
    }

    public int compres() {
        return this.compres;
    }

    public String nom() {
        return this.nom;
    }

    public void incrementaPuntuacio(int puntuacio) {
        this.puntuacio += puntuacio;
    }
    
    
    
    //Cas d'us 1 i 2: novesFotos i nouAlbum
    
    public void publicaVendible(Album a) {
        if (!this.mpVendibles.containsKey(a.codi()))
            this.mpVendibles.put(a.codi(), a);
    }
    
    public void publicaVendible(Foto f) {
        this.mpVendibles.put(f.codi(), f);
    }
    
    //Cas d'us 3: novaComanda
    public void actualitzaEstadistiques(int num){
        this.compres+=num;
        this.puntuacio+=(10*num);
    }
    
    // Cas d'ús 4: reiniciaPunts
    public void reiniciIndret() {
        this.puntuacio = 0;
    }
}
