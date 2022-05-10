package com.hibernate.dao;

import com.hibernate.models.Department;

import java.util.List;

public interface DepartmentI {
    List<Department> getAllDepartments();

    Department createDepartment(Department d);

    boolean updateDepartment(Department d);

    boolean deleteDepartment(Department d);

    Department getDepartmentById(int id);

}
