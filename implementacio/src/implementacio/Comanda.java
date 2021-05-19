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
public class Comanda {
    
    public static final String GREEN = "\u001B[42m";
    
    //Propietats atributives
    String id;
    Map <String, Article> mpArticles;
    JSONObject json;

    public Comanda(){
        this.id = nouCodiComanda();
        this.mpArticles = new HashMap<>();
        this.json = new JSONObject ();
        this.createJSON();
    }

    public Map<String, Article> articles() {
        return mpArticles;
    }
    
    public void createJSON() {
        this.json.put("id", id);
        this.json.put("numVariacions", this.mpArticles);
        System.out.println(GREEN+"Comanda creada: "+this.json.toJSONString()+GREEN);
    }
    
    public JSONObject getJSON(){
        return this.json;
    }

    public String id() {
        return id;
    }
    
    public String nouCodiComanda (){
        UUID uuid = UUID.randomUUID();
        long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
        return Long.toString(l, Character.MAX_RADIX);
    }
    
    // Cas d'us 3: novaComanda
    
    public void afegeixArticle(Foto f, int num){
        Article a = new Article (f, num);
        this.mpArticles.put(a.id(), a);
    }
    
    public void afegeixArticle(Vendible a){
        Article ar = new Article (a);
        this.mpArticles.put(ar.id(), ar);
    }
    
    
}
