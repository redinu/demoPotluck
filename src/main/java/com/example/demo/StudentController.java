package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;

    @GetMapping(path="/add")
    public String addNew(Model m)
     {
                Student student = new Student();
                m.addAttribute("student", student);
                System.out.println(m);
                return "index";
      }
    
    
    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String studentValidator(@ModelAttribute("student") Student s)
    {
    	studentRepository.save(s);
    	return "saved";
			
    }
			
    
    @GetMapping(path="/all")
    public String getAll(Model model)
    {
    	 Iterable<Student> s = studentRepository.findAll();
    	 model.addAttribute("students", s);
    	 
         return "list";
    }
}