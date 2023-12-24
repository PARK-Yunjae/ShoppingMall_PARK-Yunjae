package menu_admin_category;

import _mall.MenuCommand;
import controller.MallController;
import util.Util;

public class AdminCategoryDelete implements MenuCommand {

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
			System.out.println("[관리자] 카테고리가 존재하지 않습니다.");
			return false;
		}
		mallCont.getCgDAO().DeleteCategory(cgIdx);
		System.out.println("[관리자] 카테고리 삭제 완료");
		return false;
	}
}
