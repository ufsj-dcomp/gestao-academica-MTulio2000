/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.managementsystem.Management;
import java.util.ArrayList;

public class Project {

    private String title = "";
    private String status = "Em elaboração";
    private String target = "";
    private String begin = "",end = "";
    private String description = "";
    private String financier = "";
    private Double value = 0.0;
    private Teacher coordinator;
    private final ArrayList<Person> participant;
    
    public Project()
    {
        this.participant = new ArrayList();
    }
    
    public void addParticipant(Person p)
    {
        this.participant.add(p);
    }  
    
    public void removeParticipant(Person p)
    {
        this.participant.remove(p);
    }
    
    public ArrayList<Person> getParticipants()
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

    public String getStatus() {
        return status;
    }

    public boolean setStatus(String status) {
        if(begin.equals(""))return false;
        if(end.equals(""))return false;
        if(description.equals(""))return false;
        if(target.equals(""))return false;
        if(title.equals(""))return false;
        if(begin.equals(""))return false;
        if(financier.equals(""))return false;
        if(value == 0.0)return false;
        this.status = status;
        return true;
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
