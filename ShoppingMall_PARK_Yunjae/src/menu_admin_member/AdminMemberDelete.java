package menu_admin_member;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminMemberDelete implements MenuCommand {
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("AdminMember");
		String id = Util.getValue("ID");
		int idIdx = mallCont.getmDAO().idValue(id);
		if (idIdx == -1) {
			System.out.println("[관리자] ID가 존재하지 않습니다");
			return false;
		}
		mallCont.getmDAO().DeleteMember(idIdx);
		System.out.println("[관리자] 회원 삭제 완료");
		return false;
	}
}
