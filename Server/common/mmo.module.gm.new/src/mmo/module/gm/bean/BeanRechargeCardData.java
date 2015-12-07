package mmo.module.gm.bean;

import java.util.Date;

import mmo.common.config.role.RoleProfession;
import mmo.tools.util.DateUtil;

public class BeanRechargeCardData {
	private int    roleId;      // ��ɫID
	private String roleName;    // ��ɫ����
	private byte   profession;  // ��ɫְҵ
	private int    state;
	/** ��¼ʱ�� */
	private long   dateTime = 0;
	private int    totalCount;
	private int    dayOfYear;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public byte getProfession() {
		return profession;
	}

	public void setProfession(byte profession) {
		this.profession = profession;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public long getDateTime() {
		return dateTime;
	}

	public void setDateTime(long dateTime) {
		this.dateTime = dateTime;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getDayOfYear() {
		return dayOfYear;
	}

	public void setDayOfYear(int dayOfYear) {
		this.dayOfYear = dayOfYear;
	}

	public String[] toArray() {
		return new String[] { getRoleId() + "", getRoleName(), RoleProfession.getProfessionName(getProfession()), state + "",
		        DateUtil.formatDate(new Date(getDateTime())), getDayOfYear() + "", getTotalCount() + "" };
	}
}
