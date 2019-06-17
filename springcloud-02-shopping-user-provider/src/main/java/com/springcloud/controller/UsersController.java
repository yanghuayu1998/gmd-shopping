package com.springcloud.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springcloud.common.PageUtils;
import com.springcloud.entity.Users;
import com.springcloud.service.UsersService;
import com.springcloud.vo.ResultValue;

/**
 * ���Ʋ㣺������ͼ������ݣ�������ģ�Ͳ���Ӧ�ķ����������ݷ��ص���ͼ����
 * 
 * @author asus
 *
 */
@RestController
public class UsersController {
	@Autowired
	private UsersService usersService;

	/**
	 * �û���Ϣ
	 * 
	 * @param userId           �û����
	 * @param userPassword�û�����
	 * @param jdictionIdȨ�ޱ��
	 * @return
	 */

	@RequestMapping(value = "/login")
	public ResultValue login(@RequestParam("userId") Integer userId, @RequestParam("userPassword") String userPassword,
			@RequestParam("jdictionId") Integer jdictionId) {
		ResultValue rv = new ResultValue();

		try {
			Users login = this.usersService.login(userId, userPassword, jdictionId);
			if (login != null) {
				rv.setCode(0);

				Map<String, Object> map = new HashMap<>();
				map.put("loginUser", login);
				rv.setDataMap(map);

				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		rv.setCode(1);
		rv.setMessage("��¼��Ϣ����ȷ�����������룡����");
		return rv;
	}

	@RequestMapping(value = "/insert")
	public ResultValue insert(Users users) {
		ResultValue rv = new ResultValue();

		try {
			Users insert = this.usersService.insert(users);
			if (insert != null) {
				rv.setCode(0);
				rv.setMessage("�û�¼��ɹ�������");
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}
		rv.setCode(1);
		rv.setMessage("�û�¼��ʧ�ܣ���!");
		return rv;
	}

	/**
	 * ��ѯ�����������û���Ϣ
	 * 
	 * @return
	 */
	@RequestMapping(value = "select")
	public ResultValue select(Users users, @RequestParam("pageNumber") Integer pageNumber) {
		ResultValue rv = new ResultValue();
		try {
			Page<Users> page = this.usersService.select(users, pageNumber);
			// ��÷�ҳ����
			List<Users> list = page.getContent();

			// �ж��Ƿ��ѯ��������
			if (list != null && list.size() > 0) {
				rv.setCode(0);
				Map<String, Object> map = new HashMap<>();
				// ����ҳ������ӵ�Map��
				map.put("userList", list);

				PageUtils pageUtils = new PageUtils((int) page.getTotalElements());
				pageUtils.setPageNumber(pageNumber);
				// ����ҳ��Ϣ��ӵ�Map��
				map.put("pageUtils", pageUtils);

				// ��Map������ӵ�ResultValue������
				rv.setDataMap(map);
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}

	@RequestMapping(value = "/updateStatus")
	public ResultValue updateStatus(@RequestParam("userId") Integer userId,
			@RequestParam("userStatus") Integer userStatus) {
		ResultValue rv = new ResultValue();
		try {
			Integer status = this.usersService.updateStatus(userId, userStatus);
			if (status > 0) {
				rv.setCode(0);
				rv.setMessage("�û��޸ĳɹ�������");
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("�û��޸�ʧ�ܣ�����");
		return rv;
	}

	/**
	 * ��ѯָ����ŵ��û���Ϣ
	 * 
	 * @param userId �û����
	 * @return
	 */
	@RequestMapping(value = "/select/{userId}")
	public ResultValue selectById(@PathVariable("userId") Integer userId) {
		ResultValue rv = new ResultValue();
		try {

			// ����service�еķ���������ò�ѯ���
			Users users = this.usersService.selectById(userId);

			// ����ɹ�
			if (users != null) {

				// ���ý����״̬Ϊ0
				rv.setCode(0);
				// ����Map���ϱ��浽��ѯ���
				Map<String, Object> map = new HashMap<>();
				// ����ѯ���������Map������
				map.put("users", users);
				// ����ѯ�����ӵ�ResultValue������
				rv.setDataMap(map);
				// ����ResultValue����
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		rv.setCode(1);
		rv.setMessage("�û���Ϣ��ȡʧ�ܣ�����");
		return rv;
	}

	@RequestMapping(value = "/update")
	public ResultValue update(Users users) {
		ResultValue rv = new ResultValue();
		try {
			// ����service����Ӧ�ķ����޸��û���Ϣ
			Integer update = this.usersService.update(users);
			// ����ɹ�
			if (update > 0) {
				// ���ý����״̬Ϊ0
				rv.setCode(0);
				// ����ResultValue����
				return rv;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("�û���Ϣ�޸�ʧ�ܣ�����");
		return rv;
	}
	/**
	 * �޸��û���Ϣ
	 * @param users
	 * @return
	 */
	
	@RequestMapping(value = "/updateMessage")
	public ResultValue updateMessage(Users users) {
		ResultValue rv = new ResultValue();
		try {
			Integer message = this.usersService.updateMessage(users);
			if(message > 0) {
				rv.setCode(0);
				rv.setMessage("�û���Ϣ�޸ĳɹ�!!!");
				return rv;
			}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}
		rv.setCode(1);
		rv.setMessage("�û���Ϣ�޸�ʧ�ܣ���!");
		return rv;
	}
}
