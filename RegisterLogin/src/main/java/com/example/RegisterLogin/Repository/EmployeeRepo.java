package com.example.RegisterLogin.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.RegisterLogin.Entity.Employee;

public interface EmployeeRepo  extends JpaRepository<Employee, Integer>{
	
	Employee findByEmail(String email);
	
	Optional<Employee> findOneByEmailAndPassword(String email,String password);

}
