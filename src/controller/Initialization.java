package controller;

//初始化接口
public interface Initialization {

	// 仓库商品信息初始化
	public abstract void warehouseInit();

	// 采购进货初始化
	public abstract void purchaseInit();

	// 销售出货初始化
	public abstract void saleInit();

	// 商品利润初始化
	public abstract void profitInit();
}
