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

	// ͨ���޲ι����ʼ������
	public AdminUtil() {
		saxReader = new SAXReader();
		file = new File("Admin.xml");
		try {
			document = saxReader.read(file);
		} catch (DocumentException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		rootele = document.getRootElement();
	}

	// ��¼(ƥ���û���������)
	public boolean login(String account, String password) {
		boolean flag = false;
		List<Element> adminlist = rootele.elements();
		// ����Ԫ����account,passwordƥ��
		for (Element adminele : adminlist) {
			if (adminele.elementText("account").equals(account) && adminele.elementText("password").equals(password)) {
				flag = true;
				break;
			}
		}

		return flag;
	}

	// �����˺�ƥ���û�����
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
