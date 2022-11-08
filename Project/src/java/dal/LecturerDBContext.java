/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Instructor;

/**
 *
 * @author win
 */
public class LecturerDBContext extends DBContext {

    @Override
    public void insert(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Object model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Instructor get(int id) {
        try {
            String sql = "select i.inid, i.inname from Instructor i \n"
                    + "where i.inid=? ";
            PreparedStatement stm= connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs= stm.executeQuery();
            while(rs.next()){
                Instructor i= new Instructor();
                i.setInid(rs.getInt("inid"));
                i.setInname(rs.getString("inname"));
                return i;
            }
            

        } catch (SQLException ex) {

        }
        return null;
    }

    @Override
    public ArrayList list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
