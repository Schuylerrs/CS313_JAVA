/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.helloworld;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Schuyler
 */
@WebServlet(name = "ShowComments", urlPatterns = {"/ShowComments"})
public class ShowComments extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            if (System.getProperty("saveFile") == null)
            {
                String dir = System.getenv("OPENSHIFT_DATA_DIR");
                
                if (dir == null)
                {
                    dir = getServletContext().getRealPath(System.getenv("file.separator"));
                }
                
                System.setProperty("saveFile", dir + System.getenv("file.separator") + "comments");
            }

            String username = (String)request.getSession().getAttribute("username");
            if(username == null)
            {
                String newname = (String)request.getParameter("username");
                if (newname == null)
                {
                    request.getRequestDispatcher("Login.jsp").forward(request, response);
                }
                else
                {
                    request.getSession().setAttribute("username", newname);
                }
            }

            List<Comment> myList = CommentHandeler.getComments();

            request.getSession().setAttribute("comments", myList);
            request.setAttribute("comments", myList);
            request.getRequestDispatcher("CommentList.jsp").forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
