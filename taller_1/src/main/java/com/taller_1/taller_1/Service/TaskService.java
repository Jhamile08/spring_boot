package com.taller_1.taller_1.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import com.taller_1.taller_1.Entity.Task;
import com.taller_1.taller_1.Repository.TaskRepository;

@Service
public class TaskService {
    @Autowired
    private TaskRepository objTaskRepository;
    public List<Task> findAll(){
        return this.objTaskRepository.findAll();
    }
    
    public Task create(Task objTask){
        return this.objTaskRepository.save(objTask);
    }
}
