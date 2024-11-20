package com.maverick.tasks;

import com.maverick.tasks.model.Tasks;
import com.maverick.tasks.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TasksController {

    @Autowired
    public TasksService service;

    //Retrieve all the existing tasks
    @GetMapping("/tasks")
    public ResponseEntity<List<Tasks>> getTasks(){
        return new ResponseEntity<>(service.getTasks(), HttpStatus.OK);
    }

    //Add a new task
    @PostMapping("/tasks")
    public ResponseEntity<?> addTask(@RequestBody Tasks task){
        try {
             return new ResponseEntity<>(service.addTask(task), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Retrieve a task by its task_id
    @GetMapping("tasks/{id}")
    public ResponseEntity<?> getTaskbyId(@PathVariable int id){
        Tasks t = service.getTaskbyId(id);
        if(t!=null)
            return new ResponseEntity<>(t, HttpStatus.OK);
        else
            return new ResponseEntity<>("Not found",HttpStatus.NOT_FOUND);
    }

    //Update a task details by id
    @PutMapping("tasks/{id}")
    public ResponseEntity<String> updateTaskById(@PathVariable int id, @RequestBody Tasks task){
        try{
            service.updateTaskById(id,task);
        }
        catch(Exception e) {
            return new ResponseEntity<>("Failed to Update", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

    @PatchMapping("tasks/{id}/complete")
    public ResponseEntity<String> markTaskAsCompleted(@PathVariable("id") int id, @RequestBody Tasks task){
        try{
            service.markTaskAsCompleted(id,task);
        }
        catch(Exception e) {
            return new ResponseEntity<>("Failed to Patch", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Patched", HttpStatus.OK);
    }

    @DeleteMapping("tasks/{id}")
    public ResponseEntity<String> markTaskAsCompleted(@PathVariable("id") int id) {
        Tasks task = service.getTaskbyId(id);
        if (task != null) {
            service.deleteProduct(id);
            return new ResponseEntity<>("Deleted the task with id:"+id, HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Task not found", HttpStatus.NOT_FOUND);
    }
}
