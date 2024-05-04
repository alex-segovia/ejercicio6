package com.example.laboratorio4.controller;


import com.example.ejercicio6.Dto.EmployeeDepartmentDto;
import com.example.ejercicio6.Repository.EmployeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/Search")
public class SearchController {

    @Autowired
    EmployeesRepository employeesRepository;

    @GetMapping(value = {"","/"})
    public String indice(){
        return "Search/indice";
    }

    @GetMapping(value = {"/Salario"})
    public String listaEmpleadosMayorSalrio (){

      //COMPLETAR
        return "Search/lista2";
    }

    @PostMapping("/busqueda")
    public String buscar (){

        //COMPLETAR
    }

    @GetMapping(value = "/Filtro2")
    public String cantidadEmpleadosPorPais (){

        //COMPLETAR
        return "/Search/salario";
    }

    @GetMapping("/listar")
    public String listarEmpleadoDep(@RequestParam("idDepartment") int idDepartment, Model model) {
        List<EmployeeDepartmentDto> listaDepartamentosEmpleados = employeesRepository.listarEmpleadoDepartamento(idDepartment);
        model.addAttribute("listaDepartamentosEmpleados", listaDepartamentosEmpleados);


        return "/Search/lista3";

    }


}
