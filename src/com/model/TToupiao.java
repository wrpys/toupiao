package com.model;

import java.util.List;

/**
 * TToupiao generated by MyEclipse Persistence Tools
 */

public class TToupiao implements java.io.Serializable
{
	private String id;
	private String title;
	private String wenjuan_id;
	private Integer type;
	private List xuanxiangList;
	private String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getTitle()
	{
		return title;
	}
	public void setTitle(String title)
	{
		this.title = title;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getWenjuan_id()
	{
		return wenjuan_id;
	}
	public void setWenjuan_id(String wenjuan_id)
	{
		this.wenjuan_id = wenjuan_id;
	}
	public List getXuanxiangList()
	{
		return xuanxiangList;
	}
	public void setXuanxiangList(List xuanxiangList)
	{
		this.xuanxiangList = xuanxiangList;
	}
	public String getLetterByIndex(int index) {
		return letters[index];
	}
	
}