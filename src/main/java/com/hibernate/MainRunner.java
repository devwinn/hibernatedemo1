package com.hibernate;


import com.hibernate.models.Department;
import com.hibernate.services.DepartmentService;
import lombok.extern.java.Log;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;

@Log
public class MainRunner
{
    private static SessionFactory factory;
    public static void main( String[] args ) {
        DepartmentService departmentService = new DepartmentService();

        Department new1 = new Department("Maintenance", "AZ");

        departmentService.createDepartment(new Department("Human Resources", "AZ"));
        departmentService.createDepartment(new Department("Information Technology", "CA"));
        departmentService.createDepartment(new1);

        log.info(departmentService.getAllDepartments().toString());


    }
}
