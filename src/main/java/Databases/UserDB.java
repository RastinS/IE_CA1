package Databases;

import Models.User;

import java.util.ArrayList;

public class UserDB {
    private ArrayList<User> users = new ArrayList<User>();
    private static UserDB instance = null;

    private UserDB() {
    }

    public static UserDB getInstance() {
        if(instance == null)
            instance = new UserDB();
        return instance;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUser(String username) {
        for(int i = 0; i < users.size(); i++) {
            if(users.get(i).getUserName().equals(username))
                return users.get(i);
        }
        return null;
    }
}
