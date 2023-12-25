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
		String cgName = Util.getValue("이름");
		int cgIdx = mallCont.getCgDAO().nameValue(cgName);
		if (cgIdx != -1) {
			System.out.println("[관리자] 카테고리가 존재합니다");
			return false;
		}
		mallCont.getCgDAO().AddCategory(cgName);
		System.out.println("[관리자] 카테고리 %s 추가 완료".formatted(cgName));
		return false;
	}
}
