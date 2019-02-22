package com.luo.mappper;

import com.luo.entity.EmployeeEntity;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

//@Mapper
public interface EmployeePlusMapper {
    List<EmployeeEntity> getEmpById();

    List<EmployeeEntity> getEmpByIdDiff();

    EmployeeEntity getEmpByIdStep(@Param("id") Integer id);
}
