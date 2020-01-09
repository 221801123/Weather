package com.xier.service.impl;

import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.xier.dao.factory.DAOFactory;
import com.xier.dto.WhetherDTO;
import com.xier.service.WeatherService;
import com.xier.util.HttpUtil;
/**
 * 天气Service接口实现类
 * @author Wu yongyi
 * 2019-12-23
 */
public class WeatherServiceImpl implements WeatherService {
	@Override
	public WhetherDTO getWeatherInfoByAdcode(String adcode,String type) {
		WhetherDTO whetherDTO=null;
		try {
			String serviceUrl="https://restapi.amap.com/v3/weather/weatherInfo?city="+adcode+"&key=7dc3cad79ac631e10be1b35f5f0dd1b1&extensions="+type;
			String outMsg=HttpUtil.httpGet(serviceUrl);
			whetherDTO=JSON.parseObject(outMsg, WhetherDTO.class);
			if("all".equals(type)) {//只保存预报信息，不保存实况天气
				//先获取主表主键，若不存在，则主表新增一条数据，然后再取主表主键，用于保存到子表中做外键
				int id=DAOFactory.getWeatherDAO().queryAddressByAdcode(adcode);
				if(id<1) {
					DAOFactory.getWeatherDAO().saveAddress(whetherDTO.getForecasts().get(0));
					id=DAOFactory.getWeatherDAO().queryAddressByAdcode(adcode);
				}else {//先删除老数据
					DAOFactory.getWeatherDAO().deleteWeather(id);
				}
				whetherDTO.getForecasts().get(0).setId(id);
				//保存天气预报信息
				DAOFactory.getWeatherDAO().saveWeather(whetherDTO.getForecasts().get(0));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			
		}
		return whetherDTO;
	}
	@Override
	public Map<String, String> getCityList() {
		return DAOFactory.getWeatherDAO().getCityList();
	}
	@Override
	public boolean updateCityName(String cityCode, String cityName) {
		return DAOFactory.getWeatherDAO().updateCityName(cityCode, cityName);
	}
	

}
