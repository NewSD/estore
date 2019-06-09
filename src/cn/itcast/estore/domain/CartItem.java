package cn.itcast.estore.domain;
/**
 * 购物项的实体:
 */
public class CartItem {
	private Book book;//商品:图书
	private Integer count = 0;//数量
	private Double subtotal;//小计
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	
	public Double getSubtotal(){
		return count * book.getPrice();
	}
	@Override
	public String toString() {
		return "CartItem [book=" + book + ", count=" + count + ", subtotal=" + subtotal + "]";
	}
	
	
}
