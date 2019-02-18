package Models;

import org.json.JSONException;
import org.json.JSONObject;

public class Skill {
    private String name;
    private int points;

    public Skill() {}

    public void setPoints(int points) {
        this.points = points;
    }

    public int getPoints() {
        return points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Skill makeNewSkill(JSONObject data) throws JSONException {
        Skill newSkill = new Skill();
        newSkill.setName(data.getString("name"));
        newSkill.setPoints(data.getInt("points"));
        return newSkill;
    }
}
