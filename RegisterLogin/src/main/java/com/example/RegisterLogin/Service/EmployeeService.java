package com.example.RegisterLogin.Service;

import com.example.RegisterLogin.DTO.EmployeeDTO;
import com.example.RegisterLogin.DTO.LoginDTO;
import com.example.RegisterLogin.Response.LoginResponse;

public interface EmployeeService {
	
	String addEmployee(EmployeeDTO employeeDTO);
  public LoginResponse logInEmployee(LoginDTO loginDTO);
}
