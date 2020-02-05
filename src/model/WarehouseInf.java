package model;

import java.io.Serializable;

public class WarehouseInf implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1346769400311255540L;
	private String WIName;// 仓库名称
	private String WIPeople;// 仓库负责人
	private String WIPhone;// 联系电话
	private String WIAddress;// 地址
	private String WIRemarks;// 备注

	public WarehouseInf() {
		super();
		// TODO 自动生成的构造函数存根
	}

	public WarehouseInf(String wIName, String wIPeople, String wIPhone, String wIAddress, String wIRemarks) {
		super();
		WIName = wIName;
		WIPeople = wIPeople;
		WIPhone = wIPhone;
		WIAddress = wIAddress;
		WIRemarks = wIRemarks;
	}

	public String getWIName() {
		return WIName;
	}

	public void setWIName(String wIName) {
		WIName = wIName;
	}

	public String getWIPeople() {
		return WIPeople;
	}

	public void setWIPeople(String wIPeople) {
		WIPeople = wIPeople;
	}

	public String getWIPhone() {
		return WIPhone;
	}

	public void setWIPhone(String wIPhone) {
		WIPhone = wIPhone;
	}

	public String getWIAddress() {
		return WIAddress;
	}

	public void setWIAddress(String wIAddress) {
		WIAddress = wIAddress;
	}

	public String getWIRemarks() {
		return WIRemarks;
	}

	public void setWIRemarks(String wIRemarks) {
		WIRemarks = wIRemarks;
	}

}
