package com.xier.dto;

import java.io.Serializable;

public class LiveDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	private String province;//省份名
	private String city;//城市名
	private String adcode;//区域编码
	private String weather;//天气现象（汉字描述）
	private String temperature;//实时气温，单位：摄氏度
	private String winddirection;//风向描述
	private String windpower;//风力级别，单位：级
	private String humidity;//空气湿度
	private String reporttime;//数据发布的时间
	
	@Override
	public String toString() {
		return this.province+this.city+"; 天气现象："+this.weather+"; 实时气温："+this.temperature+"; 风向："+this.winddirection+"; 风力："
	           +this.windpower+"; 空气湿度："+this.humidity+"; 发布时间："+this.reporttime;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
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
	public String getWeather() {
		return weather;
	}
	public void setWeather(String weather) {
		this.weather = weather;
	}
	public String getTemperature() {
		return temperature;
	}
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}
	public String getWinddirection() {
		return winddirection;
	}
	public void setWinddirection(String winddirection) {
		this.winddirection = winddirection;
	}
	public String getWindpower() {
		return windpower;
	}
	public void setWindpower(String windpower) {
		this.windpower = windpower;
	}
	public String getHumidity() {
		return humidity;
	}
	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}
	public String getReporttime() {
		return reporttime;
	}
	public void setReporttime(String reporttime) {
		this.reporttime = reporttime;
	}

}
