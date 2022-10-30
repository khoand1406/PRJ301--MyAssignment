/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author win
 */
public class Room {
    int rid;
    String rname;
    private ArrayList<SessionGroup> sessions;

    public Room() {
    }
    
    
    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public ArrayList<SessionGroup> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<SessionGroup> sessions) {
        this.sessions = sessions;
    }
    
}
