/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.smd.forum.console;

import java.io.InputStream;

/**
 *
 * @author davitabosa
 */
public class Resource {
    public Resource(){
        
    }
    
    public InputStream getFirebaseJSON(){
        return Resource.class.getResourceAsStream("/resources/forum-poo-fb4571cd7fdc");
    }
}
