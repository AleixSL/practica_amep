package implementacio;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
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
public class Vendible {
    
    public static final String GREEN = "\u001B[42m";
    
    // Atributs
    private String descripcio;
    private String codi;
    private Indret preponderant;
    private final String type;
    JSONObject json;
    
    //Repositoris
    Map <String, Etiqueta> mpEtiquetes;
    
    public Vendible (String descripcio, String type){
        this.descripcio = descripcio;
        this.type = type;
        this.codi = nouCodiVendible();
        this.mpEtiquetes = new HashMap <>(); // create
        this.json = new JSONObject();
        this.createJSON();
    }
    
    public void createJSON() {
        this.json.put("codi", this.codi);
        this.json.put("descripcio", this.descripcio);
        this.json.put("preponderant", this.preponderant);
        this.json.put("type", this.type);
        this.json.put("etiquetes", this.mpEtiquetes);
        System.out.println(GREEN+"Vendible creat: "+this.json.toJSONString()+GREEN);
    }
    
    public JSONObject getJSON(){
        return this.json;
    }
    
    public <Foto extends Vendible> Foto getFoto() {
        return (Foto) this;
    }
    
    public <Album extends Vendible> Album getAlbum() {
        return (Album) this;
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
    
    public void actualitzaEstadistiques(){
        this.preponderant.incrementaPuntuacio(20);
    }
    
}
