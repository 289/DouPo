package com.huayi.doupo.base.model;

import java.io.*;

/**
	玩家卡牌修炼存储实例表
*/
@SuppressWarnings("serial")
public class InstPlayerTrain implements Serializable
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
		卡牌实例Id
	*/
	private int instPlayerCardId;
	public int getInstPlayerCardId(){
		return instPlayerCardId;
	}
	public void setInstPlayerCardId(int instPlayerCardId) {
		this.instPlayerCardId = instPlayerCardId;
		index = 3;
		result += index + "*int*" + instPlayerCardId + "#";
	}

	public void setInstPlayerCardId(int instPlayerCardId, int bs) {
		this.instPlayerCardId = instPlayerCardId;
	}

	/**
		战斗属性Id
	*/
	private int fightPropId;
	public int getFightPropId(){
		return fightPropId;
	}
	public void setFightPropId(int fightPropId) {
		this.fightPropId = fightPropId;
		index = 4;
		result += index + "*int*" + fightPropId + "#";
	}

	public void setFightPropId(int fightPropId, int bs) {
		this.fightPropId = fightPropId;
	}

	/**
		具体值
	*/
	private int fightPropValue;
	public int getFightPropValue(){
		return fightPropValue;
	}
	public void setFightPropValue(int fightPropValue) {
		this.fightPropValue = fightPropValue;
		index = 5;
		result += index + "*int*" + fightPropValue + "#";
	}

	public void setFightPropValue(int fightPropValue, int bs) {
		this.fightPropValue = fightPropValue;
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
		index = 6;
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
		index = 7;
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
		index = 8;
		result += index + "*String*" + updateTime + "#";
	}

	public void setUpdateTime(String updateTime, int bs) {
		this.updateTime = updateTime;
	}

	public String getResult(){
		return result;
	}

	public InstPlayerTrain clone(){
		InstPlayerTrain extend=new InstPlayerTrain();
		extend.setId(this.id);
		extend.setInstPlayerId(this.instPlayerId);
		extend.setInstPlayerCardId(this.instPlayerCardId);
		extend.setFightPropId(this.fightPropId);
		extend.setFightPropValue(this.fightPropValue);
		extend.setVersion(this.version);
		extend.setInsertTime(this.insertTime);
		extend.setUpdateTime(this.updateTime);
		return extend;
	}
}
