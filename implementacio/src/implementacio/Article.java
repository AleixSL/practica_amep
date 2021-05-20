package implementacio;

import java.nio.ByteBuffer;
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
public final class Article {
    
    public static final String GREEN = "\u001B[42m";
    public static final String RESET = "\u001B[0m";
    
    private final String id;
    private final Vendible v;
    private final int numVariacions;

    public Article(Foto f, int num) {
        this.numVariacions = num;
        this.id = nouCodiArticle();
        this.v = f;
        System.out.println(GREEN+"Article creat: "+this.id+RESET);
    }
    
    public Article(Vendible a) {
        this.numVariacions = 0;
        this.id = nouCodiArticle();
        this.v = a;
        System.out.println(GREEN+"Article creat: "+this.id+RESET);
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
