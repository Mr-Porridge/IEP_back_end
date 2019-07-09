package com.iep.schoolstandard.service;

import java.util.List;

import com.iep.schoolstandard.entity.SchoolTablesDO;
import com.iep.schoolstandard.entity.TransferTablesDTO;

public interface DataFormService {
	String toSuperManagerTable();// 获取超级管理员表单

	String toSchoolTable();// 获取学校表单

	String insertSchoolTable(List<TransferTablesDTO> transferTablesDTOs);// 插入并获取学校表单

	String updateSchoolTable(TransferTablesDTO transferTablesDTO);// 更新并获取学校表单
}
