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
public class Person {
    private String name;
    private final ArrayList<Orientation> orientations;

    public Person() {
        this.orientations = new ArrayList();
    }
    
    public boolean addOrientation(Orientation p)
    {
        if(p.getCoordinator() != null) {
            this.orientations.add(p);
            return true;
        }   
        return false;
    }

    public String getName() {
        return name;
    }
    
    public ArrayList<Orientation> getOrientations()
    {
        return this.orientations;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
