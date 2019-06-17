package com.springcloud.service;

import org.springframework.data.domain.Page;

import com.springcloud.entity.Users;

/**
 * ģ�Ͳ�Ľӿڣ����ڶ����û�ģ��ķ���
 * 
 * @author asus
 *
 */

public interface UsersService {
	/**
	 * ��֤�û��Ƿ��¼�ɹ�
	 * 
	 * @param userId           �û����
	 * @param userPassword�û�����
	 * @param jdictionId�û�Ȩ�ޱ��
	 * @return �ɹ����ص�¼�û�������Ϣ��ʧ�ܷ���null
	 */

	public abstract Users login(Integer userId, String userPassword, Integer jdictionId);

	/**
	 * ����û���Ϣ
	 * 
	 * @param users �µ��û���Ϣ
	 * @return ��ӳɹ� ����com.springcloud.entity.Users���͵�ʵ�������򷵻�null
	 */
	public abstract Users insert(Users users);

	/**
	 * ��ѯ�����������û���Ϣ
	 * 
	 * @param users      ��ѯ����
	 * @param pageNumber ��ѯҳ��
	 * @return �ɹ�����org.springframework.data.domain.Page��ʵ�������򷵻�false
	 */
	public abstract Page<Users> select(Users users, Integer pageNumber);
	
	/**
	 * �޸�ָ���û���ŵ�״̬
	 * @param userId	�û����
	 * @param userStatus�û�״̬
	 * @return �޸ĳɹ����ش���0 �����������򷵻�0
	 */

	public abstract Integer updateStatus(Integer userId, Integer userStatus);
	/**
	 **  ��ѯָ����ŵ��û���Ϣ
	 * @param userId  �û����
	 * @return �ɹ�����com.springclound.entity.Users���͵�ʵ�������򷵻�null
	 */
	public abstract Users selectById(Integer userId);
	/**
	 * �޸�ָ����ŵ��û���Ϣ
	 * @param users	�޸ĵ��û���Ϣ
	 * @return �޸ĳɹ����ش���0 �����������򷵻�0
	 */
	
	public abstract Integer update(Users users);
	/**
	 * ���ݲ����޸�ָ������û���ͷ���������ǳ�
	 * @param users �޸ĵ��û���Ϣ
	 * @return �޸ĳɹ����ش���0�����������򷵻�0
	 */
	public abstract Integer updateMessage(Users users);
}



