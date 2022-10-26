/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author win
 */
public abstract class BaseAuthentic extends HttpServlet{
    public abstract void processGet(HttpServletRequest request, HttpServletResponse response);
    public abstract void processPost(HttpServletRequest request, HttpServletResponse response);
    
    public boolean isAuthenticated(HttpServletRequest req){
        return req.getSession().getAttribute("account")!=null;
        
    } 
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(isAuthenticated(req)){
            
            processPost(req, resp);
        }else{
            resp.getWriter().println("Access denied!!");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(isAuthenticated(req)){
            
            processGet(req, resp);
        }else{
            resp.getWriter().println("Access denied!!");
        }
    }
    
}
