package com.ex.demo.Model;


import javax.persistence.*;

@Entity
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long projectId;
    private String projectName;
    private String projectDescription;
    private StageType stage;


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
    

   

}
