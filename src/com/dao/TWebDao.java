package com.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TWeb;

public class TWebDao extends HibernateDaoSupport{

	public TWeb getTweb(){
		List<TWeb> tWebs = (List<TWeb>)this.getHibernateTemplate().find("from TWeb");
		if(tWebs!=null && tWebs.size()>0){
			return  tWebs.get(0);
		}
		return null;
	}
}
