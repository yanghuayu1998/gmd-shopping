package com.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Goods {
	/**
	 * *��Ʒ���
	 */
    private Integer goodId;
    /**
	 * *��Ʒ����
	 */

    private String goodName;
    /**
	 * *��Ʒ�۸�
	 */

    private Double goodPrices;
    /**
	 * *��Ʒ�ۿ�
	 */

    private Double goodDiscount;
    /**
	 * *��Ʒ״̬��0Ԥ�ۣ�1�����У�2���¼�
	 */

    private Integer goodStatus;
    /**
	 * *��Ʒ����
	 */

    private Integer goodCount;
    /**
	 * *��Ʒ�Ƿ���Ʒ 0����Ʒ��1������Ʒ
	 */

    private Integer goodIsNew;
    /**
	 * *��Ʒ�Ƿ�������0��������1��������
	 */

    private Integer goodIsHot;
    /**
	 * *��Ʒ�ȼ���0-4 5���ȼ�
	 */

    private Integer goodLevel;
    /**
	 * *��Ʒ���
	 */

    private String goodBrief;
    /**
	 * *��Ʒ����
	 */

    private String goodDetails;
    /**
	 * *��ƷͼƬ
	 */

    private String goodPhoto;
    /**
	 * *��Ʒ����
	 */

    private Integer class2Id;
    /**
     * *��ѯ���� ����Ʒ�۸�����
     */
    
    private Double goodsPriceMin;
    
    /**
     * *��ѯ��������Ʒ�۸�����
     */
    
    private Double goodsPriceMax;
    /**
     * *��ѯ������һ�����ͱ��
     */
    
    private Integer class1Id;
    /**
     * ��Ʒ���������ڱ���ͳ�Ʒ���Ľ��
     */
    
    private Integer goodSum;
    
}