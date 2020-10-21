/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.managementsystem.Management;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/**
 *
 * @author marco
 */
public class Laboratory {

    private final Map<String,Student> students =  new HashMap<>();
    private final Map<String,Teacher> teacher =  new HashMap<>();
    private final Map<String,Person> person =  new HashMap<>();
    
    private final Map<String,Project> project =  new HashMap<>();
    private final ArrayList<Student> studentsList = new ArrayList();
    private final ArrayList<Teacher> teacherList = new ArrayList();
    private final ArrayList<Project> projectsList = new ArrayList();
    private final ArrayList<Orientation> orientations = new ArrayList();
    private final Scanner scan = new Scanner(System.in);
    private int colaborators = 0;
    private int elaboration = 0;
    private int progress = 0;
    private int finished = 0;
    private int orientation = 0;
    private int publish = 0;
    
    private void print(String s)
    {
        System.out.println(s);
    }
    private void print(int i)
    {
        System.out.println(i);
    }
    
    public void addStudent()
    {
        print("Digite o nome:");
        Student p = new Student();
        String name = scan.next();
        p.setName(name);
        students.put(p.getName(), p);
        person.put(p.getName(), p);
        studentsList.add(p);
        colaborators++;
    }    
    
    public void addTeacher()
    {
        print("Digite o nome:");
        Teacher t = new Teacher();
        String name = scan.next();
        t.setName(name);
        teacher.put(t.getName(), t);
        teacherList.add(t);
        person.put(t.getName(), t);
        colaborators++;
    }
    
    private Project getProject()
    {
        Project p = null;
        String title;
        do
        {
            print("Titulo do projeto(exit -> sair):");
            title = scan.next();
            p = project.get(title);
            if(p == null)
                print("Nao encontrado!");
        }while(title.equals("exit"));
        return p;
    }
    
    public void updateStatus()
    {
        Project p = getProject();
        int actual = p.getStatus();
        if(actual == 2)
        {
            print("Projeto finalizado!");
        }
        if(p.setStatus(actual+1))
        {
            print("Status Atualizado!");
            if(actual == 0)
            {
                this.elaboration--;
                this.progress++;
            }
            else if(actual == 1)
            {
                this.progress--;
                this.finished++;
            }
        }
        else
            print("Problema ao atualizar Status");
    }
    
    public Teacher getTeacher()
    {
        Teacher t = null;
        String teacher_name;
        do
        {
            print("Professor:");
            teacher_name= scan.next();
            t = this.teacher.get(teacher_name);
            if(t==null)
                print("Professor não encontrado!");
        }while(t == null);
        return t;
    }
    
    public void addProject()
    {
        print("Title:");
        String title = scan.next();
        print("Target:");
        String target = scan.next();
        print("Descrição:");
        String description = scan.next();
        print("Begin(mm/dd/yyyy):");
        String begin = scan.next();
        print("End(mm/dd/yyyy):");
        String end = scan.next();
        print("Financiador:");
        String financier = scan.next();
        String teacher_name;
        Teacher t = getTeacher();        
        Project p = new Project();       
        
        p.setDescription(description);
        p.setTitle(title);
        p.setTarget(target);
        p.setBegin(begin);
        p.setEnd(end);
        p.setCoordinator(t);
        p.setFinancier(financier);
        project.put(p.getTitle(), p);
        projectsList.add(p);
        this.elaboration++;
        addParticipant(p);
    }   
    public void addParticipant()
    {
        Project p = getProject();
        if(p.getStatus() != 0)
            print("Projeto nao está em Elaboração!");
        else
            addParticipant(p);
    }
    
    public void removeParticipant()
    {
        Project p = getProject();
        Student student;
        do
        {
            student = getStudent();
            if(student == null)break;
            student.removeProject(p.getTitle());
            p.removeParticipant(student);
        }while(true);
        
    }
    
    public Student getStudent()
    {
        String student_name;
        Student student = null;
        do
        {
            print("Nome do estudante(exit -> sair):");
            student_name = scan.next();
            student = students.get(student_name);
            if(student == null)
                print("Estudante nao encontrado!");
        }while(!student_name.equals("exit")&&student == null);
        return student;
    }
    
    public void addParticipant(Project p)
    {
        Student student = null;
        do
        {
            student = getStudent();
            if(student == null)break;
            if(student.getProjectsInProgress()<2) {
                student.addProject(p.getTitle());
                p.addParticipant(student);
            } else print("Aluno com muitas participações!");
        }while(true);
    }
    
