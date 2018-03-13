/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.galgelegweb;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author viktor
 */
public class Todo {
    private String title;
    private String text;
    private Date createdOn;
    private int tal;
    Todo(String title, String text){
        this.title = title;
        this.text = text;
        this.createdOn = new Date();
        this.tal = 46;
    }
    
    String getTitle(){
        return this.title;
    }
    
    String getText(){
        return this.text;
    }
    
    Date getDate(){
        return this.createdOn;
    }
    
    int getTal(){
        return this.tal;
    }
    
}
