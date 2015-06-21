/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.helloworld;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Schuyler
 */
public class CommentHandeler 
{
    static List<Comment> getComments()
    {
        List<Comment> comments = new ArrayList<Comment>();
        try 
        {
            String save = System.getProperty("saveFile");
            comments = (ArrayList<Comment>) FileToucher.load(save);
        } 
        catch (ClassNotFoundException ex) 
        {
            Logger.getLogger(CommentHandeler.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(CommentHandeler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return comments;
    }
}
