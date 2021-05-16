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
    
