package com.iep.schoolstandard.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.iep.schoolstandard.entity.SchoolTablesDO;
import com.iep.schoolstandard.entity.TransferTablesDTO;

@Repository
@Mapper
public interface DataFormDao {
	List<SchoolTablesDO> getDataForm();// 获取超级管理员表单

	void updateSchoolTable(SchoolTablesDO schoolTablesDO);// 更新学校表单

	List<SchoolTablesDO> getSchoolTable();// 获取学校表单

	void insertSchoolTable(List<SchoolTablesDO> schoolTablesDOs);// 插入学校表单
}
