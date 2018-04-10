package com.action;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.dao.TToupiaoDAO;
import com.dao.TToupiaoxuanxiangDAO;
import com.dao.TWenjuanDAO;
import com.model.TToupiao;
import com.model.TToupiaoxuanxiang;
import com.model.TWenjuan;
import com.opensymphony.xwork2.ActionSupport;

public class wenjuanAction extends ActionSupport {
	private String id;
	private String mingcheng;
	private Integer mingchengType;

	private String message;
	private String path;

	private TWenjuanDAO wenjuanDAO;
	private TToupiaoDAO toupiaoDAO;
	private TToupiaoxuanxiangDAO toupiaoxuanxiangDAO;
	
	public String wenjuanAdd() {
		TWenjuan wenjuan = new TWenjuan();

		wenjuan.setId(String.valueOf(new Date().getTime()));
		wenjuan.setMingcheng(mingcheng);
		wenjuan.setMingchengType(mingchengType);
		wenjuan.setShijian(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

		wenjuanDAO.save(wenjuan);
		this.setMessage("�������");
		this.setPath("wenjuanMana.action");
		return "succeed";
	}

	public String wenjuanMana() {
		String sql = "from TWenjuan";
		List wenjuanList = wenjuanDAO.getHibernateTemplate().find(sql);
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("wenjuanList", wenjuanList);
		return ActionSupport.SUCCESS;
	}

	public String wenjuanDel() {
		TWenjuan wenjuan = wenjuanDAO.findById(id);
		wenjuanDAO.delete(wenjuan);
		this.setMessage("ɾ�����");
		this.setPath("wenjuanMana.action");
		return "succeed";
	}

	public String wenjuan_search() {
		String sql = "from TWenjuan where mingcheng like '%" + mingcheng.trim() + "%'";
		List wenjuanList = wenjuanDAO.getHibernateTemplate().find(sql);
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("wenjuanList", wenjuanList);
		return ActionSupport.SUCCESS;
	}

	public String wenjuanDetailQian() {
		TWenjuan wenjuan = wenjuanDAO.findById(id);

		String sql = "from TToupiao where wenjuan_id=" + wenjuan.getId();
		List toupiaoList = toupiaoDAO.getHibernateTemplate().find(sql);
		for (int i = 0; i < toupiaoList.size(); i++) {
			TToupiao toupiao = (TToupiao) toupiaoList.get(i);
			String sql11 = "from TToupiaoxuanxiang where toupiao_id=" + toupiao.getId();
			List xuanxiangList = toupiaoxuanxiangDAO.getHibernateTemplate().find(sql11);
			toupiao.setXuanxiangList(xuanxiangList);
		}

		wenjuan.setToupiaoList(toupiaoList);
		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("wenjuan", wenjuan);
		request.put("id", id);

		return ActionSupport.SUCCESS;

	}

	public String wenjuan_canyu() {
		HttpServletRequest request = ServletActionContext.getRequest();

		String xxxxx = request.getParameter("xxxxx");
		System.out.println(xxxxx + "^^^^");

		String[] s = xxxxx.split(",");
		for (int i = 0; i < s.length; i++) {
			String xuanxiang_id = request.getParameter(s[i]);
			String sql = "update TToupiaoxuanxiang set piaoshu=piaoshu+1 where id=" + xuanxiang_id;
			toupiaoxuanxiangDAO.getHibernateTemplate().bulkUpdate(sql);
		}

		request.setAttribute("msg", "�ǳ���л���Ĳ���");
		return "msg";
	}

	public String wenjuan_jieguo() {
		TWenjuan wenjuan = wenjuanDAO.findById(id);

		String sql = "from TToupiao where wenjuan_id=" + wenjuan.getId();
		List toupiaoList = toupiaoDAO.getHibernateTemplate().find(sql);
		for (int i = 0; i < toupiaoList.size(); i++) {
			TToupiao toupiao = (TToupiao) toupiaoList.get(i);
			String sql11 = "from TToupiaoxuanxiang where toupiao_id=" + toupiao.getId();
			List xuanxiangList = toupiaoxuanxiangDAO.getHibernateTemplate().find(sql11);
			toupiao.setXuanxiangList(xuanxiangList);
		}

		wenjuan.setToupiaoList(toupiaoList);

		Map request = (Map) ServletActionContext.getContext().get("request");
		request.put("wenjuan", wenjuan);
		return ActionSupport.SUCCESS;
	}
	
	
	
	/**
	 * �����ʾ�ID��ȡ���е���Ŀ
	 * @author CZX
	 * @return
	 */
	public String getAllSubjects() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String wenjuanId = request.getParameter("wenjuan_id");//�ʾ���ϢID
		String sql = "from TToupiao where wenjuan_id=" + wenjuanId + " order by id ASC";
		List<TToupiao> subjectList = toupiaoDAO.getHibernateTemplate().find(sql);
		Map<String,Object> request2 = (Map) ServletActionContext.getContext().get("request");
		if (subjectList == null) {
			subjectList = new ArrayList<TToupiao>();
		}
		request2.put("subjectList", subjectList);
		return ActionSupport.SUCCESS;
	}
	
