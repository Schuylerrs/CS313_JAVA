/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.helloworld;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Schuyler
 */
public class Comment 
    implements Serializable
{
    private String username;
    private String comment;
    private Date timestamp;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Comment(String username, String comment) 
    {
        this.username = username;
        this.comment = comment;
        this.timestamp = new Date();
    }
    
    @Override
    public String toString() 
    {
        String result = "<div class=\"jumbotron\"><h3> " + username + " wrote:</h3><br/>";
        result += comment + "<br/>";
        result += "On: " + timestamp + "</div>";
        
        return result;
    }
}
