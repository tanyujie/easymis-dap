package org.easymis.dap.catalog.controller;

import javax.servlet.http.HttpSession;

import org.easymis.dap.catalog.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;

@RestController
@Api(value = "数据目录controller", tags = { "数据目录操作接口" })
@RequestMapping("/catalog")
public class CatalogController {
	@Autowired
	private BusinessService dbsService;

	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("catalog/index");
		return mv;
	}

	@RequestMapping("/index.html")
	public ModelAndView index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("catalog/index");
		return mv;
	}
	@RequestMapping("/search.html")
	public ModelAndView search(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("catalog/search");
		return mv;
	}
	@RequestMapping("/filter.html")
	public ModelAndView filter(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("catalog/filter");
		return mv;
	}
}
