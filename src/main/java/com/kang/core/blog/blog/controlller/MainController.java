package com.kang.core.blog.blog.controlller;

import com.kang.core.blog.blog.domain.User;
import com.kang.core.blog.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * 主页控制器.
 */
@Controller
public class MainController {
	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String root() {
		return "redirect:/index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/login-error")
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		model.addAttribute("errorMsg", "草泥马的 密码错了！");
		return "login";
	}
	
	@GetMapping("/register")
	public String register() {
		return "register";
	}
	/**
	 * 注册用户
	 * @param user
	 * @return
	 */
	@PostMapping("/register")
	public String registerUser(User user) {
		userService.registerUser(user);
		return "redirect:/login";
	}
}