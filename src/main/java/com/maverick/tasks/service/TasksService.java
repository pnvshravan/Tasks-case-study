package com.maverick.tasks.service;

import com.maverick.tasks.model.Tasks;
import com.maverick.tasks.repo.TasksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class TasksService {
    @Autowired
    public TasksRepo repo;


    //Service func for retrieving all the existing tasks
    public List<Tasks> getTasks(){
        return repo.findAll();
    }

    //Service func for add a new task into db
    public Tasks addTask(Tasks task) {
        repo.save(task);
        return task;
    }

    public Tasks getTaskbyId(int id) {
        return repo.findById(id).orElse(null);
    }

    public void updateTaskById(int id, Tasks t) {
        Optional<Tasks> status = repo.findById(id);
        if(status.isPresent()){
            Tasks existingTask = status.get();

            //updating the values for existing task
            existingTask.setTitle(t.getTitle());
            existingTask.setDescription(t.getDescription());
            existingTask.setDate(t.getDate());
            existingTask.setUpdated_at(t.getUpdated_at());
            repo.save(t);
        }
    }
    public void markTaskAsCompleted(int id, Tasks t) {
        Optional<Tasks> status = repo.findById(id);
        if (status.isPresent()) {
            Tasks existingTask = status.get();

            //Patching the values for existing task
            existingTask.setStatus(Tasks.Status.completed);
            repo.save(existingTask);
        }
    }

    public void deleteProduct(int id) {
        repo.deleteById(id);
    }
}