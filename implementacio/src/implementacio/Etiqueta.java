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
public class Etiqueta {
    
    // Repositori
    Map <String, Vendible> mpVendibles;
    
    // Propietats atributives
    private final String titol;
    
    public Etiqueta (String titol){
        this.titol = titol;
        this.mpVendibles = new HashMap <>();
    }
    public String titol() {
        return this.titol;
    }

    public Map<String, Vendible> vendibles() {
        return mpVendibles;
    }
    
    
    
    //Cas d'us 1 i 2: novesFotos i nouAlbum
    public void publicaVendible(Vendible v){
        this.mpVendibles.put(v.codi(), v); // add
    }
    
}
    
