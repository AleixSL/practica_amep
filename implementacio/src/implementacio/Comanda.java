package implementacio;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
    
    //Propietats atributives
    String id;
    Map <String, Article> mpArticles;

    public Comanda(){
        this.id = nouCodiComanda();
        this.mpArticles = new HashMap<>();
    }

    public Map<String, Article> articles() {
        return mpArticles;
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
