package com.example.demo.service;

import com.example.demo.controller.MainController;
import com.example.demo.entity.Employee;
import com.example.demo.repo.MainRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class MainService {
    @Autowired
    private MainRepo mainRepo;

    public void save(Employee employee) {
        mainRepo.save(employee);
    }
    public Employee getEmployee(int id) {
        return mainRepo.findById(id).orElse(null);
    }

    public void update(Employee employee) {
        mainRepo.save(employee);
    }


    public  void updateCity(String city, int eid){
      Employee employee =  mainRepo.findById(eid).get();
        employee.setCity(city);
        mainRepo.save(employee);
    }

    public void deleteCity(int eid) {
        Employee employee = mainRepo.findById(eid).orElseThrow(() -> new NoSuchElementException("Employee not found"));
        employee.setCity(null); // or set it to an empty string if you prefer
        mainRepo.save(employee);
    }
    public void deleteName(int eid) {
        Employee employee = mainRepo.findById(eid).orElseThrow(() -> new NoSuchElementException("Employee not found"));
        employee.setName(null); // or set it to an empty string if you prefer
        mainRepo.save(employee);
    }
    public void deleteSalary(int eid) {
        Employee employee = mainRepo.findById(eid).orElseThrow(() -> new NoSuchElementException("Employee not found"));
        employee.setSalary(0); // or set it to an empty string if you prefer
        mainRepo.save(employee);
    }
    public void deleteEmployee(int eid) {
        mainRepo.deleteById(eid);
    }

}
