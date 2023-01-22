package com.ssafy.ws.step4.chapter4;

public class Restaurant {
	private	int resid;
	private String name;
	private String adress;
	private String signatureMenu;
	private int rate;
	
	//기본 생성자
	public Restaurant() {}
	
	//생성자 선언
	public Restaurant(int resid, String name, String adress, String signatureMenu, int rate) {
		this.resid = resid;
		this.name = name;
		this.adress = adress;
		this.signatureMenu = signatureMenu;
		this.rate = rate;
	}

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
		builder.append(", adress=");
		builder.append(adress);
		builder.append(", signatureMenu=");
		builder.append(signatureMenu);
		builder.append(", rate=");
		builder.append(rate);
		builder.append("]");
		return builder.toString();
	}
}
