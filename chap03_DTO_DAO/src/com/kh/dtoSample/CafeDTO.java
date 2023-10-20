package com.kh.dtoSample;
// CafeDTO : 데이터 전송 객체
public class CafeDTO {
	/*
	  model sql 열 형식에 맞춰 데이터를 캡슐화하고 getter setter 를 활용하여 데이터를 저장하고 내보내는 공간
	 */

	// 필드 멤버변수 작성
	private int cafeId;
	private String name;
	private String address;
	private String phoneNumber;
	private String operatingHours;
	
	// 생성자 
	//1. 기본 생성자
	public CafeDTO() {}
	
	//2. 파라미터 값을 받을 생성자
	public CafeDTO(int cafeId, String name, String address, String phoneNumber, String operatingHours) {
		this.cafeId = cafeId;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.operatingHours = operatingHours;
	}
	
	//Getter Setter 메서드
	public int getCafeId() {
		return cafeId;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getOperatingHours() {
		return operatingHours;
	}

	public void setCafeId(int cafeId) {
		this.cafeId = cafeId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setOperatingHours(String operatingHours) {
		this.operatingHours = operatingHours;
	}
	
	
	// @Override를 활용한 toString 메서드 추가
	@Override
	public String toString() {
		return "CafeDTO" + cafeId;
		
	}
	
}
