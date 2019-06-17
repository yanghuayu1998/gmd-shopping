package com.springcloud.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * USERS琛ㄥ搴旂殑瀹炰綋绫伙紝鐢ㄤ簬灏佽USERS琛ㄤ腑涓�琛岀敤鎴蜂俊鎭�
 * @author p
 *
 */


@Data
@Entity
@Table(name="users")
@NoArgsConstructor
@AllArgsConstructor
public class Users implements java.io.Serializable {
	
	private static final long serialVersionUID = -720590741960403850L;
	/**
	 *鐢ㄦ埛缂栧彿
	 */
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	/**
	 * 鐢ㄦ埛濮撳悕
	 */
	@Column(name="user_name")
	private String userName;
	/**
	 * 韬唤璇佸彿
	 */
	@Column(name="user_number")
	private String userNumber;
	/**
	 * 鐢ㄦ埛瀵嗙爜
	 */
	@Column(name="user_password")
	private String userPassword;
	/**
	 * 鐢ㄦ埛鎬у埆 锛�0涓虹敺锛�1涓哄コ锛�

	 */
	@Column(name="user_sex")
	private Integer userSex;
	/**
	 * 鐢ㄦ埛鑱旂郴鍙风爜
	 */
	@Column(name="user_phone")
	private String userPhone;
	/**
	 * 鏀惰揣鍦板潃
	 */
	@Column(name="user_site")
	private String userSite;
	/**
	 * 鍑虹敓鏃ユ湡
	 */
	@Column(name="user_birthday")
	@DateTimeFormat(pattern ="yy-MM-dd")
	private Date userBirthday;
	/**
	 * 閭
	 */
	@Column(name="user_email")
	private String userEmail;
	/**
	 * 澶村儚
	 */
	@Column(name="user_photo")
	private String userPhoto;
	/**
	 * 鏉冮檺缂栧彿锛�1涓鸿秴绾х鐞嗗憳锛�2涓烘櫘閫氱鐞嗗憳锛�3涓烘櫘閫氱敤鎴凤紝4涓篤IP鐢ㄦ埛锛�

	 */
	@Column(name="jdiction_id")
	private Integer jdictionId;
	/**
	 * 鐢ㄦ埛鐘舵�� 锛�0涓哄彲鐢紝1涓虹鐢級
	 */
	@Column(name="user_status")
	private Integer userStatus;
	
}

