package com.riwi.holamundo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//This class will be a controller
@Controller
//Request mapping create the rute base for access the controller
@RequestMapping("/controller")

public class HolaMundo {

    //Get ,apping create the specific rute where to shoot the method
    @GetMapping("saludar")
    //permit answer in format text or json 
    @ResponseBody

    public String showMessage(){
        return "Hola mundo";
    }
}
