/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import jakarta.websocket.Session;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Attendence;
import model.Student;
import model.SessionGroup;
/**
 *
 * @author win
 */
public class AttendenceDBContext extends DBContext<Attendence> {

    public ArrayList<Attendence> getAttsBySessionId(int id) {
        ArrayList<Attendence> atts = new ArrayList<>();
        try {
            String sql = "select st.[sid], st.sname, ses.ssid, ISNULL(att.present,0) present, "
                    + "ISNULL(att.[description], '') [description] from Session ses inner join GroupS g on ses.gid= g.gid\n"
                    + "INNER JOIN Group_Student gs on g.gid=gs.gid\n"
                    + "inner join Student st on st.[sid]= gs.[sid]\n"
                    + "	left join Attend att on att.ssid=ses.ssid\n and st.[sid]=att.[stuid]"
                    + "	where ses.ssid=?";
            PreparedStatement stm= connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs= stm.executeQuery();
            while(rs.next()){
                Attendence att= new Attendence();
                Student s= new Student();
                att.setStudent(s);
                SessionGroup ses= new SessionGroup();
                att.setSessions(ses);
                att.setStatus(rs.getBoolean("present"));
                att.setDescription(rs.getString("description"));
                s.setId(rs.getInt("sid"));
                s.setName(rs.getString("sname"));
                ses.setId(rs.getInt("ssid"));
                atts.add(att);
                       
                
            }

        } catch (SQLException ex) {

        }
        return atts;
    }

    @Override
    public void insert(Attendence model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Attendence model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Attendence model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Attendence get(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Attendence> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
