package org.easymis.dap.catalog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.easymis.dap.catalog.entity.Technical;
import org.easymis.dap.catalog.service.TechnicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;

@RestController
@Api(value = "技术质量规则controller", tags = { "技术质量规则操作接口" })
@RequestMapping("/technical")
public class TechnicalController {
    @Autowired
    private TechnicalService dbsService;
	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("technical/index");
		return mv;
	}
	@RequestMapping("/index.html")
	public ModelAndView  index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("technical/index");
		return mv;
	}
	@RequestMapping(value = "/findAll",method = RequestMethod.GET)
	public List<Technical> get(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return dbsService.findAll();
	}
}
