﻿package mmo.common.xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import mmo.extension.application.ApplicationConfig;
import mmo.tools.log.LoggerError;
import mmo.tools.util.FileUtil;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

/***
 * 负责解析XLS文件
 * 
 * @author 李天喜
 * 
 */
abstract public class AXLSManager {

	/** 配置文件子目录 */
	private static final String          SUB_DIR        = "xls";
	private static final String          TAR_DIR        = "files";

	protected static final String        CFG_FILE       = "files.xml";
	protected final static String        TAG_FILES      = "files";
	protected final static String        TAG_FILE       = "file";
	protected final static String        ATT_NAME       = "name";
	protected final static String        ATT_TARGET     = "target";
	protected final static String        ATT_PARENT_DIR = "parent_dir";

	/** 数据文件存放目录 */
	protected String                     filePath       = "";
	protected String                     parentDir;

	/** 中文文件名与重命名后的文件之间的映射 */
	protected static Map<String, String> files          = new HashMap<String, String>();

	public AXLSManager() {

	}

	public void loadXLS(String path, boolean rename) {
		filePath = path;
		parseXml();
		if (rename) {
			rename();
		}
		loadXLS();
	}

	public void rename(String path) {
		filePath = path;
		parseXml();
		rename();
	}

	/**
	 * 加载XLS文件
	 */
	abstract public void loadXLS();

	/**
	 * 通过源文件名获取重命名后文件的完成路径
	 * 
	 * @param file
	 *            源文件名
	 * @return 重命名后文件的完成路径
	 */
	public static final String getTargetFile(String file) {
		return files.get(file);
	}

	/**
	 * 对源文件进行重命名
	 */
	private void rename() {
		if (!ApplicationConfig.getInstance().isWin()) {
			return;
		}
		StringBuilder fullDir = new StringBuilder();
		fullDir.append(filePath).append(FileUtil.FILE_SEPARATOR).append(SUB_DIR).append(FileUtil.FILE_SEPARATOR);
		String sourcePath = fullDir.toString();

		Set<String> keys = files.keySet();
		if (parentDir != null && parentDir.trim().length() > 1) {
			sourcePath = parentDir;
		}

		for (String key : keys) {
			FileUtil.rename(sourcePath + key, files.get(key));
			LoggerError.messageLog.warn((sourcePath + key) + "  ——>  " + files.get(key));
		}
	}

	/**
	 * 解析源文件与重命名文件名间的映射
	 */
	private void parseXml() {
		StringBuilder fullDir = new StringBuilder();
		fullDir.append(filePath).append(FileUtil.FILE_SEPARATOR).append(SUB_DIR).append(FileUtil.FILE_SEPARATOR).append(TAR_DIR)
		        .append(FileUtil.FILE_SEPARATOR);
		String targetPath = fullDir.toString();
		fullDir.setLength(0);
		fullDir.append(filePath).append(FileUtil.FILE_SEPARATOR).append(SUB_DIR).append(FileUtil.FILE_SEPARATOR).append(CFG_FILE);

		SAXBuilder builder = new SAXBuilder();
		Document doc = null;
		try {
			doc = builder.build(new InputStreamReader(new FileInputStream(new File(fullDir.toString())), "UTF-8"));
		} catch (JDOMException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String text = null;
		String name = null;

		Element notices = doc.getRootElement();
		parentDir = notices.getAttributeValue(ATT_PARENT_DIR);
		List<Element> eleXingList = notices.getChildren(TAG_FILE);
		if (eleXingList != null) {
			for (Element ele : eleXingList) {
				text = ele.getAttributeValue(ATT_NAME);
				if (text != null && text.trim().length() > 0) {
					name = text.trim();

					text = ele.getAttributeValue(ATT_TARGET);
					if (text != null && text.trim().length() > 0) {
						files.put(name, targetPath + text.trim());
					}
				}
			}
		}
	}
}
