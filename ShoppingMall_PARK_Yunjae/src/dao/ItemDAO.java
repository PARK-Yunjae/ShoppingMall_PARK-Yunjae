package dao;

import java.util.ArrayList;

import dto.Item;

public class ItemDAO {
	private ArrayList<Item> itemList;
	
	public ItemDAO() {
		itemList = new ArrayList<Item>();
	}
	
	//아이템 이름 중복 - 카테고리이름도 일치
	public int ItemNameValue(String cgName, String iName) {
		if(itemList.size() == 0) return -1;
		for(int i=0 ; i<itemList.size() ; i+=1) {
			String itemName = itemList.get(i).getItemName();
			String categoriName = itemList.get(i).getCategoriName();
			if(itemName.equals(iName) && categoriName.equals(cgName)) {
				return i;
			}
		}
		return -1;
	}
	
	// 아이템 추가
	public void AddItem(String cgName, String iName, String price) {
		itemList.add(new Item(cgName, iName, price));
	}
}
