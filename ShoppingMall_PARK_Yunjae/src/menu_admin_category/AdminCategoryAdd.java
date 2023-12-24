package menu_admin_category;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminCategoryAdd implements MenuCommand {

	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("AdminCategory");
		String name = Util.getValue("이름 : ");
		int cgIdx = mallCont.getCgDAO().nameValue(name);
		if (cgIdx != -1) {
			System.out.println("[관리자] 카테고리가 존재합니다");
			return false;
		}
		mallCont.getCgDAO().AddCategory(name);
		System.out.println("[관리자] 카테고리 추가 완료");
		return false;
	}
}
