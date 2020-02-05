package view;

import java.util.Scanner;

import controller.WarehouseBiz;

//�ֿ����ϵͳҳ��
public class WarehouseAction {
	private static Scanner input = new Scanner(System.in);
	private static int NUM = 1;// �ֿ���

	public static void main(String[] ages) {
		WarehouseBiz warehouse = new WarehouseBiz();
		warehouse.warehouseInit();// �ֿ���Ʒ��Ϣ��ʼ��
		warehouse.purchaseInit();// �ɹ�������ʼ��
		warehouse.saleInit();// ���۳�����ʼ��
		warehouse.profitInit();//��Ʒ�����ʼ��
		while (true) {
			System.out.println("-----��ӭʹ�òֿ����ϵͳ-----");
			System.out.println("----��¼(XMLʵ��)----");
			System.out.print("�������˺ţ�(admin)");
			String account = input.next();
			System.out.print("���������룺(123)");
			String password = input.next();
			// �ж������Ƿ���ȷ
			boolean flag = warehouse.login(account, password);
			if (flag) {
				int choose = 0;// ��־λ��ѡ����
				System.out.println("--��¼�ɹ���--");
				do {
					System.out.println("=========��ӭ\"" + warehouse.compareName(account) + "\"ʹ�òֿ����ϵͳ��=========");
					System.out.println("1.�ɹ�---------(����ʵ��)");
					System.out.println("2.����---------(����ʵ��)");
					System.out.println("3.���鿴------(����δʵ��)");
					System.out.println("4.��Ʒ����------(����ʵ��)");
					System.out.println("5.�ֿ����------(XMLʵ��)");
					System.out.println("6.�ֿ����------(����δʵ��)");
					System.out.println("7.�ͻ�����------(����δʵ��)");
					System.out.println("8.Ա������------(����δʵ��)");
					System.out.println("0.�˳�ϵͳ");
					choose = input.nextInt();
					switch (choose) {
					case 1:
						// 1.�ɹ�
						int choose1 = 0;
						do {
							System.out.println("======�ɹ�======");
							System.out.println("1.�ɹ�����-----(����ʵ��)");
							System.out.println("2.�ɹ��˻�-----(����δʵ��)");
							System.out.println("0.�˳�");
							choose1 = input.nextInt();
							switch (choose1) {
							case 1:
								// 1.�ɹ�����
								System.out.print("��ǰ�ֿ�Ϊ--------");
								warehouse.showWhName(NUM);
								// ��Ʒ����չʾ
								warehouse.showIn(NUM);
								// �ɹ���Ϣ¼��
								warehouse.purchas(NUM);
								// ��Ʒ����չʾ
								warehouse.showIn(NUM);
								break;
							case 2:
								// 2.�ɹ�����
								System.out.println("����δʵ��");
								break;
							case 0:
								// 0.�˳�
								choose1 = 0;
								break;

							default:
								System.out.println("���������������������룡");
								break;
							}
						} while (choose1 != 0);

						break;
					case 2:
						//2.����
						int choose2 = 0;
						do {
							System.out.println("======����======");
							System.out.println("1.���۳���-----(����ʵ��)");
							System.out.println("2.�����˻�-----(����δʵ��)");
							System.out.println("0.�˳�");
							choose2 = input.nextInt();
							switch (choose2) {
							case 1:
								// 1.���۳���
								System.out.print("��ǰ�ֿ�Ϊ--------");
								warehouse.showWhName(NUM);
								// ���۳���չʾ
								warehouse.showOut(NUM);
								// ���۳�����Ϣ¼��
								warehouse.sale(NUM);
								// ���۳���չʾ
								warehouse.showOut(NUM);
								break;
							case 2:
								// 2.�����˻�
								System.out.println("����δʵ��");
								break;
							case 0:
								// 0.�˳�
								choose2 = 0;
								break;

							default:
								System.out.println("���������������������룡");
								break;
							}
						} while (choose2 != 0);

						
						break;
					case 3:
						// 3.���鿴
						System.out.println("����δʵ��");
						break;
					case 4:
						// 4.��Ʒ����
						System.out.print("��ǰ�ֿ�Ϊ--------");
						warehouse.showWhName(NUM);
						// ��Ʒ����չʾ
//						warehouse.showProfit(NUM);
						warehouse.saleSum(NUM);
						break;
					case 5:
						// 5.�ֿ����
						int choose5 = 0;
						do {
							System.out.println("-------�ֿ����--------");
							System.out.println("1.���ӷֲֿ�");
							System.out.println("2.�޸ķֲֿ�");
							System.out.println("3.ɾ���ֲֿ�");
							System.out.println("0.�˳�");

							choose5 = input.nextInt();
							switch (choose5) {
							case 1:
								// 1.���ӷֲֿ�
								System.out.println("�ֿ��б�չʾ��");
								warehouse.warehouseInfShow();
								System.out.print("������ֿ����ƣ�");
								String nameAdd = input.next();
								System.out.print("������ֿ⸺���ˣ�");
								String peopleAdd = input.next();
								System.out.print("��������ϵ�绰��");
								String phoneAdd = input.next();
								System.out.print("������ֿ��ַ��");
								String addressAdd = input.next();
								System.out.print("�����뱸ע��");
								String remarksAdd = input.next();
								warehouse.warehouseInfadd(nameAdd, peopleAdd, phoneAdd, addressAdd, remarksAdd);
								System.out.println("�ֿ��б�չʾ��");
								warehouse.warehouseInfShow();
								break;
							case 2:
								// 2.�޸ķֲֿ�
								System.out.println("�ֿ��б�չʾ��");
								warehouse.warehouseInfShow();
								System.out.print("��ѡ��Ҫ�޸ĵĲֿ���ţ�");
								int numUpdate = input.nextInt();
								if (warehouse.findWarehouseInf(numUpdate)) {
									System.out.print("�ֿ����ƣ�");
									String nameUpdate = input.next();
									System.out.print("�����ˣ�");
									String peopleUpdate = input.next();
									System.out.print("��ϵ�绰��");
									String phoneUpdate = input.next();
									System.out.print("�ֿ��ַ��");
									String addressUpdate = input.next();
									System.out.print("��ע��");
									String remarksUpdate = input.next();
									warehouse.warehouseInfupdate(numUpdate, nameUpdate, peopleUpdate, phoneUpdate,
											addressUpdate, remarksUpdate);
									System.out.println("�ֿ��б�չʾ��");
									warehouse.warehouseInfShow();
								}

								break;
							case 3:
								// 3.ɾ���ֲֿ�
								System.out.println("�ֿ��б�չʾ��");
								warehouse.warehouseInfShow();
								System.out.print("������Ҫɾ���Ĳֿ���ţ�");
								int numDelete = input.nextInt();
								if (warehouse.findWarehouseInf(numDelete)) {
									if (numDelete == 1) {
										System.out.println("�ֿܲ��޷�ɾ����");
									} else {
										warehouse.warehouseInfDelete(numDelete);
										System.out.println("ɾ���ɹ���");
									}
								}
								System.out.println("�ֿ��б�չʾ��");
								warehouse.warehouseInfShow();
								break;
							case 0:
								// 0.�˳�
								choose5 = 0;
								break;

							default:
								System.out.println("�������������");
								break;
							}
						} while (choose5 != 0);
						break;
					case 6:
						// 6.�ֿ����
						System.out.println("����δʵ��");
						break;
					case 7:
						// 7.�ͻ�����
						System.out.println("����δʵ��");
						break;
					case 8:
						// 8.Ա������
						System.out.println("����δʵ��");
						break;

					case 0:
						choose = 0;
						System.out.println("���������ллʹ�ã�");
						System.exit(0);
						break;

					default:
						System.out.println("���������������������룡");
						break;
					}
				} while (choose != 0);

			} else {
				System.out.println("��¼ʧ�ܣ�");
			}
		}

	}
}
