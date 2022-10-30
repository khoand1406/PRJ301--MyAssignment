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
class TimeSlot {
    int tid;
    String tname;
    private ArrayList<SessionGroup> sessions;

    public TimeSlot() {
    }
    

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public ArrayList<SessionGroup> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<SessionGroup> sessions) {
        this.sessions = sessions;
    }
    
    
}
