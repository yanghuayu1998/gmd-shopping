package com.springcloud.common;

import java.util.Date;

/**
 * �ļ��ϴ��Ĺ�����
 * @author asus ���û��ϴ��ļ���ʱ���޸��ļ�������������û��ļ������ǵ����
 *
 */

public class UploadUtils {
	
	/**
	 * ������ļ����ƣ�������+4λ�������
	 * @return �����µ��ļ�����
	 */
	public static String getFileName() {
		String fileName = null;
		
		//���1��1000֮��������
		int num = (int)(Math.random() *1000 +1);
		
		//�����������Ϊ4λ
		//��������ɵ��ַ���ǰ���"000"  1,01,001,0001,��Ϊ0001,000001,0000001
		String tempNum = "000" + num;
		//�����ַ����ĺ����ȡ�������ĸ��ַ�
		tempNum = tempNum.substring(tempNum.length() - 4);
		
		Date date = new Date();
		fileName = date.getTime() + tempNum;
		
		return fileName;
	}
	/**
	 * �����ļ�����չ��
	 * @param fileName
	 * @return�ɹ������ļ���չ�������򷵻�null
	 */
	public static String getExendName(String fileName) {
		if(fileName == null || fileName.length() == 0){
			return null;
			
		}
		//����ļ��������һ�γ��ֵ�λ��
		int index = fileName.lastIndexOf(".");
		if(index == -1) {
			return null;
			
		}
		return fileName.substring(index);
	}
//	public static void main(String[] args) {
//		
//		System.out.println(getExendName("abcd.efg.jpg"));
//	}
//	
	
}
