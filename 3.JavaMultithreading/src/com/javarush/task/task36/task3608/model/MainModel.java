package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;
import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {
    private ModelData modelData;
    private UserService userService;

    public MainModel() {
        this.modelData = new ModelData();
        this.userService = new UserServiceImpl();

    }

    private List<User> getAllUsers(){
        return this.userService.filterOnlyActiveUsers(this.userService.getUsersBetweenLevels(1, 100));
    }

    @Override
    public ModelData getModelData() {
        return this.modelData;
    }

    @Override
    public void loadUsers() {
        modelData.setDisplayDeletedUserList(false);
        modelData.setUsers(getAllUsers());
    }

    @Override
    public void loadDeletedUsers() {
        List<User> users =  this.userService.getAllDeletedUsers();
        this.modelData.setDisplayDeletedUserList(true);
        this.modelData.setUsers(users);
    }

    @Override
    public void deleteUserById(long id) {
        this.userService.deleteUser(id);
        this.loadUsers();
    }

    @Override
    public void changeUserData(String name, long id, int level) {
        this.userService.createOrUpdateUser(name, id, level);
        this.loadUsers();
    }

    @Override
    public void loadUserById(long userId) {
        User user = this.userService.getUsersById(userId);
        this.modelData.setActiveUser(user);
    }


}
