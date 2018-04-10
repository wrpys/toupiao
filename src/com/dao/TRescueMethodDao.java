package com.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TRescueMethod;

public class TRescueMethodDao extends HibernateDaoSupport {

	public List<TRescueMethod> getList() {
		List<TRescueMethod> list = this.getHibernateTemplate().find("from TRescueMethod");
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public TRescueMethod getRescueMethod(int id) {
		List<TRescueMethod> list = this.getHibernateTemplate().find("from TRescueMethod a where a.id=?", id);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public void save(TRescueMethod method) {
		this.getHibernateTemplate().save(method);
	}

	public void update(TRescueMethod method) {
		this.getHibernateTemplate().update(method);
	}

	public void delete(TRescueMethod method) {
		this.getHibernateTemplate().delete(method);
	}
}
