package Models;

import java.util.ArrayList;


public class User {
    private String userName;
    private ArrayList<Skill> skills = new ArrayList<Skill>();

    public User() {}

    public void setUserName (String userName) {
        this.userName = userName;
    }

    public String getUserName () {
        return this.userName;
    }

    public int getSkillPoints(Skill skill) {
        for(Skill currSkill : skills) {
            if(currSkill.getName().equals(skill.getName()))
                return currSkill.getPoints();
        }
        return 0;
    }

    public void addSkill(Skill skill) {
        this.skills.add(skill);
    }
}
