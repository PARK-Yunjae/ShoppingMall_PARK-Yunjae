package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminCategory implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("===[ 관리자 : 카테고리 관리]===");
		System.out.println("[1] 카테고리 추가");
		System.out.println("[2] 카테고리 수정");
		System.out.println("[3] 카테고리 삭제");
		System.out.println("[4] 카테고리 목록");
		System.out.println("[0] 뒤로 가기");
		int sel = Util.getValue("메뉴 입력", 0, 4);
		
		if(sel == 0) {
			System.out.println("관리자 상품관리로 갑니다");
			mallCont.setNextMenu("AdminProduct");
		}else if(sel == 1) {
			mallCont.setNextMenu("AdminCategoryAdd");
		}else if(sel == 2) {
			mallCont.setNextMenu("AdminCategoryUpdate");
		}else if(sel == 3) {
			mallCont.setNextMenu("AdminCategoryDelete");
		}else if(sel == 4) {
			mallCont.setNextMenu("AdminCategoryList");
		}else {
			return true;
		}
		return false;
	}
}
