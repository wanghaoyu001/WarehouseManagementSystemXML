package model;

//��Ʒ����
public class Profit extends Goods {
	private double Profit;// ����
	private double ProfitMargin;// ������
	private double SaleSum;//�����ܶ�
	private int SaleNum;//��������

	

	public Profit() {
		super();
		// TODO �Զ����ɵĹ��캯�����
	}

	public Profit(double profit, double profitMargin) {
		super();
		Profit = profit;
		ProfitMargin = profitMargin;
	}

	public double getProfit() {
		return Profit;
	}

	public void setProfit(double profit) {
		Profit = profit;
	}

	public double getProfitMargin() {
		return ProfitMargin;
	}

	public void setProfitMargin(double profitMargin) {
		ProfitMargin = profitMargin;
	}
	public double getSaleSum() {
		return SaleSum;
	}

	public void setSaleSum(double saleSum) {
		SaleSum = saleSum;
	}

	public int getSaleNum() {
		return SaleNum;
	}

	public void setSaleNum(int saleNum) {
		SaleNum = saleNum;
	}

}
