/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.managementsystem.Management;
import java.util.Scanner;
/**
 *
 * @author marco
 */
public class Main{
    private static final Laboratory lab = new Laboratory();
    private static final Scanner scan = new Scanner(System.in);
    
    public static void projectOptions()
    {
        int op;
        System.out.println("Selecione a opção requerida:");
        System.out.println("1- Add Projeto");
        System.out.println("2- Editar Projeto");
        System.out.println("Other -Sair");
        op = scan.nextInt();
        switch(op)
        {
            case 1 ->{
                lab.addProject();
            }
            case 2 ->
            {
                System.out.println("Selecione a opção requerida:");
                System.out.println("1- Add Participante");
                System.out.println("2- Remover Participante");
                System.out.println("3- Alterar Status Projeto");
                System.out.println("Other -Sair");
                switch(scan.nextInt())
                {
                    case 1->{
                        lab.addParticipant();
                    }
                    case 2->{
                        lab.removeParticipant();
                    }
                    case 3->
                    {
                        lab.updateStatus();
                    }
                }
            }
        }
        
    }
    private static int options()
    {
        int op;
        System.out.println("Selecione a opção requerida:");
        System.out.println("1- Projeto");
        System.out.println("2- Aluno");
        System.out.println("3- Professor");
        System.out.println("4- Publicação");
        System.out.println("5- Orientação");
        System.out.println("6- Relatorio");
        System.out.println("7- Consulta");
        System.out.println("Other - sair");
        
        op = scan.nextInt();
        return op;
    }
    
    public static void queryOptions()
    {
        
        int op;
        System.out.println("Selecione a opção requerida:");
        System.out.println("1- Consulta Colaborador");
        System.out.println("2- Consulta Projeto");
        System.out.println("Other -Sair");
        op = scan.nextInt();
        switch(op)
        {
            case 1 ->{
                lab.contributorQuery();
            }
            case 2 ->
            {
                lab.projectsQuery();
            }
        }
    }
    
    public static void main(String[] args) {
        boolean runApp = true;
        do
        {
            switch(Main.options())
            {
                case 1 -> {
                    projectOptions();
                }
                case 2 -> {
                    lab.addStudent();
                }
                case 3 -> {
                    lab.addTeacher();
                }
                case 4 -> {
                    lab.addPublication();
                }
                case 5 -> {
                    lab.addOrientation();
                }
                case 6 -> {
                    lab.logOptions();
                }
                case 7->
                {
                    queryOptions();
                }
                default -> runApp = false;
            }
        }while(runApp);
    }
    
}
