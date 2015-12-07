package mmo.common.module.datacenter.bean;

import java.io.*;

/**
 * ���ʵ����
 */
@SuppressWarnings("serial")
public class InstPlayer implements Serializable {
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
	 * �˺�Id
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
	 * ����
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setName(String name, int bs) {
		this.name = name;
	}

	/**
	 * �ȼ�
	 */
	private int level;

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setLevel(int level, int bs) {
		this.level = level;
	}

	/**
	 * Ԫ��
	 */
	private int gold;

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public void setGold(int gold, int bs) {
		this.gold = gold;
	}

	/**
	 * ͭǮ
	 */
	private String copper;

	public String getCopper() {
		return copper;
	}

	public void setCopper(String copper) {
		this.copper = copper;
	}

	public void setCopper(String copper, int bs) {
		this.copper = copper;
	}

	/**
	 * ����
	 */
	private int exp;

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public void setExp(int exp, int bs) {
		this.exp = exp;
	}

	/**
	 * ����
	 */
	private int energy;

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public void setEnergy(int energy, int bs) {
		this.energy = energy;
	}

	/**
	 * �������
	 */
	private int maxEnergy;

	public int getMaxEnergy() {
		return maxEnergy;
	}

	public void setMaxEnergy(int maxEnergy) {
		this.maxEnergy = maxEnergy;
	}

	public void setMaxEnergy(int maxEnergy, int bs) {
		this.maxEnergy = maxEnergy;
	}

	/**
	 * ����
	 */
	private int vigor;

	public int getVigor() {
		return vigor;
	}

	public void setVigor(int vigor) {
		this.vigor = vigor;
	}

	public void setVigor(int vigor, int bs) {
		this.vigor = vigor;
	}

	/**
	 * �������
	 */
	private int maxVigor;

	public int getMaxVigor() {
		return maxVigor;
	}

	public void setMaxVigor(int maxVigor) {
		this.maxVigor = maxVigor;
	}

	public void setMaxVigor(int maxVigor, int bs) {
		this.maxVigor = maxVigor;
	}

	/**
	 * ����������
	 */
	private int cardNum;

	public int getCardNum() {
		return cardNum;
	}

	public void setCardNum(int cardNum) {
		this.cardNum = cardNum;
	}

	public void setCardNum(int cardNum, int bs) {
		this.cardNum = cardNum;
	}

	/**
	 * �����������
	 */
	private int maxCardNum;

	public int getMaxCardNum() {
		return maxCardNum;
	}

	public void setMaxCardNum(int maxCardNum) {
		this.maxCardNum = maxCardNum;
	}

	public void setMaxCardNum(int maxCardNum, int bs) {
		this.maxCardNum = maxCardNum;
	}

	/**
	 * �������� ���ݸ�ʽΪ��level_step&level_step;
	 */
	private String guidStep;

	public String getGuidStep() {
		return guidStep;
	}

	public void setGuidStep(String guidStep) {
		this.guidStep = guidStep;
	}

	public void setGuidStep(String guidStep, int bs) {
		this.guidStep = guidStep;
	}

	/**
	 * �½�Id
	 */
	private int chapterId;

	public int getChapterId() {
		return chapterId;
	}

	public void setChapterId(int chapterId) {
		this.chapterId = chapterId;
	}

	public void setChapterId(int chapterId, int bs) {
		this.chapterId = chapterId;
	}

	/**
	 * �ؿ�Id
	 */
	private int barrierId;

	public int getBarrierId() {
		return barrierId;
	}

	public void setBarrierId(int barrierId) {
		this.barrierId = barrierId;
	}

	public void setBarrierId(int barrierId, int bs) {
		this.barrierId = barrierId;
	}

	/**
	 * ���ץȡ����Id
	 */
	private int fireGainRuleId;

	public int getFireGainRuleId() {
		return fireGainRuleId;
	}

	public void setFireGainRuleId(int fireGainRuleId) {
		this.fireGainRuleId = fireGainRuleId;
	}

	public void setFireGainRuleId(int fireGainRuleId, int bs) {
		this.fireGainRuleId = fireGainRuleId;
	}

	/**
	 * ������ʵ��Id 0-δװ��
	 */
	private int instPlayerFireId;

