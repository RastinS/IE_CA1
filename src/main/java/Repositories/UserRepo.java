package Repositories;

import Databases.UserDB;
import Models.Skill;
import Models.User;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserRepo {
    private static UserDB userDB;

    public static void init() {
        userDB = UserDB.getInstance();
    }

    public static void addNewUser (String userData) throws JSONException{
        JSONObject newUserData = new JSONObject(userData);
        User newUser = new User();
        newUser.setUserName(newUserData.getString("username"));

        JSONArray skills = newUserData.getJSONArray("skills");
        for(int i = 0; i < skills.length(); i++)
            newUser.addSkill(Skill.makeNewSkill(skills.getJSONObject(i)));
        userDB.addUser(newUser);
    }

    public static User findUser(String username) {
        return userDB.getUser(username);
    }
}