	/**
	 * չʾ���ʾ���Ϣ�ĵ�һ����Ŀ���������κλش𣬶���ת����һ����Ŀ
	 * @author CZX
	 * @return
	 */
	public String getTimuByWenjuanId1() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String currentWenjuanID = request.getParameter("currentWenjuanID");//�˴��ʾ�ID
		String wenjuanId = request.getParameter("wenjuan_id");//�ʾ���ϢID
		String mingchengType = request.getParameter("mingchengType");//�ʾ���ϢID
		String subjectId = request.getParameter("subject_id");//�}ĿID,���ڻ�ȡ��һ����Ŀ
		String type = request.getParameter("type");
		if("1".equals(type)) {
			String answer = request.getParameter("answer");
			if(answer != null && !"".equals(answer)) {
				String updateSql = "update TToupiaoxuanxiang set piaoshu=piaoshu+1 where id=" + answer;
				toupiaoxuanxiangDAO.getHibernateTemplate().bulkUpdate(updateSql);
			}
		} else if("2".equals(type)) {
			String[] answer = request.getParameterValues("answer");
			if(answer != null) {
				for (int i = 0; i < answer.length; i++) {
					String updateSql = "update TToupiaoxuanxiang set piaoshu=piaoshu+1 where id=" + answer[i];
					toupiaoxuanxiangDAO.getHibernateTemplate().bulkUpdate(updateSql);
				}
			}
		} else if("3".equals(type)) {
			String text_answer = request.getParameter("text_answer");
			// TODO
		}
		
