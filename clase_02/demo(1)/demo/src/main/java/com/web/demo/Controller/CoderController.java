package com.web.demo.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.web.demo.entity.Coder;
import java.util.List;
import com.web.demo.Service.CoderService;

@Controller
@RequestMapping("/")
public class CoderController {
 @Autowired
 private CoderService objCoderService;
 
    @GetMapping
    public String showViewCoder(Model objModel){
        List<Coder> listCoder = this.objCoderService.findAll();
        objModel.addAttribute("listCoder", listCoder);
        return "viewCoders";
    }

    @GetMapping("form")
    public String showViewForm(Model model){
        model.addAttribute("coder", new Coder());
        model.addAttribute("action", "/create-coder");
        return "viewForm";
    }

    @PostMapping("create-coder")
    public String createCoder(@ModelAttribute Coder objCoder){
        this.objCoderService.create(objCoder);
        return "redirect:/";
    }
    
     
}
