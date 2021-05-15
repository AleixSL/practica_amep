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
public class K {
    
    // Atributs
    Indret indretActiu;
    Foto fotoActiva;
    
    // Repositoris
    Map <String, Vendible> mpVendibles; //Cataleg
    Map <String, Indret> mpIndrets;
    Map <String, Etiqueta> mpEtiquetes;
    Map <String, Client> mpClients;
    
    // Constructor
    public K (String [] predefinides){
       
        this.mpVendibles = new HashMap<>();
        this.mpIndrets = new HashMap<>();
        this.mpEtiquetes = new HashMap<>();
        this.mpClients = new HashMap<>();
       
        for (String predefinida : predefinides) {
            Etiqueta et = new Etiqueta(predefinida);
            this.mpEtiquetes.put(predefinida, et);
        }
    }

    
    @Override
    public String toString() {
        
        String vendibles = "{\n"; 
        String indrets = "{\n"; 
        String etiquetes = "{\n"; 
        String clients = "{\n"; 
        
        for (String name: mpVendibles.keySet()) {
            String descripcio = mpVendibles.get(name).descripcio();
            vendibles += "\tcodi: "+name+", descripcio: "+descripcio+"\n";
        }
        
        for (String name: mpIndrets.keySet()) {
            Indret in = mpIndrets.get(name);
            indrets += "\tnom: "+name+", puntuacio: "+
                    in.puntuacio()+", compres: "+in.compres()+"\n";
        }
        
        for (String name: mpEtiquetes.keySet()) {
            
            String vendiblesEt = "";
            Etiqueta et = mpEtiquetes.get(name);
            
            for (String vname: et.vendibles().keySet()) {
                String descripcio = et.vendibles().get(vname).descripcio();
                vendiblesEt += "\n\t\tcodi: "+vname+", descripcio: "+descripcio+"\t";
            }   
            etiquetes += "\tnom: "+name+", vendibles: {"+ vendiblesEt +"}\n";
        }
        
        //for (UUID name: mpVendibles.keySet()) {
           // String descripcio = mpVendibles.get(name).descripcio();
            //clients += "\tcodi: "+name+", descripcio: "+descripcio+"\n";
        //}
        
        return  "Vendibles " + vendibles +"}\n" +
                "Indrets "   + indrets   +"}\n" +
                "Etiquetes " + etiquetes +"}\n" +
                "Clients "   + clients   +"}\n";
    }

    
    
    
    
    
    
    // Cas d'us 1: novesFotos
    public void introduirIndret(String nom) {
        this.indretActiu = this.mpIndrets.get(nom); // find
        
        if (this.indretActiu==null){
            this.indretActiu = new Indret(nom); // create
            this.mpIndrets.put(nom, this.indretActiu); // add
        }
    }
    
    public void introduirFoto(int any, String descripcio) {
        
        this.fotoActiva = new Foto (any, descripcio, this.indretActiu); // create
        this.mpVendibles.put(this.fotoActiva.codi(), this.fotoActiva); // add
        
    }
    
    public void introduirEtiqueta(String titol){
        
        Etiqueta et = this.mpEtiquetes.get(titol); // find
        this.fotoActiva.novaEtiqueta(et);
        
    }
    
}
