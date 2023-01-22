package com.ssafy.ws.step4.chapter5;

public class Restaurant {
	private int resid;
	private String name;
	private String address;
	private String signatureMenu;
	private int rate;
	
	//기본 생성자
	public Restaurant() {}
	
	//생성자 선언
	public Restaurant(int resid, String name, String address, String signatureMenu ,int rate) {
		this.resid = resid;
		this.name = name;
		this.address = address;
		this.signatureMenu = signatureMenu;
		this.rate = rate;
	}
	
	//Encapsulation
	/**
	 * @return the resid
	 */
	public int getResid() {
		return resid;
	}

	/**
	 * @param resid the resid to set
	 */
	public void setResid(int resid) {
		this.resid = resid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the signatureMenu
	 */
	public String getSignatureMenu() {
		return signatureMenu;
	}

	/**
	 * @param signatureMenu the signatureMenu to set
	 */
	public void setSignatureMenu(String signatureMenu) {
		this.signatureMenu = signatureMenu;
	}

	/**
	 * @return the rate
	 */
	public int getRate() {
		return rate;
	}

	/**
	 * @param rate the rate to set
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}
	
	//toString_override
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Restaurant [resid=");
		builder.append(resid);
		builder.append(", name=");
		builder.append(name);
		builder.append(", address=");
		builder.append(address);
		builder.append(", signatureMenu=");
		builder.append(signatureMenu);
		builder.append(", rate=");
		builder.append(rate);
		builder.append("]");
		return builder.toString();
	}
}
