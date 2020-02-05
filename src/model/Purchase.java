package model;

//采购进货
public class Purchase extends Goods {
	private int PurchaseIn;// 进货数量
	private double PurchaseUnitPrice;// 进货单价
	private double PurchaseTotalPrice;// 合计
	private double PurchasePaidPrice;// 已付金额
	private double PurchaseDebtPrice;// 欠款金额

	public Purchase() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public Purchase(String goodsNum, int purchaseIn, double purchaseUnitPrice) {
		super(goodsNum);
		PurchaseIn = purchaseIn;
		PurchaseUnitPrice = purchaseUnitPrice;
	}

	public int getPurchaseIn() {
		return PurchaseIn;
	}

	public void setPurchaseIn(int purchaseIn) {
		PurchaseIn = purchaseIn;
	}

	public double getPurchaseUnitPrice() {
		return PurchaseUnitPrice;
	}

	public void setPurchaseUnitPrice(double purchaseUnitPrice) {
		PurchaseUnitPrice = purchaseUnitPrice;
	}

	public double getPurchasePaidPrice() {
		return PurchasePaidPrice;
	}

	public void setPurchasePaidPrice(double purchasePaidPrice) {
		PurchasePaidPrice = purchasePaidPrice;
	}

	public double getPurchaseTotalPrice() {
		return PurchaseTotalPrice;
	}

	public void setPurchaseTotalPrice(double purchaseTotalPrice) {
		PurchaseTotalPrice = purchaseTotalPrice;
	}

	public double getPurchaseDebtPrice() {
		return PurchaseDebtPrice;
	}

	public void setPurchaseDebtPrice(double purchaseDebtPrice) {
		PurchaseDebtPrice = purchaseDebtPrice;
	}

}
