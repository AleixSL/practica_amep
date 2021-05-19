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
public class Etiqueta {
    
    public static final String GREEN = "\u001B[42m";
    
    // Repositori
    Map <String, Vendible> mpVendibles;
    JSONObject json;
    
    // Propietats atributives
    private final String titol;
    
    public Etiqueta (String titol){
        this.titol = titol;
        this.mpVendibles = new HashMap <>();
        this.json = new JSONObject();
        this.createJSON();
    }
    
    public void createJSON() {
        this.json.put("vendibles", this.mpVendibles);
        this.json.put("titol", this.titol);
        System.out.println(GREEN+"Etiqueta creada: "+this.json.toJSONString()+GREEN);
    }
    
    public JSONObject getJSON(){
        return this.json;
    }
    
    public String titol() {
        return this.titol;
    }

    public Map<String, Vendible> vendibles() {
        return mpVendibles;
    }
    
    //Cas d'us 1 i 2: novesFotos i nouAlbum
    public void publicaFoto(Vendible f){
        this.mpVendibles.put(f.codi(), f); // add
    }
    
    // Cas d'us 2: nouAlbum
    
    public void etiquetacioAlbum(Album a){
        if (!this.mpVendibles.containsKey(a.codi()))
            this.mpVendibles.put(a.codi(), a); // add
        a.afegeixEtiqueta(this);
    }
    
}
    
