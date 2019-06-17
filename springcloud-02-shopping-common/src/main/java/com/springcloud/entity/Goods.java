package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
	/**
	 * *商品编号
	 */
    private Integer goodId;
    /**
	 * *商品名称
	 */

    private String goodName;
    /**
	 * *商品价格
	 */

    private Double goodPrices;
    /**
	 * *商品折扣
	 */

    private Double goodDiscount;
    /**
	 * *商品状态：0预售，1热卖中，2已下架
	 */

    private Integer goodStatus;
    /**
	 * *商品数量
	 */

    private Integer goodCount;
    /**
	 * *商品是否新品 0是新品，1不是新品
	 */

    private Integer goodIsNew;
    /**
	 * *商品是否热卖：0是热卖，1不是热卖
	 */

    private Integer goodIsHot;
    /**
	 * *商品等级：0-4 5个等级
	 */

    private Integer goodLevel;
    /**
	 * *商品简介
	 */

    private String goodBrief;
    /**
	 * *商品详情
	 */

    private String goodDetails;
    /**
	 * *商品图片
	 */

    private String goodPhoto;
    /**
	 * *商品类别二
	 */

    private Integer class2Id;
    /**
     * *查询条件 ：商品价格下限
     */
    
    private Double goodsPriceMin;
    
    /**
     * *查询条件：商品价格上限
     */
    
    private Double goodsPriceMax;
    /**
     * *查询条件：一级类型编号
     */
    
    private Integer class1Id;
    /**
     * 商品销量：用于保存统计分组的结果
     */
    
    private Integer goodSum;
    
}