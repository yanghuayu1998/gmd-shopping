package com.springcloud.service;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.OrderDetail;

/**
 * ������ϸģ���ģ�Ͳ㣬���ڶ��嶩����ϸģ��ķ���
 * @author asus
 *
 */
public interface OrderDetailService {
	/**
	 * ��ѯָ��������ŵĶ�����Ϣ����ҳ���ܣ�
	 * @param orderId �������
	 *  @param PageNUmber ҳ��
	 * @return ����com.github.pagehelper.PageInfo<OrderDetail>��ʵ��
	 */
	
	public abstract PageInfo<OrderDetail> selectByOrderId(Integer orderId,Integer pageNmuber);

}
