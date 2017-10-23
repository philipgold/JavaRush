package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData;

    public FakeModel() {
        this.modelData = new ModelData();
    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUsers() {
        User u1 = new User("A", 1, 1);
        User u2 = new User("B", 2, 1);
        List<User> users = new ArrayList<>();
        users.add(u1);
        users.add(u2);

        this.modelData.setUsers(users);
    }

    @Override
    public ModelData getModelData() {
        return this.modelData;
    }
}
