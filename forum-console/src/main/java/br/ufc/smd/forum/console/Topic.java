/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufc.smd.forum.console;

import java.util.Date;
import java.util.List;

/**
 *
 * @author filip
 */
public class Topic {
    private String title;
    private String message;
    private Date date;
    private List<Answer> answerList;

    
    // Contructor
    public Topic(String title, String message, Date date, List<Answer> answerList) {
        this.title = title;
        this.message = message;
        this.date = date;
        this.answerList = answerList;
    }
    
    
    // Methods
    public void addAnswer(Answer newAnswer){
        
    }

    
    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public List<Answer> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer> answerList) {
        this.answerList = answerList;
    }
}
