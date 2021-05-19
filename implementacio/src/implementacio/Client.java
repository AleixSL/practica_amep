package implementacio;

import java.util.HashMap;
import java.util.Map;
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
public class Client {
    
    public static final String GREEN = "\u001B[42m";
    
    Map <String, Comanda> mpComandes;
    private final String nickname;
    JSONObject json;
    
    // Constructor
    public Client (String nickname){
        this.nickname = nickname;
        this.mpComandes = new HashMap<>();
        this.json = new JSONObject ();
        this.createJSON();
    }

    public Map<String, Comanda> comandes() {
        return mpComandes;
    }
    
    public void createJSON() {
        this.json.put("nickname", this.nickname);
        this.json.put("comandes", this.mpComandes);
        System.out.println(GREEN+"Client creat: "+this.json.toJSONString()+GREEN);
    }
    
    public JSONObject getJSON(){
        return this.json;
    }
    
    
    // Cas d'us 3: novaComanda
    
    public Comanda creaComanda(){
        Comanda co = new Comanda(); //create
        this.mpComandes.put(co.id(), co); //add
        return co;
    }
}
