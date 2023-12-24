package menu_admin_item;

import _mall.MenuCommand;
import controller.MallController;

public class AdminItemUpdate implements MenuCommand{
	private MallController mallCont;

	@Override
	public void init() {
		mallCont = MallController.getInstance();
	}

	@Override
	public boolean update() {

		return false;
	}
}
