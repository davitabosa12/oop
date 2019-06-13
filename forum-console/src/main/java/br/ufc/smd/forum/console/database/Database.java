/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.smd.forum.console.database;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author davitabosa
 */
public class Database {
    
    private static Database instance;
    
    private Map<Integer, Object> users;
    private Map<Integer, Object> moderators;
    private Map<Integer, Object> topics;
    private Map<Integer, Object> messages;
    
    private int moderatorsNextInt = 0;
    private int usersNextInt = 0;
    
    
    private Database(){
        users = new HashMap<>();
        moderators = new HashMap<>();
        topics = new HashMap<>();
        messages = new HashMap<>();
    }
    
    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        } 
        return instance;
    }

    public Map<Integer, Object> getUsers() {
        return users;
    }

    public Map<Integer, Object> getModerators() {
        return moderators;
    }

    public Map<Integer, Object> getTopics() {
        return topics;
    }

    public Map<Integer, Object> getMessages() {
        return messages;
    }
    
    
    
}
