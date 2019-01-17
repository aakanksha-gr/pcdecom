package com.pcdgroup.cms.PcdEcom.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcdgroup.cms.PcdEcom.BasicRegistration.Passwordsecurity;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	Passwordsecurity passwordsecurity;
	
	@Override
	public String createEmployee(Employeemaster employeemaster) {
		
		try {
			
			passwordsecurity = new Passwordsecurity();
			
			if(null != employeeRepository.checkDuplicateEmail(employeemaster.getEmployeeemail())) {
				
				return "Email already exist, please try different..!";
				
			} else {
				
				if(null != employeeRepository.getMaxId()) {
					
					employeemaster.setEmployeeid(employeeRepository.getMaxId()+1);
					
				} else {
					
					employeemaster.setEmployeeid(1);
					
				}
				
				employeemaster.setEmployeepassword(passwordsecurity.encrypt(employeemaster.getEmployeepassword()));
				employeeRepository.save(employeemaster);
				
				return "Employee created..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
	
	}

	@Override
	public Employeemaster getEmployee(Integer employeeid) {
		
		try {
			
			if(null != employeeid) {
				
				return employeeRepository.getEmployee(employeeid);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public List<Employeemaster> getAllEmploiees() {
		
		try {
			
			if(null != employeeRepository.getAllEmploiees() && employeeRepository.getAllEmploiees().size() > 0) {
				
				return employeeRepository.getAllEmploiees();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	
	}

	@Override
	public String deleteEmployee(Integer employeeid) {
		
		try {
			
			if(null != employeeid) {
				
				if(null != employeeRepository.getEmployee(employeeid)) {
					
					employeeRepository.deleteById(employeeid);
					
					return "Employee removed..!";
					
				} else {
					
					return "No employee avilable with provided id..!";
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
	
	}

	@Override
	public String updateEmployee(Employeemaster employeemaster, Integer employeeid) {
	
		try {
	
			passwordsecurity = new Passwordsecurity();
			
			if(null != employeeid) {
				
				if(null != employeeRepository.checkDuplicateEmail(employeemaster.getEmployeeemail(), employeeid)) {
					
					return "Email id already used by other employee..!";
					
				} else {
					
					employeemaster.setEmployeeid(employeeid);
					
					if(null != employeemaster.getEmployeepassword()) {
					
						employeemaster.setEmployeepassword(passwordsecurity.encrypt(employeemaster.getEmployeepassword()));
						
					}
					
					employeeRepository.save(employeemaster);
					
					return "Employee updated..!";
					
				}
				
			}	
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
	
	}

	@Override
	public List<?> getEmployeeByWorkingArea(String employeeworkingbrand, String employeeworkingtype, Integer index) {
		
		try {
			
			if(null != employeeworkingbrand && null != employeeworkingtype && null != index) {
				
				if(null != employeeRepository.getEmployeeByWorkingArea(employeeworkingbrand, employeeworkingtype, index) && employeeRepository.getEmployeeByWorkingArea(employeeworkingbrand, employeeworkingtype, index).size() > 0) {
					
					return employeeRepository.getEmployeeByWorkingArea(employeeworkingbrand, employeeworkingtype, index);
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}
	
}
