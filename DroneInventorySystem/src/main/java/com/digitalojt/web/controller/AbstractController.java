package com.digitalojt.web.controller;

import org.slf4j.Logger;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.digitalojt.web.consts.LogMessage;
import com.digitalojt.web.util.MessageManager;

/**
 * 抽象コントローラー
 * ※全てのコントローラークラスは、このクラスを継承すること
 *
 * @author dotlife
 *
 */
public class AbstractController {

	/**
	 * 処理開始のログ
	 * 
	 * @param logger ロガーオブジェクト
	 * @param action アクション名
	 * @param method メソッド名
	 */
	protected void logStart(Logger logger, String action, String method) {
		logger.info(String.format(LogMessage.ACCESS_LOG));
		logger.info(String.format(LogMessage.APP_LOG, action, method, "START"));
	}

	/**
	 * 処理終了のログ
	 * 
	 * @param logger ロガーオブジェクト
	 * @param action アクション名
	 * @param method メソッド名
	 */
	protected void logEnd(Logger logger, String action, String method) {
		logger.info(String.format(LogMessage.APP_LOG, action, method, "END"));
	}

	/**
	 * エラーログ
	 * 
	 * @param logger ロガーオブジェクト
	 * @param action アクション名
	 * @param method メソッド名
	 * @param e 例外オブジェクト
	 */
	protected void logError(Logger logger, String action, String method, Exception e) {
		logger.error(String.format(LogMessage.ERROR_LOG, action, method, e));
	}

	/**
	 * バリデーションエラーログ
	 * 
	 * @param logger ロガーオブジェクト
	 * @param action アクション名
	 * @param method メソッド名
	 * @param errorMsg エラーメッセージ
	 */
	protected void logValidationError(Logger logger, String action, String method, String errorMsg) {
		logger.error(String.format(LogMessage.ERROR_LOG, action, method, errorMsg));
	}

	/**
	 * エラーメッセージをフラッシュメッセージにセット
	 * 
	 * @param messageSource メッセージソース
	 * @param redirectAttributes リダイレクト属性
	 * @param messageConst メッセージ定数
	 */
	public void setFlashErrorMsg(MessageSource messageSource, RedirectAttributes redirectAttributes,
			String messageConst) {
		String errorMsg = MessageManager.getMessage(messageSource, messageConst);
		redirectAttributes.addFlashAttribute("errorMsg", errorMsg);
	}
}
