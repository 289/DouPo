package mmo.module.gm.gui.dialog;

import mmo.module.gm.gui.GMWindow;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Display;

public class MyDialog {
	public static void openError(final String message) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openError(GMWindow.getInstance().getTopShell(), "������Ϣ", message);
			}
		});
	}

	public static boolean openConfirm(final String message) {
		return MessageDialog.openConfirm(GMWindow.getInstance().getTopShell(), "ȷ����Ϣ", message);
	}

	public static void openInformation(final String message) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openInformation(GMWindow.getInstance().getTopShell(), "��ʾ��Ϣ", message);
			}
		});
	}

	public static boolean openQuestion(final String message) {
		return MessageDialog.openQuestion(GMWindow.getInstance().getTopShell(), "ѯ�ʲ���", message);
	}

	public static void openWarning(final String message) {
		Display.getDefault().asyncExec(new Runnable() {
			public void run() {
				MessageDialog.openWarning(GMWindow.getInstance().getTopShell(), "������Ϣ", message);
			}
		});
	}
}
