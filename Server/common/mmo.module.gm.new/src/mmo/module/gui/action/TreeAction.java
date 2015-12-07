package mmo.module.gui.action;


import mmo.module.gui.resource.ResourcePath;
import mmo.module.gui.resource.UIResourceManager;

import org.eclipse.swt.events.TreeEvent;
import org.eclipse.swt.events.TreeListener;
import org.eclipse.swt.widgets.TreeItem;

public class TreeAction implements TreeListener {
	/**
	 * ���۵����ڵ�ʱ
	 */
	public void treeCollapsed(TreeEvent e) {
		// ���Ȼ�ô����¼���TreeItem
		TreeItem item = (TreeItem) e.item;
		// ���ýڵ��ͼ������Ϊ�ر�״̬
		item.setImage(UIResourceManager.getImage(e.display, ResourcePath.ICON_EDITOR + UIResourceManager.TOC_CLOSED));
	}

	/**
	 * ��չ�����ڵ�ʱ
	 */
	public void treeExpanded(TreeEvent e) {
		TreeItem item = (TreeItem) e.item;
		item.setImage(UIResourceManager.getImage(e.display, ResourcePath.ICON_EDITOR + UIResourceManager.TOC_OPEN));
	}

}
