package com.xier.dao.factory;

import com.xier.dao.WeatherDAO;
import com.xier.dao.impl.WeatherDAOImpl;

/**
 * DAO工厂
 * @author Wu yongyi
 * 2019-12-23
 */
public class DAOFactory {
	public static WeatherDAO getWeatherDAO(){
		 return new WeatherDAOImpl();
	}
}
