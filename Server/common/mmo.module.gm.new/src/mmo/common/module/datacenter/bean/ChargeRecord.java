package mmo.common.module.datacenter.bean;

public class ChargeRecord {
	private static int FLUSH_OFFSET = 1000 * 60 * 1;
	/** �������ͣ��״γ�ֵ */
	public final static int HANDSEL_1_FIRST = 1;
	/** �������ͣ���ֵ��� */
	public final static int HANDSEL_2_AMOUNT = 2;
	/** �������ͣ����� */
	public final static int HANDSEL_3_BACK = 3;
	private long id;
	private long friendId;
	private String orderId;
	private int gameId;
	private int serverId;
	private String channelId;
	private int accountId;
	private int roleId;
	private String rolename;
	/** ʵ�ʳ�ֵ��� */
	private int money;
	/** �������������� */
	private int getmoney;
	private byte ctype;
	private byte state;
	private long atime;
	private long dtime;
	private String note = "";
	private String orderform = "";
	private String proxy = "";
	private String proxyChannel = "";
	private long proxyTime;

	private String userid;
	private String channelSub;
	private short roleLevel;
	private int goodsId;
	private String goodsName = "";
	private int goodsCount;
	/** ������Ʒ���������ͣ���ƷID��������Ʒ�ף��� */
	private String handsel;
	/** �豸����ϵͳ */
	private String deviceOS = "";
	private String deviceImei;
	/** �۸� */
	private int price;
	private String deviceSerial;
	private String deviceMac;
	private String idfa;
	private long nextFlushTime;

	public void resetFlushTime() {
		this.nextFlushTime = System.currentTimeMillis() + FLUSH_OFFSET;
	}

	public boolean isFlush(long time) {
		if (nextFlushTime < time) {
			resetFlushTime();
			return true;
		}
		return false;
	}

	public ChargeRecord() {

	}

	public String getDeviceSerial() {
		if (deviceSerial == null) {
			return "";
		}
		return deviceSerial;
	}

	public void setDeviceSerial(String deviceSerial) {
		this.deviceSerial = deviceSerial;
	}

	public String getDeviceMac() {
		if (deviceMac == null) {
			return "";
		}
		return deviceMac;
	}

	public void setDeviceMac(String deviceMac) {
		this.deviceMac = deviceMac;
	}

	public String getIdfa() {
		if (idfa == null) {
			return "";
		}
		return idfa;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setIdfa(String idfa) {
		this.idfa = idfa;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public int getGameId() {
		return gameId;
	}

	public String getChannelId() {
		return channelId;
	}

	public void setChannelId(String channelId) {
		this.channelId = channelId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public int getServerId() {
		return serverId;
	}

	public void setServerId(int serverId) {
		this.serverId = serverId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getGetmoney() {
		return getmoney;
	}

	public void setGetmoney(int getmoney) {
		this.getmoney = getmoney;
	}

	public byte getCtype() {
		return ctype;
	}

	public void setCtype(byte ctype) {
		this.ctype = ctype;
	}

	public byte getState() {
		return state;
	}

	public void setState(byte state) {
		this.state = state;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOrderform() {
		return orderform;
	}

	public void setOrderform(String orderform) {
		this.orderform = orderform;
	}

	public String getProxy() {
		return proxy;
	}

	public void setProxy(String proxy) {
		this.proxy = proxy;
	}

	public String getProxyChannel() {
		return proxyChannel;
	}

	public void setProxyChannel(String proxyChannel) {
		this.proxyChannel = proxyChannel;
	}

	public String getUserid() {
		if (userid == null) {
			return "";
		}
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public short getRoleLevel() {
		return roleLevel;
	}

	public void setRoleLevel(short roleLevel) {
		this.roleLevel = roleLevel;
	}

	public String getChannelSub() {
		return channelSub;
	}

	public void setChannelSub(String channelSub) {
		this.channelSub = channelSub;
	}

	public long getAtime() {
		return atime;
	}

	public void setAtime(long atime) {
		this.atime = atime;
	}

	public long getDtime() {
		return dtime;
	}

	public void setDtime(long dtime) {
		this.dtime = dtime;
	}

	public long getProxyTime() {
		return proxyTime;
	}

	public void setProxyTime(long proxyTime) {
		this.proxyTime = proxyTime;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getGoodsCount() {
		return goodsCount;
	}

	public void setGoodsCount(int goodsCount) {
		this.goodsCount = goodsCount;
	}

	public long getFriendId() {
		return friendId;
	}

	public void setFriendId(long friendId) {
		this.friendId = friendId;
	}

	public String getHandsel() {
		return handsel;
	}

	public void setHandsel(String handsel) {
		this.handsel = handsel;
	}

	public String getDeviceOS() {
		if (deviceOS == null) {
			deviceOS = "";
		}
		return deviceOS;
	}

	public void setDeviceOS(String deviceOS) {
		this.deviceOS = deviceOS;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDeviceImei() {
		if (deviceImei == null) {
			deviceImei = "";
		}
		return deviceImei;
	}

	public void setDeviceImei(String deviceImei) {
		this.deviceImei = deviceImei;
	}

	@Override
	public String toString() {
		return "���֧�� [id=" + id + ", ���ж���=" + orderId + ", ƽ̨����=" + gameId + ", �������=" + serverId + ", ����=" + channelId + ", �����˺�=" + accountId + ", ��ɫ���=" + roleId + ", ��ɫ��=" + rolename + ", ���=" + money + ", ����=" + ctype + ", ״̬=" + state + ", ���ʱ��=" + atime + ", ����ʱ��=" + dtime + ", ����=" + note + ", ��������=" + orderform + ", OpenId=" + userid + ", ����=" + channelSub + ", ��ɫ�ȼ�=" + roleLevel + ", ���߱��=" + goodsId + ", ��������=" + goodsName + ", ����=" + goodsCount + ", OS=" + deviceOS + ", Imei=" + deviceImei + ", ����=" + price + ", ���к�=" + deviceSerial + ", MAC=" + deviceMac + ", idfa=" + idfa + "]";
	}

}
