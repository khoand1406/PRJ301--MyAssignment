/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Courses;
import model.Group;
import model.Instructor;
import model.Room;
import model.SessionGroup;
import model.TimeSlot;

/**
 *
 * @author win
 */
public class SessionDBContext extends DBContext<SessionGroup> {

    public void updateAttendence(SessionGroup model) {
        try {
            connection.setAutoCommit(false);
            String sql_update = "UPDATE [Session] \n"
                    + "set attended=1\n"
                    + "where [Session].ssid=?";
            PreparedStatement stm = connection.prepareStatement(sql_update);
            stm.setInt(1, model.getId());
            stm.executeUpdate();

            String sql_delete = "DELETE [Session]\n"
                    + "where [Session].ssid=?";

            PreparedStatement stm_remove= connection.prepareStatement(sql_delete);
            stm_remove.setInt(1, model.getId());
            stm_remove.executeUpdate();
        } catch (Exception ex) {

        }
    }

    @Override
    public ArrayList<SessionGroup> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(SessionGroup model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(SessionGroup model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(SessionGroup model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public SessionGroup get(int id) {
        try {
            String sql = "select ses.ssid, ses.[date], ses.[index], ses.attended, "
                    + "g.gid, g.gname, "
                    + "r.rid, r.rname, "
                    + "t.tid, t.tname, i.inid, i.inname, c.cid, c.cname from dbo.[Session] ses\n"
                    + "		inner join GroupS g on g.gid=ses.gid\n"
                    + "		inner join Room r on r.rid= ses.rid\n"
                    + "		inner join TimeSlot t on t.tid= ses.tid\n"
                    + "		inner join Instructor i on i.inid= ses.inid\n"
                    + "		inner join Course c on c.cid= g.cid\n"
                    + "		where ses.ssid= 1";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            stm.setInt(1, id);
            while (rs.next()) {
                SessionGroup s = new SessionGroup();
                s.setId(rs.getInt("ssid"));
                s.setDate(rs.getDate("date"));
                s.setIndex(rs.getInt("index"));
                s.setAttended(rs.getBoolean("attended"));
                Group g = new Group();
                s.setGroup(g);
                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("gname"));
                Room r = new Room();
                s.setRoom(r);
                r.setRid(rs.getInt("rid"));
                r.setRname(rs.getString("rname"));
                TimeSlot t = new TimeSlot();
                s.setSlot(t);
                t.setTid(rs.getInt("tid"));
                t.setTname(rs.getString("tname"));
                Instructor i = new Instructor();
                s.setInstructor(i);
                i.setInid(rs.getInt("inid"));
                i.setInname(rs.getString("inname"));

                Courses c = new Courses();
                g.setCourse(c);
                c.setCid(rs.getInt("cid"));
                c.setCname(rs.getString("cname"));
                return s;

            }
        } catch (Exception ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
