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
		mallCont.getCgDAO().CategoryList();
		return false;
	}
}
