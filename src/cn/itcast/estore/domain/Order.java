package cn.itcast.estore.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//订单类
public class Order {
	private String oid;//订单id
	private Double total;//总计
	private Date ordertime;//下单时间
	private Integer state;// 1:未付款   2:已付款,但未发货   3:已经发货,没有确认收货     4:已经确认收货,订单结束
	private String addr;//地址
	private User user;//下单用户
	//表示一个订单中有多个订单项
	private List<OrderItem> orderItems = new ArrayList<OrderItem>();
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public Double getTotal() {
		return total;
	}
	public void setTotal(Double total) {
		this.total = total;
	}
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<OrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<OrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	@Override
	public String toString() {
		return "Order [oid=" + oid + ", total=" + total + ", ordertime=" + ordertime + ", state=" + state + ", addr="
				+ addr + ", user=" + user + ", orderItems=" + orderItems + "]";
	}
	
	
}
