package com.digitalojt.web.form;

import com.digitalojt.web.validation.CenterInfoFormValidator;

import lombok.Data;

/**
 * 在庫センター情報画面のフォームクラス
 * 
 * @author dotlife
 *
 */
@Data
@CenterInfoFormValidator
public class CenterInfoForm {

	/**
	 * センター名
	 */
	private String centerName;

	/**
	 * 都道府県
	 */
	private String region;

	/**
	 * 容量(From)
	 */
	private Integer storageCapacityFrom;

	/**
	 * 容量(To)
	 */
	private Integer storageCapacityTo;

	// 容量(From)初期値
	final int INITIAL_CAPACITY_FROM = 10;

	/**
	 * 容量(From)のデフォルト値（10）を設定
	 * 
	 * @return
	 */
	public Integer getStorageCapacityFrom() {

		if (storageCapacityTo != null && storageCapacityFrom == null) {
			return INITIAL_CAPACITY_FROM;
		}
		return storageCapacityFrom;
	}
}
