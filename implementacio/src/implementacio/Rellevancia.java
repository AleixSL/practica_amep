package implementacio;

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
public class Rellevancia {
    
    public static final String GREEN = "\u001B[42m";
    
    // Propietats atributives
    private final Indret in;
    private int vegades;
    JSONObject json;
    
    //Constructor
    public Rellevancia (Indret in){
        this.in = in;
        this.vegades = 0;
        this.json = new JSONObject();
        this.createJSON();
    }
    
    public void createJSON() {
        this.json.put("in", this.in);
        this.json.put("vegades", this.vegades);
        System.out.println(GREEN+"Rellevancia creada: "+this.json.toJSONString()+GREEN);
    }
    
    public JSONObject getJSON(){
        return this.json;
    }
    
    public void augmentaRellevancia () {
        this.vegades++;
    }

    public int vegades() {
        return vegades;
    }
    
    
    
    
    
}
