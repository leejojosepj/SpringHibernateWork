package com.leejo.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leejo.model.LoginAuth;

import com.leejo.model.UserLinks;
/**
 * 
 * @author Leejo Jose
 * @date 01-11-2017
 *
 */
@Repository
public class CommonDaoImpl implements CommonDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public LoginAuth loginCheck(String uemail, String upass) {
		// TODO Auto-generated method stub
		LoginAuth loginAuth=new LoginAuth();
		
		try{
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(LoginAuth.class);
			criteria.add(Restrictions.eq("emailId", uemail));
			criteria.add(Restrictions.eq("pass", upass));
			loginAuth = (LoginAuth)criteria.uniqueResult();
		}
		catch(Exception e){
			throw e;
		}
		
		return loginAuth;
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<UserLinks> getUserLinks(String utype) {
		// TODO Auto-generated method stub
		String hql = "FROM UserLinks where userType=:utype order by orderNum";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString("utype",utype);
		List<UserLinks> obj = query.list();
		return obj;
	}

}
