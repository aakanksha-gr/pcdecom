package com.pcdgroup.cms.PcdEcom.Employee;

import java.util.List;

public interface EmployeeService {

	public String createEmployee(Employeemaster employeemaster);
	public Employeemaster getEmployee(Integer employeeid);
	public List<Employeemaster> getAllEmploiees();
	public String deleteEmployee(Integer employeeid);
	public String updateEmployee(Employeemaster employeemaster, Integer employeeid);
	public List<?> getEmployeeByWorkingArea(String employeeworkingbrand, String employeeworkingtype, Integer index);
	
}
