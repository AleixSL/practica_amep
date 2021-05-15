package implementacio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aleix
 */
public class Foto extends Vendible {
    
    // Propietats atributives
    private final int any;
    private int puntuacio;
    Indret preponderant;
    
    
    public Foto (int any, String descripcio, Indret in){
        super(descripcio);
        this.any = any;
        this.puntuacio = 0;
        this.preponderant = in;
        preponderant.afegeixFoto(this);
    }
    
}
