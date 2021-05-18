package implementacio;
import java.util.HashMap;
import java.util.Map;
import java.time.LocalDate;

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
    Album albumActiu;
    Comanda comandaActiva;
    private LocalDate ultimReinici;
    
    // Repositoris
    Map <String, Vendible> mpVendibles; //Cataleg
    Map <String, Indret> mpIndrets;
    Map <String, Etiqueta> mpEtiquetes;
    Map <String, Client> mpClients;
    
    // Constructor
    public K (String [] predefinides, String [] clients){
       
        this.mpVendibles = new HashMap<>();
        this.mpIndrets = new HashMap<>();
        this.mpEtiquetes = new HashMap<>();
        this.mpClients = new HashMap<>();
       
        for (String predefinida : predefinides) {
            Etiqueta et = new Etiqueta(predefinida);
            this.mpEtiquetes.put(predefinida, et);
        }
        
        for (String client : clients) {
            Client c = new Client(client);
            this.mpClients.put(client, c);
        }
        this.ultimReinici = LocalDate.now();
        // this.ultimReinici = this.ultimReinici.minusYears(5);
    }

    
    @Override
    public String toString() {
        
        String vendibles = "{\n"; 
        String indrets = "{\n"; 
        String etiquetes = "{\n"; 
        String clients = "{\n"; 
        
        for (String name: mpVendibles.keySet()) {
            Vendible v = mpVendibles.get(name);
            String descripcio = v.descripcio();
            vendibles += "\tcodi: "+name+", descripcio: "+descripcio;
            if (v.getType()=="foto") {
                Foto f = v.getFoto();
                vendibles+=", puntuacio: "+f.puntuacio()+"\n";
            }
                
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
        
        for (String name: mpClients.keySet()) {
            Client c = mpClients.get(name);
            String comandes = "";
            for (String coname: c.comandes().keySet()) {
                Comanda co = c.comandes().get(coname);
                comandes +="\n\t\t"+co.articles().toString();
            }   
            clients += "\tnom: "+name+", comandes: "+comandes+"\n";
        }
        
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
    
    
    // Cas d'us 2: nouAlbum
    
    public void iniAlbum(String titol, String descripcio){
        this.albumActiu = new Album(titol, descripcio); // create
        this.mpVendibles.put(this.albumActiu.codi(), this.albumActiu); // add
    }
    
    public void seleccionaFoto(Foto Foto){
        this.albumActiu.afegeixFoto(Foto);
        Foto.etiquetacioAlbum(this.albumActiu);
        
    }
    
    public void fiAlbum(){
        this.albumActiu.fiAlbum();
    }
    
    
    // Cas d'us 3: novaComanda
    public void iniComanda(String nickname){
        Client c = this.mpClients.get(nickname);
        if (c!=null) this.comandaActiva = c.creaComanda();
        
    }
    
    public void inclouFoto(String codi, int num){
        Vendible v = this.mpVendibles.get(codi);
        if (v!=null) {
            this.fotoActiva = v.getFoto();
            this.comandaActiva.afegeixArticle(this.fotoActiva, num);
            this.fotoActiva.actualitzaEstadistiques(num);
        }
        
          
    }
    
    public void inclouAlbum(String codi){
        Vendible v = this.mpVendibles.get(codi);
        if (v!=null) {

            this.comandaActiva.afegeixArticle(v);
            v.actualitzaEstadistiques();
        }
    }
    
    // Cas d'ús 4 reiniciaPunts
    public boolean iniReinici() {
        boolean res = false;
        if (ultimReinici()) {
            for (String name: mpVendibles.keySet()) {
                Vendible v = mpVendibles.get(name);
                if (v.getType()=="foto") {
                    Foto f = v.getFoto();
                    f.reiniciVendible();
                }
            }

            for (String name: mpIndrets.keySet()) {
                Indret in = mpIndrets.get(name);
                in.reiniciIndret();
            }
            res = true;
        }
        return res;
    }
    
    public boolean ultimReinici() {
        boolean res = false;
        LocalDate avui = LocalDate.now();
        LocalDate ult = this.ultimReinici.plusYears(5);
        if(avui.isEqual(ult) || avui.isAfter(ult)){
            res = true;
            this.ultimReinici = LocalDate.now();
        }
        return res;
    }

    
}
