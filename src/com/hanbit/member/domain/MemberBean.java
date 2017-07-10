package com.hanbit.member.domain;

public class MemberBean {
private String id, pwd, name, ssn;
	
	public void setId(String id){
		this.id = id;
	}
	public void setPwd(String pwd){
		this.pwd = pwd;
	}
	public void setSsn(String ssn){
		this.ssn = ssn;
	}
	public void setName(String name){
		this.name = name;
	}
	//get
	public String getId(){
		return this.id;
	}
	public String getPwd(){
		return this.pwd;
	}
	public String getSsn(){
		return this.ssn;
	}
	public String getName(){
		return this.name;
	}
	
	public String toString(){
		return "id는 "+id+" 이름은 "+name+" 비밀번호는 "+pwd+" ssn은"+ssn+"\n";
	}


}
