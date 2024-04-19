package com.taller_1.taller_1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.taller_1.taller_1.Entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task,Long>{

}
