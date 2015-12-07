package mmo.module.cache.role;

import mmo.tools.util.StringUtil;

public class CacheRoleFight {
	public static final String FLAG_fabao            = "fabao";
	public static final String FLAG_pet              = "pet";
	public static final String FLAG_ROLE_SKILL       = "roleSkill";
	public static final String FLAG_FOLLOW_PET       = "followPet";
	public static final String FLAG_WORLD_BOSS_ARRAY = "worldBossArray";
	public static final String FLAG_COMMON_ARRAY     = "commonArray";
	public static final String FLAG_EXPAND_INFO      = "expandInfo";
	/** һСʱ��û�� */
	private final static long  OVERTIME_OFFSET       = 1000 * 60 * 60;
	/** ����ʱ�� */
	private long               overtime;
	/** ����ʱ�䱻���ù�����Ҫ�����Ŷ� */
	private boolean            reorder;
	/****************************************************/
	/** ��ɫ��� */
	protected int              roleId;
	/** ��ɫ���� */
	protected String           username;
	/** ��ɫ�˺� */
	protected int              accountId;
	short                      level;
	String                     profession;

	/** �ۺϹ����� */
	protected int              sumAttack;
	/** HP����ֵ */
	protected int              sumHp;
	/** �ۺϷ���ֵ */
	protected int              sumDefence;
	/** �ۺ����� */
	protected int              sumAttackChance;
	/** �ۺ����� */
	protected int              sumDuck;
	/** �ۺϱ��� */
	protected int              sumCruel;
	/** �ۺ����� */
	protected int              sumTenacity;
	/** �ۺϸ� */
	protected int              sumFender;
	/** �ۺ��Ƽ� */
	protected int              sumDestroy;
	/** �ۺ���Ѫ */
	protected int              sumSuckHp;
	/** �ۺϷ��� */
	protected int              sumRebound;
	/** �ۺ��Ʒ� */
	protected int              sumReduceDefence;
	/** �ۺϵֿ� */
	protected int              sumResist;
	/** ��ɫ���� */
	protected String           skeletons;
	/** װ���ķ���������ļ��� */
	protected String           fabaoAndSkill;
	/** ���������Ϣ */
	protected String           petInfo;
	/** ��ɫս���� */
	protected int              fight;
	/** ���ﶯ�� */
	protected String           mountAni;
	/** ��ɫ�������� */
	protected String           roleSkill;
	/** ����������Ϣ */
	protected String           followPetInfo;
	/** ��������������Ϣ */
	protected String           worldBossArrayInfo;
	/** ��ͨ������Ϣ */
	protected String           commonArrayInfo;
	/** ������������Ϣ */
	protected String           roleExpandInfo;

