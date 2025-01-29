package com.digitalojt.web.controller;

import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.digitalojt.web.consts.UrlConsts;
import com.digitalojt.web.form.LoginForm;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

/**
 * ログイン画面のコントローラークラス
 * 
 * @author dotlife
 *
 */
@Controller
@RequiredArgsConstructor
public class LoginController extends AbstractController {
	
	/** セッション情報 */
	private final HttpSession session;
	
	/**
	 * 初期表示
	 * 
	 * @param model
	 * @return 
	 */
	@GetMapping(UrlConsts.LOGIN)
	public String index(Model model, LoginForm form) {

		return "admin/login/index";
	}
	
	/**
	 * ログインエラー画面表示
	 * 
	 * @param model
	 * @return 
	 */
	@GetMapping(value = UrlConsts.LOGIN, params = "error")
	public String error(Model model, LoginForm form) {

		Exception errorInfo = (Exception) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		model.addAttribute("errorMsg", errorInfo.getMessage());
		return "admin/login/index";
	}
}
