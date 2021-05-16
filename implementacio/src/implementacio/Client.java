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
public class Client {
    
    
    Map <String, Comanda> mpComandes;
    private final String nickname;
    
    // Constructor
    public Client (String nickname){
        this.nickname = nickname;
        this.mpComandes = new HashMap<>();
    }

    public Map<String, Comanda> comandes() {
        return mpComandes;
    }
    
    
    
    // Cas d'us 3: novaComanda
    
    public Comanda creaComanda(){
        Comanda co = new Comanda(); //create
        this.mpComandes.put(co.id(), co); //add
        return co;
    }
}
