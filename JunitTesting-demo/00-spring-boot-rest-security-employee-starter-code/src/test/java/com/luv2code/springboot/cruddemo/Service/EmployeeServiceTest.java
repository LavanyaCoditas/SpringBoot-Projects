package com.luv2code.springboot.cruddemo.Service;

import com.luv2code.springboot.cruddemo.dao.EmployeeRepository;
import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import com.luv2code.springboot.cruddemo.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceTest
{
    //Mocking employeeRepository does that the test doesn’t hit the database,
    @Mock
    EmployeeRepository employeeRepository;
    @InjectMocks
    EmployeeServiceImpl employeeService;
    //create a mock object
    //now mocikto will come in picture

    @Test
    void addEmployeeTest()
    {
        // gives null pointer exception=> so add mock object
        Employee emp =new Employee();

        emp.setId(1L);
        emp.setFirstName("lavanya");
        emp.setLastName("bhosale");
        emp.setEmail("lavanyabhosale15@gmail.com");

        Mockito.when(employeeRepository.save(emp)).thenReturn(emp);

       Employee emp_added= employeeService.save(emp);
       Assertions.assertNotNull(emp_added);
        Assertions.assertEquals(emp.getId(),emp_added.getId());
        System.out.println(emp_added);
    }

    @Test
    public void deleteEmployeeByIdTest()
    {
        //tell the method to do nothing when it is called
        //specifies that this behavior applies when deleteById is invoked
        doNothing().when(employeeRepository).deleteById(1L);
        System.out.println("product deletion");
        employeeService.deleteById(1L);
       verify(employeeRepository,times(1)).deleteById(1L);
    }
}