		String sql = "";
		if("".equals(subjectId) || null==subjectId) {
			sql = "from TToupiao where wenjuan_id=" + wenjuanId + " order by id ASC";
		}else {
			sql = "from TToupiao where wenjuan_id=" + wenjuanId + " and id>" + subjectId + " order by id ASC";
		}
		List<TToupiao> subjectList = toupiaoDAO.page(sql, 0, 1);
		if(subjectList != null && subjectList.size() > 0) {
			request.setAttribute("subject", subjectList.get(0));
			List<TToupiaoxuanxiang> answers = toupiaoxuanxiangDAO.getHibernateTemplate().find("from TToupiaoxuanxiang where toupiao_id=" + subjectList.get(0).getId());
			List<TToupiaoxuanxiang> answersTmp = new ArrayList<TToupiaoxuanxiang>();
			if(answers != null) {
				for (int i = 0; i < answers.size(); i++) {
					TToupiaoxuanxiang t = answers.get(i);
					t.setLabel(subjectList.get(0).getLetterByIndex(i));
					answersTmp.add(t);
				}
			}
			request.setAttribute("answers", answersTmp);
			request.setAttribute("wenjuanId", wenjuanId);
			request.setAttribute("mingchengType", mingchengType);
			
			if(StringUtils.isEmpty(currentWenjuanID)) {
				currentWenjuanID = String.valueOf(System.currentTimeMillis());
			}
			request.setAttribute("currentWenjuanID", currentWenjuanID);
			return ActionSupport.SUCCESS;
		} else if (StringUtils.isNotEmpty(currentWenjuanID)) {
			request.setAttribute("msg", "����������ǳ���л���Ĳ���");
			return "msg";
		} else {
			request.setAttribute("msg", "���ʾ����黹δ������Ŀ��");
			return "msg";
		}
	}

	
	/**
	 * 
	 * չʾ���ʾ���Ϣ�ĵ�һ����Ŀ��������ѡѡ�������ת����Ӧ��Ŀ��ֱ�������ı�����Ŀ���ߴ�û��������ת����Ŀ
	 *@author CZX 
	 * @throws Exception 
	 */
	public String getTimuByWenjuanIdOne2() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		String currentWenjuanID = request.getParameter("currentWenjuanID");//�˴��ʾ�ID
		String wenjuanId = request.getParameter("wenjuan_id");//�ʾ���ϢID
		String subjectId = request.getParameter("subject_id");//�}ĿID,���ڻ�ȡ��һ����Ŀ
		String subjectRelId = request.getParameter("subjectRelId");//�}Ŀ��ѡ��,������ѡѡ�������ת����Ӧ��Ŀ
		String type = request.getParameter("type");
		if("1".equals(type)) {
			String answer = request.getParameter("answer");
			if(answer != null && !"".equals(answer)) {
				String updateSql = "update TToupiaoxuanxiang set piaoshu=piaoshu+1 where id=" + answer;
				toupiaoxuanxiangDAO.getHibernateTemplate().bulkUpdate(updateSql);
			}
		} else if("2".equals(type)) {
			String[] answer = request.getParameterValues("answer");
			if(answer != null) {
				for (int i = 0; i < answer.length; i++) {
					String updateSql = "update TToupiaoxuanxiang set piaoshu=piaoshu+1 where id=" + answer[i];
					toupiaoxuanxiangDAO.getHibernateTemplate().bulkUpdate(updateSql);
				}
			}
		} else if("3".equals(type)) {
			String text_answer = request.getParameter("text_answer");
			// TODO
		}
		
		String sql = "";
		if("".equals(subjectId) || null==subjectId) {
			sql = "from TToupiao where wenjuan_id=" + wenjuanId + " order by id ASC";
		}else {
			if (StringUtils.isEmpty(subjectRelId)) {
				request.setAttribute("msg", "����������ǳ���л���Ĳ���");
				return "msg";
			} else {
				sql = "from TToupiao where wenjuan_id=" + wenjuanId + " and id=" + subjectRelId;
			}
		}
		List<TToupiao> subjectList = toupiaoDAO.page(sql, 0, 1);
		
		if(subjectList != null && subjectList.size() > 0) {
			request.setAttribute("subject", subjectList.get(0));
			List<TToupiaoxuanxiang> answers = toupiaoxuanxiangDAO.getHibernateTemplate().find("from TToupiaoxuanxiang where toupiao_id=" + subjectList.get(0).getId());
			List<TToupiaoxuanxiang> answersTmp = new ArrayList<TToupiaoxuanxiang>();
			if(answers != null) {
				for (int i = 0; i < answers.size(); i++) {
					TToupiaoxuanxiang t = answers.get(i);
					t.setLabel(subjectList.get(0).getLetterByIndex(i));
					answersTmp.add(t);
				}
			}
			request.setAttribute("answers", answersTmp);
			request.setAttribute("wenjuanId", wenjuanId);
			request.setAttribute("mingchengType", mingchengType);
			
			if(StringUtils.isEmpty(currentWenjuanID)) {
				currentWenjuanID = String.valueOf(System.currentTimeMillis());
			}
			request.setAttribute("currentWenjuanID", currentWenjuanID);
			return ActionSupport.SUCCESS;
		} else if (StringUtils.isNotEmpty(currentWenjuanID)) {
			request.setAttribute("msg", "����������ǳ���л���Ĳ���");
			return "msg";
		} else {
			request.setAttribute("msg", "���ʾ����黹δ������Ŀ��");
			return "msg";
		}
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getMingcheng() {
		return mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public Integer getMingchengType() {
		return mingchengType;
	}

	public void setMingchengType(Integer mingchengType) {
		this.mingchengType = mingchengType;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public TWenjuanDAO getWenjuanDAO() {
		return wenjuanDAO;
	}

	public void setWenjuanDAO(TWenjuanDAO wenjuanDAO) {
		this.wenjuanDAO = wenjuanDAO;
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

}