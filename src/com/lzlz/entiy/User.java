package com.lzlz.entiy;

public class User {
	private int uid;
	private String username;
	private String password;
	private String netname;
	private String relname;
	private String gender;
	private String about;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int uid, String username, String password, String netname, String relname, String gender,
			String about) {
		super();
		this.uid = uid;
		this.username = username;
		this.password = password;
		this.netname = netname;
		this.relname = relname;
		this.gender = gender;
		this.about = about;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNetname() {
		return netname;
	}

	public void setNetname(String netname) {
		this.netname = netname;
	}

	public String getRelname() {
		return relname;
	}

	public void setRelname(String relname) {
		this.relname = relname;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", password=" + password + ", netname=" + netname
				+ ", relname=" + relname + ", gender=" + gender + ", about=" + about + "]";
	}

}
