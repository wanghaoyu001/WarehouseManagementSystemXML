package model;

//仓库
public class Warehouse extends Goods {
	private String goodsName; // 商品名称
	private String goodsType;// 商品种类
	private String goodsPeci;// 商品规格(颜色,型号)

	public Warehouse() {
		super();
		// TODO 自动生成的构造函数存根
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
