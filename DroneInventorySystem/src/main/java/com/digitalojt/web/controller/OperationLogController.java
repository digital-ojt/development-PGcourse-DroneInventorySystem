package com.digitalojt.web.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.digitalojt.web.consts.UrlConsts;
import com.digitalojt.web.entity.OperationLog;
import com.digitalojt.web.service.OperationLogService;

import lombok.RequiredArgsConstructor;

/**
 * 操作履歴画面のコントローラークラス
 * 
 * @author dotlife
 *
 */
@Controller
@RequiredArgsConstructor
public class OperationLogController extends AbstractController {

	/** 操作履歴 サービス */
	private final OperationLogService operationLogService;

	/** メッセージソース */
	private final MessageSource messageSource;

	/** ログ設定 */
	private final Logger logger = LoggerFactory.getLogger("OperationLog");

	/**
	 * 初期表示
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping(UrlConsts.OPERATION_LOG)
	public String index(Model model) {

		logStart(logger, "GET", "operationLogView");

		// 操作履歴情報の取得
		List<OperationLog> operationLogList = operationLogService.getOperationLogList();
		model.addAttribute("operationLogList", operationLogList);

		logEnd(logger, "GET", "operationLogView");

		return "admin/operationLog/index";
	}
}
