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
    private Indret preponderant;
    private final String type;
    
    //Repositoris
    Map <String, Etiqueta> mpEtiquetes;
    
    public Vendible (String descripcio, String type){
        this.descripcio = descripcio;
        this.type = type;
        this.codi = nouCodiVendible();
        this.mpEtiquetes = new HashMap <>(); // create
    }
    
    public <Foto extends Vendible> Foto getFoto() {
        return (Foto) this;
    }
    
    public Indret obtenirPreponderant() {
        return preponderant;
    }

    public String getType() {
        return type;
    }
    
    

    public void setPreponderant(Indret preponderant) {
        this.preponderant = preponderant;
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
    
}
