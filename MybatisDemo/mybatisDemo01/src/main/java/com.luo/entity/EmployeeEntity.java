package com.luo.entity;

import lombok.Data;

/**
 * @author：罗金星 date 2019/2/11 14:51
 **/
@Data
public class EmployeeEntity {
    private Long id;
    private String lastname;
    private String gender;
    private String email;
    private DepartmentEntity department;
}
