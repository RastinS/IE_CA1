package Databases;

import Models.Project;

import java.util.ArrayList;

public class ProjectDB {
    private ArrayList<Project> projects = new ArrayList<Project>();
    private static ProjectDB instance = null;

    private ProjectDB() {}

    public static ProjectDB getInstance() {
        if(instance == null)
            instance = new ProjectDB();
        return instance;
    }

    public void addProject(Project project) {
        projects.add(project);
    }

    public Project getProject(String title) {
        for(int i = 0; i < projects.size(); i++) {
            if(projects.get(i).getTitle().equals(title))
                return projects.get(i);
        }
        return null;
    }
}
