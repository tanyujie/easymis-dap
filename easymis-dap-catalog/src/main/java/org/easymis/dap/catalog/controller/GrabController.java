package org.easymis.dap.catalog.controller;

import javax.servlet.http.HttpSession;

import org.easymis.dap.catalog.entity.Dbs;
import org.easymis.dap.catalog.service.DbsService;
import org.easymis.dap.catalog.service.GrabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;

@RestController
@Api(value = "数据采集controller", tags = { "数据采集操作接口" })
@RequestMapping("/grab")
public class GrabController {
    @Autowired
    private DbsService dbsService;
    @Autowired
    private GrabService grabService;    
	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("grab/index");
		return mv;
	}
	@RequestMapping("/index.html")
	public ModelAndView  index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("grab/index");
		return mv;
	}

	@RequestMapping(value = "/start/{dbsId}", method = RequestMethod.GET)
	public boolean start(@PathVariable("dbsId") String dbsId) {
		Dbs dbs=dbsService.findById(dbsId);
		return grabService.save(dbs);
	}
}
