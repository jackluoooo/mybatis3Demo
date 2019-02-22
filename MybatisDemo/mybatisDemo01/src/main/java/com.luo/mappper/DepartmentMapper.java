package com.luo.mappper;

import com.luo.entity.DepartmentEntity;
import org.apache.ibatis.annotations.Param;

public interface DepartmentMapper {
     DepartmentEntity getDeptById(@Param("id") Integer id);

     DepartmentEntity getDeptByIdPlus(@Param("id") Integer id);
}
