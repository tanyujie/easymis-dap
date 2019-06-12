package org.easymis.dap.catalog.controller.system;

import javax.servlet.http.HttpSession;

import org.easymis.dap.catalog.service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;

@RestController
@Api(value = "职能管理controller", tags = { "职能管理操作接口" })
@RequestMapping("/system/responsibility")
public class ResponsibilityController {
    @Autowired
    private RepairService repairService;
	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("system/responsibility/index");
		return mv;
	}
	@RequestMapping("/index.html")
	public ModelAndView  index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("system/responsibility/index");
		return mv;
	}
}
