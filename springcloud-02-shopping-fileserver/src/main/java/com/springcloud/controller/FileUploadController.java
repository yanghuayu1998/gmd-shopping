package com.springcloud.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springcloud.common.UploadUtils;
import com.springcloud.vo.ResultValue;

@RestController
public class FileUploadController {
	// ��application.properties�ļ��л��ָ������ֵ����������Ӧ�ĳ�Ա����
	@Value("${web.user-path}")
	private String userPath;

	@Value("${web.goods-path}")
	private String goodsPath;

	@RequestMapping(value = "/userUpload")
	// Լ��Controller���ص�������RestValue��
	public ResultValue userUpload(@RequestParam("userPhoto") MultipartFile file) {
		ResultValue rv = new ResultValue();

		// �ϴ��ļ�
		// �����쳣
		try {
			Map<String, Object> map = this.uploadFiles(userPath, file);
			if (map != null && map.size() > 0) {
				rv.setCode(0);
				rv.setDataMap(map);
				return rv;

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("�û�ͷ���ϴ�ʧ��");
		return rv;

	}

	/**
	 * *�ϴ��ļ�
	 * 
	 * @param path �ϴ��ļ���·��
	 * @param file �ϴ����ļ�
	 * @return �ɹ�����java.util.Map���͵�ʵ�������򷵻�null
	 * @throws IOException
	 */

	@RequestMapping(value = "/goodUpload")
	// Լ��Controller���ص�������RestValue��
	public ResultValue goodUpload(@RequestParam("goodPhoto") MultipartFile file) {
		ResultValue rv = new ResultValue();

		// �ϴ��ļ�
		// �����쳣
		try {
			Map<String, Object> map = this.uploadFiles(goodsPath, file);
			if (map != null && map.size() > 0) {
				rv.setCode(0);
				rv.setDataMap(map);
				return rv;

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		rv.setMessage("��ƷͼƬ�ϴ�ʧ��");
		return rv;

	}

	/**
	 * ɾ����ƷͼƬ
	 * 
	 */
	@RequestMapping(value = "/deleteGoodPhoto")
	public ResultValue deleteGoodPhoto(@RequestParam("goodPhoto") String goodPhoto) {
		ResultValue rv = new ResultValue();
		try {
			// ��URL�л����ƷͼƬ������
			int indexOf = goodPhoto.lastIndexOf("/");
			if (indexOf != -1) {
				String fileName = goodPhoto.substring(indexOf + 1);
				File file = new File(this.goodsPath + fileName);
				// �ж��ļ���Ŀ¼�Ƿ����
				file.delete();
				rv.setCode(0);
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}

	@RequestMapping(value = "/deleteUserPhoto")
	public ResultValue deleteUserPhoto(@RequestParam("userPhoto") String userPhoto) {
		ResultValue rv = new ResultValue();
		try {
			// ��URL�л����ƷͼƬ������
			int indexOf = userPhoto.lastIndexOf("/");
			if (indexOf != -1) {
				String fileName = userPhoto.substring(indexOf + 1);
				File file = new File(this.userPath + fileName);
				// �ж��ļ���Ŀ¼�Ƿ����
				file.delete();
				rv.setCode(0);
				return rv;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		rv.setCode(1);
		return rv;
	}

	
	
	
	private Map<String, Object> uploadFiles(String path, MultipartFile file) throws IOException {
		// ����µ��ļ���
		String fileName = UploadUtils.getFileName();

		// �����ϴ����ļ���������ļ�����չ��
		String extendedName = UploadUtils.getExendName(file.getOriginalFilename());
		// �ϴ��ļ�
		// �����쳣
		// 1.���ļ�ת��Ϊ�ֽ����͵����飬����һ����������������
		byte[] bytes = file.getBytes();
		// 2.����һ���ļ�File��Ķ���ָ���ļ����ļ������ϴ�·��
		File saveFile = new File(path + fileName + extendedName);
		// 3.�ϴ��ļ�
		FileCopyUtils.copy(bytes, saveFile);
		// ���ɹ���ʱ���ļ������µ��ļ�����չ���ϴ�����ͼ��
		Map<String, Object> map = new HashMap<>();
		map.put("fileName", fileName);
		map.put("extendedName", extendedName);
		return map;
	}

}
