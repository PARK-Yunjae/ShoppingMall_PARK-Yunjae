package dto;

public class Item {
	private static int num;
	private int itemNum;
	private String categoriName;
	private String itemName;
	private int price;
	
	public Item() {
	}
	
	public int getItemNum() {
		return itemNum;
	}

	public String getCategoriName() {
		return categoriName;
	}

	public String getItemName() {
		return itemName;
	}

	public int getPrice() {
		return price;
	}

	public Item( String categoriName, String itemName, String price) {
		this.itemNum = ++num;
		this.categoriName = categoriName;
		this.itemName = itemName;
		this.price = Integer.parseInt(price);
	}
	
	private Item(String itemNum, String categoriName, String itemName, String price) {
		super();
		this.itemNum = Integer.parseInt(itemNum);
		this.categoriName = categoriName;
		this.itemName = itemName;
		this.price = Integer.parseInt(price);
	}
	
	public Item CreateItem(String[] info) {
		if(info == null || info.length == 0) return null;
		
		return new Item(info[0], info[1], info[2], info[3]);
	}
}
