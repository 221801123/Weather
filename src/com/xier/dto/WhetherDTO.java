package com.xier.dto;

import java.io.Serializable;
import java.util.List;
/**
 * 查询天气接口返回结果参数说明
 * @author Wu yongyi
 * 2019-12-24
 */
public class WhetherDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String status;//返回状态 值为0或1 1：成功；0：失败
	private String count;//返回结果总数目
	private String info;//返回的状态信息
	private String infocode;//返回状态说明,10000代表正确
	private List<LiveDTO> lives;//实况天气数据信息
	private List<AddressDTO> forecasts;//预报天气信息数据
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public String getInfocode() {
		return infocode;
	}
	public void setInfocode(String infocode) {
		this.infocode = infocode;
	}
	public List<LiveDTO> getLives() {
		return lives;
	}
	public void setLives(List<LiveDTO> lives) {
		this.lives = lives;
	}
	public List<AddressDTO> getForecasts() {
		return forecasts;
	}
	public void setForecasts(List<AddressDTO> forecasts) {
		this.forecasts = forecasts;
	}
}
