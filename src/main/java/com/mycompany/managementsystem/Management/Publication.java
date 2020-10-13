/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.managementsystem.Management;

/**
 *
 * @author marco
 */
public class Publication {
    private String title;
    private String conference;
    private String year;
    private Project project;
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getConference() {
        return conference;
    }

    public void setConference(String conference) {
        this.conference = conference;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Project getProject() {
        return project;
    }

    public boolean setProject(Project p) {
        if(p.getStatus().equals("Em andamento"))
        {
            this.project = p;
            return true;
        }
        return false;
    }
}
