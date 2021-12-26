package com.codegym.controller;

import com.codegym.model.Division;
import com.codegym.model.EducationDegree;
import com.codegym.model.Employee;
import com.codegym.model.Position;
import com.codegym.repository.employee.DivisionRepository;
import com.codegym.repository.employee.EducationDegreeRepository;
import com.codegym.repository.employee.PositionRepository;
import com.codegym.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DivisionRepository divisionRepository;
    @Autowired
    PositionRepository positionRepository;
    @Autowired
    EducationDegreeRepository educationDegreeRepository;

    @ModelAttribute("listPosition")
    public List<Position> getPositions() {
        return positionRepository.findAll();
    }

    @ModelAttribute("listDivision")
    public List<Division> getDivisions() {
        return divisionRepository.findAll();
    }

    @ModelAttribute("listDegree")
    public List<EducationDegree> geEducationDegrees() {
        return educationDegreeRepository.findAll();
    }

    @GetMapping("/listEmployee")
    public String listEmployee(Model model,
                               @RequestParam("s") Optional<String> s,
                               @RequestParam(name = "page", required = false, defaultValue = "0") int page,
                               @RequestParam(name = "size", required = false, defaultValue = "3") int size,
                               @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort) {
        Sort order = null;
        if (sort.equals("ASC")) {
            order = Sort.by("employeeIdCard").ascending();
        } else if (sort.equals("DESC")) {
            order = Sort.by("employeeIdCard").descending();
        }
        Pageable pageable = PageRequest.of(page, size, order);
        Page<Employee> employeePage;
        if (s.isPresent()) {
            employeePage = employeeService.findAllByEmployeeNameContaining(s.get(), pageable);
        } else {
            employeePage = employeeService.findAll(pageable);
        }
        model.addAttribute("listEmployee", employeePage);
        return "/employee/list";
    }

    @GetMapping("/showCreateEmployee")
    public ModelAndView showCreateEmployee() {
        return new ModelAndView("/employee/create", "employee", new Employee());
    }

    @PostMapping("/createEmployee")
    public String createEmployee(@Valid @ModelAttribute Employee employee,
                                 BindingResult bindingResult,
                                 RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            return "/employee/create";
        }
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Add success employee: "
                + employee.getEmployeeName());
        return "redirect:/listEmployee";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("employee", employeeService.findById(id));
        return "/employee/view";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/employee/edit");
        modelAndView.addObject("employee", employee);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute Employee employee, 
                       BindingResult bindingResult,
                       RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()){
            return "/employee/edit";
        }
        employeeService.save(employee);
        redirectAttributes.addFlashAttribute("message", "Update " +
                employee.getEmployeeName() + " success");
        return "redirect:/listEmployee";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id, Model model) {
        Employee employee = employeeService.findById(id);
        model.addAttribute("employee", employee);
        return "/employee/delete";
    }

    @PostMapping("/actionDelete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeService.delete(id);
        return "redirect:/listEmployee";
    }
}
