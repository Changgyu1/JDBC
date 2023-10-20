package com.kh.dtoSample;
// CafeDTO : ������ ���� ��ü
public class CafeDTO {
	/*
	  model sql �� ���Ŀ� ���� �����͸� ĸ��ȭ�ϰ� getter setter �� Ȱ���Ͽ� �����͸� �����ϰ� �������� ����
	 */

	// �ʵ� ������� �ۼ�
	private int cafeId;
	private String name;
	private String address;
	private String phoneNumber;
	private String operatingHours;
	
	// ������ 
	//1. �⺻ ������
	public CafeDTO() {}
	
	//2. �Ķ���� ���� ���� ������
	public CafeDTO(int cafeId, String name, String address, String phoneNumber, String operatingHours) {
		this.cafeId = cafeId;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.operatingHours = operatingHours;
	}
	
	//Getter Setter �޼���
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
	
	
	// @Override�� Ȱ���� toString �޼��� �߰�
	@Override
	public String toString() {
		return "CafeDTO" + cafeId;
		
	}
	
}
