package com.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TVolunteer;

public class TVolunteerDao extends HibernateDaoSupport {

	public List<TVolunteer> getList() {
		List<TVolunteer> list = this.getHibernateTemplate().find("from TVolunteer");
		if (list != null && list.size() > 0) {
			return list;
		}
		return null;
	}

	public TVolunteer geTVolunteer(int id) {
		List<TVolunteer> list = this.getHibernateTemplate().find("from TVolunteer a where a.id=?", id);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	public void save(TVolunteer v) {
		this.getHibernateTemplate().save(v);
	}

	public void update(TVolunteer v) {
		this.getHibernateTemplate().update(v);
	}

	public void delete(TVolunteer method) {
		this.getHibernateTemplate().delete(method);
	}
}
