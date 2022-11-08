/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.TimeSlot;

/**
 *
 * @author win
 */
public class TimeSlotDBContext extends DBContext{

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
    public Object get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<TimeSlot> list() {
       ArrayList<TimeSlot> slots= new ArrayList<>();
        try{
           String sql="select t.tid, t.[description] from TimeSlot t";
           PreparedStatement stm=connection.prepareStatement(sql);
           ResultSet rs= stm.executeQuery();
           while(rs.next()){
               TimeSlot t= new TimeSlot();
               t.setTid(rs.getInt("tid"));
               t.setDescription(rs.getString("description"));
               slots.add(t);
           }
       }catch(SQLException e){
           
       }
        return slots;
    }
    
}
