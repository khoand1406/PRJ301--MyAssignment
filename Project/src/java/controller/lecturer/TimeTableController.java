/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.lecturer;

import dal.LecturerDBContext;
import dal.SessionDBContext;
import dal.TimeSlotDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import model.Instructor;
import model.SessionGroup;
import model.TimeSlot;
import util.DateTimeHelper;


/**
 *
 * @author win
 */
public class TimeTableController extends HttpServlet {

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
        int lid= Integer.parseInt(request.getParameter("lid"));
        String from_raw= request.getParameter("from");
        String to_raw= request.getParameter("to");
        java.sql.Date from = null;
        java.sql.Date to = null;
        
        if(from_raw==null|| from_raw.length()==0){
            Date today = new Date();
            int todayOfWeek= DateTimeHelper.getDayOfWeek(today);
            Date e_from = DateTimeHelper.addDays(today, 2 - todayOfWeek);
            Date e_to = DateTimeHelper.addDays(today, 8-todayOfWeek);
            from = DateTimeHelper.toDateSql(e_from);
            to = DateTimeHelper.toDateSql(e_to);
        }
        else
        {
            from = java.sql.Date.valueOf(from_raw);
            to = java.sql.Date.valueOf(to_raw);
        }
        request.setAttribute("from", from);
        request.setAttribute("to", to);
        request.setAttribute("dates", DateTimeHelper.getDateList(from, to));
        TimeSlotDBContext tidb= new TimeSlotDBContext();
        ArrayList<TimeSlot> slots= tidb.list();
        request.setAttribute("slots", slots);
        SessionDBContext sesDB = new SessionDBContext();
        ArrayList<SessionGroup> sessions = sesDB.filter(lid, from, to);
        request.setAttribute("sessions", sessions);
        
        LecturerDBContext lecDB = new LecturerDBContext();
        Instructor lecturer = lecDB.get(lid);
        request.setAttribute("lecturer", lecturer);
        
        request.getRequestDispatcher("../view/lecturer/timetable.jsp").forward(request, response);
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
