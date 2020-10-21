/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.managementsystem.Management;
import java.util.ArrayList;

public class Project {

    private String title = "";
    private int status = 0;
    private String target = "";
    private String begin = "",end = "";
    private String description = "";
    private String financier = "";
    private Double value = 0.0;
    private Teacher coordinator;
    private final ArrayList<Student> participant;
    private final ArrayList<Publication> publication;
    
    public Project()
    {
        this.participant = new ArrayList();
        this.publication = new ArrayList();
    }
    
    public void addParticipant(Student p)
    {
        this.participant.add(p);
    }  
    
    public void removeParticipant(Student p)
    {
        this.participant.remove(p);
    }
    
    public ArrayList<Student> getParticipants()
    {
        return this.participant;
    }

    public Teacher getCoordinator() {
        return coordinator;
    }

    public void setCoordinator(Teacher coordinator) {
        this.coordinator = coordinator;
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getStatus() {
        return status;
    }

    public boolean setStatus(int status) {
        switch(status)
        {
            case 0->{
                if(begin.equals(""))return false;
                if(end.equals(""))return false;
                if(description.equals(""))return false;
                if(target.equals(""))return false;
                if(title.equals(""))return false;
                if(begin.equals(""))return false;
                if(financier.equals(""))return false;
                if(value == 0.0)return false;
            }
            case 2->{
                if(publication.isEmpty())return false;
            }
        }
        this.status = status;
        return true;
    }
    
    public void addPublication(Publication p)
    {
        if(this.status == 1)
            publication.add(p);
    }
    
    public ArrayList<Publication> getPublications()
    {
        return this.publication;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFinancier() {
        return financier;
    }

    public void setFinancier(String financier) {
        this.financier = financier;
    }   
    
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}
