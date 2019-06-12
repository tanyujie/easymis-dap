package org.easymis.dap.catalog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.easymis.dap.catalog.entity.Repair;
import org.easymis.dap.catalog.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;

@RestController
@Api(value = "修复任务controller", tags = { "修复任务操作接口" })
@RequestMapping("/repair")
public class RepairController {
    @Autowired
    private RepairService repairService;
	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("Repair/index");
		return mv;
	}
	@RequestMapping("/index.html")
	public ModelAndView  index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("repair/index");
		return mv;
	}
	@RequestMapping(value = "/findAll",method = RequestMethod.GET)
	public List<Repair> get(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return repairService.findAll();
	}
}
