package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * ORDER_DETAILS���Ӧ��ʵ���࣬���ڷ�װһ�ж�������ϸ��Ϣ
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderDetail implements java.io.Serializable {

	private static final long serialVersionUID = -5653921127663115225L;

	/**
	 * ������ϸ���
	 */

	private Integer orderDetailId;

	/**
	 * �������
	 */
	private Integer orderId;
	/**
	 * ��Ʒ���
	 */

	private Integer goodId;
	/**
	 * ��Ʒ����
	 */

	private String goodName;
	/**
	 * �ɽ���
	 */

	private Double transactionPrice;
	/**
	 * �ɽ�����
	 */

	private Integer transactionCount;

}