package Models;

import java.util.ArrayList;

public class Bid {
    private User user;
    private Project project;
    private int bidAmount;
    private int value;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public int getBidAmount() {
        return bidAmount;
    }

    public void setBidAmount(int bidAmount) {
        this.bidAmount = bidAmount;
    }

    public void computeValue() {
        value = 0;
        int skillPoint;
        for(Skill skill : project.getSkillsSet()) {
            skillPoint = user.getSkillPoints(skill);
            if(skillPoint != 0)
                value += 10000 * Math.pow((skillPoint - skill.getPoints()), 2);
        }
        value += project.getBudget() - bidAmount;
    }

    public int getValue() {
        return value;
    }
}
