package com.myapp.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.myapp.crud.bean.Department;
import com.myapp.crud.bean.Employee;
import com.myapp.crud.dao.DepartmentMapper;
import com.myapp.crud.dao.EmployeeMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class MapperTest {

	@Autowired
	DepartmentMapper departmentMapper;

	@Autowired
	EmployeeMapper employeeMapper;
//
	@Autowired
	SqlSession sqlSession;

	@Test
	public void testCRUD() {

		/*
		 * //原生测试方法 //1,创建springIOC容器 ApplicationContext ioc = new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); //2,从容器中获取mapper
		 * EmployeeMapper ben = ioc.getBean(EmployeeMapper.class);
		 * System.out.println(ben);
		 */

		/*
		 * spring单元测试，可自动注入需要的组件 1，导入springtest模块 2，@ContextConfiguration注解 3、@RunWith
		 * 指定运行时的测试单元 4、直接autowired要使用的组件即可
		 */

		System.out.println(departmentMapper);

		// 1,插入几个部门

		
//		 departmentMapper.insertSelective(new Department(null, "开发部"));
//		 departmentMapper.insertSelective(new Department(null,"测试部"));
		 
		//2,生成员工数据，测试员工插入
//		 employeeMapper.insertSelective(new Employee(null,"jerry","M","jerry@pl.com",1));
		

		   //3，批量插入多个员工，使用可以执行批量操作的sqlsession

	      /*  for (){
	            employeeMapper.insertSelective(new Employee(null,,"M","jerry@pl.com",1));

	        }*/

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        for(int i=0;i<200;i++){

            String uid = UUID.randomUUID().toString().substring(0,5)+i;
            mapper.insertSelective(new Employee(null,uid,"M",uid+"@pl.com",1));
        }
        System.out.println("批量添加员工成功");

	}
}
