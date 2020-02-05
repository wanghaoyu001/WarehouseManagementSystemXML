package controller;

//销售
public interface ISale {
	// 销售出货信息录入
	public abstract void sale(int NUM);
	// 销售出货展示
	public abstract void showOut(int NUM);

}
