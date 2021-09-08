package com.solero.stsrestful.s01;

public class MemberVO {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private Integer age;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		String str = String.format("[MemberVO] id(%s), pwd(%s), name(%s), email(%s), age(%d)\n",
				id, pwd, name, email, age);
		return str;
	}
	
}
