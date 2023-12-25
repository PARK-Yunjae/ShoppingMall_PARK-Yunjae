package menu_member;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class MemberInfo implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("MemberInfo");
		System.out.println("[1]이름 수정");
		System.out.println("[2]비밀번호 수정");
		System.out.println("[3]내 정보");
		System.out.println("[0]뒤로가기");
		int sel = Util.getValue("선택", 0, 3);
		if (sel == 1) {
			mallCont.setNextMenu("MemberInfoNameUpdate");
		} else if (sel == 2) {
			mallCont.setNextMenu("MemberInfoPwUpdate");
		} else if (sel == 3) {
			mallCont.setNextMenu("MemberInfoList");
		} else if (sel == 0) {
			mallCont.setNextMenu("MemberMain");
		} else {
			return true;
		}
		return false;
	}
}