	public CacheRoleFight() {
		this.overtime = System.currentTimeMillis() + OVERTIME_OFFSET;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public short getLevel() {
		return level;
	}

	public void setLevel(short level) {
		this.level = level;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public int getSumAttack() {
		return sumAttack;
	}

	public void setSumAttack(int sumAttack) {
		this.sumAttack = sumAttack;
	}

	public int getSumHp() {
		return sumHp;
	}

	public void setSumHp(int sumHp) {
		this.sumHp = sumHp;
	}

	public int getSumDefence() {
		return sumDefence;
	}

	public void setSumDefence(int sumDefence) {
		this.sumDefence = sumDefence;
	}

	public int getSumAttackChance() {
		return sumAttackChance;
	}

	public void setSumAttackChance(int sumAttackChance) {
		this.sumAttackChance = sumAttackChance;
	}

	public int getSumDuck() {
		return sumDuck;
	}

	public void setSumDuck(int sumDuck) {
		this.sumDuck = sumDuck;
	}

	public int getSumCruel() {
		return sumCruel;
	}

	public void setSumCruel(int sumCruel) {
		this.sumCruel = sumCruel;
	}

	public int getSumTenacity() {
		return sumTenacity;
	}

	public void setSumTenacity(int sumTenacity) {
		this.sumTenacity = sumTenacity;
	}

	public int getSumFender() {
		return sumFender;
	}

	public void setSumFender(int sumFender) {
		this.sumFender = sumFender;
	}

	public int getSumDestroy() {
		return sumDestroy;
	}

	public void setSumDestroy(int sumDestroy) {
		this.sumDestroy = sumDestroy;
	}

	public int getSumSuckHp() {
		return sumSuckHp;
	}

	public void setSumSuckHp(int sumSuckHp) {
		this.sumSuckHp = sumSuckHp;
	}

	public int getSumRebound() {
		return sumRebound;
	}

	public void setSumRebound(int sumRebound) {
		this.sumRebound = sumRebound;
	}

	public int getSumReduceDefence() {
		return sumReduceDefence;
	}

	public void setSumReduceDefence(int sumReduceDefence) {
		this.sumReduceDefence = sumReduceDefence;
	}

	public int getSumResist() {
		return sumResist;
	}

	public void setSumResist(int sumResist) {
		this.sumResist = sumResist;
	}

	public String getSkeletons() {
		return skeletons;
	}

	public void setSkeletons(String skeletons) {
		this.skeletons = skeletons;
	}

	public void setComplex(String complex) {
		String[] array = StringUtil.splitString(complex, '#');
		if (array.length > 0) {
			String item = null;
			int length = array.length;
			for (int ii = 0; ii < length; ii++) {
				item = array[ii];
				if (item.startsWith(FLAG_fabao)) {
					String[] array2 = StringUtil.splitString(item, ':');
					if (array2.length > 1) {
						fabaoAndSkill = array2[1];
					} else {
						fabaoAndSkill = "15008,3008";
					}
				} else if (item.startsWith(FLAG_pet)) {
					String[] array2 = StringUtil.splitString(item, ':');
					if (array2.length > 1) {
						petInfo = array2[1];
					} else {
						petInfo = "";
					}
				} else if (item.startsWith(FLAG_ROLE_SKILL)) {
					String[] array2 = StringUtil.splitString(item, ':');
					if (array2.length > 1) {
						roleSkill = array2[1];
					} else {
						roleSkill = "";
					}
				} else if (item.startsWith(FLAG_FOLLOW_PET)) {
					String[] array2 = StringUtil.splitString(item, ':');
					if (array2.length > 1) {
						followPetInfo = array2[1];
					} else {
						followPetInfo = "";
					}
				} else if (item.startsWith(FLAG_WORLD_BOSS_ARRAY)) {
					String[] array2 = StringUtil.splitString(item, ':');
					if (array2.length > 1) {
						worldBossArrayInfo = array2[1];
					} else {
						worldBossArrayInfo = "";
					}
				} else if (item.startsWith(FLAG_COMMON_ARRAY)) {
					String[] array2 = StringUtil.splitString(item, ':');
					if (array2.length > 1) {
						commonArrayInfo = array2[1];
					} else {
						commonArrayInfo = "";
					}
				} else if (item.startsWith(FLAG_EXPAND_INFO)) {
					String[] array2 = StringUtil.splitString(item, ':');
					if (array2.length > 1) {
						roleExpandInfo = array2[1];
					} else {
						roleExpandInfo = "";
					}
				} else {
					skeletons = item;
				}
			}
		}
	}

	public String getComplex() {
		StringBuilder sb = new StringBuilder();
		sb.append(skeletons);
		sb.append("#").append(FLAG_fabao).append(":").append(fabaoAndSkill);
		sb.append("#").append(FLAG_pet).append(":").append(petInfo);
		sb.append("#").append(FLAG_ROLE_SKILL).append(":").append(roleSkill);
		sb.append("#").append(FLAG_FOLLOW_PET).append(":").append(followPetInfo);
		sb.append("#").append(FLAG_WORLD_BOSS_ARRAY).append(":").append(worldBossArrayInfo);
		sb.append("#").append(FLAG_COMMON_ARRAY).append(":").append(commonArrayInfo);
		sb.append("#").append(FLAG_EXPAND_INFO).append(":").append(roleExpandInfo);
		return sb.toString();
	}

	public int getFight() {
		return fight;
	}

	public void setFight(int fight) {
		this.fight = fight;
	}

	public String getMountAni() {
		return mountAni;
	}

	public void setMountAni(String mountAni) {
		this.mountAni = mountAni;
	}

	/**
	 * �жϻ�������Ƿ��Ѿ�����
	 * 
	 * @param currTime
	 *            ��ǰʱ��
	 * @return true�Ѿ����ڣ���Ҫ�����յ���ͬʱ�����ջ���ͬһ���˺��µ����������ɫ
	 */
	public final boolean isOvertime(long currTime) {
		return currTime > overtime;
	}

	/**
	 * ���ù���ʱ��
	 */
	public void resetOvertime() {
		this.overtime = System.currentTimeMillis() + OVERTIME_OFFSET;
		this.reorder = true;
	}

	public boolean isReorder() {
		return reorder;
	}

	public void setReorder(boolean reorder) {
		this.reorder = reorder;
	}

	public String getFabaoAndSkill() {
		if (fabaoAndSkill == null) {
			fabaoAndSkill = "15008,3008";
		}
		return fabaoAndSkill;
	}

	public void setFabaoAndSkill(String fabaoAndSkill) {
		this.fabaoAndSkill = fabaoAndSkill;
	}

	public String getPetInfo() {
		if (petInfo == null) {
			petInfo = "";
		}
		return petInfo;
	}

	public void setPetInfo(String petInfo) {
		if (petInfo == null) {
			this.petInfo = "";
		} else {
			this.petInfo = petInfo;
		}
	}

	public String getFollowPetInfo() {
		if (followPetInfo == null) {
			followPetInfo = "";
		}
		return followPetInfo;
	}

	public void setFollowPetInfo(String followPetInfo) {
		if (followPetInfo == null) {
			this.followPetInfo = "";
		} else {
			this.followPetInfo = followPetInfo;
		}
	}

	public String getWorldBossArrayInfo() {
		if (worldBossArrayInfo == null) {
			worldBossArrayInfo = "";
		}
		return worldBossArrayInfo;
	}

	public void setWorldBossArrayInfo(String worldBossArrayInfo) {
		if (worldBossArrayInfo == null) {
			this.worldBossArrayInfo = "";
		} else {
			this.worldBossArrayInfo = worldBossArrayInfo;
		}
	}

	public String getCommonArrayInfo() {
		if (commonArrayInfo == null) {
			commonArrayInfo = "";
		}
		return commonArrayInfo;
	}

	public void setCommonArrayInfo(String commonArrayInfo) {
		if (commonArrayInfo == null) {
			this.commonArrayInfo = "";
		} else {
			this.commonArrayInfo = commonArrayInfo;
		}
	}

	public String getRoleExpandInfo() {
		if (roleExpandInfo == null) {
			roleExpandInfo = "";
		}
		return roleExpandInfo;
	}

	public void setRoleExpandInfo(String roleExpandInfo) {
		if (roleExpandInfo == null) {
			this.roleExpandInfo = "";
		} else {
			this.roleExpandInfo = roleExpandInfo;
		}
	}

	public String getRoleSkill() {
		if (roleSkill == null) {
			roleSkill = "";
		}
		return roleSkill;
	}

	public void setRoleSkill(String roleSkill) {
		if (roleSkill == null) {
			this.roleSkill = "";
		} else {
			this.roleSkill = roleSkill;
		}
	}
}
