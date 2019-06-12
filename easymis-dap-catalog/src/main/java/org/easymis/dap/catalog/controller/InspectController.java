package org.easymis.dap.catalog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.easymis.dap.catalog.entity.Inspect;
import org.easymis.dap.catalog.service.InspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;

@RestController
@Api(value = "检查任务controller", tags = { "检查任务操作接口" })
@RequestMapping("/inspect")
public class InspectController {
    @Autowired
    private InspectService inspectService;
	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("Inspect/index");
		return mv;
	}
	@RequestMapping("/index.html")
	public ModelAndView  index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("inspect/index");
		return mv;
	}
	@RequestMapping(value = "/findAll",method = RequestMethod.GET)
	public List<Inspect> get(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return inspectService.findAll();
	}
}
