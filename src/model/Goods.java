package model;

//���������Ϣ
public abstract class Goods {

	private String goodsNum;// ��Ʒ����
	
	public Goods() {
		super();
		// TODO �Զ����ɵĹ��캯�����
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