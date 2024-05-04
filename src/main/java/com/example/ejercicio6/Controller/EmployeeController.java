package com.example.ejercicio6.Controller;
import com.example.ejercicio6.Entity.Employees;
import com.example.ejercicio6.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jakarta.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    com.example.ejercicio6.Repository.EmployeesRepository employeesRepository;

    @Autowired
    com.example.ejercicio6.Repository.JobsRepository jobsRepository;

    @Autowired
    com.example.ejercicio6.Repository.DepartmentsRepository departmentsRepository;

    @GetMapping(value = {"","/"})
    public String listaEmployee(Model model){
        model.addAttribute("listaEmployee", employeesRepository.findAll());
        model.addAttribute("listaJobs", jobsRepository.findAll());
        model.addAttribute("listaDepartments", departmentsRepository.findAll());
        return "employee/lista";
    }

    @GetMapping("/new")
    public String nuevoEmployeeForm(@ModelAttribute ("employees") Employees employees, Model model) {
        //COMPLETAR
        return "employee/newEmployee";
    }

    @PostMapping("/save")
    public String guardarEmployee(@ModelAttribute("employees") @Valid Employees employees, BindingResult bindingResult,
                                  RedirectAttributes attr,
                                  @RequestParam(name="fechaContrato", required=false) String fechaContrato, Model model) {
        if(bindingResult.hasErrors()){
            model.addAttribute("listaJobs", jobsRepository.findAll());
            model.addAttribute("listaJefes", employeesRepository.findAll());
            model.addAttribute("listaDepartments", departmentsRepository.findAll());
            return "employee/crearEmployee";
        }else {
            if (employees.getId() == 0) {
                attr.addFlashAttribute("msg", "Empleado creado exitosamente");
                employees.setHireDate(new Date().toInstant());
                employeesRepository.save(employees);
                return "redirect:/employee";
            } else {
                try {
                    employees.setHireDate(new SimpleDateFormat("yyyy-MM-dd").parse(fechaContrato).toInstant());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                employeesRepository.save(employees);
                attr.addFlashAttribute("msg", "Empleado actualizado exitosamente");
                return "redirect:/employee";
            }
        }
    }

    @GetMapping("/edit")
    public String editarEmployee(@ModelAttribute ("employees") Employees employees,Model model,
                                 @RequestParam("id") int id) {

        Optional<Employees> optionalEmployees = employeesRepository.findById(id);
        model.addAttribute("listaEmployee", employeesRepository.findAll());
        model.addAttribute("listaJobs", jobsRepository.findAll());
        model.addAttribute("listaDepartments", departmentsRepository.findAll());

        if (optionalEmployees.isPresent()) {
            employees = optionalEmployees.get();
            model.addAttribute("employees", employees);
            return "employee/newEmployee";
        } else {
            return "redirect:/employee/list";
        }
        //COMPLETAR
    }


    @GetMapping("/delete")
    public String borrarEmpleado(Model model,
                                 @RequestParam("id") int id,
                                 RedirectAttributes attr) {

        Optional<Employees> optEmployees = employeesRepository.findById(id);

        if (optEmployees.isPresent()) {
            employeesRepository.deleteById(id);
            attr.addFlashAttribute("msg","Empleado borrado exitosamente");
        }
        return "redirect:/employee";

    }
/*
    @PostMapping("/search")
    public String buscar (){

        //COMPLETAR
    }
    */

}