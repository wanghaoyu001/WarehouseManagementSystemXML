package controller;

//�ֿ����
public interface IWarehouseInf {

	// ����Ŀ��ֿ��Ƿ����
	public abstract boolean findWarehouseInf(int number);

	// �ֿ��������
	public abstract void warehouseInfadd(String name, String people, String phone, String address, String remarks);

	// �ֿ�����ɾ��
	public abstract void warehouseInfDelete(int number);

	// �ֿ������޸�
	public abstract void warehouseInfupdate(int number, String name, String people, String phone, String address,
			String remarks);
}
