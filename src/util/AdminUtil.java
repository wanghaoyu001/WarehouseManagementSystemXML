package util;

import java.io.File;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class AdminUtil {
	private SAXReader saxReader;
	private Document document;
	private Element rootele;
	private File file;

	// 通过无参构造初始化对象
	public AdminUtil() {
		saxReader = new SAXReader();
		file = new File("Admin.xml");
		try {
			document = saxReader.read(file);
		} catch (DocumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		rootele = document.getRootElement();
	}

	// 登录(匹配用户名与密码)
	public boolean login(String account, String password) {
		boolean flag = false;
		List<Element> adminlist = rootele.elements();
		// 遍历元素与account,password匹配
		for (Element adminele : adminlist) {
			if (adminele.elementText("account").equals(account) && adminele.elementText("password").equals(password)) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	// 根据账号匹配用户名称
	public String compareName(String account) {
		List<Element> adminlist = rootele.elements();
		String name = "";
		for (Element adminele : adminlist) {
			if (adminele.elementText("account").equals(account)) {
				name = adminele.elementText("name");
				break;
			}
		}
		return name;
	}
}
