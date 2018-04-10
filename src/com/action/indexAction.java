package com.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.dao.TWebDao;
import com.dao.TWenjuanDAO;
import com.model.TWeb;
import com.opensymphony.xwork2.ActionSupport;

public class indexAction extends ActionSupport
{
	private TWenjuanDAO wenjuanDAO;
	
	private TWebDao tWebDao;
	
	public TWenjuanDAO getWenjuanDAO()
	{
		return wenjuanDAO;
	}

	public void setWenjuanDAO(TWenjuanDAO wenjuanDAO)
	{
		this.wenjuanDAO = wenjuanDAO;
	}

	public String index()
	{
		Map request=(Map)ServletActionContext.getContext().get("request");
		
		String sql="from TWenjuan";
		List wenjuanList =wenjuanDAO.getHibernateTemplate().find(sql);
		request.put("wenjuanList", wenjuanList);
		
		return ActionSupport.SUCCESS;
	}

	public String introductionIOfSite(){
		TWeb tweb  = tWebDao.getTweb();
		ServletActionContext.getRequest().setAttribute("tweb", tweb);
		return SUCCESS;
	}

	public TWebDao gettWebDao() {
		return tWebDao;
	}

	public void settWebDao(TWebDao tWebDao) {
		this.tWebDao = tWebDao;
	}
	
	
	

}
