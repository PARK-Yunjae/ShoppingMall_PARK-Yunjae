package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminBoard implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		System.out.println("===[ 관리자 : 게시판 관리 ]===");
		System.out.println("[1] 게시글 삭제"); 
		System.out.println("[2] 게시판 목록"); 
		System.out.println("[0] 뒤로 가기");
		int sel = Util.getValue("메뉴 입력", 0, 2);
		
		if(sel == 0) {
			System.out.println("관리자 메인메뉴로 갑니다");
			mallCont.setNextMenu("AdminMain");
		}else if(sel == 1) {
			mallCont.setNextMenu("AdminBoardDelete");
		}else if(sel == 2) {
			mallCont.setNextMenu("AdminBoardList");
		}else {
			return true;
		}
		return false;
	}
}
