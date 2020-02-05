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
	// ��ӹ���Ա����
	AdminUtil admin = new AdminUtil();

	// ��¼
	public boolean login(String account, String password) {
		return admin.login(account, password);
	}

	// �����˺�ƥ���û�����
	public String compareName(String account) {
		return admin.compareName(account);
	}

	// ��Ӳֿ����
	WarehouseInfUtil wInfUtil = new WarehouseInfUtil();

	public void warehouseInfadd(String name, String people, String phone, String address, String remarks) {
		WarehouseInf whif = new WarehouseInf(name, people, phone, address, remarks);
		wInfUtil.add(whif);
	}

	// չʾ�ֿ�
	public void warehouseInfShow() {
		System.out.println("�ֿ���\t\t�ֿ�����\t\t������\t\t��ϵ�绰\t\t�ֿ��ַ\t\t��ע");
		wInfUtil.show();
	}

	// ����Ŀ��ֿ��Ƿ����
	public boolean findWarehouseInf(int number) {
		boolean find = false;
		find = wInfUtil.search(number);
		return find;
	}

	// �ֿ������޸�
	public void warehouseInfupdate(int number, String name, String people, String phone, String address,
			String remarks) {
		wInfUtil.update(number, name, people, phone, address, remarks);
	}

	// �ֿ�����ɾ��
	public void warehouseInfDelete(int number) {
		wInfUtil.delete(number);

	}

	// �ֿ���չʾ
	public void showWhName(int NUM) {
		System.out.println(wInfUtil.showWhName(NUM));
	}

	// �ֿ���Ʒ��Ϣ��ʼ��
	Map<Integer, List<Warehouse>> warehouseMap = new HashMap<Integer, List<Warehouse>>();

	List<Warehouse> whList = new ArrayList<Warehouse>();
	Warehouse warehouse = new Warehouse();

	public void warehouseInit() {
		warehouseMap.put(1, whList);

		Warehouse init = new Warehouse("ˮ��", "����", "��ɫ", "001");
		warehouseMap.get(1).add(init);
	}

	// �ɹ�������ʼ��
	Map<Integer, List<Purchase>> purchaseMap = new HashMap<Integer, List<Purchase>>();
	List<Purchase> phList = new ArrayList<Purchase>();
	Purchase purchase = new Purchase();

	public void purchaseInit() {
		purchaseMap.put(1, phList);
		Purchase init = new Purchase("001", 1000, 1.2);
		init.setPurchaseTotalPrice(init.getPurchaseIn() * init.getPurchaseUnitPrice());
		purchaseMap.get(1).add(init);
	}

	// ���۳�����ʼ��
	Map<Integer, List<Sale>> saleMap = new HashMap<Integer, List<Sale>>();
	List<Sale> slList = new ArrayList<Sale>();
	Sale sale = new Sale();

	public void saleInit() {
		saleMap.put(1, slList);
	}

	// ��Ʒ�����ʼ��
	Map<Integer, List<Profit>> profitMap = new HashMap<Integer, List<Profit>>();
	List<Profit> pfList = new ArrayList<Profit>();
	Profit profit = new Profit();

	public void profitInit() {
		profitMap.put(1, pfList);

	}

	// �ɹ�����
	public void purchas(int NUM) {
		Warehouse warehouse = new Warehouse();
		System.out.print("������Ҫ�ɹ�����Ʒ����");
		warehouse.setGoodsName(input.next());
		System.out.print("������Ҫ�ɹ�����Ʒ���ͣ�");
		warehouse.setGoodsType(input.next());
		System.out.print("������Ҫ�ɹ�����Ʒ���");
		warehouse.setGoodsPeci(input.next());
		System.out.print("������Ҫ�ɹ�����Ʒ���룺");
		warehouse.setGoodsNum(input.next());
		purchase.setGoodsNum(warehouse.getGoodsNum());
		System.out.print("���������������");
		purchase.setPurchaseIn(input.nextInt());
		System.out.print("������������ۣ�");
		purchase.setPurchaseUnitPrice(input.nextDouble());
		// �Զ������ܽ��
		purchase.setPurchaseTotalPrice(purchase.getPurchaseIn() * purchase.getPurchaseUnitPrice());
		// ��aWarehouse�������List
		warehouseMap.get(NUM).add(warehouse);
		// warehouseMap.replace(NUM, warehouseMap.get(NUM));
		purchaseMap.get(NUM).add(purchase);
	}

	// ���۳���
	public void sale(int NUM) {
		Sale sale = new Sale();
		System.out.print("������Ҫ���۵���Ʒ���룺");
		String num = input.next();
		if (findGoods(num, NUM)) {
			sale.setGoodsNum(num);
			System.out.print("���������������");
			sale.setSaleOut(input.nextInt());
			System.out.print("���������۵��ۣ�");
			sale.setSaleUnitPrice(input.nextDouble());
			sale.setSaleTotalPrice(sale.getSaleOut() * sale.getSaleUnitPrice());
			saleMap.get(NUM).add(sale);

		} else {
			System.out.println("��Ҫ���۵���Ʒ�����ڣ�");
		}

	}

	// Ѱ����Ʒ�Ƿ����
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

	// �����ֿ�
	public void crateW() {
		warehouseMap.put(warehouseMap.size() + 1, whList);
	}

	// �ɹ�����չʾ
	public void showIn(int NUM) {
		System.out.println("��Ʒ����\t\t��Ʒ����\t\t��Ʒ���\t\t��Ʒ����\t\t��������\t\t��������\t\t�ϼ�\t\t");
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

	// ���۳���չʾ
	public void showOut(int NUM) {
		System.out.println("��Ʒ����\t\t��Ʒ����\t\t��Ʒ���\t\t��Ʒ����\t\t��������\t\t��������\t\t�ϼ�");
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
			System.out.println("�������۳�����¼��");
		}

	}
	//��Ʒ����չʾ
	public void showProfit(int NUM) {
		double Profit=0;
		System.out.println("��Ʒ����\t\t��Ʒ����\t\t��Ʒ���\t\t��Ʒ����\t\t��������\t\t��������\t\t�����ܽ��\t\t��������\t\t��������\t\t�����ܽ��\t\t����\t\t������");
		for (int i = 0; i < saleMap.get(NUM).size(); i++) {
			for (Warehouse warehouse : warehouseMap.get(NUM)) {
				if (saleMap.get(NUM).get(i).getGoodsNum().equals(warehouse.getGoodsNum())) {
					
				}
			}

		}
	}
	//��Ʒ���۶�ͳ��
	
	public void saleSum(int NUM) {
		Map<String , Profit> salesum = new HashMap<String , Profit>();
		for (int i = 0; i < saleMap.get(NUM).size(); i++) {
			Profit profit = new Profit();
			//���ó��ۼ�¼����Ʒ�������ʱ
			if(salesum.containsKey(saleMap.get(NUM).get(i).getGoodsNum())) {
				System.out.println("----if-----");
				//���������ۼ�
				salesum.get(saleMap.get(NUM).get(i).getGoodsNum()).setSaleNum(salesum.get(saleMap.get(NUM).get(i).getGoodsNum()).getSaleNum()+saleMap.get(NUM).get(i).getSaleOut());
				//���۶��ۼ�
				salesum.get(saleMap.get(NUM).get(i).getGoodsNum()).setSaleSum(salesum.get(saleMap.get(NUM).get(i).getGoodsNum()).getSaleSum()+saleMap.get(NUM).get(i).getSaleTotalPrice());
				
			}else {
				//���ó��ۼ�¼����Ʒ������ʱ
				System.out.println("----else-----");
				profit.setSaleNum(saleMap.get(NUM).get(i).getSaleOut());
				profit.setSaleSum(saleMap.get(NUM).get(i).getSaleTotalPrice());
				//����KEY-VELUE
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
