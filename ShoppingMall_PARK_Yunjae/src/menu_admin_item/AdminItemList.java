package menu_admin_item;

import _mall.MenuCommand;
import controller.MallController;

public class AdminItemList implements MenuCommand{
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
