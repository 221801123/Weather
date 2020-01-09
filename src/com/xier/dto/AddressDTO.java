package com.xier.dto;

import java.io.Serializable;
import java.util.List;

public class AddressDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private int id;//主键
	private String city;//城市名称
	private String adcode;//城市编码
	private String province;//省份名称
	private String reporttime;//预报发布时间
	private List<CastDTO> casts;//预报数据list结构
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAdcode() {
		return adcode;
	}
	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getReporttime() {
		return reporttime;
	}
	public void setReporttime(String reporttime) {
		this.reporttime = reporttime;
	}
	public List<CastDTO> getCasts() {
		return casts;
	}
	public void setCasts(List<CastDTO> casts) {
		this.casts = casts;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
