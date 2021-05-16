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
public class Album extends Vendible {
    
    // Repositoris
    Map <String, Foto> mpFotos;
    Map <String, Rellevancia> mpRellevancies;
    
    // Propietats atributives
    private final String titol;
    private Boolean especial;
    private int totalFotos;

    
    // Constructor
    public Album (String titol, String descripcio){
        super(descripcio, "album");
        this.mpFotos = new HashMap <>(); // create
        this.mpRellevancies = new HashMap <>(); // create
        this.titol = titol;
        this.especial = false;
        this.totalFotos = 0;
    }
    
    //Cas d'us 2: nouAlbum
    
    public void afegeixFoto(Foto Foto){
        
        this.mpFotos.put(Foto.codi(), Foto); // add
         this.totalFotos++;
        // A part
        afegeixIndret(Foto);
        
    }
    
    public void afegeixEtiqueta(Etiqueta e){
        if (!this.mpEtiquetes.containsKey(e.titol())){ // addx
                this.mpEtiquetes.put(e.titol(), e); 
            }
    }
    
    public void afegeixIndret(Foto Foto){
        Indret in = Foto.obtenirPreponderant();
        Rellevancia r = this.mpRellevancies.get(in.nom());
        if (r==null) {
            r = new Rellevancia(in); //create
            this.mpRellevancies.put(in.nom(), r); //add
        }
        
        r.augmentaRellevancia();
        Rellevancia rprep;
        
        if (!this.mpRellevancies.isEmpty() && this.totalFotos>1){
             rprep = this.mpRellevancies.get(this.obtenirPreponderant().nom());
             if (r.vegades() > rprep.vegades())
                this.setPreponderant(in);
        } else {
            this.setPreponderant(in);
        }
       
        in.publicaVendible(this);
        
    }
    
    public void fiAlbum (){
        Rellevancia r = this.mpRellevancies.get(this.obtenirPreponderant().nom()); //find
        if ((float)r.vegades()/this.totalFotos >= 0.7) this.especial = true;
        System.out.println(this.titol+": {"+this.mpFotos+"}");
        System.out.println("Preponderant: " + this.obtenirPreponderant().nom() );
        System.out.println("Especial: "+this.especial);
    }
    
}
