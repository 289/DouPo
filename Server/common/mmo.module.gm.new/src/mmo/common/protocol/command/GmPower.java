package mmo.common.protocol.command;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GmPower {
	private final static Map<Integer, String> menus = new HashMap<Integer, String>();
	private final static Map<Integer, String> menuItems = new HashMap<Integer, String>();


	static {
		menus.put(1, "�ͷ�����");
		menuItems.put(1, "����˺�");
		menuItems.put(2, "���߲�ѯ");
		menuItems.put(3, "��������");
		menuItems.put(5, "���֧��");
		menuItems.put(6, "���ʼ�¼");
		menuItems.put(7, "��������");
	}
	
	public final static String getMenu(int id){
		String name = menus.get(id);
		if (name == null) {
			return "�쳣#" + id;
		}
		return name;
	}
	
	public final static String getMenuItem(int id){
		String name = menuItems.get(id);
		if (name == null) {
			return "�쳣#" + id;
		}
		return name;
	}

	public final static int getMenuItemId(String name){
		Set<Integer> keys = menuItems.keySet();
		for(int k:keys){
			if(menuItems.get(k).equalsIgnoreCase(name)){
				return k;
			}
		}
		return 0;
	}
}
