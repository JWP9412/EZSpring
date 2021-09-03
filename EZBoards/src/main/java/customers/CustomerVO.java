/*
 * MemberVO Value Object
 */
package customers;


public class CustomerVO {
	private String num;
	private String name;
	private String tel;
	private String address;
	

	public CustomerVO() {}

	public CustomerVO(String num, String name, String tel, String address) {
		this.num = num;
		this.name = name;
		this.tel = tel;
		this.address = address;
	}

	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	
}
