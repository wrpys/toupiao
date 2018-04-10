package com.action;

import java.util.Date;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.dao.TVolunteerDao;
import com.model.TVolunteer;
import com.opensymphony.xwork2.ActionSupport;

public class TVolunteerAction extends ActionSupport {
	private static final long serialVersionUID = -2265277621062218986L;
	private TVolunteerDao volunteerDao;
	private TVolunteer volunteer = new TVolunteer();
	private String message;
	private String path;

	public String volunteerlist() {
		List<TVolunteer> list = volunteerDao.getList();
		ServletActionContext.getRequest().setAttribute("list", list);
		return SUCCESS;
	}

	public String volunteerAdd() {
		volunteerDao.save(volunteer);
		this.setMessage("操作成功");
		this.setPath("volunteerlist.action");
		return "succeed";
	}
	public String volunteerDel() {
		Integer id = Integer.parseInt(ServletActionContext.getRequest().getParameter("id"));
		volunteerDao.delete(volunteerDao.geTVolunteer(id));
		this.setMessage("操作成功");
		this.setPath("volunteerlist.action");
		return "succeed";
	}
	public String vollist() {
		List<TVolunteer> list = volunteerDao.getList();
		ServletActionContext.getRequest().setAttribute("list", list);
		return SUCCESS;
	}
	public String detail() {

		return SUCCESS;
	}

	public TVolunteerDao getVolunteerDao() {
		return volunteerDao;
	}

	public void setVolunteerDao(TVolunteerDao volunteerDao) {
		this.volunteerDao = volunteerDao;
	}

	public TVolunteer getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(TVolunteer volunteer) {
		this.volunteer = volunteer;
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
