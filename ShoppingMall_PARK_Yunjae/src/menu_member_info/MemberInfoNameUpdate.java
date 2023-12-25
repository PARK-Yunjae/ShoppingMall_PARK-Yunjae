package menu_member_info;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class MemberInfoNameUpdate  implements MenuCommand{
	private MallController mallCont;
	
	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("MemberInfo");
		String newName = Util.getValue("새이름");
		int idx = mallCont.getmDAO().idValue(mallCont.getId());
		mallCont.getmDAO().getmList().get(idx).setMemberName(newName);;
		System.out.println("[%s] 이름 변경 완료".formatted(mallCont.getId()));
		return false;
	}
}
