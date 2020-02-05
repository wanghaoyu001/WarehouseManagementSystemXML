package controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.Warehouse;
import model.WarehouseInf;
import util.AdminUtil;
import util.WarehouseInfUtil;
import model.Profit;
import model.Purchase;
import model.Sale;

public class WarehouseBiz implements Initialization, Login, CWarehouse, IPurchase, ISale, IProfit,IWarehouseInf {
	Scanner input = new Scanner(System.in);
	// 添加管理员对象
	AdminUtil admin = new AdminUtil();

	// 登录
	public boolean login(String account, String password) {
		return admin.login(account, password);
	}

	// 根据账号匹配用户名称
	public String compareName(String account) {
		return admin.compareName(account);
	}

	// 添加仓库对象
	WarehouseInfUtil wInfUtil = new WarehouseInfUtil();

	public void warehouseInfadd(String name, String people, String phone, String address, String remarks) {
		WarehouseInf whif = new WarehouseInf(name, people, phone, address, remarks);
		wInfUtil.add(whif);
	}

	// 展示仓库
	public void warehouseInfShow() {
		System.out.println("仓库编号\t\t仓库名称\t\t负责人\t\t联系电话\t\t仓库地址\t\t备注");
		wInfUtil.show();
	}

	// 查找目标仓库是否存在
	public boolean findWarehouseInf(int number) {
		boolean find = false;
		find = wInfUtil.search(number);
		return find;
	}

	// 仓库数据修改
	public void warehouseInfupdate(int number, String name, String people, String phone, String address,
			String remarks) {
		wInfUtil.update(number, name, people, phone, address, remarks);
	}

	// 仓库数据删除
	public void warehouseInfDelete(int number) {
		wInfUtil.delete(number);

	}

	// 仓库名展示
	public void showWhName(int NUM) {
		System.out.println(wInfUtil.showWhName(NUM));
	}

	// 仓库商品信息初始化
	Map<Integer, List<Warehouse>> warehouseMap = new HashMap<Integer, List<Warehouse>>();

	List<Warehouse> whList = new ArrayList<Warehouse>();
	Warehouse warehouse = new Warehouse();

	public void warehouseInit() {
		warehouseMap.put(1, whList);

		Warehouse init = new Warehouse("水果", "西瓜", "绿色", "001");
		warehouseMap.get(1).add(init);
	}

	// 采购进货初始化
	Map<Integer, List<Purchase>> purchaseMap = new HashMap<Integer, List<Purchase>>();
	List<Purchase> phList = new ArrayList<Purchase>();
	Purchase purchase = new Purchase();

	public void purchaseInit() {
		purchaseMap.put(1, phList);
		Purchase init = new Purchase("001", 1000, 1.2);
		init.setPurchaseTotalPrice(init.getPurchaseIn() * init.getPurchaseUnitPrice());
		purchaseMap.get(1).add(init);
	}

	// 销售出货初始化
	Map<Integer, List<Sale>> saleMap = new HashMap<Integer, List<Sale>>();
	List<Sale> slList = new ArrayList<Sale>();
	Sale sale = new Sale();

	public void saleInit() {
		saleMap.put(1, slList);
	}

	// 商品利润初始化
	Map<Integer, List<Profit>> profitMap = new HashMap<Integer, List<Profit>>();
	List<Profit> pfList = new ArrayList<Profit>();
	Profit profit = new Profit();

	public void profitInit() {
		profitMap.put(1, pfList);

	}

	// 采购进货
	public void purchas(int NUM) {
		Warehouse warehouse = new Warehouse();
		System.out.print("请输入要采购的商品名：");
		warehouse.setGoodsName(input.next());
		System.out.print("请输入要采购的商品类型：");
		warehouse.setGoodsType(input.next());
		System.out.print("请输入要采购的商品规格：");
		warehouse.setGoodsPeci(input.next());
		System.out.print("请输入要采购的商品编码：");
		warehouse.setGoodsNum(input.next());
		purchase.setGoodsNum(warehouse.getGoodsNum());
		System.out.print("请输入进货数量：");
		purchase.setPurchaseIn(input.nextInt());
		System.out.print("请输入进货单价：");
		purchase.setPurchaseUnitPrice(input.nextDouble());
		// 自动计算总金额
		purchase.setPurchaseTotalPrice(purchase.getPurchaseIn() * purchase.getPurchaseUnitPrice());
		// 将aWarehouse对象存入List
		warehouseMap.get(NUM).add(warehouse);
		// warehouseMap.replace(NUM, warehouseMap.get(NUM));
		purchaseMap.get(NUM).add(purchase);
	}

	// 销售出货
	public void sale(int NUM) {
		Sale sale = new Sale();
		System.out.print("请输入要出售的商品编码：");
		String num = input.next();
		if (findGoods(num, NUM)) {
			sale.setGoodsNum(num);
			System.out.print("请输入出货数量：");
			sale.setSaleOut(input.nextInt());
			System.out.print("请输入销售单价：");
			sale.setSaleUnitPrice(input.nextDouble());
			sale.setSaleTotalPrice(sale.getSaleOut() * sale.getSaleUnitPrice());
			saleMap.get(NUM).add(sale);

		} else {
			System.out.println("您要出售的商品不存在！");
		}

	}

	// 寻找商品是否存在
	public boolean findGoods(String goodsNum, int NUM) {
		boolean find = false;
		for (Warehouse warehouse : warehouseMap.get(NUM)) {
			if (goodsNum.equals(warehouse.getGoodsNum())) {
				find = true;
				break;
			}
		}

		return find;
	}

	// 创建仓库
	public void crateW() {
		warehouseMap.put(warehouseMap.size() + 1, whList);
	}

