package com.web.demo.Service;
import com.web.demo.entity.Coder;
import com.web.demo.repository.CoderRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoderService {
    // resgistrer the inyection of dependecies in spring boot
    @Autowired
    private CoderRepository objCoderRepository;
    public List<Coder> findAll(){
        return this.objCoderRepository.findAll();
    }

    public Coder create(Coder objCoder){
        return this.objCoderRepository.save(objCoder);
    }
}
