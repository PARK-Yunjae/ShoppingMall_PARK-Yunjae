package menu_admin_category;

import _mall.MenuCommand;
import controller.MallController;

public class AdminCategoryList implements MenuCommand {

	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {
		mallCont.setNextMenu("AdminCategory");
		if(mallCont.getCgDAO().getCgList().size() == 0) {
			System.out.println("[관리자] 카테고리가 존재하지 않습니다");
			return false;
		}
		mallCont.getCgDAO().CategoryList();
		return false;
	}
}
