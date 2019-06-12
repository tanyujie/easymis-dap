package org.easymis.dap.catalog.controller.system;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import io.swagger.annotations.Api;
@Api(value = "系统登录controller", tags = { "系统登录操作接口" })
@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login() { return "login"; }
	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String getLoginView(HttpServletRequest request) {
		if (request.getSession().getAttribute("admin") != null)
			return "index";
		return "login";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(String username, String password, Model model) {
		model.addAttribute("username", username);
		model.addAttribute("password", password);
		model.addAttribute("error", "登录失败");
		return "login";
	}
}