	public int getInstPlayerFireId() {
		return instPlayerFireId;
	}

	public void setInstPlayerFireId(int instPlayerFireId) {
		this.instPlayerFireId = instPlayerFireId;
	}

	public void setInstPlayerFireId(int instPlayerFireId, int bs) {
		this.instPlayerFireId = instPlayerFireId;
	}

	/**
	 * vip�ȼ�
	 */
	private int vipLevel;

	public int getVipLevel() {
		return vipLevel;
	}

	public void setVipLevel(int vipLevel) {
		this.vipLevel = vipLevel;
	}

	public void setVipLevel(int vipLevel, int bs) {
		this.vipLevel = vipLevel;
	}

	/**
	 * Ԫ�������ֶ�Ŀǰû�ã�
	 */
	private int vigour;

	public int getVigour() {
		return vigour;
	}

	public void setVigour(int vigour) {
		this.vigour = vigour;
	}

	public void setVigour(int vigour, int bs) {
		this.vigour = vigour;
	}

	/**
	 * ���ܣ���֮ǰ����Ϊ��Ϊ���ܣ�
	 */
	private int culture;

	public int getCulture() {
		return culture;
	}

	public void setCulture(int culture) {
		this.culture = culture;
	}

	public void setCulture(int culture, int bs) {
		this.culture = culture;
	}

	/**
	 * �������壺1-�״�����/ʹ��ʱ�� 2-��һ�������ָ�ʱ��
	 */
	private String lastEnergyRecoverTime;

	public String getLastEnergyRecoverTime() {
		return lastEnergyRecoverTime;
	}

	public void setLastEnergyRecoverTime(String lastEnergyRecoverTime) {
		this.lastEnergyRecoverTime = lastEnergyRecoverTime;
	}

	public void setLastEnergyRecoverTime(String lastEnergyRecoverTime, int bs) {
		this.lastEnergyRecoverTime = lastEnergyRecoverTime;
	}

	/**
	 * �������壺1-�״�����/ʹ��ʱ�� 2-��һ�������ָ�ʱ��
	 */
	private String lastVigorRecoverTime;

	public String getLastVigorRecoverTime() {
		return lastVigorRecoverTime;
	}

	public void setLastVigorRecoverTime(String lastVigorRecoverTime) {
		this.lastVigorRecoverTime = lastVigorRecoverTime;
	}

	public void setLastVigorRecoverTime(String lastVigorRecoverTime, int bs) {
		this.lastVigorRecoverTime = lastVigorRecoverTime;
	}

	/**
	 * ����ս��ʤ�����������ڿ��������п�����
	 */
	private int barrierNum;

	public int getBarrierNum() {
		return barrierNum;
	}

	public void setBarrierNum(int barrierNum) {
		this.barrierNum = barrierNum;
	}

	public void setBarrierNum(int barrierNum, int bs) {
		this.barrierNum = barrierNum;
	}

	/**
	 * ���չ��������Ĵ���
	 */
	private int buyEnergyNum;

	public int getBuyEnergyNum() {
		return buyEnergyNum;
	}

	public void setBuyEnergyNum(int buyEnergyNum) {
		this.buyEnergyNum = buyEnergyNum;
	}

	public void setBuyEnergyNum(int buyEnergyNum, int bs) {
		this.buyEnergyNum = buyEnergyNum;
	}

	/**
	 * ���չ��������Ĵ���
	 */
	private int buyVigorNum;

	public int getBuyVigorNum() {
		return buyVigorNum;
	}

	public void setBuyVigorNum(int buyVigorNum) {
		this.buyVigorNum = buyVigorNum;
	}

	public void setBuyVigorNum(int buyVigorNum, int bs) {
		this.buyVigorNum = buyVigorNum;
	}

	/**
	 * ���һ�ι���������ʱ��
	 */
	private String lastBuyEnergyTime;

	public String getLastBuyEnergyTime() {
		return lastBuyEnergyTime;
	}

	public void setLastBuyEnergyTime(String lastBuyEnergyTime) {
		this.lastBuyEnergyTime = lastBuyEnergyTime;
	}

