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
		 * //ԭ�����Է��� //1,����springIOC���� ApplicationContext ioc = new
		 * ClassPathXmlApplicationContext("applicationContext.xml"); //2,�������л�ȡmapper
		 * EmployeeMapper ben = ioc.getBean(EmployeeMapper.class);
		 * System.out.println(ben);
		 */

		/*
		 * spring��Ԫ���ԣ����Զ�ע����Ҫ����� 1������springtestģ�� 2��@ContextConfigurationע�� 3��@RunWith
		 * ָ������ʱ�Ĳ��Ե�Ԫ 4��ֱ��autowiredҪʹ�õ��������
		 */

		System.out.println(departmentMapper);

		// 1,���뼸������

		
//		 departmentMapper.insertSelective(new Department(null, "������"));
//		 departmentMapper.insertSelective(new Department(null,"���Բ�"));
		 
		//2,����Ա�����ݣ�����Ա������
//		 employeeMapper.insertSelective(new Employee(null,"jerry","M","jerry@pl.com",1));
		

		   //3������������Ա����ʹ�ÿ���ִ������������sqlsession

	      /*  for (){
	            employeeMapper.insertSelective(new Employee(null,,"M","jerry@pl.com",1));

	        }*/

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        for(int i=0;i<200;i++){

            String uid = UUID.randomUUID().toString().substring(0,5)+i;
            mapper.insertSelective(new Employee(null,uid,"M",uid+"@pl.com",1));
        }
        System.out.println("�������Ա���ɹ�");

	}
}
