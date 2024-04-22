package com.taller_1.taller_1.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    
    public Page<Task> findAllPaginate(int page, int size) {
        /* Validar que la página no sea menor a 0 */
        if (page < 0) {
            page = 0;
        }

        /* Crear la paginación */
        Pageable objPage = PageRequest.of(page, size);

        return this.objTaskRepository.findAll(objPage);
    }
    
    public Task create(Task objTask){
        return this.objTaskRepository.save(objTask);
    }

    public void delete(Long id) {
        // Llamar al repositorio
        this.objTaskRepository.deleteById(id);
    }

    /**
     * Método para obtener por Id
     */
    public Task findById(Long id) {
        /* Busca unatarea por ID y encaso de no ser encontrado devuelve un null */
        return this.objTaskRepository.findById(id).orElse(null);
    }

    /**
     * Método para actulizar un tarea
     */
    public Task update(Long id, Task task) {
        /* 1. Buscar el tarea por ID */
        Task objTaskDB = this.findById(id);

        /*
         * Verificamos que el tarea exista
         */
        if (objTaskDB == null)
            return null;

        /* Actualizar el tarea viejo */
        objTaskDB = task;
        /**
         * El método save verifica, si el objeto tiene la llave primaria
         * llena entonces actualizar de lo contrario , crea un nuevo registro
         */
        return this.objTaskRepository.save(objTaskDB);
    }
}
