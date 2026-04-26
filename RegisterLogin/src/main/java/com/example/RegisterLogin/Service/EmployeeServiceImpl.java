package com.example.RegisterLogin.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.RegisterLogin.DTO.EmployeeDTO;
import com.example.RegisterLogin.DTO.LoginDTO;
import com.example.RegisterLogin.Entity.Employee;
import com.example.RegisterLogin.Repository.EmployeeRepo;
import com.example.RegisterLogin.Response.LoginResponse;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public String addEmployee(EmployeeDTO employeeDTO) {
		Employee employee = new Employee(employeeDTO.getEmployeeId(), employeeDTO.getEmployeeName(),
				employeeDTO.getEmail(), this.encoder.encode(employeeDTO.getPassword()));

		employeeRepo.save(employee);
		return employee.getEmployeeName();
	}

	
	
	@Override
	public LoginResponse logInEmployee(LoginDTO loginDTO) {

	    Employee employee = employeeRepo.findByEmail(loginDTO.getEmail());
	    if (employee != null) {

	        String rawPassword = loginDTO.getPassword();
	        String encodedPassword = employee.getPassword();

	        boolean isPwdRight = encoder.matches(rawPassword, encodedPassword);

	        if (isPwdRight) {
	            return new LoginResponse("Login Success", true);
	        } else {
	            return new LoginResponse("Incorrect Password", false);
	        }

	    } else {
	        return new LoginResponse("Email Not Exist", false);
	    }
	}
}
