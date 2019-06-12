package org.easymis.dap.catalog.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.easymis.dap.catalog.entity.Dbs;
import org.easymis.dap.catalog.service.DbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;

@RestController
@Api(value = "系统首页controller", tags = { "系统首页操作接口" })
@RequestMapping("/dbs")
public class DbsController {
    @Autowired
    private DbsService dbsService;
	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("dbs/index");
		return mv;
	}
	@RequestMapping("/index.html")
	public ModelAndView  index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("dbs/index");
		return mv;
	}
	@RequestMapping(value = "/findAll",method = RequestMethod.GET)
	public List<Dbs> get(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return dbsService.findAll();
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public boolean add(Dbs bean) {
		return dbsService.save(bean);
	}
	@RequestMapping("/update")
	public String update(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return "customer/index";
	}
	@RequestMapping("/delete/")
	public String delete(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return "business/index";
	}
}
