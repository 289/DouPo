package mmo.module.gui.tab;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CTabFolder;
import org.eclipse.swt.widgets.Composite;

public class TabFolderFactory {
	/**
	 * 
	 * @param parent
	 * @return
	 */
	public static final CTabFolder getTabFolder(final Composite parent) {
		// �����Զ���ѡ�����
		final CTabFolder folder = new CTabFolder(parent, SWT.BORDER);

		// ����ѡ��Ĳ��֣�ͨ�����ֵ����ó��ֳ���󻯺���С�������
		// folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		// ���ø��ӵ�ѡ���Ҳ���Ǵ���Բ�ǵ�ѡ���ǩ
		folder.setSimple(false);
		// ����δѡ�б�ǩ��ͼ��͹رհ�ť��״̬
		folder.setUnselectedImageVisible(true);
		folder.setUnselectedCloseVisible(true);
		// ����ǰ��ɫ�ͱ���ɫ
		folder.setSelectionForeground(parent.getDisplay().getSystemColor(SWT.COLOR_WHITE));
		folder.setSelectionBackground(parent.getDisplay().getSystemColor(SWT.COLOR_DARK_GRAY));
		// // ��ʾ��󻯺���С����ť
		// folder.setMinimizeVisible(true);
		// folder.setMaximizeVisible(true);
		// ע��ѡ��¼�
		// folder.addCTabFolder2Listener(new CTabFolder2Adapter() {
		// // ��������С����ťʱ�������¼�
		// public void minimize(CTabFolderEvent event) {
		// // ����ѡ���״̬Ϊ��С����ѡ���״̬������ʾ�����ϽǵĴ��ڰ�ť
		// folder.setMinimized(true);
		// // �ı�ѡ��Ĳ��֣�������С��״̬
		// folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		// // ˢ�²��֣������������õĲ��ֽ���������
		// parent.layout(true);
		// }
		//
		// // ��������󻯰�ťʱ�������¼�
		// public void maximize(CTabFolderEvent event) {
		// folder.setMaximized(true);
		// folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		// parent.layout(true);
		// }
		//
		// // ��������ԭ��ťʱ�������¼�
		// public void restore(CTabFolderEvent event) {
		// folder.setMinimized(false);
		// folder.setMaximized(false);
		// folder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		// parent.layout(true);
		// }
		// });
		return folder;
	}

}
