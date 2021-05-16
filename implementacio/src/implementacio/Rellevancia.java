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
public class Rellevancia {
    
    // Propietats atributives
    private final Indret in;
    private int vegades;
    
    //Constructor
    public Rellevancia (Indret in){
        this.in = in;
        this.vegades = 0;
    }
    
    public void augmentaRellevancia () {
        this.vegades++;
    }

    public int vegades() {
        return vegades;
    }
    
    
    
    
    
}
