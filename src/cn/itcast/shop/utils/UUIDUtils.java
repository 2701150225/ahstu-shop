package cn.itcast.shop.utils;

import java.util.UUID;

/**
 * 生成随机字符串UUID工具类
 * @author wss
 *
 */
public class UUIDUtils {
	/**
	 * 获得随机的字符串
	 * @return
	 */
	public static String getUUID(){
		return UUID.randomUUID().toString().replace("-", "");
	}
}
