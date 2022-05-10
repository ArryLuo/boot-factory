package com.arryluo.util;

import java.util.UUID;

/**
 * @author arryluo
 */
public class UuidUtil {
	/**
	 * 返回32位小写得uuid字符串
	 * @return
	 */
	public static String get32UUID() {
		String uuid = UUID.randomUUID().toString().trim().replaceAll("-", "");
		return uuid;
	}
	
	public static void main(String[] args) {
		System.out.println(get32UUID());
	}
}

