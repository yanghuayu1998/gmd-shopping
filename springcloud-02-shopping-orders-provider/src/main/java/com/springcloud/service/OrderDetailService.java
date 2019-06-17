package com.springcloud.service;

import com.github.pagehelper.PageInfo;
import com.springcloud.entity.OrderDetail;

/**
 * 订单明细模块的模型层，用于定义订单明细模块的方法
 * @author asus
 *
 */
public interface OrderDetailService {
	/**
	 * 查询指定订单编号的订单信息（分页功能）
	 * @param orderId 订单编号
	 *  @param PageNUmber 页数
	 * @return 返回com.github.pagehelper.PageInfo<OrderDetail>的实例
	 */
	
	public abstract PageInfo<OrderDetail> selectByOrderId(Integer orderId,Integer pageNmuber);

}
