package com.luo.mappper;

import com.luo.entity.EmployeeEntity;
import org.apache.ibatis.annotations.MapKey;

import java.util.List;
import java.util.Map;

//@Mapper
public interface EmployeeMapperDynamicSql {
   List<EmployeeEntity> getEmpBycConditionIF(EmployeeEntity employeeEntity);

   List<EmployeeEntity> getEmpBycConditionTrim(EmployeeEntity employeeEntity);

   List<EmployeeEntity> getEmpBycConditionChoose(EmployeeEntity employeeEntity);
}
