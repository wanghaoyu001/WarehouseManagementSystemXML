package controller;

//登录
public interface Login {
	// 判断账号密码是否正确
	public abstract boolean login(String account, String password);

	// 根据账号匹配用户名称
	public abstract String compareName(String account);
}
