package mmo.module.gui.tree;

import mmo.module.gui.action.TreeAction;
import mmo.module.gui.resource.ResourcePath;
import mmo.module.gui.resource.UIResourceManager;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeItem;

public class TreeUtil {

	/**
	 * ����һ����
	 * 
	 * @param parent
	 * @return
	 */
	public static Tree getTree(Composite parent) {
		final Tree tree = new Tree(parent, SWT.BORDER | SWT.SINGLE);
		// Ϊ��ע���������¼�
		tree.addTreeListener(new TreeAction());
		return tree;
	}

	/**
	 * ������ͼ��ķ���
	 * 
	 * @param tree
	 */
	public static void convertImage(Tree tree) {
		// �������ֻ��һ�����ڵ�
		TreeItem[] items = tree.getItems();
		int length = items.length;
		for (int i = 0; i < length; i++) {
			UIResourceManager.bindID2Widget(items[i]);
			// ���ȸ��ݸ��ڵ��״̬����ͼ��
			if (items[i].getExpanded()) {// ����ýڵ�Ϊչ��״̬
				items[i].setImage(UIResourceManager.getImage(tree.getDisplay(), ResourcePath.ICON_EDITOR + UIResourceManager.TOC_OPEN));
			} else { // �������Ϊ�۵�״̬
				items[i].setImage(UIResourceManager.getImage(tree.getDisplay(), ResourcePath.ICON_EDITOR + UIResourceManager.TOC_CLOSED));
			}
			// ���øø��ڵ��ͼ��
			setChildImage(items[i]);
		}
	}

	/**
	 * ����һ���ڵ�ķ������÷����ǳ���Ҫ��Ҫ���÷����ĵݹ��÷�
	 * 
	 * @param item���԰ѵ������������е�ĳһ��TreeItem
	 */
	private static void setChildImage(TreeItem item) {
		TreeItem[] items = item.getItems();// ���Ȼ�ø�TreeItem��������TreeItem
		for (int i = 0; i < items.length; i++) {// ѭ��ÿһ��TreeItem
			UIResourceManager.bindID2Widget(items[i]);
			if (items[i].getItems().length == 0) {// ������TreeItem��û������
				items[i].setImage(UIResourceManager.getImage(item.getDisplay(), ResourcePath.ICON_EDITOR + UIResourceManager.TOPIC));
			} else {// ������TreeItem�ж������
				if (items[i].getExpanded()) {// ������TreeItem��չ��״̬��������չ����ͼƬ
					items[i].setImage(UIResourceManager.getImage(item.getDisplay(), ResourcePath.ICON_EDITOR + UIResourceManager.TOC_OPEN));
				} else {// �����������۵���ͼƬ
					items[i].setImage(UIResourceManager.getImage(item.getDisplay(), ResourcePath.ICON_EDITOR + UIResourceManager.TOC_CLOSED));
				}
				setChildImage(items[i]);// ҪΪ��TreeItem����������ͼ�꣬�ݹ����setChildImage����
			}
		}
	}

	public static Tree initSceneTree(Composite parent) {
		return null;
	}

	// �����������������ݣ��ݹ���ø÷���
	// private static void setDirectory(File file, TreeItem parent) {
	// File[] files = file.listFiles();
	// for (int i = 0; i < files.length; i++) {
	// TreeItem item = new TreeItem(parent, SWT.NONE);
	// item.setData(Constants.TREE_CATE, Constants.TREE_RESOURCE);
	// item.setText(files[i].getName());
	// if (files[i].isDirectory()) {
	// setDirectory(files[i], item);
	// }
	// }
	// }
}
