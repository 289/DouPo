package com.huayi.doupo.base.model;

import java.io.*;

/**
	玩家装备红装用到的淬炼值实例表
*/
@SuppressWarnings("serial")
public class InstPlayerRedEquip implements Serializable
{
	private int index;
	public String result = "";
	/**
		编号
	*/
	private int id;
	public int getId(){
		return id;
	}
	public void setId(int id) {
		this.id = id;
		index = 1;
		result += index + "*int*" + id + "#";
	}

	public void setId(int id, int bs) {
		this.id = id;
	}

	/**
		玩家实例Id
	*/
	private int instPlayerId;
	public int getInstPlayerId(){
		return instPlayerId;
	}
	public void setInstPlayerId(int instPlayerId) {
		this.instPlayerId = instPlayerId;
		index = 2;
		result += index + "*int*" + instPlayerId + "#";
	}

	public void setInstPlayerId(int instPlayerId, int bs) {
		this.instPlayerId = instPlayerId;
	}

	/**
		装备Id
	*/
	private int equipInstId;
	public int getEquipInstId(){
		return equipInstId;
	}
	public void setEquipInstId(int equipInstId) {
		this.equipInstId = equipInstId;
		index = 3;
		result += index + "*int*" + equipInstId + "#";
	}

	public void setEquipInstId(int equipInstId, int bs) {
		this.equipInstId = equipInstId;
	}

	/**
		
	*/
	private int contions;
	public int getContions(){
		return contions;
	}
	public void setContions(int contions) {
		this.contions = contions;
		index = 4;
		result += index + "*int*" + contions + "#";
	}

	public void setContions(int contions, int bs) {
		this.contions = contions;
	}

	/**
		版本号
	*/
	private int version;
	public int getVersion(){
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
		index = 5;
		result += index + "*int*" + version + "#";
	}

	public void setVersion(int version, int bs) {
		this.version = version;
	}

	/**
		添加时间
	*/
	private String insertTime;
	public String getInsertTime(){
		return insertTime;
	}
	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
		index = 6;
		result += index + "*String*" + insertTime + "#";
	}

	public void setInsertTime(String insertTime, int bs) {
		this.insertTime = insertTime;
	}

	/**
		更新时间
	*/
	private String updateTime;
	public String getUpdateTime(){
		return updateTime;
	}
	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
		index = 7;
		result += index + "*String*" + updateTime + "#";
	}

	public void setUpdateTime(String updateTime, int bs) {
		this.updateTime = updateTime;
	}

	public String getResult(){
		return result;
	}

	public InstPlayerRedEquip clone(){
		InstPlayerRedEquip extend=new InstPlayerRedEquip();
		extend.setId(this.id);
		extend.setInstPlayerId(this.instPlayerId);
		extend.setEquipInstId(this.equipInstId);
		extend.setContions(this.contions);
		extend.setVersion(this.version);
		extend.setInsertTime(this.insertTime);
		extend.setUpdateTime(this.updateTime);
		return extend;
	}
}
