package com.iep.schoolstandard.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.iep.schoolstandard.dao.DataFormDao;
import com.iep.schoolstandard.entity.SchoolTablesDO;
import com.iep.schoolstandard.entity.TransferTablesDTO;

@Service("dataFormService")
public class DataFormServiceImpl implements DataFormService {

	@Autowired
	private DataFormDao dao;

	@Override
	public String toSuperManagerTable() {// 获取超级管理员表单
		List<SchoolTablesDO> schoolTablesDOs = dao.getDataForm();
		List<TransferTablesDTO> transferTablesDTOs = new LinkedList<TransferTablesDTO>();
		schoolTablesDOs.forEach(dataForm -> {// 将多条记录转换
			transferTablesDTOs.add(dataForm.toTransferTablesDTO());
		});
		return JSONObject.toJSON(transferTablesDTOs).toString();
	}

	@Override
	public String insertSchoolTable(List<TransferTablesDTO> transferTablesDTOs) {// 插入并获取学校表单
		List<SchoolTablesDO> schoolTablesDOs = new LinkedList<SchoolTablesDO>();
		transferTablesDTOs.forEach(transferTablesDTO -> {
			schoolTablesDOs.add(transferTablesDTO.toSchoolTablesDO());
		});
		for(SchoolTablesDO do1:schoolTablesDOs) {
			System.out.println(do1.getId());
		}
		dao.insertSchoolTable(schoolTablesDOs);
		return toSchoolTable();
	}

	@Override
	public String updateSchoolTable(TransferTablesDTO transferTablesDTO) {// 更新并获取学校表单
		dao.updateSchoolTable(transferTablesDTO.toSchoolTablesDO());
		return toSchoolTable();
	}

	@Override
	public String toSchoolTable() {// 获取学校表单
		List<SchoolTablesDO> schoolTablesDOs = dao.getSchoolTable();
		List<TransferTablesDTO> transferTablesDTOs = new LinkedList<TransferTablesDTO>();
		schoolTablesDOs.forEach(dataForm -> {// 将多条记录转换
			transferTablesDTOs.add(dataForm.toTransferTablesDTO());
		});
		return JSONObject.toJSON(transferTablesDTOs).toString();
	}

}
