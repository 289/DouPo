package mmo.module.gm.net.logic.parser;

import java.util.Date;

import mmo.common.gm.RoleDataVersion;
import mmo.common.protocol.command.ProGmServer_9000;
import mmo.module.cache.role.CacheRole;
import mmo.module.cache.role.GoodsBag;
import mmo.module.cache.role.RoleGoods;
import mmo.module.cache.role.RoleMission;
import mmo.module.cache.role.RolePet;
import mmo.module.gm.bean.TreeNode;
import mmo.module.gm.config.TabItemConfig;
import mmo.module.gm.gui.GMWindow;
import mmo.module.gm.gui.progress.ProgressFrame;
import mmo.module.gm.net.GMNetManager;
import mmo.module.logger.develop.GmOperate;
import mmo.module.logger.develop.LoggerDevelop;
import mmo.tools.log.LoggerFilter;
import mmo.tools.net.extension.logic.ASessionParser;
import mmo.tools.net.extension.session.UserSession;
import mmo.tools.util.DateUtil;

import org.apache.mina.core.buffer.IoBuffer;

public class Pros_9008_roleDetail extends ASessionParser {
	public Pros_9008_roleDetail() {
		this.protocol = ProGmServer_9000.P_9008_ROLE_DETAIL;
	}

	@Override
	public void parse(UserSession session, IoBuffer packet) {
		int connectId = packet.getConnectId();
		CacheRole role = new CacheRole();
		role.setGameId(packet.getInt());
		role.setGameName(packet.getString());
		role.setServerId(packet.getInt());
		role.setServerName(packet.getString());
		role.setRoleId(packet.getInt());

		int dataVersion = packet.getInt();
		switch (dataVersion) {
			case RoleDataVersion.V_1_BASE: {
				parseRoleData_V_1(role, packet);
				break;
			}
			case RoleDataVersion.V_2_BASE: {
				parseRoleData_V_2(role, packet);
				break;
			}
			case RoleDataVersion.V_3_BASE: {
				parseRoleData_V_3(role, packet);
				break;
			}
			default: {
				break;
			}
		}

		ProgressFrame.validateCode(connectId);
//		GMWindow.getInstance().gmSwitchTabItem(TabItemConfig.ITEM_36_ROLE_DETAIL, role);
		LoggerDevelop.gm(GmOperate.S_ROLE_DETAIL, GMNetManager.getGmUserId(),
		        role.getGameId() + LoggerFilter.logDivide + role.getGameName() + LoggerFilter.logDivide + role.getServerId() + LoggerFilter.logDivide
		                + role.getServerName() + LoggerFilter.logDivide + role.getRoleId() + LoggerFilter.logDivide + role.getUsername());
	}

