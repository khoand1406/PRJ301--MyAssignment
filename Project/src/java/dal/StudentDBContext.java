/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Attendence;
import model.Student;

/**
 *
 * @author win
 */
public class StudentDBContext extends DBContext {

    @Override
    public ArrayList<Student> list() {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "select [sid], sname, gender, simage,[status], \n" +
"                recordtime from (Student Inner Join Attendence on Student.aid=Attendence.aid)";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student s = new Student();
                Attendence a= new Attendence();
                int sid = rs.getInt("sid");
                String sname = rs.getString("sname");
                Boolean gender= rs.getBoolean("gender");
                String image = rs.getString("simage");
                Timestamp timestamp = rs.getTimestamp("recordtime");
                java.util.Date recordtime
                        = new java.util.Date(timestamp.getTime());
                Boolean status=rs.getBoolean("status");
                
                s.setId(sid);
                s.setName(sname);
                s.setGender(gender);
                s.setImage(image);
                a.setRecordtime(recordtime);
                a.setStatus(status);
                s.setAttend(a);
                students.add(s);
            }
        } catch (SQLException e) {
Logger.getLogger(StudentDBContext.class.getName()).log(Level.SEVERE, null, e);
        }
        return students;
    }

}
