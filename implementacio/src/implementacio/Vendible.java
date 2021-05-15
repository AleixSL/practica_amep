package implementacio;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aleix
 */
public class Vendible {
    
    // Atributs
    private String descripcio;
    private String codi;
    
    //Repositoris
    Map <String, Etiqueta> mpEtiquetes;
    
    Vendible (String descripcio){
        this.descripcio = descripcio;
        this.codi = nouCodiVendible();
        this.mpEtiquetes = new HashMap <>(); // create
    }
    
    private String nouCodiVendible (){
        UUID uuid = UUID.randomUUID();
        long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
        return Long.toString(l, Character.MAX_RADIX);
    }

    public String codi() {
        return this.codi;
    }

    public String descripcio() {
        return this.descripcio;
    }
    
    
    
    //Cas d'us 1: novesFotos
    public void novaEtiqueta (Etiqueta et){
        this.mpEtiquetes.put(et.titol(), et);
        et.publicaVendible(this);
    }
    
    
}
