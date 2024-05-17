package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    private MainService mainService;

    @PostMapping("/Employee/save")
    public String postOperation(@RequestBody Employee employee) {
        try {
            mainService.save(employee);
        } catch (Exception e) {
            return "error " + e.getMessage();
        }
        return "success";
    }

    @GetMapping("/Employee/get")
    public Employee getEmployeeDetails(@RequestParam("id") int eid) {
        return mainService.getEmployee(eid);
    }

        @PutMapping("/Employee/update")
    public String updateData(@RequestBody Employee employee) {
        try {
            mainService.update(employee);
            return "success";
        } catch (Exception e) {
            return "error " + e.getMessage();
        }

    }
    @PutMapping("Employee/updateA/{city}/{id}")
    public String updateCityDetails (@PathVariable ("city") String city,@PathVariable ("id")int eid){
        try{ mainService.updateCity(city,eid);
        }catch (Exception e){

            return "error  " + e.getMessage();
        }
        return "success";
    }


     @DeleteMapping("/Employee/deleteA/{id}")
    public String deleteCity(@PathVariable("id") int eid) {
        try {
            mainService.deleteCity(eid);
        } catch (Exception e) {
            return "error " + e.getMessage();
        }
        return "success";
    }
    @DeleteMapping("/Employee/deleteAllValue/{id}")
    public String deleteAddress(@PathVariable("id") int id) {
        try {
            mainService.deleteCity(id);
            mainService.deleteName(id);
            mainService.deleteSalary(id);
        } catch (Exception e) {
            return "error " + e.getMessage();
        }
        return "success";
    }
    @DeleteMapping("/delete/{eid}")
    public void deleteEmployee(@PathVariable("eid") int eid) {
        mainService.deleteEmployee(eid);
    }

}
