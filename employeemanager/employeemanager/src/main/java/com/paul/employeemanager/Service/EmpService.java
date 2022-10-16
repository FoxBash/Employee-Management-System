package com.paul.employeemanager.Service;

import com.paul.employeemanager.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpService {

    @Autowired
    private EmpRepo repo;

    public List<Employee> getEmployees() {
        return repo.findAll();
    }

    public void addEmployee(Employee employee) {
        repo.save(employee);
    }

    public Optional<Employee> findOneById(Long id) {
        return repo.findById(id);
    }

    public void deleteEmp(Employee employee) {
        repo.delete(employee);
    }
}
