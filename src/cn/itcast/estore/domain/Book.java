package cn.itcast.estore.domain;
//图书
public class Book {
	public Double getPrice() {
		return price;
	}
	private String bid;//图书id
	private String bname;//书名
	private Double price;//价格
	private String author;//作者
	private String image;//图片的url
	private String cid;//外键:分类id
	private int isdel;// isdel 0:上架   1:下架
	public String getBid() {
		return bid;
	}
	public void setBid(String bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public int getIsdel() {
		return isdel;
	}
	public void setIsdel(int isdel) {
		this.isdel = isdel;
	}
	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", price=" + price + ", author=" + author + ", image=" + image
				+ ", cid=" + cid + ", isdel=" + isdel + "]";
	}
	
}
