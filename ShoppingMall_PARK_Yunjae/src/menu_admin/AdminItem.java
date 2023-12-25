package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminItem implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("AdminItem");
		System.out.println("===[ 관리자 : 아이템 관리]===");
		System.out.println("[1] 아이템 추가");
		System.out.println("[2] 아이템 수정");
		System.out.println("[3] 아이템 삭제");
		System.out.println("[4] 아이템 목록");
		System.out.println("[0] 뒤로 가기");
		int sel = Util.getValue("메뉴 입력", 0, 4);
		
		if(sel == 0) {
			System.out.println("관리자 상품관리로 갑니다");
			mallCont.setNextMenu("AdminProduct");
		}else if(sel == 1) {
			mallCont.setNextMenu("AdminItemAdd");
		}else if(sel == 2) {
			mallCont.setNextMenu("AdminItemUpdate");
		}else if(sel == 3) {
			mallCont.setNextMenu("AdminItemDelete");
		}else if(sel == 4) {
			mallCont.setNextMenu("AdminItemList");
		}else {
			return true;
		}
		return false;
	}
}
