package com.taller_1.taller_1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.taller_1.taller_1.Entity.Task;
import com.taller_1.taller_1.Service.TaskService;

import java.util.List;

@Controller
@RequestMapping("/")
public class TaskController {
    @Autowired
    private TaskService objTaskService;

    @GetMapping
    public String showViewTask(Model objModel,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "2") int size) {

        /* Obtenemos la lista de tareas */
        Page<Task> listTask = this.objTaskService.findAllPaginate(page - 1, size);

        /* Cargamos la lista en el modelo */
        objModel.addAttribute("listTask", listTask); // LLave-valor
        objModel.addAttribute("currentPage", page); // LLave-valor
        objModel.addAttribute("totalPage", listTask.getTotalPages()); // LLave-valor
        return "viewTask";
    }

    @GetMapping("form")
    public String showViewForm(Model model) {
        model.addAttribute("coder", new Task());
        model.addAttribute("action", "/create-task");
        return "viewForm";
    }

    @PostMapping("create-task")
    public String createTask(@ModelAttribute Task objTask){
        this.objTaskService.create(objTask);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        this.objTaskService.delete(id);

        // Redireccionar a la lista de Task
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateTask(@PathVariable Long id, Model model) {
        Task objTask = this.objTaskService.findById(id);
        model.addAttribute("task", objTask);
        model.addAttribute("action", "/edit/" + id);
        return "viewForm";
    }

    @PostMapping("edit/{id}")
    public String updateTask(@PathVariable Long id, @ModelAttribute Task objTask) {
        this.objTaskService.update(id, objTask);
        return "redirect:/";
    }

}
