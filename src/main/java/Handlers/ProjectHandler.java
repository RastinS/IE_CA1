package Handlers;

import Databases.ProjectDB;
import Models.Project;
import Models.Skill;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ProjectHandler {
    private static ProjectDB projectDB;

    public static void init() {
        projectDB = ProjectDB.getInstance();
    }

    public static void addNewProject(String projectData) throws JSONException {
        JSONObject newProjectData = new JSONObject(projectData);
        Project newProject = new Project();
        newProject.setTitle(newProjectData.getString("title"));
        newProject.setBudget(newProjectData.getInt("budget"));

        JSONArray skillSetData = newProjectData.getJSONArray("skills");
        for(int i = 0; i < skillSetData.length(); i++)
            newProject.addSkill(Skill.makeNewSkill(skillSetData.getJSONObject(i)));
        projectDB.addProject(newProject);
    }

    public static Project findProject(String title) {
        return projectDB.getProject(title);
    }
}
