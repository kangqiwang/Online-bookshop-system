package com.jzyqd.servlet.gwc;

import java.util.Collection;

public interface IGwc {

	/**
	 * ���ﳵ�����һ����Ʒ(1,��Ʒ������,���һ��.2,��Ʒ����,������һ)
	 * @param gwcItem
	 */
	public abstract void addItem(GwcItem gwcItem);

	/**
	 * �޸Ĺ��ﳵ��ĳ����Ʒ������
	 * @param id ��Ʒ���
	 * @param num ����
	 */
	public abstract void updateItemNum(int id, int num);

	/**
	 * ɾ�����ﳵ�е�ĳ����Ʒ 
	 * @param id ��Ʒ���
	 */
	public abstract void deleteGwcItem(int id);

	/**
	 * ��չ��ﳵ�е�������Ʒ
	 */
	public abstract void clear();

	/**
	 * �õ�ԭʼ�ܼ� 
	 * @return
	 */
	public abstract float getOldPrices();

	/**
	 * �õ���Ա�� 
	 * @return
	 */
	public abstract float getHyPrices();

	/**
	 * �õ��Ż��ܼ� 
	 * @return
	 */
	public abstract float getYhPrices();
	
	/**
	 * �õ����ﳵ�����е���Ʒ
	 * @return
	 */
	public Collection<GwcItem> getAllItems();

}