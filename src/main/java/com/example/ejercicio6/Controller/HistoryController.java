package com.example.ejercicio6.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping(value = "/history")
public class HistoryController {


    @GetMapping(value = {"","/"})
    public String historialEmpleado(){
        return "";
        //COMPLETAR
    }



}
