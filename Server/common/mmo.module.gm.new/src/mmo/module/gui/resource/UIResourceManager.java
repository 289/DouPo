package mmo.module.gui.resource;


import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Widget;

import com.swtdesigner.SWTResourceManager;

public class UIResourceManager {
	/** ��ɫ */
	public static final int            COLOR_RED         = SWT.COLOR_RED;
	/** ��ɫ */
	public static final int            COLOR_BLACK       = SWT.COLOR_BLACK;
	/** ��񱳾���ɫ */
	public static final Color          TABLE_ROW_0_COLOR = SWTResourceManager.getColor(255, 245, 238);
	public static final Color          TABLE_ROW_1_COLOR = SWTResourceManager.getColor(245, 255, 250);
	/** ��ԴͼƬ���� */
	public static final String         TOC_CLOSED        = "closed.gif";
	public static final String         TOC_OPEN          = "open.gif";
	public static final String         TOPIC             = "topic.gif";
	public static final String         ADDTASK           = "addtsk.gif";
	public static final String         GAME              = "game.gif";
	public static final String         RESOURCE          = "resource.gif";
	public static final String         EDITOR            = "editor.gif";

	/** ��������ؼ�ID�ļ� */
	public final static String         WIDGET_ID         = "controlID";
	/** ����Ϊ�ؼ�����Ψһ�ļ�ֵ */
	private final static AtomicInteger createControlID   = new AtomicInteger(1);

	/** ���� */
	public static Font                 arial             = null;
	public static Font                 courierNew        = null;
	/** �����Ѿ����ص�ͼƬ��Դ */
	private static Map<String, Image>  images            = new HashMap<String, Image>();

	public final static void initResource(Display display) {
		arial = new Font(display, "Arial", 11, SWT.NONE);
		courierNew = SWTResourceManager.getFont("Courier New", 10, SWT.NORMAL);
	}

	/**
	 * �ͷ��Ѿ���������Դ
	 */
	public final static void disposeResource() {
		disposeFont();
		disposeImage();
		disposeColor();
	}

	/**
	 * ����ͼƬ.���ȴ�htImage�л��ͼƬ�������û�У�������µ�ͼƬ�����뵽htImage
	 * 
	 * @param display
	 * @param imageUrl
	 * @return
	 */
	public final static Image getImage(Display display, String imageUrl) {
		Image image = (Image) images.get(imageUrl.toUpperCase());
		if (image == null) {
			image = new Image(display, imageUrl);
			images.put(imageUrl.toUpperCase(), image);
		}
		return image;
	}

	public final static Image createImage(Display display, byte[] data) {
		InputStream is = new ByteArrayInputStream(data);
		Image image = new Image(display, is);
		return image;
	}

	/**
	 * �ͷż��ص�ͼƬ
	 */
	private final static void disposeImage() {
		Iterator<Image> iterator = images.values().iterator();
		while (iterator.hasNext()) {
			Image image = (Image) iterator.next();
			if (!image.isDisposed())
				image.dispose();
		}
		images.clear();
	}

	/**
	 * �ͷŴ���������
	 */
	private final static void disposeFont() {
		if (arial != null && !arial.isDisposed()) {
			arial.dispose();
			arial = null;
		}
		if (courierNew != null && !courierNew.isDisposed()) {
			courierNew.dispose();
			courierNew = null;
		}
	}

	private final static void disposeColor() {
		if (TABLE_ROW_0_COLOR != null && !TABLE_ROW_0_COLOR.isDisposed()) {
			TABLE_ROW_0_COLOR.dispose();
		}
		if (TABLE_ROW_1_COLOR != null && !TABLE_ROW_1_COLOR.isDisposed()) {
			TABLE_ROW_1_COLOR.dispose();
		}
	}

	public final static void bindID2Widget(Widget widget) {
		if (widget != null && widget.getData(WIDGET_ID) == null) {
			widget.setData(WIDGET_ID, createControlID.getAndIncrement());
		}
	}

	public final static int generateID() {
		return createControlID.getAndIncrement();
	}
}
