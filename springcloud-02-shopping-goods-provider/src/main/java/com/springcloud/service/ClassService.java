package com.springcloud.service;

import java.util.List;

import com.springcloud.entity.Class1;
import com.springcloud.entity.Class2;

/**
 * 
 * *���ڶ���һ�������������ģ��ķ���
 * @author asus
 *
 */
public interface ClassService {
	/**
	 * ��ѯһ��������Ϣ
	 * @return
	 */

	public abstract List<Class1> selectAllClass1();
	
	/**
	 * *����һ������Ų�ѯ��Ӧ�Ķ��������Ϣ
	 * @param class1Id һ�������
	 * @return �ɹ�����java.util.List���͵�ʵ�������򷵻�null
	 */
	
	public abstract List<Class2> selectClass2ByClass1Id(Integer class1Id);
}
