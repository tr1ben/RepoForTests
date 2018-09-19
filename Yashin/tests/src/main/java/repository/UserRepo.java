package repository;

import model.User;

import java.util.ArrayList;

public class UserRepo {

    private static final ArrayList<User> users = new ArrayList<>();

    public static void createRepo() {
        users.add(new User(0, "Alex1", "1111"));
        users.add(new User(1, "Alex2", "1111"));
        users.add(new User(2, "Alex3", "1111"));
        users.add(new User(3, "Alex4", "1111"));
    }

    public static ArrayList<User> getUsers() {
        return users;
    }

    public static void add(User user) {

        int id = 0;

        for (int i = 0; i < users.size(); i++) {
            if (id == users.get(i).getId()) {
                id++;
                i = 0;
            }
        }

        user.setId(id);

        users.add(user);

    }
}
