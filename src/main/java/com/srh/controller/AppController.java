package com.srh.controller;

import com.srh.model.Employee;
import com.srh.model.Person;
import com.srh.mongo.repositories.PersonRepository;
import com.srh.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by RaghavendraKulkarni on 5/18/2016.
 */


@Controller
public class AppController {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    PersonRepository personRepository;

    private static final String VIEW_INDEX = "index";
    private static final String VIEW_SUCCESS = "success";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcomeView() {
        return VIEW_INDEX;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView successView(@RequestParam("empName") String empName,
                                    @RequestParam("empState") String empState,
                                    @RequestParam("empBG") String empBG) {

        Employee employee = new Employee(empName,empState);
        Person person = new Person(empName,empBG);
        employeeRepository.save(employee);
        personRepository.save(person);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("empName",employee.getEmpName());
        model.put("empState",employee.getEmpState());
        model.put("empId",employee.getId());
        model.put("empBg",person.getPersonBloodGroup());
        return new ModelAndView(VIEW_SUCCESS,model);

    }

}