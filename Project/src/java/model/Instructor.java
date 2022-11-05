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
public class Instructor {
    int inid;
    String inname;
    private ArrayList<SessionGroup> sessions;
    private ArrayList<Group> groups;
    
    String inimage;
    String inemail;

    public Instructor() {
    }

    public int getInid() {
        return inid;
    }

    public void setInid(int inid) {
        this.inid = inid;
    }

    public String getInname() {
        return inname;
    }

    public void setInname(String inname) {
        this.inname = inname;
    }

    public ArrayList<SessionGroup> getSessions() {
        return sessions;
    }

    public void setSessions(ArrayList<SessionGroup> sessions) {
        this.sessions = sessions;
    }

    public ArrayList<Group> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<Group> groups) {
        this.groups = groups;
    }

    public String getInimage() {
        return inimage;
    }

    public void setInimage(String inimage) {
        this.inimage = inimage;
    }

    public String getInemail() {
        return inemail;
    }

    public void setInemail(String inemail) {
        this.inemail = inemail;
    }
    
    
}