	// 采购进货展示
	public void showIn(int NUM) {
		System.out.println("商品大类\t\t商品名称\t\t商品规格\t\t商品编码\t\t进货数量\t\t进货单价\t\t合计\t\t");
		for (int i = 0; i < warehouseMap.get(NUM).size(); i++) {

			System.out.println(warehouseMap.get(NUM).get(i).getGoodsType() + "\t\t"
					+ warehouseMap.get(NUM).get(i).getGoodsName() + "\t\t" 
					+ warehouseMap.get(NUM).get(i).getGoodsPeci()+ "\t\t" 
					+ warehouseMap.get(NUM).get(i).getGoodsNum() + "\t\t"
					+ purchaseMap.get(NUM).get(i).getPurchaseIn() + "\t\t"
					+ purchaseMap.get(NUM).get(i).getPurchaseUnitPrice() + "\t\t"
					+ purchaseMap.get(NUM).get(i).getPurchaseTotalPrice());
		}

	}

	// 销售出货展示
	public void showOut(int NUM) {
		System.out.println("商品大类\t\t商品名称\t\t商品规格\t\t商品编码\t\t出货数量\t\t出货单价\t\t合计");
		if (saleMap.get(NUM).size() != 0) {
			for (int i = 0; i < saleMap.get(NUM).size(); i++) {
				for (Warehouse warehouse : warehouseMap.get(NUM)) {
					if (saleMap.get(NUM).get(i).getGoodsNum().equals(warehouse.getGoodsNum())) {
						System.out.println(warehouse.getGoodsType() + "\t\t" 
					            + warehouse.getGoodsName() + "\t\t"
								+ warehouse.getGoodsPeci() + "\t\t" 
					            + warehouse.getGoodsNum() + "\t\t"
								+ saleMap.get(NUM).get(i).getSaleOut() + "\t\t"
								+ saleMap.get(NUM).get(i).getSaleUnitPrice() + "\t\t"
								+ saleMap.get(NUM).get(i).getSaleTotalPrice());
						break;
					}
				}

			}
		}else {
			System.out.println("暂无销售出货记录！");
		}

	}
	//商品利润展示
	public void showProfit(int NUM) {
		double Profit=0;
		System.out.println("商品大类\t\t商品名称\t\t商品规格\t\t商品编码\t\t进货数量\t\t进货单价\t\t进货总金额\t\t出货数量\t\t出货单价\t\t出货总金额\t\t利润\t\t利润率");
		for (int i = 0; i < saleMap.get(NUM).size(); i++) {
			for (Warehouse warehouse : warehouseMap.get(NUM)) {
				if (saleMap.get(NUM).get(i).getGoodsNum().equals(warehouse.getGoodsNum())) {
					
				}
			}

		}
	}
	//商品销售额统计
	
	public void saleSum(int NUM) {
		Map<String , Profit> salesum = new HashMap<String , Profit>();
		for (int i = 0; i < saleMap.get(NUM).size(); i++) {
			Profit profit = new Profit();
			//当该出售记录的物品曾今存在时
			if(salesum.containsKey(saleMap.get(NUM).get(i).getGoodsNum())) {
				System.out.println("----if-----");
				//销售数量累加
				salesum.get(saleMap.get(NUM).get(i).getGoodsNum()).setSaleNum(salesum.get(saleMap.get(NUM).get(i).getGoodsNum()).getSaleNum()+saleMap.get(NUM).get(i).getSaleOut());
				//销售额累加
				salesum.get(saleMap.get(NUM).get(i).getGoodsNum()).setSaleSum(salesum.get(saleMap.get(NUM).get(i).getGoodsNum()).getSaleSum()+saleMap.get(NUM).get(i).getSaleTotalPrice());
				
			}else {
				//当该出售记录的物品不存在时
				System.out.println("----else-----");
				profit.setSaleNum(saleMap.get(NUM).get(i).getSaleOut());
				profit.setSaleSum(saleMap.get(NUM).get(i).getSaleTotalPrice());
				//新增KEY-VELUE
				salesum.put(saleMap.get(NUM).get(i).getGoodsNum(), profit);
			}
		}
		
			System.out.println(salesum.get("001").getSaleNum()+"  "+salesum.get("001").getSaleSum());
			System.out.println(salesum.get("002").getSaleNum()+"  "+salesum.get("002").getSaleSum());
			
		
	
	}

}
//for (int i = 0; i < warehouseMap.get(NUM).size(); i++) {
//Profit=saleMap.get(NUM).get(i).getSaleTotalPrice()-purchaseMap.get(NUM).get(i).getPurchaseTotalPrice();
//System.out.println(warehouseMap.get(NUM).get(i).getGoodsType() + "\t\t"
//		+ warehouseMap.get(NUM).get(i).getGoodsName() + "\t\t" 
//		+ warehouseMap.get(NUM).get(i).getGoodsPeci()+ "\t\t" 
//		+ warehouseMap.get(NUM).get(i).getGoodsNum() + "\t\t"
//		+ purchaseMap.get(NUM).get(i).getPurchaseIn() + "\t\t"
//		+ purchaseMap.get(NUM).get(i).getPurchaseUnitPrice() + "\t\t"
//		+ purchaseMap.get(NUM).get(i).getPurchaseTotalPrice()+ "\t\t"
//		+ saleMap.get(NUM).get(i).getSaleOut() + "\t\t"
//		+ saleMap.get(NUM).get(i).getSaleUnitPrice() + "\t\t"
//		+ saleMap.get(NUM).get(i).getSaleTotalPrice() + "\t\t"
//		+ Profit + "\t\t"
//		+ Profit/purchaseMap.get(NUM).get(i).getPurchaseTotalPrice()
//		);
//}
