package controller;

//�ֿ����
public interface CWarehouse {

	// �����ֿ�
	public abstract void crateW();

	// ��Ʒ����չʾ
	public abstract void showIn(int NUM);

	// ��Ʒ����չʾ
	public abstract void showOut(int NUM);

	// �ֿ���չʾ
	public abstract void showWhName(int NUM);

	// Ѱ����Ʒ�Ƿ����
	public abstract boolean findGoods(String goodsNum, int NUM);
}
