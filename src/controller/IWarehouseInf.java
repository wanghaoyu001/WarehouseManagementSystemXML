package controller;

//仓库管理
public interface IWarehouseInf {

	// 查找目标仓库是否存在
	public abstract boolean findWarehouseInf(int number);

	// 仓库数据添加
	public abstract void warehouseInfadd(String name, String people, String phone, String address, String remarks);

	// 仓库数据删除
	public abstract void warehouseInfDelete(int number);

	// 仓库数据修改
	public abstract void warehouseInfupdate(int number, String name, String people, String phone, String address,
			String remarks);
}
