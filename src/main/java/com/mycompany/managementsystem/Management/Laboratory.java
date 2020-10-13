/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.managementsystem.Management;

import java.util.ArrayList;
/**
 *
 * @author marco
 */
public class Laboratory {
    private final ArrayList<Project> projects;
    private final ArrayList<Teacher> coordinators;
    private final ArrayList<Person> students;

    public Laboratory() {
        this.projects = new ArrayList();
        this.coordinators = new ArrayList();
        this.students = new ArrayList();
    }
    
}
