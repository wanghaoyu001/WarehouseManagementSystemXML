package model;

//�ɹ�����
public class Purchase extends Goods {
	private int PurchaseIn;// ��������
	private double PurchaseUnitPrice;// ��������
	private double PurchaseTotalPrice;// �ϼ�
	private double PurchasePaidPrice;// �Ѹ����
	private double PurchaseDebtPrice;// Ƿ����

	public Purchase() {
		super();
		// TODO �Զ����ɵĹ��캯�����
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
