
package util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import model.WarehouseInf;

//�ֿ���Ϣ����
public class WarehouseInfUtil {
	private SAXReader saxReader;
	private Document document;
	private Element rootele;
	private File file;

	// ͨ���޲ι����ʼ������
	public WarehouseInfUtil() {
		saxReader = new SAXReader();
		file = new File("WarehouseInf.xml");
		try {
			document = saxReader.read(file);
		} catch (DocumentException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		rootele = document.getRootElement();
	}

	// ��Ӳֿ����XML�ĵ�
	public boolean add(WarehouseInf whif) {
		List<Element> whilist = rootele.elements();

		// ��Ӳֿ�Ԫ��
		Element element = rootele.addElement("warehouse");

		element.addAttribute("id", whilist.size() + 1 + "");
		element.addElement("name").setText(whif.getWIName());
		element.addElement("people").setText(whif.getWIPeople());
		element.addElement("phone").setText(whif.getWIPhone());
		element.addElement("address").setText(whif.getWIAddress());
		element.addElement("remarks").setText(whif.getWIRemarks());
		save2();
		return false;
	}

	// �ֿ������µ�XML�ĵ�
	public void update(int number, String name, String people, String phone, String address, String remarks) {
		List<Element> whilist = rootele.elements();
		// ����Ԫ����numberƥ��
		for (Element whiele : whilist) {
			if (whiele.attributeValue("id").equals(number + "")) {
				whiele.element("name").setText(name);
				whiele.element("people").setText(people);
				whiele.element("phone").setText(phone);
				whiele.element("address").setText(address);
				whiele.element("remarks").setText(remarks);
				break;
			}
		}
		save2();

	}

	// ɾ��Ԫ�ز����µ�XML�ĵ�
	public void delete(int number) {
		List<Element> whilist = rootele.elements();
		// ����Ԫ��
		for (Element whiele : whilist) {
			if (whiele.attributeValue("id").equals(number + "")) {
				rootele.remove(whiele);// �ڸ�Ԫ����ɾ��ָ����Ԫ��
				break;
			}
		}
		save2();
	}

	// ���浽XML�ĵ�
	public boolean save() {
		FileOutputStream files;
		try {
			files = new FileOutputStream(file);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(files, "utf-8"));
			document.write(bw);
			bw.flush();
			bw.close();
			System.out.println("����ɹ�");
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}

		return false;
	}

	// ���浽XML�ĵ�����ʽ
	public boolean save2() {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		try {
			XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(file)), format);
			try {
				writer.write(document);
				writer.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return false;
	}

	// Ԫ��չʾ
	public void show() {
		List<Element> whilist = rootele.elements();
		// ����Ԫ��
		for (Element whiele : whilist) {
			System.out.println(whiele.attributeValue("id") + "\t\t" + whiele.elementText("name") + "\t\t"
					+ whiele.elementText("people") + "\t\t" + whiele.elementText("phone") + "\t\t"
					+ whiele.elementText("address") + "\t\t" + whiele.elementText("remarks"));

		}
	}

	// ����Ŀ��ֿ��Ƿ���ڣ����ڷ���true
	public boolean search(int number) {
		boolean find = false;
		List<Element> whilist = rootele.elements();
		// ����Ԫ����numberƥ��
		for (Element whiele : whilist) {
			if (whiele.attributeValue("id").equals(number + "")) {
				find = true;
				break;
			}
		}
		return find;
	}

	// ����Ŀ��ֿ�����,���زֿ�����WhName
	public String showWhName(int number) {
		String WhName = "";
		List<Element> whilist = rootele.elements();
		// ����Ԫ����numberƥ��
		for (Element whiele : whilist) {
			if (whiele.attributeValue("id").equals(number + "")) {
				WhName = whiele.elementText("name");
				break;
			}
		}
		return WhName;
	}
}
