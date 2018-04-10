package com.action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.dao.TToupiaoDAO;
import com.dao.TToupiaoxuanxiangDAO;
import com.model.TToupiao;
import com.model.TToupiaoxuanxiang;
import com.opensymphony.xwork2.ActionSupport;

public class toupiaoAction extends ActionSupport {

	private static final long serialVersionUID = -4225143477547173182L;
	
	private List<TToupiaoxuanxiang> answers;//单选或多选的答案列表。文本域的话数组只有一条记录
	
	private TToupiaoDAO toupiaoDAO;
	private TToupiaoxuanxiangDAO toupiaoxuanxiangDAO;
	
	private String message;
	private String path;

	public String toupiaoAdd() {
		HttpServletRequest request = ServletActionContext.getRequest();

		String id = String.valueOf(new Date().getTime());
		String title = request.getParameter("title");
		String wenjuan_id = request.getParameter("wenjuan_id");
		TToupiao toupiao = new TToupiao();

		toupiao.setId(id);
		toupiao.setTitle(title);
		toupiao.setWenjuan_id(wenjuan_id);

		toupiaoDAO.save(toupiao);

		String[] xuanxiangneirong = request.getParameterValues("xuanxiangneirong");
		for (int i = 0; i < xuanxiangneirong.length; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(xuanxiangneirong[i] + "%%");
			toupiaoxuanxiangSave(xuanxiangneirong[i], id);// 这个地方的id是投票的id
		}

		request.setAttribute("msg", "添加完毕");
		return "msg";
	}
	
	public String subjectMana() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String wenjuanId = request.getParameter("wenjuan_id");//问卷信息ID
		String mingchengType = request.getParameter("mingchengType");//问卷信息类型
		String sql = "from TToupiao where wenjuan_id=" + wenjuanId + " order by id ASC";
		List<TToupiao> subjectList = toupiaoDAO.getHibernateTemplate().find(sql);
		request.setAttribute("subjectList", subjectList);
		request.setAttribute("wenjuanId", wenjuanId);
		request.setAttribute("mingchengType", mingchengType);
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * 投票-顺序添加题目
	 * @author CZX
	 * @return
	 * @throws Exception 
	 */
	public String toupiaoShunxuAdd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String wenjuanId = request.getParameter("wenjuanId");//问卷信息ID
		String mingchengType = request.getParameter("mingchengType");//问卷信息类型
		String subjectTitle = request.getParameter("title");//题目标题
		int subjectType = Integer.parseInt(request.getParameter("type"));//（单选，多选，文本）
		TToupiao subject = new TToupiao();
		subject.setTitle(subjectTitle);
		subject.setType(subjectType);
		subject.setWenjuan_id(wenjuanId);
		subject.setId(String.valueOf(new Date().getTime()));
		toupiaoDAO.save(subject);
		for (TToupiaoxuanxiang answer : answers) {
			answer.setToupiao_id(subject.getId());
			answer.setId(String.valueOf(new Date().getTime()));
			toupiaoxuanxiangDAO.save(answer);
		}
		this.setMessage("添加完毕");
		this.setPath("subjectMana.action?wenjuan_id="+wenjuanId+"&mingchengType="+mingchengType);
		return "succeed";
	}
	
	/**
	 * 添加跳转题目时，答案可以选择对应跳转的题目（弹出框，表格列出此问卷的其他题目）
	 * @author CZX
	 * @return
	 */
	public String toupiaoTiaozhuanAdd() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String wenjuanId = request.getParameter("wenjuanId");//问卷信息ID
		String mingchengType = request.getParameter("mingchengType");//问卷信息类型
		String subjectTitle = request.getParameter("title");//题目标题
		int subjectType = Integer.parseInt(request.getParameter("type"));//（单选，多选，文本）
		TToupiao subject = new TToupiao();
		subject.setTitle(subjectTitle);
		subject.setType(subjectType);
		subject.setWenjuan_id(wenjuanId);
		subject.setId(String.valueOf(new Date().getTime()));
		toupiaoDAO.save(subject);
		//{answer_content:答案,subject_rel_id:关联题目},{answer_content:答案2,subject_rel_id:关联题目2}
		for (TToupiaoxuanxiang answer : answers) {
			answer.setToupiao_id(subject.getId());
			answer.setId(String.valueOf(new Date().getTime()));
			toupiaoxuanxiangDAO.save(answer);
		}
		this.setMessage("添加完毕");
		this.setPath("subjectMana.action?wenjuan_id="+wenjuanId+"&mingchengType="+mingchengType);
		return "succeed";
	}
	
	public String toupiaoDelete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String id = request.getParameter("id");
		String wenjuanId = request.getParameter("wenjuan_id");//问卷信息ID
		String mingchengType = request.getParameter("mingchengType");//问卷信息类型
		TToupiao subject = new TToupiao();
		subject.setId(id);
		toupiaoDAO.delete(subject);
		List<TToupiaoxuanxiang> answers = toupiaoxuanxiangDAO.getHibernateTemplate().find("from TToupiaoxuanxiang where toupiao_id=" + id);
		for (TToupiaoxuanxiang answer : answers) {
			toupiaoxuanxiangDAO.delete(answer);
		}
		this.setMessage("删除完毕");
		this.setPath("subjectMana.action?wenjuan_id="+wenjuanId+"&mingchengType="+mingchengType);
		return "succeed";
	}
	
	public void toupiaoxuanxiangSave(String xuanxiangneirong, String toupiao_id) {
		TToupiaoxuanxiang toupiaoxuanxiang = new TToupiaoxuanxiang();

		toupiaoxuanxiang.setId(String.valueOf(new Date().getTime()));
		toupiaoxuanxiang.setXuanxiangneirong(xuanxiangneirong);
		toupiaoxuanxiang.setPiaoshu(0);
		toupiaoxuanxiang.setToupiao_id(toupiao_id);

		toupiaoxuanxiangDAO.save(toupiaoxuanxiang);
	}

	public String toupiao_zhutu() {
		HttpServletRequest request = ServletActionContext.getRequest();

		String toupiao_id = request.getParameter("toupiao_id");

		String sql = "from TToupiaoxuanxiang where toupiao_id=?";
		Object[] c = { toupiao_id };
		List xuanxiangList = toupiaoxuanxiangDAO.getHibernateTemplate().find(sql, c);

		request.setAttribute("xuanxiangList", xuanxiangList);
		return ActionSupport.SUCCESS;
	}

	public TToupiaoDAO getToupiaoDAO() {
		return toupiaoDAO;
	}

	public void setToupiaoDAO(TToupiaoDAO toupiaoDAO) {
		this.toupiaoDAO = toupiaoDAO;
	}

	public TToupiaoxuanxiangDAO getToupiaoxuanxiangDAO() {
		return toupiaoxuanxiangDAO;
	}

	public void setToupiaoxuanxiangDAO(TToupiaoxuanxiangDAO toupiaoxuanxiangDAO) {
		this.toupiaoxuanxiangDAO = toupiaoxuanxiangDAO;
	}

	public List<TToupiaoxuanxiang> getAnswers() {
		return answers;
	}


	public void setAnswers(List<TToupiaoxuanxiang> answers) {
		this.answers = answers;
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
