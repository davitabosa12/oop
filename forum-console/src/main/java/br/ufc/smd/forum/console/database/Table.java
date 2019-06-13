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
public abstract class Table<T> {
    protected Map<Integer, T> data;
    protected int nextId = 0;
    public Table(){
        data = new HashMap<>();
    }
    
    abstract T getFromId(int id);
    abstract Map<Integer, T> getAll();
    abstract int create(T data);
    abstract boolean update(T data);
    abstract boolean delete(T data);
    
    public int getNextId(){
        return nextId;
    }
}
