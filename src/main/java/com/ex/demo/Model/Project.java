package com.ex.demo.Model;


import java.util.List;

import javax.persistence.*;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectId;
    private String projectName;
    private String projectDescription;
    private StageType stage;
    
    @OneToMany(mappedBy="theProject",cascade={CascadeType.REMOVE})  //many employees can connect to one project
    private List<Employee> employees;
    
    public enum StageType{

        COMPLETED("COMPLETED"),
        NOTSTARTED("NOTSTARTED"),
        INPROGRESS("INPROGRESS");
        
        public String getStageType() {
            return stageType;
        }
        private final String stageType;
        private StageType(String stageType) {
            this.stageType = stageType;
        }
      
        
    }
    
    
    public Project() {
    }


    //Constructor
    public Project(String projectName, String projectDescription, StageType stage) {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
        this.stage = stage;
    }


    public long getProjectId() {
        return projectId;
    }


    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }


    public String getProjectName() {
        return projectName;
    }


    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    public String getProjectDescription() {
        return projectDescription;
    }


    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }


    public StageType getStage() {
        return stage;
    }


    public void setStage(StageType stage) {
        this.stage = stage;
    }


    public List<Employee> getEmployees() {
        return employees;
    }


    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
    

   

}
