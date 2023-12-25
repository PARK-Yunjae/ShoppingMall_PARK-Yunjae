package menu_admin_member;

import _mall.MenuCommand;
import controller.MallController;

public class AdminMemberList implements MenuCommand {
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("AdminMember");
		if(mallCont.getmDAO().getmList().size() == 0) {
			System.out.println("[관리자] 회원이 존재하지 않습니다");
			return false;
		}
		mallCont.getmDAO().MemberList();
		return false;
	}

}
