package com.luo.mappper;

import com.luo.entity.EmployeeEntity;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

//@Mapper
public interface EmployeeMapper {

    @MapKey("id")//标注什么作为主键
    Map<Integer, EmployeeEntity> querry();

    Map<String, Object> selectEmpByIdReturnMap(Integer id);

    EmployeeEntity selectEmp(Integer id);

    List<EmployeeEntity> selectByLastNmae(String lastname);

    List<EmployeeEntity> selectByDepId(Integer id );

}
