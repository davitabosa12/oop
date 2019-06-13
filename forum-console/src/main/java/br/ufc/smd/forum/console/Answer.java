/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.smd.forum.console;

import java.util.Date;

/**
 *
 * @author filip
 */
public class Answer {
    private String userNameId;
    private String message;
    private Date date;

    
    // Constructor
    public Answer(String userNameId, String message, Date date) {
        this.userNameId = userNameId;
        this.message = message;
        this.date = date;
    }

    
    // Getters and Setters
    public String getUserNameId() {
        return userNameId;
    }

    public void setUserNameId(String userNameId) {
        this.userNameId = userNameId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
