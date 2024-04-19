package com.taller_1.taller_1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taller_1.taller_1.Entity.Task;
import com.taller_1.taller_1.Service.TaskService;

import java.util.List;

@Controller
@RequestMapping("/")
public class TaskController {
    @Autowired
    private TaskService objTaskService;

    @GetMapping
    public String showViewTask(Model objModel){
        List<Task> listTask = this.objTaskService.findAll();
        objModel.addAttribute("listTask", listTask);
        return "viewTask";
    }

    @GetMapping("/form")
    public String showViewForm(Model model){
        model.addAttribute("task", new Task());
        model.addAttribute("action", "/create-task");
        return "viewForm";
    }

    @PostMapping("/create-task")
    public String createTask(@ModelAttribute Task objTask){
        this.objTaskService.create(objTask);
        return "redirect:/";
    }
}