	private void parseRoleData_V_1(CacheRole role, IoBuffer packet) {
		role.setAccountId(packet.getInt());
		role.setUserId(packet.getString());
		role.setAccuse(packet.getShort());
		role.setRealm(packet.getString());
		role.setExperience(packet.getInt());
		role.setEvilPK(packet.getShort());
		role.setTimeCreateRole(packet.getString());
		role.setGamehonor(packet.getString());
		role.setHp(packet.getInt());
		role.setLevel(packet.getShort());
		role.setLongevity(packet.getShort());
		role.setSceneId(packet.getInt());
		role.setUsername(packet.getString());
		role.setOnlinetime(packet.getInt());
		role.setPkf(packet.getInt());
		role.setPks(packet.getInt());
		role.setPkContinueWin(packet.getInt());
		role.setProfession(packet.getString());
		role.setSex(packet.getString());
		role.setDbState(packet.getString());
		role.setTileX(packet.getShort());
		role.setTileY(packet.getShort());
		role.setKidney(packet.getShort());
		role.setSectId(packet.getLong());
		role.setVipLevel(packet.getShort());
		role.setIntegral(packet.getInt());
		role.setChargeTotal(packet.getInt());
		role.setLayer(packet.getInt());
		role.setReliveScene(packet.getInt());
		role.setShopTimer(DateUtil.formatDate(new Date(packet.getLong())));
		role.setTimeLastOffline(packet.getString());
		role.setFreeze(DateUtil.formatDate(new Date(packet.getLong())));
		role.setMaxFighting(packet.getInt());
		role.setLevelupFirstTime(DateUtil.formatDate(new Date(packet.getLong())));
		role.setSectCreateCount(packet.getInt());
		role.setTimeLastLogin(packet.getString());
		role.setVirtualVIPLevel(packet.getShort());
		role.setVirtualVIPexpiredTime(DateUtil.formatDate(new Date(packet.getLong())));
		role.setComplex(packet.getString());
		role.setSumAttack(packet.getInt());
		role.setSumAttackChance(packet.getInt());
		role.setSumCruel(packet.getInt());
		role.setSumDefence(packet.getInt());
		role.setSumDestroy(packet.getInt());
		role.setSumDuck(packet.getInt());
		role.setSumFender(packet.getInt());
		role.setSumHp(packet.getInt());
		role.setSumRebound(packet.getInt());
		role.setSumReduceDefence(packet.getInt());
		role.setSumResist(packet.getInt());
		role.setSumSuckHp(packet.getInt());
		role.setSumTenacity(packet.getInt());
		role.setFight(packet.getInt());
		role.setOneStandIntegral(packet.getInt());
		role.setLeaderIntegral(packet.getInt());
		role.setPermit(packet.getString());
		role.setSceneName(packet.getString());
		role.setOnlineState(packet.get() == 0 ? "����" : "����");
		initBaseDateTree(role);
		// //////////////////////////////////////////////////////////////////
		GoodsBag bag = null;
		RoleGoods goods = null;
		short bagId = -1;
		TreeNode bagData = new TreeNode("��Ʒ����", role.getGoodsBag());
		while ((bagId = packet.getShort()) > -1) {
			bag = new GoodsBag("����", bagData);
			bag.setBagId(bagId);
			bag.setBagName(packet.getString());

			int id = -1;
			while ((id = packet.getInt()) > -1) {
				goods = new RoleGoods("��Ʒ", bag);
				goods.setId(id);
				goods.setBag(bagId);
				goods.setGoodsId(packet.getInt());
				goods.setName(packet.getString());
				goods.setCategory(packet.getShort());
				goods.setCategoryName(packet.getString());
				goods.setLevel(packet.getShort());
				goods.setRealm(packet.get());
				goods.setCount(packet.getInt());
				goods.setTimeGet(packet.getLong());
				goods.setTimeEffect(packet.getLong());
				goods.setPinZhi(packet.get());
				goods.setQuality(packet.get());
				goods.setStar(packet.get());
				goods.setStrength(packet.getShort());
				goods.setHoleCount(packet.getInt());
			}
		}
		// //////////////////////////////////////////////////////////
		TreeNode petData = new TreeNode("����б�", role.getGoodsBag());
		RolePet pet = null;
		int petId = -1;
		while ((petId = packet.getInt()) > -1) {
			pet = new RolePet("���", petData);
			pet.setId(petId);
			pet.setRealId(packet.getInt());
			pet.setUsername(packet.getString());
			pet.setLevel(packet.getShort());
			pet.setQuality(packet.get());
			pet.setStar(packet.get());
			pet.setState(packet.get());
			pet.setHp(packet.getInt());
			pet.setExperience(packet.getInt());
		}
		// ////////////////////////////////////////////////////////////
		TreeNode missionData = new TreeNode("������Ϣ", role.getGoodsBag());
		RoleMission mission = null;
		int missionId = -1;
		while ((missionId = packet.getInt()) > -1) {
			mission = new RoleMission("����", missionData);
			mission.setMissionId(missionId);
			mission.setTitle(packet.getString());
			mission.setCategory(packet.getShort());
			mission.setCategoryName(packet.getString());
			mission.setTimeAccept(DateUtil.formatDate(new Date(packet.getLong())));
			mission.setState(packet.getShort());
		}
	}

