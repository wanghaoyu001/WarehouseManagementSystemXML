package model;

//商品利润
public class Profit extends Goods {
	private double Profit;// 利润
	private double ProfitMargin;// 利润率
	private double SaleSum;//销售总额
	private int SaleNum;//销售数量

	

	public Profit() {
		super();
		// TODO 自动生成的构造函数存根
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
