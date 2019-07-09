package com.iep.schoolstandard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iep.schoolstandard.entity.SchoolTablesDO;
import com.iep.schoolstandard.entity.TransferTablesDTO;
import com.iep.schoolstandard.service.DataFormService;

@Controller
public class DataFormController {
	@Autowired
	private DataFormService service;

	@ResponseBody
	@RequestMapping(value = "/toSuperDataFormPage", method = RequestMethod.GET, produces = "text/html;charset=UTF-8")
	private String toDataFormPage() {
		return service.toSuperManagerTable();
	}

	@ResponseBody
	@RequestMapping(value = "/createSchoolDataForm", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	private String insertSchoolTable(@RequestBody List<TransferTablesDTO> transferTablesDTOs) {
		return service.insertSchoolTable(transferTablesDTOs);
	}

	@ResponseBody
	@RequestMapping(value = "/toSchoolTable", produces = "text/html;charset=UTF-8")
	private String toSchoolTable() {
		return service.toSchoolTable();
	}

	@ResponseBody
	@RequestMapping(value = "/updateSchoolTable", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	private String updateSchoolTable(@RequestBody TransferTablesDTO transferTablesDTO) {
		return service.updateSchoolTable(transferTablesDTO);
	}
}
