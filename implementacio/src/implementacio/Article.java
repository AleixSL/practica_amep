package implementacio;

import java.nio.ByteBuffer;
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
public final class Article {
    
    public static final String GREEN = "\u001B[42m";
    
    private final String id;
    private final Vendible v;
    private final int numVariacions;
    JSONObject json = new JSONObject();

    public Article(Foto f, int num) {
        this.numVariacions = num;
        this.id = nouCodiArticle();
        this.v = f;
        this.createJSON();
    }
    
    public Article(Vendible a) {
        this.numVariacions = 0;
        this.id = nouCodiArticle();
        this.v = a;
        this.json = new JSONObject ();
        this.createJSON();
    }
    
    public void createJSON() {
        this.json.put("id", id);
        this.json.put("vendible", this.v);
        this.json.put("numVariacions", this.numVariacions);
        System.out.println(GREEN+"Article creat: "+this.json.toJSONString()+GREEN);
    }
    
    public JSONObject getJSON(){
        return this.json;
    }
    
    public String nouCodiArticle (){
        UUID uuid = UUID.randomUUID();
        long l = ByteBuffer.wrap(uuid.toString().getBytes()).getLong();
        return Long.toString(l, Character.MAX_RADIX);
    }

    public String id() {
        return id;
    }
    
    
    
}
