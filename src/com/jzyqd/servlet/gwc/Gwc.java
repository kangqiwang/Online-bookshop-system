package com.jzyqd.servlet.gwc;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class Gwc implements IGwc {
	private Map<Integer, GwcItem> items = new Hashtable<Integer, GwcItem>();
	/**
	 * 向购物车中添加一件商品(1,商品不存在,添加一件.2,商品存在,数量加一)
	 * @param gwcItem
	 */
	public void addItem(GwcItem gwcItem) {
		Set<Integer> ids = items.keySet();
		//如果商品已经存在
		if (ids.contains(gwcItem.getBookId())) {
			GwcItem oldItem = items.get(gwcItem.getBookId());
			oldItem.setNum(oldItem.getNum() + 1);
			items.put(oldItem.getBookId(), oldItem);
		} else {
			items.put(gwcItem.getBookId(), gwcItem);
		}
	}

	public void clear() {
		items.clear();
	}

	public void deleteGwcItem(int id) {
		items.remove(id);
	}
	public void updateItemNum(int id, int num) {
		GwcItem item = items.get(id);
		item.setNum(num);
		//items.put(id, item);
	}

	public Collection<GwcItem> getAllItems() {
		
		return items.values();
	}

	public float getHyPrices() {
		float sumPrice = 0;
		Collection<GwcItem> shangpins = items.values();
		for (GwcItem gwcItem : shangpins) {
			sumPrice += gwcItem.getNum() * gwcItem.getHyprice();
		}
		return sumPrice;
	}

	public float getOldPrices() {
		float sumPrice = 0;
		Collection<GwcItem> shangpins = items.values();
		for (GwcItem gwcItem : shangpins) {
			sumPrice += gwcItem.getNum() * gwcItem.getPrice();
		}
		return sumPrice;
	}

	public float getYhPrices() {
		return getOldPrices() - getHyPrices();
	}

	

}
