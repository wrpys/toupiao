package com.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.dao.TRescueMethodDao;
import com.model.TRescueMethod;
import com.opensymphony.xwork2.ActionSupport;

public class TRescueMethodAction extends ActionSupport {
	private static final long serialVersionUID = -2265277621062218986L;
	private TRescueMethodDao tRescueMethodDao;
	private TRescueMethod method = new TRescueMethod();
	private String message;
	private String path;

	public String resueMethodlist() {
		List<TRescueMethod> list = tRescueMethodDao.getList();
		ServletActionContext.getRequest().setAttribute("list", list);
		return SUCCESS;
	}

	public String detail() {

		return SUCCESS;
	}

	public String resueMethodAdd() {
		method.setCreateTime(new Date().toLocaleString());
		tRescueMethodDao.save(method);
		this.setMessage("操作成功");
		this.setPath("resueMethodlist.action");
		return "succeed";
	}

	public String resueMethodDel() {
		Integer id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		method = tRescueMethodDao.getRescueMethod(id);
		tRescueMethodDao.delete(method);
		this.setMessage("操作成功");
		this.setPath("resueMethodlist.action");
		return "succeed";
	}

	public TRescueMethodDao gettRescueMethodDao() {
		return tRescueMethodDao;
	}

	public String resuelist() {
		List<TRescueMethod> list = tRescueMethodDao.getList();
		ServletActionContext.getRequest().setAttribute("list", list);
		return SUCCESS;
	}
	
	public String resueDetail(){
		Integer id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		method = tRescueMethodDao.getRescueMethod(id);
		ServletActionContext.getRequest().setAttribute("method", method);
		return SUCCESS;
		
	}
	public void settRescueMethodDao(TRescueMethodDao tRescueMethodDao) {
		this.tRescueMethodDao = tRescueMethodDao;
	}

	public TRescueMethod getMethod() {
		return method;
	}

	public void setMethod(TRescueMethod method) {
		this.method = method;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
}
