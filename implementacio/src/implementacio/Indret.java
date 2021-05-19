package implementacio;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;


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
    
    public static final String GREEN = "\u001B[42m";
    
    private Map <String, Vendible> mpVendibles;
    private int puntuacio;
    private int compres;
    private final String nom;
    JSONObject json;
    
    public Indret(String nom){
        this.nom = nom;
        this.puntuacio = 0;
        this.compres = 0;
        this.mpVendibles = new HashMap <>();
        this.json = new JSONObject();
        this.createJSON();
    }
    
    public void createJSON() {
        this.json.put("nom", this.nom);
        this.json.put("puntuacio", this.puntuacio);
        this.json.put("compres", this.compres);
        this.json.put("vendibles", this.mpVendibles);
        System.out.println(GREEN+"Indret creat: "+this.json.toJSONString()+GREEN);
    }
    
    public JSONObject getJSON(){
        return this.json;
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
