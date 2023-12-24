package menu_admin_category;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminCategoryUpdate implements MenuCommand {

	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("AdminCategory");
		String name = Util.getValue("이름");
		int cgIdx = mallCont.getCgDAO().nameValue(name);
		if (cgIdx == -1) {
			System.out.println("[관리자] 카테고리가 존재하지 않습니다");
			return false;
		}
		name = Util.getValue("변경할 이름 : ");
		mallCont.getCgDAO().getCgList().set(cgIdx, name);
		System.out.println("[관리자] 카테고리 이름 변경 완료");
		return false;
	}
}
