/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.smd.forum.console.database;

import br.ufc.smd.forum.console.User;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 *
 * @author davitabosa
 */
public class UserTable extends Table<User>{
    
    public UserTable(){
        super();
    }
    
    @Override
    public User getFromId(int id) {
        return (User) data.get(id);
    }

    @Override
    public Map<Integer, User> getAll() {
        return data;
    }

    @Override
    public int create(User u) {
        int thisId = nextId;
        data.put(nextId++, u);
        return thisId;
    }

    @Override
    public boolean update(User u) {
        for(Entry<Integer, User> entry : data.entrySet()){
            if(entry.getValue().equals(u)){
                data.put(entry.getKey(), u);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(User u) {
        for(Entry<Integer,User> entry : data.entrySet()){
            if(entry.getValue().equals(u)){
                data.remove(entry.getKey());
                return true;
            }
        }
        return false;
    }
    
}
