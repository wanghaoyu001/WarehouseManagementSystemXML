
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

//仓库信息管理
public class WarehouseInfUtil {
	private SAXReader saxReader;
	private Document document;
	private Element rootele;
	private File file;

	// 通过无参构造初始化对象
	public WarehouseInfUtil() {
		saxReader = new SAXReader();
		file = new File("WarehouseInf.xml");
		try {
			document = saxReader.read(file);
		} catch (DocumentException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		rootele = document.getRootElement();
	}

	// 添加仓库对象到XML文档
	public boolean add(WarehouseInf whif) {
		List<Element> whilist = rootele.elements();

		// 添加仓库元素
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

	// 仓库对象更新到XML文档
	public void update(int number, String name, String people, String phone, String address, String remarks) {
		List<Element> whilist = rootele.elements();
		// 遍历元素与number匹配
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

	// 删除元素并更新到XML文档
	public void delete(int number) {
		List<Element> whilist = rootele.elements();
		// 遍历元素
		for (Element whiele : whilist) {
			if (whiele.attributeValue("id").equals(number + "")) {
				rootele.remove(whiele);// 在根元素中删除指定的元素
				break;
			}
		}
		save2();
	}

	// 保存到XML文档
	public boolean save() {
		FileOutputStream files;
		try {
			files = new FileOutputStream(file);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(files, "utf-8"));
			document.write(bw);
			bw.flush();
			bw.close();
			System.out.println("保存成功");
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

		return false;
	}

	// 保存到XML文档带格式
	public boolean save2() {
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("GBK");
		try {
			XMLWriter writer = new XMLWriter(new OutputStreamWriter(new FileOutputStream(file)), format);
			try {
				writer.write(document);
				writer.close();
			} catch (IOException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return false;
	}

	// 元素展示
	public void show() {
		List<Element> whilist = rootele.elements();
		// 遍历元素
		for (Element whiele : whilist) {
			System.out.println(whiele.attributeValue("id") + "\t\t" + whiele.elementText("name") + "\t\t"
					+ whiele.elementText("people") + "\t\t" + whiele.elementText("phone") + "\t\t"
					+ whiele.elementText("address") + "\t\t" + whiele.elementText("remarks"));

		}
	}

	// 查找目标仓库是否存在，存在返回true
	public boolean search(int number) {
		boolean find = false;
		List<Element> whilist = rootele.elements();
		// 遍历元素与number匹配
		for (Element whiele : whilist) {
			if (whiele.attributeValue("id").equals(number + "")) {
				find = true;
				break;
			}
		}
		return find;
	}

	// 查找目标仓库名称,返回仓库名称WhName
	public String showWhName(int number) {
		String WhName = "";
		List<Element> whilist = rootele.elements();
		// 遍历元素与number匹配
		for (Element whiele : whilist) {
			if (whiele.attributeValue("id").equals(number + "")) {
				WhName = whiele.elementText("name");
				break;
			}
		}
		return WhName;
	}
}