	public void setLastBuyEnergyTime(String lastBuyEnergyTime, int bs) {
		this.lastBuyEnergyTime = lastBuyEnergyTime;
	}

	/**
	 * ���һ�ι���������ʱ��
	 */
	private String lastBuyVigorTime;

	public String getLastBuyVigorTime() {
		return lastBuyVigorTime;
	}

	public void setLastBuyVigorTime(String lastBuyVigorTime) {
		this.lastBuyVigorTime = lastBuyVigorTime;
	}

	public void setLastBuyVigorTime(String lastBuyVigorTime, int bs) {
		this.lastBuyVigorTime = lastBuyVigorTime;
	}

	/**
	 * �ؿ��������� ���ݸ�ʽΪ��barrierId#step&barrierId#step;barrierId#step;
	 */
	private String guipedBarrier;

	public String getGuipedBarrier() {
		return guipedBarrier;
	}

	public void setGuipedBarrier(String guipedBarrier) {
		this.guipedBarrier = guipedBarrier;
	}

	public void setGuipedBarrier(String guipedBarrier, int bs) {
		this.guipedBarrier = guipedBarrier;
	}

	/**
	 * ϴ��ָ�����ʱ��
	 */
	private String washTime;

	public String getWashTime() {
		return washTime;
	}

	public void setWashTime(String washTime) {
		this.washTime = washTime;
	}

	public void setWashTime(String washTime, int bs) {
		this.washTime = washTime;
	}

	/**
	 * ÿ������ʱ��
	 */
	private String dailyTashTime;

	public String getDailyTashTime() {
		return dailyTashTime;
	}

	public void setDailyTashTime(String dailyTashTime) {
		this.dailyTashTime = dailyTashTime;
	}

	public void setDailyTashTime(String dailyTashTime, int bs) {
		this.dailyTashTime = dailyTashTime;
	}

	/**
	 * ͷ����Id
	 */
	private int headerCardId;

	public int getHeaderCardId() {
		return headerCardId;
	}

	public void setHeaderCardId(int headerCardId) {
		this.headerCardId = headerCardId;
	}

	public void setHeaderCardId(int headerCardId, int bs) {
		this.headerCardId = headerCardId;
	}

	/**
	 * ���ڴ洢����ȡ��vipId���
	 */
	private String vipIds;

	public String getVipIds() {
		return vipIds;
	}

	public void setVipIds(String vipIds) {
		this.vipIds = vipIds;
	}

	public void setVipIds(String vipIds, int bs) {
		this.vipIds = vipIds;
	}

	/**
	 * ���� 1-����
	 */
	private int pullBlack;

	public int getPullBlack() {
		return pullBlack;
	}

	public void setPullBlack(int pullBlack) {
		this.pullBlack = pullBlack;
	}

	public void setPullBlack(int pullBlack, int bs) {
		this.pullBlack = pullBlack;
	}

	/**
	 * �Ƿ������׳���� 0-δ��ȡ 1-����ȡ
	 */
	private int isGetFirstRechargeGift;

	public int getIsGetFirstRechargeGift() {
		return isGetFirstRechargeGift;
	}

	public void setIsGetFirstRechargeGift(int isGetFirstRechargeGift) {
		this.isGetFirstRechargeGift = isGetFirstRechargeGift;
	}

	public void setIsGetFirstRechargeGift(int isGetFirstRechargeGift, int bs) {
		this.isGetFirstRechargeGift = isGetFirstRechargeGift;
	}

	/**
	 * ���˲���ʱ��
	 */
	private String beautyCardTime;

	public String getBeautyCardTime() {
		return beautyCardTime;
	}

	public void setBeautyCardTime(String beautyCardTime) {
		this.beautyCardTime = beautyCardTime;
	}

	public void setBeautyCardTime(String beautyCardTime, int bs) {
		this.beautyCardTime = beautyCardTime;
	}

	/**
		
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

	/**
	 * ���ʱ��
	 */
	private String insertTime;

	public String getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(String insertTime) {
		this.insertTime = insertTime;
	}

	public void setInsertTime(String insertTime, int bs) {
		this.insertTime = insertTime;
	}

	/**
	 * ����ʱ��
	 */
	private String updateTime;

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public void setUpdateTime(String updateTime, int bs) {
		this.updateTime = updateTime;
	}

