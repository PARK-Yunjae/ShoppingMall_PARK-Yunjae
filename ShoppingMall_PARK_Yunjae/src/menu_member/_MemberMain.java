package menu_member;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class _MemberMain implements MenuCommand {
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("MemberMain");
		System.out.println("===[ %s ]===".formatted(mallCont.getId()));
		System.out.println("[1] 상품구매");
		System.out.println("[2] 장바구니");
		System.out.println("[3] 게시판");
		System.out.println("[4] 나의정보");
		System.out.println("[5] 회원탈퇴");
		System.out.println("[0] 로그아웃");
		int sel = Util.getValue("메뉴 입력", 0, 5);

		if (sel == 0) {
			mallCont.setNextMenu("MallMain");
		} else if (sel == 1) {
			mallCont.setNextMenu("MemberShopping");
		} else if (sel == 2) {
			mallCont.setNextMenu("MemberCart");
		} else if (sel == 3) {
			mallCont.setNextMenu("MemberBoard");
		} else if (sel == 4) {
			mallCont.setNextMenu("MemberInfo");
		} else if (sel == 5) {
			mallCont.setNextMenu("MemberQuit");
		} else {
			return true;
		}
		return false;
	}

}
