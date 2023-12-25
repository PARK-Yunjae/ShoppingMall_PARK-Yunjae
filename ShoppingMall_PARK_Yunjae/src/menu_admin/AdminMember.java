package menu_admin;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminMember implements MenuCommand {
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("AdminMember");
		System.out.println("===[ 관리자 : 회원 관리]===");
		System.out.println("[1] 회원 목록");
		System.out.println("[2] 회원 수정");
		System.out.println("[3] 회원 삭제");
		System.out.println("[0] 뒤로 가기");
		int sel = Util.getValue("메뉴 입력", 0, 3);
		
		if(sel == 0) {
			System.out.println("관리자 메인메뉴로 갑니다");
			mallCont.setNextMenu("AdminMain");
		}else if(sel == 1) {
			mallCont.setNextMenu("AdminMemberList");
		}else if(sel == 2) {
			mallCont.setNextMenu("AdminMemberUpdate");
		}else if(sel == 3) {
			mallCont.setNextMenu("AdminMemberDelete");
		}else {
			return true;
		}
		return false;
	}

}
