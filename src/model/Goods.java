package model;

//货物基本信息
public abstract class Goods {

	private String goodsNum;// 商品编码
	
	public Goods() {
		super();
		// TODO 自动生成的构造函数存根
	}
	

	public Goods(String goodsNum) {
		super();
		this.goodsNum = goodsNum;
	}


	public String getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(String goodsNum) {
		this.goodsNum = goodsNum;
	}

}