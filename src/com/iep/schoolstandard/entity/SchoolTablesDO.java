package com.iep.schoolstandard.entity;

import java.util.List;

import com.alibaba.fastjson.JSONArray;

public class SchoolTablesDO {
	private int Id;
	private String describeDataForm;// 表单描述
	private String showType;
	private String childrenID;
	private String relevanceID;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDescribeDataForm() {
		return describeDataForm;
	}

	public void setDescribeDataForm(String describeDataForm) {
		this.describeDataForm = describeDataForm;
	}

	public String getShowType() {
		return showType;
	}

	public void setShowType(String showType) {
		this.showType = showType;
	}

	public String getChildrenID() {
		return childrenID;
	}

	public void setChildrenID(String childrenID) {
		this.childrenID = childrenID;
	}

	public String getRelevanceID() {
		return relevanceID;
	}

	public void setRelevanceID(String relevanceID) {
		this.relevanceID = relevanceID;
	}

	public SchoolTablesDO() {
		// TODO Auto-generated constructor stub
	}

	public SchoolTablesDO(int id, String des, String childrenID, String relevanceID, String showType) {
		this.Id = id;
		this.childrenID = childrenID;
		this.describeDataForm = des;
		this.showType = showType;
		this.relevanceID = relevanceID;
	}

	public TransferTablesDTO toTransferTablesDTO() {
		// 读取数据的时候，将JSON数据在转化为List<String>，再传回前端
		return new TransferTablesDTO(Id, describeDataForm,
				(List<Integer>) JSONArray.parseArray(childrenID, Integer.class),
				(List<Integer>) JSONArray.parseArray(relevanceID, Integer.class), showType);
	}

}
