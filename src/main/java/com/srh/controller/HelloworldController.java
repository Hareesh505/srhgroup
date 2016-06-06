package com.srh.controller;

import com.srh.model.Employee;
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
public class HelloworldController {

    @Autowired
    EmployeeRepository employeeRepository;

    private static final String VIEW_INDEX = "index";
    private static final String VIEW_SUCCESS = "success";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(ModelMap model) {

        model.addAttribute("message", "Welcome");
        // Spring uses InternalResourceViewResolver and return back index.jsp
        return VIEW_INDEX;

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView welcomeName(@RequestParam("empName") String empName,
                                    @RequestParam("empState") String empState) {

        Employee employee = new Employee(empName,empState);
        employeeRepository.save(employee);

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("empName",employee.getEmpName());
        model.put("empState",employee.getEmpState());
        model.put("empId",employee.getId());
        return new ModelAndView(VIEW_SUCCESS,model);

    }

}