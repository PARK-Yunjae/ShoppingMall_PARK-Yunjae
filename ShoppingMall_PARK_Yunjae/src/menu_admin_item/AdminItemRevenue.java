package menu_admin_item;

import _mall.MenuCommand;
import controller.MallController;
import dao.CartDAO;
import dao.ItemDAO;

public class AdminItemRevenue implements MenuCommand {
	private MallController cont = MallController.getInstance();

	@Override
	public boolean update() {
		ItemDAO iDAO = ItemDAO.getInstance();
		CartDAO cDAO = CartDAO.getInstance();
		
		cont.setNext("AdminItem");
		// ItemDAO에서 일단 itemNum개수만큼 번호도 저장해서 배열로 받아옴
		int[][] arr = iDAO.itemNumList();
		cDAO.ItemRevenue(arr);
		// arr[itemList.size()][3] 
		// 0번엔 아이템 번호 1번엔 개수 2번엔 랭크
		iDAO.ItemRevenue(arr); 
		return false;
	}
}
