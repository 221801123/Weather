package com.main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.xier.dto.AddressDTO;
import com.xier.dto.CastDTO;
import com.xier.dto.LiveDTO;
import com.xier.dto.WhetherDTO;
import com.xier.service.WeatherService;
import com.xier.service.impl.WeatherServiceImpl;

/**
 * 入口类
 * @author Wu yongyi
 * 2019-12-24
 */
public class MainClient {
	private static Map<String,String> cityMap=new HashMap<String,String>();//存储城市与编码信息
	private WeatherService weatherService;//
	public MainClient() {
		this.weatherService=new WeatherServiceImpl();//初始化Service实例
		cityMap=this.weatherService.getCityList();//获取城市及编码信息
	}
	
	public static void main(String [] args) {
		while(true) {
			MainClient mainClient=new MainClient();
			System.out.println("==========主窗口===================");
			System.out.println("        1：实况天气查询");//从接口查
			System.out.println("        2：预报天气查询");//从接口查，并存到数据库
			System.out.println("        3：查询所有城市");//从数据库
			System.out.println("        4：修改城市名称");
			System.out.println("        5：退出");
			System.out.print("请输入操作项：");
		    Scanner scan = new Scanner(System.in);
		    String index = scan.nextLine();
		    if("1".equals(index)) {//实况天气查询
		    	System.out.print("请输入城市名称（如：北京市）：");
		    	while(true) {
			    	String cityName = scan.nextLine();
			    	if(!cityMap.containsKey(cityName)) {
			    		System.out.print("城市名称输入错误，请重新输入：");
			    	}else {
			    		String cityCode=cityMap.get(cityName);
			    		//获取实况天气
			    		WhetherDTO whetherDTO=mainClient.weatherService.getWeatherInfoByAdcode(cityCode,"base");
			    		List<LiveDTO> liveList=whetherDTO.getLives();
			    		if(liveList!=null&&liveList.size()>0) {
			    			LiveDTO liveDTO=liveList.get(0);
			    			System.out.println(liveDTO);
			    			break;
			    		}
			    	}
		    	}
		    }else if("2".equals(index)) {
		    	System.out.print("请输入城市名称（如：北京市）：");
		    	while(true) {
			    	String cityName = scan.nextLine();
			    	if(!cityMap.containsKey(cityName)) {
			    		System.out.print("城市名称输入错误，请重新输入：");
			    	}else {
			    		String cityCode=cityMap.get(cityName);
			    		//获取实况天气
			    		WhetherDTO whetherDTO=mainClient.weatherService.getWeatherInfoByAdcode(cityCode,"all");
			    		List<AddressDTO> forecasts=whetherDTO.getForecasts();
			    		if(forecasts!=null&&forecasts.size()>0) {
			    			AddressDTO addressDTO=forecasts.get(0);
			    			List<CastDTO> casts=addressDTO.getCasts();
			    			System.out.println("==日期===白天天气现象=晚上天气现象=白天温度=晚上温度=白天风向=晚上风向=白天风力=晚上风力");
			    			for(CastDTO cast:casts) {
                                StringBuffer sb=new StringBuffer();
			    				sb.append(cast.getDate()).append("     ").append(cast.getDayweather()).append("      ").append(cast.getNightweather());
			    				sb.append("         ").append(cast.getDaytemp()).append("         ").append(cast.getNighttemp()).append("         ").append(cast.getDaywind());
			    				sb.append("      ").append(cast.getNightwind()).append("      ").append(cast.getDaypower()).append("      ").append(cast.getNightpower());
                                System.out.println(sb.toString());
			    			}
			    		}
			    		break;
			    	}
		    	}
		    }else if("3".equals(index)) {
		    	System.out.println("序号    编号    城市");
		    	int i=0;//序号
		    	//获取所有的key
		    	Set<String> keySet=cityMap.keySet();
		    	for(String key:keySet) {
		    		String value=cityMap.get(key);
		    		i=i+1;
		    		if(i<10) {//当序号为一位数字时，前面补充0
		    			System.out.println("0"+i+"    "+value+"    "+key);
		    		}else {
		    			System.out.println(i+"    "+value+"    "+key);
		    		}
		    	}
		    }else if("4".equals(index)) {
		    	System.out.print("请输入要修改的城市名称（如：北京市）：");
		    	while(true) {
			    	String cityName = scan.nextLine();
			    	if(!cityMap.containsKey(cityName)) {
			    		System.out.print("城市名称输入错误，请重新输入：");
			    	}else {
			    		System.out.print("请输入修改后的城市名称（注意城市名称不可以重复，可以在主窗口查询目前的所有城市信息。）：");
			    		while(true) {
			    			String newCityName = scan.nextLine();
					    	if(cityMap.containsKey(newCityName)) {
					    		System.out.print("城市名称和已有城市名称重复，请重新输入：");
					    	}else {//修改成功
					    		String cityCode=cityMap.get(cityName);
					    		boolean flag=mainClient.weatherService.updateCityName(cityCode, newCityName);
					    		if(flag) {
					    			System.out.println("修改成功");
					    		}else {
					    			System.out.println("修改失败");
					    		}
					    		break;
					    	}
			    		}
			    		break;
			    	}
		    	}
		    }else if("5".equals(index)) {
		    	break;
		    }else {
		    	System.out.println("输入错误！");
		    	System.out.println("输入R返回主窗口,输入其它字符结束。请输入：");
		    	String isNext = scan.nextLine();
		    	if(!"R".equalsIgnoreCase(isNext)) {
		    		break;
		    	}
		    }
		}
	}
	
}
