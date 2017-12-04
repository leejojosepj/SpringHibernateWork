package com.leejo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import com.leejo.model.Student;
/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */
@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<Student> getAllStudents() {
		String hql = "FROM Student";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		List<Student> obj = query.list();
		return obj;
	}

	@Override
	@Transactional
	public Student getStudentData(Integer sid) {
		// TODO Auto-generated method stub
		Student student=new Student();
		try{
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
			criteria.add(Restrictions.eq("sid", sid));
			student = (Student)criteria.uniqueResult();
		}
		catch(Exception e){
			throw e;
		}
		return student;
	}

}
