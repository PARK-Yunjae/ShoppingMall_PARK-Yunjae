package dao;

import java.util.ArrayList;

import dto.Cart;

public class CartDAO {
	private ArrayList<Cart> cList;

	public CartDAO() {
		cList = new ArrayList<Cart>();
	}

	public ArrayList<Cart> getcList() {
		return cList;
	}

	// 회원 삭제 시 카트 날리기
	public void DeleteMember(String id) {
		if (cList.size() == 0)
			return;

		for (int i = 0; i < cList.size(); i += 1) {
			if (cList.get(i).getId().equals(id)) {
				cList.remove(i);
				i--;
			}
		}
	}

	// 아이템 삭제시 카트 아이템도 삭제
	public void DeleteItem(int itemNum) {
		if (cList.size() == 0)
			return;
		for (int i = 0; i < cList.size(); i += 1) {
			if (cList.get(i).getItemNum() == itemNum) {
				cList.remove(i);
				i--;
			}
		}
	}
	// 카테고리 삭제시 안에 있는 아이템 넘버들 받아와서 다 삭제
	public void DeleteCategory(ArrayList<Integer> iNumList) {
		if (iNumList.size() == 0)
			return;
		for (int i = 0; i < cList.size(); i += 1) {
			for(int k = 0 ; k<iNumList.size() ; k+=1) {
				if(cList.get(i).getItemNum() == iNumList.get(k)) {
					cList.remove(i);
					i--;
					break;
				}
			}
		}
	}
	
	// 텍스트 파일 저장용 데이터 만들기
	public String DataToFile() {
		String data = "";
		if(cList.size() == 0) return data;
		for(Cart c : cList) {
			data += c.DataToFile() + "\n";
		}
		data = data.substring(0, data.length()-1);
		return data;
	}
	
	// 텍스트파일에서 문자열 받아와서 데이터 넣기
	public void FileToData(String data) {
		String datas[] = data.split("\n");
		cList.clear();
		for(int i=0 ; i<datas.length ; i+=1) {
			Cart c = new Cart();
			String[] info = datas[i].split("/");
			c = c.CreateCart(info);
			cList.add(c);
		}
	}
}