    public void logOptions()
    {
        print("Colaboradores: ");
        print(this.colaborators);
        
        print("Projetos em Elaboração: ");
        print(this.elaboration);
        print("Projetos em Andamento: ");
        print(this.progress);
        print("Projetos em Concluidos: ");
        print(this.finished);
        print("Total de Projetos: ");
        print(this.elaboration+this.progress+this.finished);
        
        print("Produção academica - Orientação: ");
        print(this.orientation);
        print("Produção academica - Publicação: ");
        print(this.publish);        
    }
    
    private boolean isValid(Project p)
    {
        if(p == null)
            print("Projeto não encontrado!");
        else if(p.getStatus()!=1)
            print("Projeto não está em andamento!!");   
        return (p!=null && p.getStatus() == 1);
    }
    
    public void addPublication( )
    {
        Project p;
        do
        {
            p = getProject();
        }while(!isValid(p)/*Verificando se projeto é valido*/);
        Publication pub = new Publication();//criando objeto Publication
        print("Titulo");
        String title = scan.next();//Pegando o titulo da publicação
        print("Conferencia:");
        String conference = scan.next();//Pegando a conferencia
        print("Ano: ");
        int year = scan.nextInt();//Ano
        pub.setTitle(title);//atribuindo o titulo a publicação
        pub.setYear(year);//atribuindo o ano
        pub.setConference(conference);//atribuindo conferencia
        p.addPublication(pub);//adicionando publicação  
        this.publish++;
    }
    
    public void addOrientation()
    {
        print("Titulo: ");
        String title = scan.next();
        print("Inicio2"
                + "a"
                + ": ");
        int begin = scan.nextInt();
        print("Fim: ");
        int end = scan.nextInt();
        Teacher t = getTeacher();
        Student student = getStudent();
        
        
        Orientation o = new Orientation();
        
        o.setBegin(begin);
        o.setCoordinator(t);
        o.setEnd(end);
        o.setStudent(student);
        o.setTitle(title);
        t.addOrientation(o);
        
        
        this.orientations.add(o);
        this.orientation++;
    }
    
    public void projectsQuery()
    {
        Project p = getProject();
        print("Titulo:");
        print(p.getTitle());
        print("Objetivo:");
        print(p.getTarget());
        print("Inicio:");
        print(p.getBegin());
        print("Fim:");
        print(p.getEnd());
        print("Financiador:");
        print(p.getFinancier());
        print("Coordenador:");
        print(p.getCoordinator().getName());
        switch(p.getStatus())
        {
            case 0 ->{
                print("Em elaboração!");
            }
            case 1->
            {
                print("Em Andamento!");
            }
            default ->{
                print("Concluido!");
            }
        }
        print("Participantes:");
        ArrayList<Student> studentsInTheProject = p.getParticipants();
        studentsInTheProject.forEach(student -> {
            print(student.getName());
        });
        
        Map<String,Publication> show = new HashMap<>();
        ArrayList<Publication> _publications = p.getPublications();
        Publication pub = null;
        int maior = 0;
        for (Publication _orientation : _publications) {
            maior = 0;
            for(Publication single_publication:_publications)
            {
                if(single_publication.getYear()>maior && show.get(single_publication.getTitle())==null)
                {
                    maior = single_publication.getYear(); 
                    pub = single_publication;
                }
            }
            if(pub != null)
            {
                print("Title:");
                print(pub.getTitle());  
                print("Ano:");
                print(pub.getYear());  
                show.put(pub.getTitle(), pub);
            }
        }
    }
    
    public Person getPerson()
    {
        
        String contributor_name;
        Person contributor = null;
        do
        {
            print("Nome do Colaborador(exit -> sair):");
            contributor_name = scan.next();
            contributor = students.get(contributor_name);
            if(contributor == null)
                print("Colaborador nao encontrado!");
        }while(!contributor_name.equals("exit")&&contributor == null);
        return contributor;
    }
    
    public void contributorQuery()
    {
        Person p = getPerson();
        print("Name:");
        print(p.getName());
        Map<String,Orientation> show = new HashMap<>();
        ArrayList<Orientation> _orientations = p.getOrientations();
        Orientation ori = null;
        int maior = 0;
        for (Orientation _orientation : _orientations) {
            maior = 0;
            for(Orientation single_orientation:_orientations)
            {
                if(single_orientation.getEnd()>maior && show.get(single_orientation.getTitle())==null)
                {
                    maior = single_orientation.getEnd(); 
                    ori = single_orientation;
                }
            }
            if(ori != null)
            {
                print("Title:");
                print(ori.getTitle()); 
                print("Fim:");
                print(ori.getEnd());  
                show.put(ori.getTitle(), ori);
            }
        }
    }
}
