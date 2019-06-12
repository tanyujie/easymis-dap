package org.easymis.dap.catalog.controller.system;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.easymis.dap.catalog.config.NoRepeatSubmit;
import org.easymis.dap.catalog.entity.LoginLog;
import org.easymis.dap.catalog.service.LoginLogService;
import org.easymis.dap.catalog.web.DataTableResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.swagger.annotations.Api;

@RestController
@Api(value = "系统角色controller", tags = { "系统角色操作接口" })
@RequestMapping("/system/login/log")
public class LoginLogController {
    @Autowired
    private LoginLogService loginLogService;
	@RequestMapping("/")
	public ModelAndView index1(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("system/loginLog/index");
		return mv;
	}
	@RequestMapping("/index.html")
	public ModelAndView  index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		ModelAndView mv = new ModelAndView("system/loginLog/index");
		return mv;
	}

	@RequestMapping(value = "/save.do", method = RequestMethod.POST)
	@NoRepeatSubmit
	public boolean add(@RequestBody LoginLog bean) {
		return loginLogService.save(bean);
	}
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public DataTableResult  findAll(HttpServletRequest request,HttpSession httpSession) {
		int start = Integer.parseInt(request.getParameter("start"));
		int length = Integer.parseInt(request.getParameter("length"));

		HashMap<String, Object> map = new HashMap<String, Object>();
		int page=1;
		if(start==0) {
			 page=1;
		}else {
			 page=start/length+1;			
		}

		httpSession.getAttribute("userLogin");
		return loginLogService.findAll(map, page, length);

		
	}
    @RequestMapping("/test")
    @NoRepeatSubmit
    public String test() {
        return ("程序逻辑返回");
    }
}
