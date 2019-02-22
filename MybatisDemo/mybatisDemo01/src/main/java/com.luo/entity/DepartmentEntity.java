package com.luo.entity;

import lombok.Data;

import java.util.List;

/**
 * @author：罗金星 date 2019/2/15 15:37
 **/
@Data
public class DepartmentEntity {
    private int id;
    private String departmentname;
    private List<EmployeeEntity> emps;
}