	private void parseRoleData_V_2(CacheRole role, IoBuffer packet) {
		role.setAccountId(packet.getInt());
		role.setUserId(packet.getString());
		role.setAccuse(packet.getShort());
		role.setRealm(packet.getString());
		role.setExperience(packet.getInt());
		role.setEvilPK(packet.getShort());
		role.setTimeCreateRole(packet.getString());
		role.setGamehonor(packet.getString());
		role.setHp(packet.getInt());
		role.setLevel(packet.getShort());
		role.setLongevity(packet.getShort());
		role.setSceneId(packet.getInt());
		role.setUsername(packet.getString());
		role.setOnlinetime(packet.getInt());
		role.setPkf(packet.getInt());
		role.setPks(packet.getInt());
		role.setPkContinueWin(packet.getInt());
		role.setProfession(packet.getString());
		role.setSex(packet.getString());
		role.setDbState(packet.getString());
		role.setTileX(packet.getShort());
		role.setTileY(packet.getShort());
		role.setKidney(packet.getShort());
		role.setSectId(packet.getLong());
		role.setVipLevel(packet.getShort());
		role.setIntegral(packet.getInt());
		role.setChargeTotal(packet.getInt());
		role.setLayer(packet.getInt());
		role.setReliveScene(packet.getInt());
		role.setShopTimer(DateUtil.formatDate(new Date(packet.getLong())));
		role.setTimeLastOffline(packet.getString());
		role.setFreeze(DateUtil.formatDate(new Date(packet.getLong())));
		role.setMaxFighting(packet.getInt());
		role.setLevelupFirstTime(DateUtil.formatDate(new Date(packet.getLong())));
		role.setSectCreateCount(packet.getInt());
		role.setTimeLastLogin(packet.getString());
		role.setVirtualVIPLevel(packet.getShort());
		role.setVirtualVIPexpiredTime(DateUtil.formatDate(new Date(packet.getLong())));
		role.setComplex(packet.getString());
		role.setSumAttack(packet.getInt());
		role.setSumDefence(packet.getInt());
		role.setSumHp(packet.getInt());
		// role.setSumAttackChance(packet.getInt());
		// role.setSumCruel(packet.getInt());
		// role.setSumDestroy(packet.getInt());
		// role.setSumDuck(packet.getInt());
		// role.setSumFender(packet.getInt());
		// role.setSumRebound(packet.getInt());
		// role.setSumReduceDefence(packet.getInt());
		// role.setSumResist(packet.getInt());
		// role.setSumSuckHp(packet.getInt());
		// role.setSumTenacity(packet.getInt());
		role.setFight(packet.getInt());
		role.setOneStandIntegral(packet.getInt());
		role.setLeaderIntegral(packet.getInt());
		role.setPermit(packet.getString());
		role.setSceneName(packet.getString());
		role.setOnlineState(packet.get() == 0 ? "����" : "����");
		initBaseDateTree(role);
		// //////////////////////////////////////////////////////////////////
		GoodsBag bag = null;
		RoleGoods goods = null;
		short bagId = -1;
		TreeNode bagData = new TreeNode("��Ʒ����", role.getGoodsBag());
		while ((bagId = packet.getShort()) > -1) {
			bag = new GoodsBag("����", bagData);
			bag.setBagId(bagId);
			bag.setBagName(packet.getString());

			int id = -1;
			while ((id = packet.getInt()) > -1) {
				goods = new RoleGoods("��Ʒ", bag);
				goods.setId(id);
				goods.setBag(bagId);
				goods.setGoodsId(packet.getInt());
				goods.setName(packet.getString());
				goods.setCategory(packet.getShort());
				goods.setCategoryName(packet.getString());
				goods.setLevel(packet.getShort());
				goods.setRealm(packet.get());
				goods.setCount(packet.getInt());
				goods.setTimeGet(packet.getLong());
				goods.setTimeEffect(packet.getLong());
				goods.setPinZhi(packet.get());
				goods.setQuality(packet.get());
				goods.setStar(packet.get());
				goods.setStrength(packet.getShort());
				goods.setHoleCount(packet.getInt());
			}
		}
		// //////////////////////////////////////////////////////////
		TreeNode petData = new TreeNode("����б�", role.getGoodsBag());
		RolePet pet = null;
		int petId = -1;
		while ((petId = packet.getInt()) > -1) {
			pet = new RolePet("���", petData);
			pet.setId(petId);
			pet.setRealId(packet.getInt());
			pet.setUsername(packet.getString());
			pet.setLevel(packet.getShort());
			pet.setQuality(packet.get());
			pet.setStar(packet.get());
			pet.setState(packet.get());
			pet.setHp(packet.getInt());
			pet.setExperience(packet.getInt());
		}
		// ////////////////////////////////////////////////////////////
		TreeNode missionData = new TreeNode("������Ϣ", role.getGoodsBag());
		RoleMission mission = null;
		int missionId = -1;
		while ((missionId = packet.getInt()) > -1) {
			mission = new RoleMission("����", missionData);
			mission.setMissionId(missionId);
			mission.setTitle(packet.getString());
			mission.setCategory(packet.getShort());
			mission.setCategoryName(packet.getString());
			mission.setTimeAccept(DateUtil.formatDate(new Date(packet.getLong())));
			mission.setState(packet.getShort());
		}

	}

