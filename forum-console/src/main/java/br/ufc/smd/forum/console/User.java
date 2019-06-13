/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.smd.forum.console;

import java.util.List;

/**
 *
 * @author filip
 */
public class User {
    protected String nameId;
    protected String email;
    protected String password;
    //protected List<Topic> topicList; // nao e muito interessante puxar todas as mensagens quando puxar info do usuario
    protected boolean banned;

    
    // Constructor
    public User(String nameId, String email, String password, boolean banned) {
        this.nameId = nameId;
        this.email = email;
        this.password = password;
        this.banned = banned;
    }
    
    
    // Methods
    public void createTopic(Topic newTopic){
        
    }
    
    
    public void replyToTopic(Topic topic, Answer newAnswer){
        
    }

    
    // Getters and Setters
    public String getNameId() {
        return nameId;
    }

    public void setNameId(String nameId) {
        this.nameId = nameId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public boolean isBanned() {
        return banned;
    }

    public void setBanned(boolean banned) {
        this.banned = banned;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User){
            User userObj = (User) obj;    
            return this.nameId.equals(userObj.nameId);
        }
        return false;
        
        
    }
    
    
}
