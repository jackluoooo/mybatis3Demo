package com.luo;

import com.luo.entity.DepartmentEntity;
import com.luo.entity.EmployeeEntity;
import com.luo.mappper.DepartmentMapper;
import com.luo.mappper.EmployeeMapper;
import com.luo.mappper.EmployeeMapperDynamicSql;
import com.luo.mappper.EmployeePlusMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * SqlSessionFactory 是非线程安全
 */

public class DemoApplicationTests {

    @Test
    public void contextLoads() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession实例
        SqlSession session = sqlSessionFactory.openSession();
        EmployeeEntity employee = session.selectOne("com.luo.mappper.EmployeeMapper.selectEmp", 1);
        System.out.println(employee);
        session.close();
    }

    @Test
    public void test02() throws Exception {
        //获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        try {
            //获取接口代理对象
            EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);

//            EmployeeEntity employeeEntity = mapper.selectEmp(1);
//            System.out.println(employeeEntity);
//            List<EmployeeEntity> entities=mapper.selectByLastNmae("l");
            //entities.forEach((e)->{});
//            for (int i = 0; i <entities.size() ; i++) {
////                System.out.println(entities.get(i));
////            }
            //   Map<String, Object> map = mapper.selectEmpByIdReturnMap(1);
            Map<Integer, EmployeeEntity> map = mapper.querry();
            System.out.println(map);
        } finally {
            session.close();
        }

    }

    @Test
    public void test03() throws Exception {
        //获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = sqlSessionFactory.openSession();

        try {
            //获取接口代理对象
            EmployeePlusMapper mapper = session.getMapper(EmployeePlusMapper.class);
            DepartmentMapper departmentMapper = session.getMapper(DepartmentMapper.class);
//            List<EmployeeEntity> emp = mapper.getEmpById();
//            List<EmployeeEntity> emp =mapper.getEmpByIdDiff();

//            for (EmployeeEntity e:emp
//                 ) {
//                System.out.println(e);
//            }
//            EmployeeEntity employee=mapper.getEmpByIdStep(1);
//            System.out.println(employee.getLastname());
            DepartmentEntity dep = departmentMapper.getDeptByIdPlus(1);
            System.out.println(dep);
        } finally {
            session.close();
        }

    }

     @Test
    public void testDynamicSql(){
        SqlSession session=null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();

            EmployeeMapperDynamicSql mapper = session.getMapper(EmployeeMapperDynamicSql.class);
            EmployeeEntity employeeEntity=new EmployeeEntity();
            employeeEntity.setId(1L);
            List<EmployeeEntity> empBycCondition = mapper.getEmpBycConditionTrim(employeeEntity);
            //某些条件不带，Sql拼装会有问题
            /**
             * 解决方法1.where拼装1=1
             * 2.mybatis拼接where标签====》只能去掉第一个多余的and,所以建议where放在条件队头。
             */
            for (EmployeeEntity e:empBycCondition
                 ) {
               System.out.println(e);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            session.close();
        }


    }

}

