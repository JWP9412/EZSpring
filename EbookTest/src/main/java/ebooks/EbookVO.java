package ebooks;

public class EbookVO {
	private Integer serial;
	private String title;
	private String author;
	private Integer price;
	private Integer qty;
	
	public EbookVO() {}
	
	public EbookVO(Integer serial, String title, String author, Integer price, Integer qty) {
		this.serial = serial;
		this.title = title;
		this.author = author;
		this.price = price;
		this.qty = qty;
	}
	
	
	
	public Integer getSerial() {
		return serial;
	}
	public void setSerial(Integer serial) {
		this.serial = serial;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
}
