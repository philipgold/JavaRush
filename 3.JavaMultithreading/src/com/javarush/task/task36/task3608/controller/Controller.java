package com.javarush.task.task36.task3608.controller;

import com.javarush.task.task36.task3608.model.Model;
import com.javarush.task.task36.task3608.view.EditUserView;
import com.javarush.task.task36.task3608.view.UsersView;

public class Controller {
    private Model model;
    private UsersView usersView;
    private EditUserView editUserView;

    public void setEditUserView(EditUserView editUserView) {
        this.editUserView = editUserView;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public void onShowAllUsers(){
        this.model.loadUsers();
        this.usersView.refresh(model.getModelData());
    }

    public void onShowAllDeletedUsers() {
        this.model.loadDeletedUsers();
        this.usersView.refresh(model.getModelData());
    }

    public void onOpenUserEditForm(long userId){
        this.model.loadUserById(userId);
        this.editUserView.refresh(model.getModelData());
    }
    public void setUsersView(UsersView usersView) {
        this.usersView = usersView;
    }

    public void onUserDelete(long id) {
        this.model.deleteUserById(id);
        this.usersView.refresh(this.model.getModelData());
    }

    public void onUserChange(String name, long id, int level) {
        this.model.changeUserData(name, id, level);
        this.usersView.refresh(this.model.getModelData());
    }
}
