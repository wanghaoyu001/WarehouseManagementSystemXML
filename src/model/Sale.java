package model;

//销售出货
public class Sale extends Goods {
	private int SaleOut;// 出货数量
	private double SaleUnitPrice;// 出货单价
	private double SaleTotalPrice;// 合计
	private double SalePaidPrice;// 已付金额
	private double SaleDebtPrice;// 欠款金额

	public Sale() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Sale(String goodsNum) {
		super(goodsNum);

	}

	public int getSaleOut() {
		return SaleOut;
	}

	public void setSaleOut(int saleOut) {
		SaleOut = saleOut;
	}

	public double getSaleUnitPrice() {
		return SaleUnitPrice;
	}

	public void setSaleUnitPrice(double saleUnitPrice) {
		SaleUnitPrice = saleUnitPrice;
	}

	public double getSaleTotalPrice() {
		return SaleTotalPrice;
	}

	public void setSaleTotalPrice(double saleTotalPrice) {
		SaleTotalPrice = saleTotalPrice;
	}

	public double getSalePaidPrice() {
		return SalePaidPrice;
	}

	public void setSalePaidPrice(double salePaidPrice) {
		SalePaidPrice = salePaidPrice;
	}

	public double getSaleDebtPrice() {
		return SaleDebtPrice;
	}

	public void setSaleDebtPrice(double saleDebtPrice) {
		SaleDebtPrice = saleDebtPrice;
	}

}
