package com.leejo.dao;



import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leejo.model.AdminDetails;
import com.leejo.model.LoginAuth;
import com.leejo.model.Student;
/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */
@Repository
public class AdminDaoImpl implements AdminDao{
	//spring 4 demo leejo jose
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	@Transactional
	public AdminDetails getAdminData(Integer aid) {
		// TODO Auto-generated method stub
		AdminDetails adminDetails=new AdminDetails();
		try{
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(AdminDetails.class);
			criteria.add(Restrictions.eq("adminId", aid));
			adminDetails = (AdminDetails)criteria.uniqueResult();
		}
		catch(Exception e){
			throw e;
		}
		
		
		
		return adminDetails;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Student student) {
		
		sessionFactory.getCurrentSession().saveOrUpdate(student);
		
		String hql = "update LoginAuth set emailId=:semailid where userId=:suserid and utype='student'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("semailid", student.getSemail());
		query.setInteger("suserid", student.getSid());
		
		query.executeUpdate();
		
	}

	@Override
	@Transactional
	public void delete(Integer sid) {
		String hql = "delete from Student where sid="+sid;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.executeUpdate();
		
	}

	@Override
	@Transactional
	public void saveUpdate(Student student) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(student);
	}

	@Override
	@Transactional
	public void saveOrUpdate(LoginAuth loginAuth) {
		// TODO Auto-generated method stub
		sessionFactory.getCurrentSession().saveOrUpdate(loginAuth);
	}
	
	
	@Override
	@Transactional
	public void testDelete(Integer sid) {
		Student student=getStudent(sid);
		//delete() will delete orphan entries at address table too
		sessionFactory.getCurrentSession().delete(student);
	}

	@Override
	@Transactional
	public Student getStudent(Integer studentId) {
		// TODO Auto-generated method stub
		String hql = "FROM Student where sid="+studentId;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		Student student = (Student) query.uniqueResult();
		
		return student;
	}

	@Override
	@Transactional
	public Integer getMaxStudentId() {
		Integer maxId=null;
		try{
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Student.class);
			criteria.setProjection(Projections.max("sid"));
			
			maxId = (Integer)criteria.uniqueResult();
		}
		catch(Exception e){
			throw e;
		}
		
		return maxId;
	}

	@Override
	@Transactional
	public void deleteLogin(Integer studentId) {
		// TODO Auto-generated method stub
		String hql = "delete from LoginAuth where userId=:studentId and utype='student'";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setInteger("studentId", studentId);
		query.executeUpdate();
		
	}

	@Override
	@Transactional
	public void updateLogin(String email,Integer studentId,String type) {
		// TODO Auto-generated method stub
		String hql = "update LoginAuth set emailId=:email where userId=:studentId and utype=:type";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setParameter("email", email);
		query.setInteger("studentId", studentId);
		query.setParameter("type", type);
		query.executeUpdate();
	}


}
