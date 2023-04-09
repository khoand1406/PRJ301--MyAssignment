/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.lecturer;

import controller.auth.BaseAuthentic;
import dal.AttendenceDBContext;
import dal.SessionDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendence;
import model.SessionGroup;
import model.Student;


/**
 *
 * @author win
 */
public class TakeAttController extends BaseAuthentic {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TakeAttController</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TakeAttController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        int sesid= Integer.parseInt(request.getParameter("id"));
//        AttendenceDBContext adb= new AttendenceDBContext();
//        ArrayList<Attendence> atts= adb.getAttsBySessionId(sesid);
//        request.setAttribute("atts", atts);
//        SessionDBContext sesdb= new SessionDBContext();
//        SessionGroup ses=  sesdb.get(sesid);
//        request.setAttribute("ses", ses);
//        request.getRequestDispatcher("../view/lecturer/takeatt.jsp").forward(request, response);
//        
//               
//    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        SessionGroup ses= new SessionGroup();
//        ses.setId(Integer.parseInt(request.getParameter("sesid")));
//        String[] stdids= request.getParameterValues("stdid");
//        for(String stdid: stdids){
//            Attendence a = new Attendence();
//            Student s = new Student();
//            a.setStudent(s);
//            a.setSessions(ses);
//            s.setId(Integer.parseInt(stdid));
//            a.setStatus(request.getParameter("present"+stdid).equals("present"));
//            a.setDescription(request.getParameter("description"+stdid));
//            ses.getAttends().add(a);
//        }
//        
//        SessionDBContext db = new SessionDBContext();
//        db.updateAttendence(ses);
//        response.sendRedirect("takeatt?id="+ses.getId());
//        }
    
        

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    @Override
    public void processGet(HttpServletRequest request, HttpServletResponse response) {
            int sesid= Integer.parseInt(request.getParameter("id"));
        AttendenceDBContext adb= new AttendenceDBContext();
        ArrayList<Attendence> atts= adb.getAttsBySessionId(sesid);
        request.setAttribute("atts", atts);
        SessionDBContext sesdb= new SessionDBContext();
        SessionGroup ses=  sesdb.get(sesid);
        request.setAttribute("ses", ses);
        try {
            request.getRequestDispatcher("../view/lecturer/takeatt.jsp").forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(TakeAttController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void processPost(HttpServletRequest request, HttpServletResponse response) {
          SessionGroup ses= new SessionGroup();
        ses.setId(Integer.parseInt(request.getParameter("sesid")));
        String[] stdids= request.getParameterValues("stdid");
        for(String stdid: stdids){
            Attendence a = new Attendence();
            Student s = new Student();
            a.setStudent(s);
            a.setSessions(ses);
            s.setId(Integer.parseInt(stdid));
            a.setStatus(request.getParameter("present"+stdid).equals("present"));
            a.setDescription(request.getParameter("description"+stdid));
            ses.getAttends().add(a);
        }
        
        SessionDBContext db = new SessionDBContext();
        db.updateAttendence(ses);
        try {
            response.sendRedirect("takeatt?id="+ses.getId());
        } catch (IOException ex) {
            Logger.getLogger(TakeAttController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
