package view;

import java.util.Scanner;

import controller.WarehouseBiz;

//仓库管理系统页面
public class WarehouseAction {
	private static Scanner input = new Scanner(System.in);
	private static int NUM = 1;// 仓库编号

	public static void main(String[] ages) {
		WarehouseBiz warehouse = new WarehouseBiz();
		warehouse.warehouseInit();// 仓库商品信息初始化
		warehouse.purchaseInit();// 采购进货初始化
		warehouse.saleInit();// 销售出货初始化
		warehouse.profitInit();//商品利润初始化
		while (true) {
			System.out.println("-----欢迎使用仓库管理系统-----");
			System.out.println("----登录(XML实现)----");
			System.out.print("请输入账号：(admin)");
			String account = input.next();
			System.out.print("请输入密码：(123)");
			String password = input.next();
			// 判断密码是否正确
			boolean flag = warehouse.login(account, password);
			if (flag) {
				int choose = 0;// 标志位，选择功能
				System.out.println("--登录成功！--");
				do {
					System.out.println("=========欢迎\"" + warehouse.compareName(account) + "\"使用仓库管理系统！=========");
					System.out.println("1.采购---------(集合实现)");
					System.out.println("2.销售---------(集合实现)");
					System.out.println("3.库存查看------(功能未实现)");
					System.out.println("4.商品利润------(集合实现)");
					System.out.println("5.仓库管理------(XML实现)");
					System.out.println("6.仓库调拨------(功能未实现)");
					System.out.println("7.客户管理------(功能未实现)");
					System.out.println("8.员工管理------(功能未实现)");
					System.out.println("0.退出系统");
					choose = input.nextInt();
					switch (choose) {
					case 1:
						// 1.采购
						int choose1 = 0;
						do {
							System.out.println("======采购======");
							System.out.println("1.采购进货-----(集合实现)");
							System.out.println("2.采购退货-----(功能未实现)");
							System.out.println("0.退出");
							choose1 = input.nextInt();
							switch (choose1) {
							case 1:
								// 1.采购进货
								System.out.print("当前仓库为--------");
								warehouse.showWhName(NUM);
								// 商品进货展示
								warehouse.showIn(NUM);
								// 采购信息录入
								warehouse.purchas(NUM);
								// 商品进货展示
								warehouse.showIn(NUM);
								break;
							case 2:
								// 2.采购出货
								System.out.println("功能未实现");
								break;
							case 0:
								// 0.退出
								choose1 = 0;
								break;

							default:
								System.out.println("输入数字有误，请重新输入！");
								break;
							}
						} while (choose1 != 0);

						break;
					case 2:
						//2.销售
						int choose2 = 0;
						do {
							System.out.println("======销售======");
							System.out.println("1.销售出货-----(集合实现)");
							System.out.println("2.销售退货-----(功能未实现)");
							System.out.println("0.退出");
							choose2 = input.nextInt();
							switch (choose2) {
							case 1:
								// 1.销售出货
								System.out.print("当前仓库为--------");
								warehouse.showWhName(NUM);
								// 销售出货展示
								warehouse.showOut(NUM);
								// 销售出货信息录入
								warehouse.sale(NUM);
								// 销售出货展示
								warehouse.showOut(NUM);
								break;
							case 2:
								// 2.销售退货
								System.out.println("功能未实现");
								break;
							case 0:
								// 0.退出
								choose2 = 0;
								break;

							default:
								System.out.println("输入数字有误，请重新输入！");
								break;
							}
						} while (choose2 != 0);

						
						break;
					case 3:
						// 3.库存查看
						System.out.println("功能未实现");
						break;
					case 4:
						// 4.商品利润
						System.out.print("当前仓库为--------");
						warehouse.showWhName(NUM);
						// 商品利润展示
//						warehouse.showProfit(NUM);
						warehouse.saleSum(NUM);
						break;
					case 5:
						// 5.仓库管理
						int choose5 = 0;
						do {
							System.out.println("-------仓库管理--------");
							System.out.println("1.增加分仓库");
							System.out.println("2.修改分仓库");
							System.out.println("3.删除分仓库");
							System.out.println("0.退出");

							choose5 = input.nextInt();
							switch (choose5) {
							case 1:
								// 1.增加分仓库
								System.out.println("仓库列表展示：");
								warehouse.warehouseInfShow();
								System.out.print("请输入仓库名称：");
								String nameAdd = input.next();
								System.out.print("请输入仓库负责人：");
								String peopleAdd = input.next();
								System.out.print("请输入联系电话：");
								String phoneAdd = input.next();
								System.out.print("请输入仓库地址：");
								String addressAdd = input.next();
								System.out.print("请输入备注：");
								String remarksAdd = input.next();
								warehouse.warehouseInfadd(nameAdd, peopleAdd, phoneAdd, addressAdd, remarksAdd);
								System.out.println("仓库列表展示：");
								warehouse.warehouseInfShow();
								break;
							case 2:
								// 2.修改分仓库
								System.out.println("仓库列表展示：");
								warehouse.warehouseInfShow();
								System.out.print("请选择要修改的仓库序号：");
								int numUpdate = input.nextInt();
								if (warehouse.findWarehouseInf(numUpdate)) {
									System.out.print("仓库名称：");
									String nameUpdate = input.next();
									System.out.print("负责人：");
									String peopleUpdate = input.next();
									System.out.print("联系电话：");
									String phoneUpdate = input.next();
									System.out.print("仓库地址：");
									String addressUpdate = input.next();
									System.out.print("备注：");
									String remarksUpdate = input.next();
									warehouse.warehouseInfupdate(numUpdate, nameUpdate, peopleUpdate, phoneUpdate,
											addressUpdate, remarksUpdate);
									System.out.println("仓库列表展示：");
									warehouse.warehouseInfShow();
								}

								break;
							case 3:
								// 3.删除分仓库
								System.out.println("仓库列表展示：");
								warehouse.warehouseInfShow();
								System.out.print("请输入要删除的仓库序号：");
								int numDelete = input.nextInt();
								if (warehouse.findWarehouseInf(numDelete)) {
									if (numDelete == 1) {
										System.out.println("总仓库无法删除！");
									} else {
										warehouse.warehouseInfDelete(numDelete);
										System.out.println("删除成功！");
									}
								}
								System.out.println("仓库列表展示：");
								warehouse.warehouseInfShow();
								break;
							case 0:
								// 0.退出
								choose5 = 0;
								break;

							default:
								System.out.println("输入的数字有误！");
								break;
							}
						} while (choose5 != 0);
						break;
					case 6:
						// 6.仓库调拨
						System.out.println("功能未实现");
						break;
					case 7:
						// 7.客户管理
						System.out.println("功能未实现");
						break;
					case 8:
						// 8.员工管理
						System.out.println("功能未实现");
						break;

					case 0:
						choose = 0;
						System.out.println("程序结束，谢谢使用！");
						System.exit(0);
						break;

					default:
						System.out.println("输入数字有误，请重新输入！");
						break;
					}
				} while (choose != 0);

			} else {
				System.out.println("登录失败！");
			}
		}

	}
}
