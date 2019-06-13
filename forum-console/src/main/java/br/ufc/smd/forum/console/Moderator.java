/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.smd.forum.console;


/**
 *
 * @author filip
 */
public class Moderator extends User{
    // Constructor
    public Moderator(String nameId, String email, String password, boolean banned) {
        super(nameId, email, password, banned);
    }
    
    
    // Method
    public void banUser(User user){
        user.setBanned(true);
        
    }
}
