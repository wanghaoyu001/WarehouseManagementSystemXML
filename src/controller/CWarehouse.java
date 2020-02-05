package controller;

//仓库操作
public interface CWarehouse {

	// 创建仓库
	public abstract void crateW();

	// 商品进货展示
	public abstract void showIn(int NUM);

	// 商品出货展示
	public abstract void showOut(int NUM);

	// 仓库名展示
	public abstract void showWhName(int NUM);

	// 寻找商品是否存在
	public abstract boolean findGoods(String goodsNum, int NUM);
}
