package com.digitalojt.web.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 管理者情報Entity
 * 
 * @author dotlife
 * 
 */
@Data
@Getter
@Setter
@Entity
public class AdminInfo {

	/**
	 * 管理者ID
	 */
	@Id
	private String adminId;
	
	/**
	 * 管理者名
	 */
	private String adminName;
	
	/**
	 * パスワード
	 */
	private String password;
}
