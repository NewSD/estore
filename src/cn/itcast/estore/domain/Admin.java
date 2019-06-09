package cn.itcast.estore.domain;

//后台管理员实体
public class Admin {
	private String aid;//id
	private String adminname;//用户名
	private String password;//密码
	private String role;//角色
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return "Admin [aid=" + aid + ", adminname=" + adminname + ", password=" + password + ", role=" + role
				+ "]";
	}
	
}