	private void parseRoleData_V_3(CacheRole role, IoBuffer packet) {
		role.setAccountId(packet.getInt());
		role.setUserId(packet.getString());
		role.setRealm(packet.getString());
		role.setExperience(packet.getInt());
		role.setTimeCreateRole(packet.getString());
		role.setGamehonor(packet.getString());
		role.setHp(packet.getInt());
		role.setLevel(packet.getShort());
		role.setSceneId(packet.getInt());
		role.setUsername(packet.getString());
		role.setOnlinetime(packet.getInt());
		role.setPkf(packet.getInt());
		role.setPks(packet.getInt());
		role.setPkContinueWin(packet.getInt());
		role.setProfession(packet.getString());
		role.setSex(packet.getString());
		role.setDbState(packet.getString());
		role.setTileX(packet.getShort());
		role.setTileY(packet.getShort());
		role.setSectId(packet.getLong());
		role.setVipLevel(packet.getShort());
		role.setIntegral(packet.getInt());
		role.setChargeTotal(packet.getInt());
		role.setLayer(packet.getInt());
		role.setReliveScene(packet.getInt());
		role.setShopTimer(DateUtil.formatDate(new Date(packet.getLong())));
		role.setTimeLastOffline(packet.getString());
		role.setFreeze(DateUtil.formatDate(new Date(packet.getLong())));
		role.setMaxFighting(packet.getInt());
		role.setLevelupFirstTime(DateUtil.formatDate(new Date(packet.getLong())));
		role.setSectCreateCount(packet.getInt());
		role.setTimeLastLogin(packet.getString());
		role.setVirtualVIPLevel(packet.getShort());
		role.setVirtualVIPexpiredTime(DateUtil.formatDate(new Date(packet.getLong())));
		role.setComplex(packet.getString());
		role.setSumAttack(packet.getInt());
		role.setSumDefence(packet.getInt());
		role.setSumHp(packet.getInt());
		// role.setSumAttackChance(packet.getInt());
		// role.setSumCruel(packet.getInt());
		// role.setSumDestroy(packet.getInt());
		// role.setSumDuck(packet.getInt());
		// role.setSumFender(packet.getInt());
		// role.setSumRebound(packet.getInt());
		// role.setSumReduceDefence(packet.getInt());
		// role.setSumResist(packet.getInt());
		// role.setSumSuckHp(packet.getInt());
		// role.setSumTenacity(packet.getInt());
		role.setFight(packet.getInt());
		role.setOneStandIntegral(packet.getInt());
		role.setLeaderIntegral(packet.getInt());
		role.setPermit(packet.getString());
		role.setSceneName(packet.getString());
		role.setOnlineState(packet.get() == 0 ? "����" : "����");
		initBaseDateTree(role);
		// //////////////////////////////////////////////////////////////////
		GoodsBag bag = null;
		RoleGoods goods = null;
		short bagId = -1;
		TreeNode bagData = new TreeNode("��Ʒ����", role.getGoodsBag());
		while ((bagId = packet.getShort()) > -1) {
			bag = new GoodsBag("����", bagData);
			bag.setBagId(bagId);
			bag.setBagName(packet.getString());

			int id = -1;
			while ((id = packet.getInt()) > -1) {
				goods = new RoleGoods("��Ʒ", bag);
				goods.setId(id);
				goods.setBag(bagId);
				goods.setGoodsId(packet.getInt());
				goods.setName(packet.getString());
				goods.setCategory(packet.getShort());
				goods.setCategoryName(packet.getString());
				goods.setLevel(packet.getShort());
				goods.setRealm(packet.get());
				goods.setCount(packet.getInt());
				goods.setTimeGet(packet.getLong());
				goods.setTimeEffect(packet.getLong());
				goods.setPinZhi(packet.get());
				goods.setQuality(packet.get());
				goods.setStar(packet.get());
				goods.setStrength(packet.getShort());
				goods.setHoleCount(packet.getInt());
			}
		}
		// //////////////////////////////////////////////////////////
		TreeNode petData = new TreeNode("����б�", role.getGoodsBag());
		RolePet pet = null;
		int petId = -1;
		while ((petId = packet.getInt()) > -1) {
			pet = new RolePet("���", petData);
			pet.setId(petId);
			pet.setRealId(packet.getInt());
			pet.setUsername(packet.getString());
			pet.setLevel(packet.getShort());
			pet.setQuality(packet.get());
			pet.setStar(packet.get());
			pet.setState(packet.get());
			pet.setHp(packet.getInt());
			pet.setExperience(packet.getInt());
		}
		// ////////////////////////////////////////////////////////////
		TreeNode missionData = new TreeNode("������Ϣ", role.getGoodsBag());
		RoleMission mission = null;
		int missionId = -1;
		while ((missionId = packet.getInt()) > -1) {
			mission = new RoleMission("����", missionData);
			mission.setMissionId(missionId);
			mission.setTitle(packet.getString());
			mission.setCategory(packet.getShort());
			mission.setCategoryName(packet.getString());
			mission.setTimeAccept(DateUtil.formatDate(new Date(packet.getLong())));
			mission.setState(packet.getShort());
		}

	}

