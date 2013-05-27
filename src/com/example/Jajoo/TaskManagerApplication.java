package com.example.Jajoo;

import android.app.Application;
import com.example.Jajoo.model.Task;

import java.util.ArrayList;


public class TaskManagerApplication extends Application {


    private ArrayList<Task> currentTasks;

    @Override
    public void onCreate() {
        super.onCreate();
        if (currentTasks == null) {
            currentTasks = new ArrayList<Task>();
        }
    }

    public ArrayList<Task> getCurrentTasks() {
        return currentTasks;
    }

    public void setCurrentTasks(ArrayList<Task> currentTasks) {
        this.currentTasks = currentTasks;
    }

    public void addTask(Task task) {
        currentTasks.add(task);
    }
}
