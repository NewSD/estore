package cn.itcast.estore.domain;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;



/**
 * 购物车的实体
 */
public class Cart {
	private Map<String,CartItem> map = new LinkedHashMap<String,CartItem>();
	
	private Double total = 0d;//总计,
	public Map<String,CartItem> getMap(){
		return map;
	}
	public Double getTotal(){
		return total;
	}
	/**
	 * 提供返回Map中的所有的value的值的方法
	 * @return
	 */
	public Collection<CartItem> getCartItems(){
		return map.values();
	}
	
	/**
	 * 将购物项添加到购物车:
	 */
	public void addCart(CartItem cartItem){
		String bid = cartItem.getBook().getBid();
		if(map.containsKey(bid)){
			//如果已经存在:将原有的数量+现在买的数量.
			CartItem cartItemOld = map.get(bid);
			cartItemOld.setCount(cartItemOld.getCount()+cartItem.getCount());
		}else{
			//如果不存在:新添加一个购物项到购物车
			map.put(bid, cartItem);
		}
		//总计=总计+现在购买的购物项的小计的值.
		total += cartItem.getSubtotal();	
	}
	/**
	 * 从购物车中移除购物项
	 */
	public void removeCart(String bid){
		CartItem cartItem = map.remove(bid);
		total -= cartItem.getSubtotal();
	}
	/**
	 * 清空购物车:
	 */
	public void clearCart(){
		map.clear();
		total = 0d;
	}
	
}
