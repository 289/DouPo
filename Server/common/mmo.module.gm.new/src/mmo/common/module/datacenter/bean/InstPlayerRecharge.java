package mmo.common.module.datacenter.bean;

import java.io.*;

/**
 * ��ҳ�ֵʵ����
 */
@SuppressWarnings("serial")
public class InstPlayerRecharge implements Serializable {
	/**
	 * ���
	 */
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setId(int id, int bs) {
		this.id = id;
	}

	/**
	 * ���ʵ��Id
	 */
	private int instPlayerId;

	public int getInstPlayerId() {
		return instPlayerId;
	}

	public void setInstPlayerId(int instPlayerId) {
		this.instPlayerId = instPlayerId;
	}

	public void setInstPlayerId(int instPlayerId, int bs) {
		this.instPlayerId = instPlayerId;
	}

	/**
	 * �˺�
	 */
	private String openId;

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public void setOpenId(String openId, int bs) {
		this.openId = openId;
	}

	/**
	 * �������
	 */
	private String playerName;

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public void setPlayerName(String playerName, int bs) {
		this.playerName = playerName;
	}

	/**
	 * ����
	 */
	private String channel;

	public String getChannel() {
		return channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public void setChannel(String channel, int bs) {
		this.channel = channel;
	}

	/**
	 * ���γ�ֵ�����
	 */
	private int thisrmb;

	public int getThisrmb() {
		return thisrmb;
	}

	public void setThisrmb(int thisrmb) {
		this.thisrmb = thisrmb;
	}

	public void setThisrmb(int thisrmb, int bs) {
		this.thisrmb = thisrmb;
	}

	/**
	 * ���γ�ֵ��Ϸ�ҽ��
	 */
	private int thisamt;

	public int getThisamt() {
		return thisamt;
	}

	public void setThisamt(int thisamt) {
		this.thisamt = thisamt;
	}

	public void setThisamt(int thisamt, int bs) {
		this.thisamt = thisamt;
	}

	/**
	 * �ۼƳ�ֵ��Ϸ�ҽ��
	 */
	private int saveamt;

	public int getSaveamt() {
		return saveamt;
	}

	public void setSaveamt(int saveamt) {
		this.saveamt = saveamt;
	}

	public void setSaveamt(int saveamt, int bs) {
		this.saveamt = saveamt;
	}

	/**
	 * ֧������ 0=��������,1=�Ƹ�ͨ,2=���п����֧��,3=û����,4=Q������,5=�ֻ���ֵ������,6=��������,7=Ԫ������,8=΢��֧������,
	 */
	private int payChannel;

	public int getPayChannel() {
		return payChannel;
	}

	public void setPayChannel(int payChannel) {
		this.payChannel = payChannel;
	}

	public void setPayChannel(int payChannel, int bs) {
		this.payChannel = payChannel;
	}

	/**
	 * �����ֶ�-��Ѷ���صģ���Ϸ�Ҹ�����������������Ϸ�ң�
	 */
	private int balance;

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public void setBalance(int balance, int bs) {
		this.balance = balance;
	}

	/**
	 * �����ֶ�-��Ѷ���صģ�������Ϸ�Ҹ���
	 */
	private int genbalance;

	public int getGenbalance() {
		return genbalance;
	}

	public void setGenbalance(int genbalance) {
		this.genbalance = genbalance;
	}

	public void setGenbalance(int genbalance, int bs) {
		this.genbalance = genbalance;
	}

	/**
	 * �����ֶ�-�ص��ӿڷ��ص�,�µ��ɹ�ʱ���������(��Ϸ��)
	 */
	private int saveNum;

	public int getSaveNum() {
		return saveNum;
	}

	public void setSaveNum(int saveNum) {
		this.saveNum = saveNum;
	}

	public void setSaveNum(int saveNum, int bs) {
		this.saveNum = saveNum;
	}

	/**
	 * ��Դ
	 */
	private String source;

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void setSource(String source, int bs) {
		this.source = source;
	}

	/**
	 * ��ֵ���������ɵĶ�����
	 */
	private String orderId;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public void setOrderId(String orderId, int bs) {
		this.orderId = orderId;
	}

	/**
	 * ���������
	 */
	private int serverId;

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}

	public void setServerId(int serverId, int bs) {
		this.serverId = serverId;
	}

	/**
	 * �˺ŷ��������ɵ�id
	 */
	private String accountId;

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public void setAccountId(String accountId, int bs) {
		this.accountId = accountId;
	}

	/**
	 * �������ɵĶ�����
	 */
	private String orderform;

	public String getOrderform() {
		return orderform;
	}

	public void setOrderform(String orderform) {
		this.orderform = orderform;
	}

	public void setOrderform(String orderform, int bs) {
		this.orderform = orderform;
	}

	/**
	 * ��ɫ�ȼ�
	 */
	private int roleLevel;

	public int getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(int roleLevel) {
		this.roleLevel = roleLevel;
	}

	public void setRoleLevel(int roleLevel, int bs) {
		this.roleLevel = roleLevel;
	}

	/**
	 * ���߱��-��ֵid
	 */
	private int goodsId;

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public void setGoodsId(int goodsId, int bs) {
		this.goodsId = goodsId;
	}

	/**
	 * ��ֵ���ͣ�1���ɹ���2��GM���㣬3����ֵʧ��
	 */
	private int ctype;

	public int getCtype() {
		return ctype;
	}

	public void setCtype(int ctype) {
		this.ctype = ctype;
	}

	public void setCtype(int ctype, int bs) {
		this.ctype = ctype;
	}

	/**
	 * ��ֵ���������صı��γ�ֵ���
	 */
	private int money;

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setMoney(int money, int bs) {
		this.money = money;
	}

	/**
	 * ��ֵ��¼���
	 */
	private String rechargeRecordId;

	public String getRechargeRecordId() {
		return rechargeRecordId;
	}

	public void setRechargeRecordId(String rechargeRecordId) {
		this.rechargeRecordId = rechargeRecordId;
	}

	public void setRechargeRecordId(String rechargeRecordId, int bs) {
		this.rechargeRecordId = rechargeRecordId;
	}

	/**
	 * ��������
	 */
	private String operateDate;

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}

	public void setOperateDate(String operateDate, int bs) {
		this.operateDate = operateDate;
	}

	/**
	 * ����ʱ��
	 */
	private String operateTime;

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public void setOperateTime(String operateTime, int bs) {
		this.operateTime = operateTime;
	}

	/**
	 * �汾��
	 */
	private int version;

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public void setVersion(int version, int bs) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "���ʼ�¼ [id=" + id + ", ��ɫ���=" + instPlayerId + ", openId=" + openId + ", ��ɫ��=" + playerName + ", ����=" + channel + ", ���γ�ֵ�����=" + thisrmb + ", ���γ�ֵ��Ϸ�ҽ��=" + thisamt + ", �ۼƳ�ֵ��Ϸ�ҽ��=" + saveamt + ", ֧������=" + payChannel + ", ��Դ=" + source + ", ���ж���=" + orderId + ", �������=" + serverId + ", �����˺�=" + accountId + ", ��������=" + orderform + ", ��ɫ�ȼ�=" + roleLevel + ", ���߱��=" + goodsId + ", ����=" + ctype + ", ���=" + money + "]";
	}

}
