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
public interface Dao<T> {
    void create(T t);
    void update(T t);
    T getPorld(String id);
    List<T> getAll();
    void delete(T t);
}
