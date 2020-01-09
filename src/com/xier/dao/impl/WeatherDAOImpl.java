package com.xier.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xier.dao.WeatherDAO;
import com.xier.dto.AddressDTO;
import com.xier.dto.CastDTO;
import com.xier.util.DBUtil;
/**
 * 天气DAO接口实现类
 * @author Wu yongyi
 * 2019-12-23
 */
public class WeatherDAOImpl implements WeatherDAO{
    private DBUtil dbUtil;
    public WeatherDAOImpl(){
  	  this.dbUtil=new DBUtil();
    }
    
	@Override
	public int queryAddressByAdcode(String adcode) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select t.id from t_forecast t where t.adcode=?";
		int id=0;
		try{
			conn=dbUtil.getConnection();
			pstmt=dbUtil.getPstmt(conn, sql);
			pstmt.setString(1,adcode);
			rs=pstmt.executeQuery();
	        if(rs.next()){
	        	id=rs.getInt("id");
	        }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closePreparedStatement(pstmt);
			dbUtil.closeConnection(conn);
		}
		return id;
	}
    
	@Override
	public boolean saveWeather(AddressDTO addressDTO) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into t_forecast_detail(forecast_id,date,week,day_weather,night_weather,day_temp,night_temp,day_wind,night_wind,day_power,night_power,valid_flag,created_by,created_date,updated_by,updated_date) values (?,DATE_FORMAT(?,'%Y-%m-%d'),?,?,?,?,?,?,?,?,?,'Y','admin',now(),'admin',now())";
		try{
			conn=dbUtil.getConnection();
			pstmt=dbUtil.getPstmt(conn, sql);
			List<CastDTO> casts=addressDTO.getCasts();
			for(CastDTO cast:casts) {
				pstmt.setInt(1,addressDTO.getId());
				pstmt.setString(2,cast.getDate());
				pstmt.setString(3,cast.getWeek());
				pstmt.setString(4,cast.getDayweather());
				pstmt.setString(5,cast.getNightweather());
				pstmt.setInt(6,Integer.parseInt(cast.getDaytemp()));
				pstmt.setInt(7,Integer.parseInt(cast.getNighttemp()));
				pstmt.setString(8,cast.getDaywind());
				pstmt.setString(9,cast.getNightwind());
				pstmt.setString(10,cast.getDaypower());
				pstmt.setString(11,cast.getNightpower());
				pstmt.addBatch();
			}
			int num[]=pstmt.executeBatch();
			if(num.length==casts.size()) {
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		    return false;
		}finally{
			dbUtil.closePreparedStatement(pstmt);
			dbUtil.closeConnection(conn);
		}
		return false;
	}

	@Override
	public boolean saveAddress(AddressDTO addressDTO) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="insert into t_forecast(city,adcode,province,report_time,valid_flag,created_by,created_date,updated_by,updated_date)values(?,?,?,DATE_FORMAT(?,'%Y-%m-%d %H:%i:%s'),'Y','admin',now(),'admin',now())";
		try{
			conn=dbUtil.getConnection();
			pstmt=dbUtil.getPstmt(conn, sql);
			pstmt.setString(1,addressDTO.getCity());
			pstmt.setString(2,addressDTO.getAdcode());
			pstmt.setString(3,addressDTO.getProvince());
			pstmt.setString(4,addressDTO.getReporttime());
			int num=pstmt.executeUpdate();
			if(num>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		    return false;
		}finally{
			dbUtil.closePreparedStatement(pstmt);
			dbUtil.closeConnection(conn);
		}
		return false;
	}
	
	public boolean deleteWeather(int forecastId) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="DELETE FROM t_forecast_detail WHERE forecast_id=?";
		try{
			conn=dbUtil.getConnection();
			pstmt=dbUtil.getPstmt(conn, sql);
			pstmt.setInt(1, forecastId);
			int num=pstmt.executeUpdate();
			if(num>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		    return false;
		}finally{
			dbUtil.closePreparedStatement(pstmt);
			dbUtil.closeConnection(conn);
		}
		return false;
	}

	@Override
	public Map<String,String> getCityList() {
		Map<String,String> map=new HashMap<String,String>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		String sql="select t.name,t.code from t_city_code t";
		try{
			conn=dbUtil.getConnection();
			pstmt=dbUtil.getPstmt(conn, sql);
			rs=pstmt.executeQuery();
	        while(rs.next()){
	        	String name=rs.getString("name");
	        	String code=rs.getString("code");
	        	map.put(name, code);
	        }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbUtil.closeResultSet(rs);
			dbUtil.closePreparedStatement(pstmt);
			dbUtil.closeConnection(conn);
		}
		return map;
	}
	
	public boolean updateCityName(String cityCode,String cityName) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		String sql="UPDATE t_city_code t SET t.name=? WHERE t.code=?";
		try{
			conn=dbUtil.getConnection();
			pstmt=dbUtil.getPstmt(conn, sql);
			pstmt.setString(1,cityName);
			pstmt.setString(2,cityCode);
			int num=pstmt.executeUpdate();
			if(num>0)
				return true;
		}catch(Exception e){
			e.printStackTrace();
		    return false;
		}finally{
			dbUtil.closePreparedStatement(pstmt);
			dbUtil.closeConnection(conn);
		}
		return false;
	}
}
