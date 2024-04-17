package com.web.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.web.demo.entity.Coder;

// Repository is the resposible of all the data persistence 
@Repository
public interface CoderRepository extends JpaRepository<Coder,Long>{

    

}
