package Models;

import java.util.ArrayList;

public class Project {
    private String title;
    private ArrayList<Skill> skillsSet = new ArrayList<Skill>();
    private int budget;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<Skill> getSkillsSet() {
        return skillsSet;
    }

    public void setSkillsSet(ArrayList<Skill> skillsSet) {
        this.skillsSet = skillsSet;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public void addSkill(Skill skill) {
        skillsSet.add(skill);
    }
}
