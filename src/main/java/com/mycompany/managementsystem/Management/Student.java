/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.managementsystem.Management;

import java.util.ArrayList;
import javax.lang.model.SourceVersion;

/**
 *
 * @author marco
 */
public class Student extends Person{
    int projectsInProgress = 0;
    ArrayList<String> projects = new ArrayList();

    public int getProjectsInProgress() {
        return projectsInProgress;
    }

    private void addProjectsIn() {
        this.projectsInProgress++;
    }

    private void removeProjectsIn() {
        this.projectsInProgress--;
        if(this.projectsInProgress <0)
            this.projectsInProgress = 0;
    }
    
    public void addProject(String s)
    {
        this.projects.add(s);
    }
    
    public void removeProject(String s)
    {
        boolean remove = this.projects.remove(s);
        if(remove)
        {
            System.out.println("Removido");
            this.removeProjectsIn();
        }
        else
            System.out.println("Nao removido");
        
    }
    
}
