package com.xier.dto;

import java.io.Serializable;

public class Geocode implements Serializable{
	private String formatted_address;//�ṹ����ַ��Ϣʡ�ݣ����У����أ�������士�ֵ������ƺ���
	private String country;//���� ���ڵ�ַĬ�Ϸ����й�
	private String province;//��ַ���ڵ�ʡ���� ���磺�����С��˴���Ҫע����ǣ��й����Ĵ�ֱϽ��Ҳ����ʡ����λ��
	private String city;//��ַ���ڵĳ����� ���磺������
	private String citycode;//���б���
	private String district;//��ַ���ڵ���
	private String street;//�ֵ� ���磺��ͨ�����
	private String number;//���� ���磺6��
	private String adcode;//�������
	private String location;//����� ���ȣ�γ��
	private String level;//ƥ�伶��
	public String getFormatted_address() {
		return formatted_address;
	}
	public void setFormatted_address(String formatted_address) {
		this.formatted_address = formatted_address;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
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
	public String getCitycode() {
		return citycode;
	}
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getAdcode() {
		return adcode;
	}
	public void setAdcode(String adcode) {
		this.adcode = adcode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
}
