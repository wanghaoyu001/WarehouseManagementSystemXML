package model;

//���۳���
public class Sale extends Goods {
	private int SaleOut;// ��������
	private double SaleUnitPrice;// ��������
	private double SaleTotalPrice;// �ϼ�
	private double SalePaidPrice;// �Ѹ����
	private double SaleDebtPrice;// Ƿ����

	public Sale() {
		super();
		// TODO �Զ����ɵĹ��캯�����
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
