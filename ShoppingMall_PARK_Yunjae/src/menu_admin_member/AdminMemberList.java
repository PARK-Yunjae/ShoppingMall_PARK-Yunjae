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
		mallCont.getmDAO().MemberList();
		return false;
	}

}
