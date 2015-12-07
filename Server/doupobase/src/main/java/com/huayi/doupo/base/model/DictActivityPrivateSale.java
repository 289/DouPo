package com.huayi.doupo.base.model;

import java.io.*;

/**
	特卖会活动字典表
*/
@SuppressWarnings("serial")
public class DictActivityPrivateSale implements Serializable
{
	private int index;
	public String result = "";
	/**
		
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
		小图标
	*/
	private int smallUiId;
	public int getSmallUiId(){
		return smallUiId;
	}
	public void setSmallUiId(int smallUiId) {
		this.smallUiId = smallUiId;
		index = 2;
		result += index + "*int*" + smallUiId + "#";
	}

	public void setSmallUiId(int smallUiId, int bs) {
		this.smallUiId = smallUiId;
	}

	/**
		类型 用于轮番分段
	*/
	private int type;
	public int getType(){
		return type;
	}
	public void setType(int type) {
		this.type = type;
		index = 3;
		result += index + "*int*" + type + "#";
	}

	public void setType(int type, int bs) {
		this.type = type;
	}

	/**
		物品 tableTypeId_tableFieldId_tableValue
	*/
	private String things;
	public String getThings(){
		return things;
	}
	public void setThings(String things) {
		this.things = things;
		index = 4;
		result += index + "*String*" + things + "#";
	}

	public void setThings(String things, int bs) {
		this.things = things;
	}

	/**
		购买次数
	*/
	private int buyCount;
	public int getBuyCount(){
		return buyCount;
	}
	public void setBuyCount(int buyCount) {
		this.buyCount = buyCount;
		index = 5;
		result += index + "*int*" + buyCount + "#";
	}

	public void setBuyCount(int buyCount, int bs) {
		this.buyCount = buyCount;
	}

	/**
		购买类型 1-元宝 2-银币
	*/
	private int buyType;
	public int getBuyType(){
		return buyType;
	}
	public void setBuyType(int buyType) {
		this.buyType = buyType;
		index = 6;
		result += index + "*int*" + buyType + "#";
	}

	public void setBuyType(int buyType, int bs) {
		this.buyType = buyType;
	}

	/**
		购买价格
	*/
	private int buyValue;
	public int getBuyValue(){
		return buyValue;
	}
	public void setBuyValue(int buyValue) {
		this.buyValue = buyValue;
		index = 7;
		result += index + "*int*" + buyValue + "#";
	}

	public void setBuyValue(int buyValue, int bs) {
		this.buyValue = buyValue;
	}

	/**
		描述
	*/
	private String description;
	public String getDescription(){
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
		index = 8;
		result += index + "*String*" + description + "#";
	}

	public void setDescription(String description, int bs) {
		this.description = description;
	}

	/**
		
	*/
	private int version;
	public int getVersion(){
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
		index = 9;
		result += index + "*int*" + version + "#";
	}

	public void setVersion(int version, int bs) {
		this.version = version;
	}

	public String getResult(){
		return result;
	}

	public DictActivityPrivateSale clone(){
		DictActivityPrivateSale extend=new DictActivityPrivateSale();
		extend.setId(this.id);
		extend.setSmallUiId(this.smallUiId);
		extend.setType(this.type);
		extend.setThings(this.things);
		extend.setBuyCount(this.buyCount);
		extend.setBuyType(this.buyType);
		extend.setBuyValue(this.buyValue);
		extend.setDescription(this.description);
		extend.setVersion(this.version);
		return extend;
	}
}
