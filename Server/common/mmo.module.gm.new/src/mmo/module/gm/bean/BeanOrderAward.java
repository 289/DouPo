package mmo.module.gm.bean;

import mmo.common.config.role.RoleProfession;

public class BeanOrderAward extends TreeNode {
	private int    goodsId;
	private String goodsName;
	private int    count;
	private byte   profession;

	public BeanOrderAward(int goodsId, String goodsName, int count, byte profession, TreeNode parent) {
		super("ID:" + goodsId + ", " + goodsName + ",������" + count + "," + (profession == 0 ? "ȫְҵ" : RoleProfession.getProfessionName(profession)),
		        parent);
		this.goodsId = goodsId;
		this.goodsName = goodsName;
		this.count = count;
		this.profession = profession;
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

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public byte getProfession() {
		return profession;
	}

	public void setProfession(byte profession) {
		this.profession = profession;
	}

	public String getNodeName() {
		nodeName = goodsName + ",������" + count + "," + (profession == 0 ? "ȫְҵ" : RoleProfession.getProfessionName(profession));
		return nodeName;
	}

}
