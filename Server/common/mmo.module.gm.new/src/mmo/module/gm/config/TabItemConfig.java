package mmo.module.gm.config;

import java.util.HashMap;
import java.util.Map;

public class TabItemConfig {
	/** �˺���Ϣ */
	public static final int ITEM_1_ROLE_INFO = 1;
	/** ���߲�ѯ */
	public static final int ITEM_2_ITEM_INFO = 2;
	/** �������� */
	public static final int ITEM_3_CHARGE_CREATE_ORDER = 3;
	/** �������� */
	public static final int ITEM_4_RESET_PWD = 4;
	/** ���֧�� */
	public static final int ITEM_5_CHARGE_FINISH = 5;
	/** ���ʼ�¼ */
	public static final int ITEM_6_GET_GOLD = 6;
	/** Ӧ������ */
	public static final int ITEM_7_APP_CONFIG = 7;

	private final static Map<Integer, String> tabItems = new HashMap<Integer, String>();

	static {

		tabItems.put(ITEM_1_ROLE_INFO, "�˺���Ϣ");
		tabItems.put(ITEM_2_ITEM_INFO, "���߲�ѯ");
		tabItems.put(ITEM_3_CHARGE_CREATE_ORDER, "��������");
		tabItems.put(ITEM_4_RESET_PWD, "��������");
		tabItems.put(ITEM_5_CHARGE_FINISH, "���֧��");
		tabItems.put(ITEM_6_GET_GOLD, "���ʼ�¼");
		tabItems.put(ITEM_7_APP_CONFIG, "Ӧ������");

	}

	public final static String getTabItemTitle(int item) {
		String itemName = tabItems.get(item);
		if (itemName == null) {
			return item + "-δ֪";
		}
		return itemName;
	}
}
