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
    
    public static final String GREEN = "\u001B[42m";
    public static final String RESET = "\u001B[0m";
    
    // Propietats atributives
    private final Indret in;
    private int vegades;
    
    //Constructor
    public Rellevancia (Indret in){
        this.in = in;
        this.vegades = 0;
        System.out.println(GREEN+"Rellevancia creada: "+this.in.nom()+RESET);
    }
    
    public void augmentaRellevancia () {
        this.vegades++;
    }

    public int vegades() {
        return vegades;
    }
    
    
    
    
    
}
