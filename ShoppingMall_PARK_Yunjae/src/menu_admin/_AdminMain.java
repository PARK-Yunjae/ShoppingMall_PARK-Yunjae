package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class _AdminMain implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("===[ 관리자 ]===");
		System.out.println("[1] 회원관리"); 
		System.out.println("[2] 상품관리"); 
		System.out.println("[3] 게시판관리");
		System.out.println("[4] 파일저장");
		System.out.println("[5] 파일저장");
		System.out.println("[0] 로그아웃");
		int sel = Util.getValue("메뉴 입력", 0, 5);
		
		if(sel == 0) {
			System.out.println("관리자 로그아웃");
			mallCont.setId("");
			mallCont.setNextMenu("MallMain");
		}else if(sel == 1) {
			mallCont.setNextMenu("AdminMember");
		}else if(sel == 2) {
			mallCont.setNextMenu("AdminProduct");
		}else if(sel == 3) {
			mallCont.setNextMenu("AdminBoard");
		}else if(sel == 4) {
			mallCont.setNextMenu("AdminFileSave");
		}else if(sel == 5) {
			mallCont.setNextMenu("AdminFileLoad");
		}else {
			return true;
		}
		return false;
	}
}
