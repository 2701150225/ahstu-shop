package com.ahstu.web.pojo;
/**
 * *购物车对象
 * @安科 王宿生
 *
 */

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart {
	Map<Integer, ShopItem> map = new LinkedHashMap<Integer, ShopItem>();// 购物项Map集合 ，key为pid ，value为购物项
	private double total;// 购物总计

	public Collection<ShopItem> getShopItems() {// 购物车对象中有一个cartItem的属性
		return map.values();
	}

	public double getTotal() {
		return total;
	}

	public void addCart(ShopItem shopItem) {
		// 判断购物车中是否存在添加的该商品
		Integer pid = shopItem.getProduct().getPid();
		if (map.containsKey(pid)) {
			// 如果存在，获得购物车中原来的购物商品
			ShopItem _shopItem = map.get(pid);
			_shopItem.setCount(_shopItem.getCount() + shopItem.getCount());
		} else {
			map.put(pid, shopItem);//如果不存在，将商品添加道购物车
		}

		total += shopItem.getSubtotal();

	}

	// 移除购物项
	public void removeCart(Integer pid) {

		ShopItem shopItem = map.remove(pid);
		total -= shopItem.getSubtotal();

	}

	// 清空购物车
	public void clearCart() {

		map.clear();// 将购物车商品清空
		total = 0; // 总计设为0
	}
}
