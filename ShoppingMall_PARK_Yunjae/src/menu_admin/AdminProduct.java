package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminProduct implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("AdminProduct");
		System.out.println("===[ 관리자 : 상품 관리]===");
		System.out.println("[1] 카테고리 관리");
		System.out.println("[2] 아이템 관리");
		System.out.println("[0] 뒤로 가기");
		int sel = Util.getValue("메뉴 입력", 0, 2);
		
		if(sel == 0) {
			System.out.println("관리자 메인메뉴로 갑니다");
			mallCont.setNextMenu("AdminMain");
		}else if(sel == 1) {
			mallCont.setNextMenu("AdminCategory");
		}else if(sel == 2) {
			mallCont.setNextMenu("AdminItem");
		}else {
			return true;
		}
		return false;
	}

}
