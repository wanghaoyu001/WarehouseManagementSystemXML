package controller;

//��¼
public interface Login {
	// �ж��˺������Ƿ���ȷ
	public abstract boolean login(String account, String password);

	// �����˺�ƥ���û�����
	public abstract String compareName(String account);
}
