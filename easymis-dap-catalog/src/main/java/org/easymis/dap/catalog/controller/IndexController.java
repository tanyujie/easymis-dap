package org.easymis.dap.catalog.controller;

import javax.servlet.http.HttpSession;

import org.easymis.dap.catalog.config.NoRepeatSubmit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.Api;

@Controller
@Api(value = "系统首页controller", tags = { "系统首页操作接口" })
public class IndexController {
	@RequestMapping("/")
	public String login(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return "login";
	}
    @RequestMapping("/index")
    public String index() { return "index";}
	@RequestMapping("/index.html")
	public String index(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return "index";
	}
	@RequestMapping("/main.html")
	public String main(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return "main";
	}
	@RequestMapping("/customer.html")
	public String customer(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return "customer/index";
	}
	@RequestMapping("/business.html")
	public String business(HttpSession httpSession) {
		httpSession.getAttribute("userLogin");
		return "business/index";
	}
    @RequestMapping("/test")
    public String test() {
    	return "test";
    }
}
