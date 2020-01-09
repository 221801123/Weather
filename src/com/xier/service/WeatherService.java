package com.xier.service;

import java.util.Map;

import com.xier.dto.WhetherDTO;

/**
 * 天气Service接口
 * @author Wu yongyi
 * 2019-12-23
 */
public interface WeatherService {
	/**
	 * 根据adcode获取天气信息
	 * @param adcode
	 * @param type base:返回实况天气；all:返回预报天气
	 * @return
	 */
	public WhetherDTO getWeatherInfoByAdcode(String adcode,String type);
	/**
	 * 获取城市及编码信息
	 * @return
	 */
	public Map<String,String> getCityList();
	/**
	 * 修改城市名称
	 * @param cityCode
	 * @param cityName
	 * @return
	 */
	public boolean updateCityName(String cityCode,String cityName);
}
