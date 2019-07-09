package com.iep.schoolstandard.entity;

import java.util.List;

import com.alibaba.fastjson.JSONObject;

public class TransferTablesDTO {
	private int Id;
	private String describeDataForm;// 表单描述
	private List<Integer> childrenID;
	private List<Integer> relevanceID;
	private String showType;

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

	public List<Integer> getChildrenID() {
		return childrenID;
	}

	public void setChildrenID(List<Integer> childrenID) {
		this.childrenID = childrenID;
	}

	public List<Integer> getRelevanceID() {
		return relevanceID;
	}

	public void setRelevanceID(List<Integer> relevanceID) {
		this.relevanceID = relevanceID;
	}

	public TransferTablesDTO() {
		// TODO Auto-generated constructor stub
	}

	public TransferTablesDTO(int id, String des, List<Integer> childrenID, List<Integer> relevanceID, String showType) {
		this.Id = id;
		this.childrenID = childrenID;
		this.describeDataForm = des;
		this.showType = showType;
		this.relevanceID = relevanceID;
	}

	public SchoolTablesDO toSchoolTablesDO() {
		// 将List<String>类型的optionsDataForm数据转化为JSON数据，将次JSON数据保存到数据库中
		return new SchoolTablesDO(Id, describeDataForm, JSONObject.toJSONString(childrenID),
				JSONObject.toJSONString(relevanceID), showType);
	}
}
