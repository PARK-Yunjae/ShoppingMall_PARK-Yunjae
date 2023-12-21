package dto;

public class Item {
	private static int num;
	private int itemNum;
	private String categoriName;
	private String itemName;
	private int price;
	
	public Item() {
	}
	
	private Item(String itemNum, String categoriName, String itemName, String price) {
		super();
		this.itemNum = Integer.parseInt(itemNum);
		this.categoriName = categoriName;
		this.itemName = itemName;
		this.price = Integer.parseInt(price);
	}
	
	public Item( String categoriName, String itemName, String price) {
		this.itemNum = ++num;
		this.categoriName = categoriName;
		this.itemName = itemName;
		this.price = Integer.parseInt(price);
	}
}