	private void initBaseDateTree(CacheRole role) {
		new TreeNode("��ɫID��" + role.getRoleId(), role.getBaseData());
		new TreeNode("�˺�ID��" + role.getAccountId(), role.getBaseData());
		new TreeNode("�˺ţ�" + role.getUserId(), role.getBaseData());
		new TreeNode("ͨ��֤��" + role.getPermit(), role.getBaseData());
		new TreeNode("�ǳƣ�" + role.getUsername(), role.getBaseData());
		new TreeNode("����״̬��" + role.getOnlineState(), role.getBaseData());
		new TreeNode("ְҵ��" + role.getProfession(), role.getBaseData());
		new TreeNode("�Ա�" + role.getSex(), role.getBaseData());
		new TreeNode("*�ȼ���" + role.getLevel(), role.getBaseData());
		new TreeNode("*���飺" + role.getExperience(), role.getBaseData());
		new TreeNode("����ʱ�䣺" + role.getLevelupFirstTime(), role.getBaseData());
		new TreeNode("*VIP��" + role.getVipLevel(), role.getBaseData());
		new TreeNode("�ۼƳ�ֵ��" + role.getChargeTotal() + "��", role.getBaseData());
		new TreeNode("����VIP��" + role.getVirtualVIPLevel(), role.getBaseData());
		new TreeNode("����VIP��Ч�ڣ�" + role.getVirtualVIPexpiredTime(), role.getBaseData());
		new TreeNode("*���磺" + role.getRealm(), role.getBaseData());
		new TreeNode("״̬��" + role.getDbState(), role.getBaseData());
		new TreeNode("����ʱ�䣺" + role.getTimeCreateRole(), role.getBaseData());
		new TreeNode("����ʱ�䣺" + role.getTimeLastOffline(), role.getBaseData());
		new TreeNode("�ⶳʱ�䣺" + role.getFreeze(), role.getBaseData());
		new TreeNode("���һ�����ߣ�" + role.getTimeLastLogin(), role.getBaseData());
		new TreeNode("����ʱ����" + (role.getOnlinetime() / 3600) + "ʱ" + ((role.getOnlinetime() % 3600) / 60) + "��"
		        + ((role.getOnlinetime() % 3600) % 60) + "��", role.getBaseData());
		new TreeNode("���ţ�" + role.getSectId(), role.getBaseData());
		new TreeNode("�������Ŵ�����" + role.getSectCreateCount(), role.getBaseData());
		new TreeNode("��������" + role.getSceneName(), role.getBaseData());
		new TreeNode("����ID��" + role.getSceneId(), role.getBaseData());
		new TreeNode("ͼ�㣺" + role.getLayer(), role.getBaseData());
		new TreeNode("�������" + role.getReliveScene(), role.getBaseData());
		new TreeNode("TileX��" + role.getTileX(), role.getBaseData());
		new TreeNode("TileY��" + role.getTileY(), role.getBaseData());
		new TreeNode("ͷ�Σ�" + role.getGamehonor(), role.getBaseData());
		new TreeNode("PK����" + role.getPkf(), role.getBaseData());
		new TreeNode("PKʤ��" + role.getPks(), role.getBaseData());
		new TreeNode("PK��ʤ��" + role.getPkContinueWin(), role.getBaseData());
		new TreeNode("�������֣�" + role.getIntegral(), role.getBaseData());
		new TreeNode("һս���׻��֣�" + role.getOneStandIntegral(), role.getBaseData());
		new TreeNode("����������֣�" + role.getLeaderIntegral(), role.getBaseData());
		new TreeNode("���������" + role.getSumHp(), role.getBaseData());
		new TreeNode("������" + role.getHp(), role.getBaseData());
		new TreeNode("ս������" + role.getFight(), role.getBaseData());
		new TreeNode("���ս����" + role.getMaxFighting(), role.getBaseData());
		new TreeNode("������" + role.getSumAttack(), role.getBaseData());
		new TreeNode("���У�" + role.getSumAttackChance(), role.getBaseData());
		new TreeNode("������" + role.getSumCruel(), role.getBaseData());
		new TreeNode("������" + role.getSumDefence(), role.getBaseData());
		new TreeNode("�Ʒ���" + role.getSumDestroy(), role.getBaseData());
		new TreeNode("���ܣ�" + role.getSumDuck(), role.getBaseData());
		new TreeNode("�񵲣�" + role.getSumFender(), role.getBaseData());
		new TreeNode("������" + role.getSumRebound(), role.getBaseData());
		new TreeNode("������" + role.getSumReduceDefence(), role.getBaseData());
		new TreeNode("�ֿ���" + role.getSumResist(), role.getBaseData());
		new TreeNode("��Ѫ��" + role.getSumSuckHp(), role.getBaseData());
		new TreeNode("���ԣ�" + role.getSumTenacity(), role.getBaseData());
	}
}