	public InstPlayer clone() {
		InstPlayer extend = new InstPlayer();
		extend.setId(this.id);
		extend.setOpenId(this.openId);
		extend.setName(this.name);
		extend.setLevel(this.level);
		extend.setGold(this.gold);
		extend.setCopper(this.copper);
		extend.setExp(this.exp);
		extend.setEnergy(this.energy);
		extend.setMaxEnergy(this.maxEnergy);
		extend.setVigor(this.vigor);
		extend.setMaxVigor(this.maxVigor);
		extend.setCardNum(this.cardNum);
		extend.setMaxCardNum(this.maxCardNum);
		extend.setGuidStep(this.guidStep);
		extend.setChapterId(this.chapterId);
		extend.setBarrierId(this.barrierId);
		extend.setFireGainRuleId(this.fireGainRuleId);
		extend.setInstPlayerFireId(this.instPlayerFireId);
		extend.setVipLevel(this.vipLevel);
		extend.setVigour(this.vigour);
		extend.setCulture(this.culture);
		extend.setLastEnergyRecoverTime(this.lastEnergyRecoverTime);
		extend.setLastVigorRecoverTime(this.lastVigorRecoverTime);
		extend.setBarrierNum(this.barrierNum);
		extend.setBuyEnergyNum(this.buyEnergyNum);
		extend.setBuyVigorNum(this.buyVigorNum);
		extend.setLastBuyEnergyTime(this.lastBuyEnergyTime);
		extend.setLastBuyVigorTime(this.lastBuyVigorTime);
		extend.setGuipedBarrier(this.guipedBarrier);
		extend.setWashTime(this.washTime);
		extend.setDailyTashTime(this.dailyTashTime);
		extend.setHeaderCardId(this.headerCardId);
		extend.setVipIds(this.vipIds);
		extend.setPullBlack(this.pullBlack);
		extend.setIsGetFirstRechargeGift(this.isGetFirstRechargeGift);
		extend.setBeautyCardTime(this.beautyCardTime);
		extend.setServerId(this.serverId);
		extend.setChannel(this.channel);
		extend.setVersion(this.version);
		extend.setInsertTime(this.insertTime);
		extend.setUpdateTime(this.updateTime);
		return extend;
	}

	@Override
	public String toString() {
		return "�����Ϣ [ID=" + id + ", OpenId=" + openId + ", ����=" + name + ", �ȼ�=" + level + ", Ԫ��=" + gold + ", ͭ��=" + copper + ", ����=" + exp + ", ����=" + energy + ", �������=" + maxEnergy + ", ����=" + vigor + ", �������=" + maxVigor + ", ����������=" + cardNum + ", �����������=" + maxCardNum + ", ��������=" + guidStep + ", �½�Id=" + chapterId + ", �ؿ�Id=" + barrierId + ", ���ץȡ����Id=" + fireGainRuleId + ", ������ʵ��Id=" + instPlayerFireId + ", vip�ȼ�=" + vipLevel + ", Ԫ��=" + vigour + ", ����=" + culture + ", ��һ�������ָ�ʱ��=" + lastEnergyRecoverTime + ", ��һ�������ָ�ʱ��=" + lastVigorRecoverTime + ", ����ս��ʤ������=" + barrierNum + ", ���չ��������Ĵ���=" + buyEnergyNum + ", ���չ��������Ĵ���=" + buyVigorNum + ", ���һ�ι���������ʱ��=" + lastBuyEnergyTime + ", ���һ�ι���������ʱ��=" + lastBuyVigorTime + ", �ؿ���������=" + guipedBarrier + ", ϴ��ָ�����ʱ��=" + washTime + ", ÿ������ʱ��=" + dailyTashTime + ", ͷ����Id=" + headerCardId + ", ����ȡ��vipId���=" + vipIds
				+ ", ����=" + pullBlack + ", �Ƿ������׳����=" + isGetFirstRechargeGift + ", ���˲���ʱ��=" + beautyCardTime + ", �������=" + serverId + ", ����=" + channel + ", �汾��=" + version + ", ���ʱ��=" + insertTime + ", ����ʱ��=" + updateTime + "]";
	}
}
