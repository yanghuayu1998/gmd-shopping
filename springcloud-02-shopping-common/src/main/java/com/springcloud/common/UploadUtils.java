package com.springcloud.common;

import java.util.Date;

/**
 * 文件上传的工具类
 * @author asus 在用户上传文件的时候修改文件名，避免出现用户文件被覆盖的情况
 *
 */

public class UploadUtils {
	
	/**
	 * 获得新文件名称（毫秒数+4位随机数）
	 * @return 返回新的文件名称
	 */
	public static String getFileName() {
		String fileName = null;
		
		//获得1到1000之间的随机数
		int num = (int)(Math.random() *1000 +1);
		
		//将随机数设置为4位
		//在随机生成的字符串前面加"000"  1,01,001,0001,改为0001,000001,0000001
		String tempNum = "000" + num;
		//再在字符串的后面截取倒数的四个字符
		tempNum = tempNum.substring(tempNum.length() - 4);
		
		Date date = new Date();
		fileName = date.getTime() + tempNum;
		
		return fileName;
	}
	/**
	 * 返回文件的扩展名
	 * @param fileName
	 * @return成功返回文件扩展名，否则返回null
	 */
	public static String getExendName(String fileName) {
		if(fileName == null || fileName.length() == 0){
			return null;
			
		}
		//获得文件名，最后一次出现的位置
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
