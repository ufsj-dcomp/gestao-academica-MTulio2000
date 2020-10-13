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
    String name;
    ArrayList<Publication> publications = new ArrayList();
    
    public void addPublication(Publication p)
    {
        this.publications.add(p);
    }
}
