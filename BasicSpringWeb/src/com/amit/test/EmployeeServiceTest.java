package com.amit.test;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amit.model.Employee;
import com.amit.service.EmployeeService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringTestConfig.class })
@ActiveProfiles(profiles = "dev")
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private Environment environment;

	@Autowired
	private MessageSource messageSource;

	@Test
	public void testDepartmentList() {
		List<String> departmentList = employeeService.getDepartmentList();
		System.out.println(departmentList.size());
		if (environment.getActiveProfiles()[0].equals("dev")) {
			assertTrue(messageSource.getMessage("department.list.error", null, Locale.getDefault()),
					departmentList.size() == 3);
		} else if (environment.getActiveProfiles()[0].equals("test")) {
			assertTrue(messageSource.getMessage("department.list.error", null, Locale.getDefault()),
					departmentList.size() == 2);
		}
	}

	@Test
	public void testEmployeeList() {
		List<Employee> employeeList = employeeService.getEmployeeList();
		System.out.println(employeeList);
		if (environment.getActiveProfiles()[0].equals("dev")) {
			assertTrue(messageSource.getMessage("employee.list.error", null, Locale.getDefault()),
					employeeList.size() == 3);
		} else if (environment.getActiveProfiles()[0].equals("test")) {
			assertTrue(messageSource.getMessage("employee.list.error", null, Locale.getDefault()),
					employeeList.size() == 2);
		}
	}
}
