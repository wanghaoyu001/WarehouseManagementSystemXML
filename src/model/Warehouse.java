package model;

//�ֿ�
public class Warehouse extends Goods {
	private String goodsName; // ��Ʒ����
	private String goodsType;// ��Ʒ����
	private String goodsPeci;// ��Ʒ���(��ɫ,�ͺ�)

	public Warehouse() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}

	public Warehouse(String goodsType, String goodsName, String goodsPeci, String goodsNum) {
		super(goodsNum);
		this.goodsName = goodsName;
		this.goodsType = goodsType;
		this.goodsPeci = goodsPeci;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsType() {
		return goodsType;
	}

	public void setGoodsType(String goodsType) {
		this.goodsType = goodsType;
	}

	public String getGoodsPeci() {
		return goodsPeci;
	}

	public void setGoodsPeci(String goodsPeci) {
		this.goodsPeci = goodsPeci;
	}

}
