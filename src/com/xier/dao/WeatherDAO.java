package com.xier.dao;

import java.util.Map;

import com.xier.dto.AddressDTO;

/**
 * 天气DAO接口
 * @author Wu yongyi
 * 2019-12-23
 */
public interface WeatherDAO {
	/**
	 * 根据adcode获得主表对应的主键
	 * @param adcode
	 * @return
	 */
	public int queryAddressByAdcode(String adcode);
	/**
	 * 保存预报天气信息中的地址信息
	 * @param addressDTO
	 * @return
	 */
	public boolean saveAddress(AddressDTO addressDTO);
	/**
	 * 保存天气信息
	 * @param addressDTO
	 * @return
	 */
	public boolean saveWeather(AddressDTO addressDTO);
	/**
	 * 删除子表信息
	 * @param forecastId
	 * @return
	 */
	public boolean deleteWeather(int forecastId);
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
