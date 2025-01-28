package com.digitalojt.web.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 操作履歴Entity
 * 
 * @author dotlife
 *
 */
@Data
@Getter
@Setter
@Entity
public class OperationLog {

	/**
	 * ログID
	 */
	@Id
	private int logId;

	/**
	 * 管理者ID
	 */
	@ManyToOne
	@JoinColumn(name = "admin_id")
	private AdminInfo adminInfo;

	/**
	 * 操作対象のテーブルキー
	 */
	private String tableKey;

	/**
	 * 操作の種類
	 */
	private String operateType;

	/**
	 * 操作のステータス
	 */
	private String status;

	/**
	 * 論理削除フラグ
	 */
	private String deleteFlag;

	/**
	 * 更新日
	 */
	private Timestamp updateDate;

	/**
	 * 登録日
	 */
	private Timestamp createDate;
}
